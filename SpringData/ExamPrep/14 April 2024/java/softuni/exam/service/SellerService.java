package softuni.exam.service;

import softuni.exam.models.entity.Seller;

import java.io.IOException;


public interface SellerService {

    boolean areImported();

    String readSellers() throws IOException;

    String importSellers() throws IOException;

    Seller findSellerById(Long sellerId);

    void saveAddedSaleToSeller(Seller seller);

}
