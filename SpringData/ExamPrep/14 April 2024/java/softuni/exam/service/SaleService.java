package softuni.exam.service;

import java.io.IOException;


public interface SaleService {

    boolean areImported();

    String readSales() throws IOException;

    String importSales() throws IOException;
}
