package softuni.exam.service;


import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface DeviceService {

    boolean areImported();

    String readDevices() throws IOException;

    String importDevices() throws IOException, JAXBException;

    String exportDevices();

}
