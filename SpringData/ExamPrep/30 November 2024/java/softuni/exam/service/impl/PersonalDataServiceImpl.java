package softuni.exam.service.impl;

import com.google.gson.Gson;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.XML.*;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.service.PersonalDataService;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//ToDo - Implement all the methods

@Service
public class PersonalDataServiceImpl implements PersonalDataService {
    private final String FILE_PATH = "src/main/resources/files/xml/personal_data.xml";

    private final PersonalDataRepository personalDataRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtilImpl validationUtil;

    public PersonalDataServiceImpl(PersonalDataRepository personalDataRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtilImpl validationUtil) {
        this.personalDataRepository = personalDataRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.personalDataRepository.count() > 0;
    }

    @Override
    public String readPersonalDataFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importPersonalData() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        PersonalDataRootDto personalDataRootDto = this.xmlParser.fromFile(FILE_PATH, PersonalDataRootDto.class);
        for (PersonalDataImportDto importDto : personalDataRootDto.getPersonalDataImportDtos()) {
            if (!validationUtil.isValid(importDto) ||
                    this.personalDataRepository.findByCardNumber(importDto.getCardNumber()).isPresent()) {
                sb.append("Invalid personal data").append(System.lineSeparator());
                continue;
            }

            PersonalData personalData = this.modelMapper.map(importDto, PersonalData.class);
            this.personalDataRepository.save(personalData);
            sb.append(String.format("Successfully imported personal data for visitor with card number %s"
                    ,personalData.getCardNumber())).append(System.lineSeparator());
        }

        return sb.toString();
    }
}