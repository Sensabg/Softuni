package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JSON.AttractionImportDto;
import softuni.exam.models.entity.Attraction;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.AttractionService;
import softuni.exam.util.ValidationUtilImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

//ToDo - Implement all the methods
@Service

public class AttractionServiceImpl implements AttractionService {
    private final String FILE_PATH = "src/main/resources/files/json/attractions.json";

    private final AttractionRepository attractionRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtilImpl validationUtil;

    public AttractionServiceImpl(AttractionRepository attractionRepository, CountryRepository countryRepository, ModelMapper modelMapper, Gson gson, ValidationUtilImpl validationUtil) {
        this.attractionRepository = attractionRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }
    @Override
    public boolean areImported() {
        return this.attractionRepository.count() > 0;
    }

    @Override
    public String readAttractionsFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importAttractions() throws IOException {
        StringBuilder sb = new StringBuilder();

        AttractionImportDto[] attractionImportDtos = this.gson.fromJson(readAttractionsFileContent(), AttractionImportDto[].class);
        for (AttractionImportDto importDto : attractionImportDtos) {
            if (!validationUtil.isValid(importDto) ||
                    this.attractionRepository.findByName(importDto.getName()).isPresent()) {
                sb.append("Invalid attraction").append(System.lineSeparator());
                continue;
            }

            Attraction attraction = this.modelMapper.map(importDto, Attraction.class);
            attraction.setCountry(this.countryRepository.findById(importDto.getCountry()).get());
            this.attractionRepository.save(attraction);
            sb.append(String.format("Successfully imported attraction %s"
                    ,attraction.getName())).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String exportAttractions() {
        StringBuilder sb = new StringBuilder();

        Set<Attraction> attractions = this.attractionRepository
                .findByElevationGreaterThanEqualAndTypeOrTypeAndElevationGreaterThanEqualOrderByNameAscCountryName(
                        300, "historical site", "archaeological site", 300);
        for (Attraction attraction : attractions) {
            sb.append(String.format("Attraction with ID%d:\n" +
                            "***%s - %s at an altitude of %dm. somewhere in %s.\n",
                    attraction.getId(), attraction.getName(), attraction.getDescription(),
                    attraction.getElevation(), attraction.getCountry().getName()));
        }

        return sb.toString();
    }
}