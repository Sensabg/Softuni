package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;


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
        return  sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return "";
    }

    @Override
    public String importSellers() throws IOException {
        return "";
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
