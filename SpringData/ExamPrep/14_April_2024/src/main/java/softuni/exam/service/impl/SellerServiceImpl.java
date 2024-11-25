package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import java.util.List;
import java.util.Optional;
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
    public String readSellers() throws IOException {
        return new String(Files.readAllBytes(Path.of(SELLER_FILE_PATH)));
    }

    @Override
    public String importSellers() throws IOException {
        List<SellerSeedDTO> sellerSeedDTOs = gson.fromJson(readSellers(),
                new TypeToken<List<SellerSeedDTO>>() {
                }.getType());

        return sellerSeedDTOs.stream()
                .map(this::processSeller)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String processSeller(SellerSeedDTO sellerSeedDTO) {
        return Optional.of(sellerSeedDTO)
                .filter(this::isValidSeller)
                .map(dto -> this.sellerRepository.saveAndFlush(mapSellerFromDTO(dto)))
                .map(seller -> String.format(SUCCESSFUL_SELLER_IMPORT, SELLER,
                        seller.getFirstName(),
                        seller.getLastName()))
                .orElse(String.format(INVALID_FORMAT, SELLER));
    }

//  private String processSeller(SellerSeedDTO sellerSeedDTO) {
//        if (!isValidSeller(sellerSeedDTO)) {
//            return String.format(INVALID_FORMAT, SELLER);
//        }
//        Seller seller = mapSellerFromDTO(sellerSeedDTO);
//        this.sellerRepository.saveAndFlush(seller);
//        return String.format(SUCCESSFUL_SELLER_IMPORT, SELLER,
//                sellerSeedDTO.getFirstName(), sellerSeedDTO.getLastName());
//  }

    private boolean isValidSeller(SellerSeedDTO sellerSeedDTO) {
        return validationUtil.isValid(sellerSeedDTO) &&
                sellerRepository.findByLastName(sellerSeedDTO.getLastName()).isEmpty();
    }

    private Seller mapSellerFromDTO(SellerSeedDTO sellerSeedDTO) {
        return modelMapper.map(sellerSeedDTO, Seller.class);
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