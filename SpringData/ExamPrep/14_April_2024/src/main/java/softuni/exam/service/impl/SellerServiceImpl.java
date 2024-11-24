package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JSON.SaleSeedDTO;
import softuni.exam.models.dto.JSON.SellerSeedDTO;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;


@Service
public class SellerServiceImpl implements SellerService {

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(ModelMapper modelMapper, Gson gson,
                             ValidationUtil validationUtil, SellerRepository sellerRepository) {

        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.sellerRepository = sellerRepository;
    }


    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(SELLER_FILE_PATH)));
    }

    @Override
    public String importSellers() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<SellerSeedDTO> validSellersDTOS =
                Arrays.stream(gson.fromJson(readSellersFromFile(), SellerSeedDTO[].class))
                        .filter(this.validationUtil::isValid)
                        .filter(sellerSeedDTO -> this.sellerRepository
                                .findByLastName(sellerSeedDTO.getLastName())
                                .isEmpty()).collect(Collectors.toList());

        String message = validSellersDTOS.isEmpty()
                ? String.format(INVALID_FORMAT, SELLER)
                : validSellersDTOS.stream()
                .map(SellerSeedDTO -> String.format(SUCCESSFUL_SELLER_IMPORT,
                        SELLER, SellerSeedDTO.getFirstName(), SellerSeedDTO.getLastName()))
                .collect(Collectors.joining(System.lineSeparator()));

        validSellersDTOS.stream()
                .map(this::mapSellerFromDTO)
                .forEach(this.sellerRepository::save);

        sb.append(message);

        return sb.toString().trim();
    }

    private Seller mapSellerFromDTO(SellerSeedDTO sellerSeedDTO) {
        return this.modelMapper.map(sellerSeedDTO, Seller.class);
    }

    @Override
    public Seller findSellerById(Long sellerId) {
        return sellerRepository.findById(sellerId).orElse(null);
    }

    @Override
    public void saveAddedSaleToSeller(Seller seller) {
        sellerRepository.save(seller);
    }
}
