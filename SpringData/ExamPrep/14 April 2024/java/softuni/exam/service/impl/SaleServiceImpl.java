package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JSON.SaleSeedDto;
import softuni.exam.models.dto.JSON.SellerSeedDTO;
import softuni.exam.models.entity.Sale;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SaleRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SaleServiceImpl(SaleRepository saleRepository, SellerRepository sellerRepository,
                           Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {

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
    public String readSales() throws IOException {
        return new String(Files.readAllBytes(Path.of(SALE_FILE_PATH)));
    }

    @Override
    public String importSales() throws IOException {
        SaleSeedDto[] saleSeedDtos = gson.fromJson(readSales(), SaleSeedDto[].class);
        return  Arrays.stream(saleSeedDtos)
                .map(this::processSaleDto)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private Sale mapSaleFromDTO(SaleSeedDto saleSeedDto) {
        return modelMapper.map(saleSeedDto, Sale.class);
    }

    private String processSaleDto(SaleSeedDto saleSeedDto) {
      return Optional.of(saleSeedDto)
                .filter(this::isValid)
                .map(dto -> this.saleRepository.saveAndFlush(mapSaleFromDTO(dto)))
                .map(sale -> String.format(SUCCESSFUL_SALE_IMPORT, SALE, sale.getNumber()))
                .orElse(String.format(INVALID_FORMAT, SALE));
    }

    private boolean isValid(SaleSeedDto saleSeedDto) {
        return validationUtil.isValid(saleSeedDto) && saleRepository.findByNumber(saleSeedDto.getNumber()).isEmpty();
    }
}