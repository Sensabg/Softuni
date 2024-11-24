package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JSON.SaleSeedDTO;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.Sale;
import softuni.exam.models.dto.JSON.SaleSeedDTO.*;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.SaleService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class SaleServiceImpl implements SaleService {

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private SaleRepository saleRepository;
    private DeviceRepository deviceRepository;
    private SellerService sellerService;

    public SaleServiceImpl(ModelMapper modelMapper, Gson gson,
                           ValidationUtil validationUtil, SaleRepository saleRepository,
                           DeviceRepository deviceRepository, SellerService sellerService) {

        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.saleRepository = saleRepository;
        this.deviceRepository = deviceRepository;
        this.sellerService = sellerService;
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

        StringBuilder sb = new StringBuilder();

        final List<SaleSeedDTO> validSalesDTOS =
                Arrays.stream(gson.fromJson(readSalesFileContent(), SaleSeedDTO[].class))
                        .filter(this.validationUtil::isValid)
                        .filter(saleSeedDto -> this.saleRepository
                                .findSaleByNumber(saleSeedDto.getNumber())
                                .isEmpty()).collect(Collectors.toList());


        String message = validSalesDTOS.isEmpty()
                ? String.format(INVALID_FORMAT, SALE)
                : validSalesDTOS.stream()
                .map(saleSeedDTO -> String.format(SUCCESSFUL_SALE_IMPORT,
                        SALE, saleSeedDTO.getNumber()))
                .collect(Collectors.joining(System.lineSeparator()));

        validSalesDTOS.stream()
                .map(this::mapSaleFromDTO)
                .map(this::associateSellerToSale)
                .map(this::saveSeller)
                .forEach(saleRepository::save);

        sb.append(message);

        return sb.toString().trim();
    }

    private Sale mapSaleFromDTO(SaleSeedDTO saleSeedDTO) {
        return modelMapper.map(saleSeedDTO, Sale.class);
    }

    private Sale associateSellerToSale(Sale sale) {
        Seller seller = sellerService.findSellerById(sale.getSeller().getId());
        seller.getSales().add(sale);
        sale.setSeller(seller);
        return sale;
    }

    private Sale saveSeller(Sale sale) {
        sellerService.saveAddedSaleToSeller(sale.getSeller());
        return sale;
    }

    @Override
    public Sale findSaleById(Long saleId) {
        return saleRepository.findById(saleId).orElse(null);
    }

    @Override
    public void addAndSaveAddedDevice(Sale sale, Device device) {

        sale.getDevices().add(device);
        saleRepository.save(sale);
    }
}
