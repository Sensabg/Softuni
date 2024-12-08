package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import softuni.exam.models.dto.XML.VisitorImportDto;

import java.util.List;
import java.util.Set;

@XmlRootElement(name = "visitors")
@XmlAccessorType(XmlAccessType.FIELD)
public class VisitorRootDto {

    @XmlElement(name = "visitor")
    List<VisitorImportDto> visitorImportDtos;

    public VisitorRootDto() {
    }

    public List<VisitorImportDto> getVisitorImportDtos() {
        return visitorImportDtos;
    }

    public void setVisitorImportDtos(List<VisitorImportDto> visitorImportDtos) {
        this.visitorImportDtos = visitorImportDtos;
    }
}