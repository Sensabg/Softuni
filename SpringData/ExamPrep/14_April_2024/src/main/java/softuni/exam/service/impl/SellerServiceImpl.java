package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
//        List<SellerSeedDTO> sellerSeedDTOs = Arrays.asList(
//                gson.fromJson(readSellersFromFile(), SellerSeedDTO[].class));


        String fileContent = readSellersFromFile();
        System.out.println(fileContent);  // Check file content
        List<SellerSeedDTO> sellerSeedDTOs = Arrays.asList(gson.fromJson(fileContent, SellerSeedDTO[].class));

        return sellerSeedDTOs.stream()
                .map(this::processSeller)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private Seller mapSellerFromDTO(SellerSeedDTO sellerSeedDTO) {
        return this.modelMapper.map(sellerSeedDTO, Seller.class);
    }

    private String processSeller(SellerSeedDTO sellerSeedDTO) {
        Seller seller = modelMapper.map(sellerSeedDTO, Seller.class);

        String message = !isValidSeller(sellerSeedDTO)
                ? String.format(INVALID_FORMAT, SELLER)
                : String.format(SUCCESSFUL_SELLER_IMPORT, SELLER,
                seller.getFirstName(), seller.getLastName());

        seller = mapSellerFromDTO(sellerSeedDTO);
        this.sellerRepository.saveAndFlush(seller);
        return message;
    }

    private boolean isValidSeller(SellerSeedDTO sellerSeedDTO) {
        return validationUtil.isValid(sellerSeedDTO) &&
                sellerRepository.findByLastName(sellerSeedDTO.getLastName()).isEmpty();
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
