package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
;
import softuni.exam.models.dto.JSON.SaleSeedDto;
import softuni.exam.models.entity.Sale;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SaleRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import static softuni.exam.models.Constants.*;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SaleServiceImpl(SaleRepository saleRepository, SellerRepository sellerRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.saleRepository = saleRepository;
        this.sellerRepository = sellerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(SALE_FILE_PATH)));
    }

    @Override
    public String importSales() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        SaleSeedDto[] saleSeedDtos = this.gson.fromJson(readSalesFileContent(), SaleSeedDto[].class);

        Stream.of(saleSeedDtos)
                .map(this::processSaleDto)
                .forEach(resultMessage -> stringBuilder.append(resultMessage).append(System.lineSeparator()));

        return stringBuilder.toString().trim();
    }

    private String processSaleDto(SaleSeedDto saleSeedDto) {
        return Optional.of(saleSeedDto)
                .filter(this::isValid)
                .map(this::saveSale)
                .orElse("Invalid sale");
    }

    private boolean isValid(SaleSeedDto saleSeedDto) {
        return ! this.validationUtil.isValid(saleSeedDto) ||
                this.saleRepository.findByNumber(saleSeedDto.getNumber()).isPresent();
    }

    private String saveSale(SaleSeedDto saleSeedDto) {
        Sale sale = this.modelMapper.map(saleSeedDto, Sale.class);
        Optional<Seller> sellerOptional = this.sellerRepository.findById(saleSeedDto.getSeller());
        sellerOptional.ifPresent(sale::setSeller);

        this.saleRepository.saveAndFlush(sale);

        return String.format(SUCCESSFUL_SALE_IMPORT,SALE, sale.getNumber());
    }
}
