package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.XML.DeviceSeedDTO;
import softuni.exam.models.dto.XML.DeviceSeedRootDTO;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static softuni.exam.models.Constants.*;


@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final SaleService saleService;

    public DeviceServiceImpl(DeviceRepository deviceRepository,
                             ModelMapper modelMapper, XmlParser xmlParser,
                             ValidationUtil validationUtil, SaleService saleService) {

        this.deviceRepository = deviceRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.saleService = saleService;
    }

    @Override
    public boolean areImported() {
        return deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        return Files.readString(Path.of(DEVICE_FILE_PATH));
    }

    @Override
    public String importDevices() throws IOException, JAXBException {

        StringBuilder result = new StringBuilder();

        xmlParser.fromFile(DEVICE_FILE_PATH, DeviceSeedRootDTO.class)
                .getSeedDTOList()
                .stream()
                .filter(deviceSeedDto -> isValidDevice(deviceSeedDto, result))
                .map(this::mapToDevice)
                .forEach(deviceRepository::save);

        return result.toString();
    }

    private boolean isValidDevice(DeviceSeedDTO deviceSeedDto, StringBuilder result) {
        boolean isValid = validationUtil.isValid(deviceSeedDto);

        Sale sale = saleService.findSaleById(deviceSeedDto.getSale());
        if (sale == null) {
            isValid = false;
        }

        Optional<Device> existingDevice = deviceRepository.findDeviceByModel(deviceSeedDto.getModel());
        if (existingDevice.isPresent()) {
            isValid = false;
        }

        appendImportResult(result, isValid, deviceSeedDto);
        return isValid;
    }

    private Device mapToDevice(DeviceSeedDTO deviceSeedDto) {
        Device device = modelMapper.map(deviceSeedDto, Device.class);
        Sale sale = saleService.findSaleById(deviceSeedDto.getSale());
        saleService.addAndSaveAddedDevice(sale, device);
        device.setSale(sale);
        return device;
    }

    private void appendImportResult(StringBuilder result, boolean isValid, DeviceSeedDTO deviceSeedDto) {
        String message = isValid ?
                String.format(SUCCESSFUL_DEVICE_IMPORT, DEVICE,
                        deviceSeedDto.getDeviceType(),
                        deviceSeedDto.getBrand()) :
                String.format(INVALID_FORMAT, DEVICE);

        result.append(message).append(System.lineSeparator());
    }

    @Override
    public String exportDevices() {
        StringBuilder build = new StringBuilder();

        List<Device> foundDevices = deviceRepository.findAllSmartPhonesCheaperThan1000AndStorageMoreThan128();

        foundDevices.forEach(device -> appendDeviceToExport(build, device));

        return build.toString();
    }

    private void appendDeviceToExport(StringBuilder result, Device device) {
        result.append(String.format("Device brand: %s\n"
                                + "*Model: %s\n"
                                + "**Storage: %d\n"
                                + "***Price: %.2f",
                        device.getBrand(), device.getModel(),
                        device.getStorage(), device.getPrice()))
                .append(System.lineSeparator());
    }
}