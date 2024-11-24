package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;

@Component
public class XmlParserImpl implements XmlParser {


    @Override
    public <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException {

        final JAXBContext context = JAXBContext.newInstance(tClass);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final File file = new File(filePath);
        T object = (T) unmarshaller.unmarshal(new File(filePath));

        return object;

    }
}
