package softuni.exam.service.impl;

import com.google.gson.Gson;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.XML.VisitorImportDto;
import softuni.exam.models.dto.VisitorRootDto;
import softuni.exam.models.entity.Visitor;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.repository.VisitorRepository;
import softuni.exam.service.VisitorService;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class VisitorServiceImpl implements VisitorService {
    private final String FILE_PATH = "src/main/resources/files/xml/visitors.xml";

    private final VisitorRepository visitorRepository;
    private final AttractionRepository attractionRepository;
    private final CountryRepository countryRepository;
    private final PersonalDataRepository personalDataRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtilImpl validationUtil;

    public VisitorServiceImpl(VisitorRepository visitorRepository, ModelMapper modelMapper, AttractionRepository attractionRepository, CountryRepository countryRepository, PersonalDataRepository personalDataRepository, XmlParser xmlParser, ValidationUtilImpl validationUtil) {
        this.visitorRepository = visitorRepository;
        this.modelMapper = modelMapper;
        this.attractionRepository = attractionRepository;
        this.countryRepository = countryRepository;
        this.personalDataRepository = personalDataRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.visitorRepository.count() > 0;
    }

    @Override
    public String readVisitorsFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importVisitors() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        VisitorRootDto visitorRootDto = this.xmlParser.fromFile(FILE_PATH, VisitorRootDto.class);
        for (VisitorImportDto importDto : visitorRootDto.getVisitorImportDtos()) {
            if (!validationUtil.isValid(importDto) ||
                    this.visitorRepository.findByFirstNameAndLastNameOrPersonalDataId(
                            importDto.getFirstName(), importDto.getLastName(),
                            importDto.getPersonalData()).isPresent()) {
                sb.append("Invalid visitor").append(System.lineSeparator());
                continue;
            }

            Visitor visitor = this.modelMapper.map(importDto, Visitor.class);
            visitor.setAttraction(this.attractionRepository.findById(importDto.getAttraction()).get());
            visitor.setCountry(this.countryRepository.findById(importDto.getCountry()).get());
            visitor.setPersonalData(this.personalDataRepository.getById(importDto.getPersonalData()));
            this.visitorRepository.save(visitor);
            sb.append(String.format("Successfully imported visitor %s %s",
                    visitor.getFirstName(), visitor.getLastName())).append(System.lineSeparator());
        }

        return sb.toString();
    }
}