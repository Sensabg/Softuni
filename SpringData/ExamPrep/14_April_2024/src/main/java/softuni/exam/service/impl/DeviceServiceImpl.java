package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JSON.SaleSeedDto;
import softuni.exam.models.dto.XML.DeviceSeedDTO;
import softuni.exam.models.dto.XML.DeviceSeedRootDTO;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;
import softuni.exam.service.SaleService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static softuni.exam.models.Constants.*;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;


    public DeviceServiceImpl(DeviceRepository deviceRepository,
                             SaleRepository saleRepository, XmlParser xmlParser,
                             ModelMapper modelMapper, ValidationUtil validationUtil) {

        this.deviceRepository = deviceRepository;
        this.saleRepository = saleRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        return Files.readString(Path.of(DEVICE_FILE_PATH));
    }
    @Override
    public String importDevices() throws IOException, JAXBException {
        DeviceSeedRootDTO deviceSeedRootDTO = this.xmlParser.fromFile(readDevicesFromFile(), DeviceSeedRootDTO.class);
        return deviceSeedRootDTO.getSeedDTOList()
                .stream()
                .map(this::processDevice)
                .collect(Collectors.joining(System.lineSeparator()));
    }


    private String processDevice(DeviceSeedDTO deviceSeedDTO) {
        Device device = this.modelMapper.map(deviceSeedDTO, Device.class);
        DeviceType deviceType = DeviceType.valueOf(deviceSeedDTO.getDeviceType());
        Optional<Sale> saleOptional = this.saleRepository.findById(deviceSeedDTO.getSale());

        String message = isDeviceValid(deviceSeedDTO)
                ? String.format(SUCCESSFUL_DEVICE_IMPORT, DEVICE, device.getDeviceType(), device.getBrand())
                : String.format(INVALID_FORMAT, DEVICE);

        device.setDeviceType(deviceType);
        saleOptional.ifPresent(device::setSale);
        this.deviceRepository.saveAndFlush(device);

        return message;
    }

    private boolean isDeviceValid(DeviceSeedDTO deviceSeedDTO) {
        Optional<Device> deviceOptional = this.deviceRepository.findDeviceByModel(deviceSeedDTO.getModel());
        Optional<Sale> saleOptional = this.saleRepository.findById(deviceSeedDTO.getSale());

        return this.validationUtil.isValid(deviceSeedDTO) && deviceOptional.isEmpty() && saleOptional.isPresent();
    }

        @Override
    public String exportDevices() {
        return deviceRepository
                .findAllSmartPhonesCheaperThan1000AndStorageMoreThan128()
                .stream()
                .map(this::formatDevice)
                .collect(Collectors.joining(System.lineSeparator()));
    }


    private String formatDevice(Device device) {
        return String.format("Device brand: %s\n" +
                        "*Model: %s\n" +
                        "**Storage: %d\n" +
                        "***Price: %.2f",
                device.getBrand(), device.getModel(), device.getStorage(), device.getPrice());
    }
}
