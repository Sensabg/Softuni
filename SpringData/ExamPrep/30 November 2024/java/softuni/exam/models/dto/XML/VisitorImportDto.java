package softuni.exam.models.dto.XML;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Length;

@XmlRootElement(name = "visitor")
@XmlAccessorType(XmlAccessType.FIELD)
public class VisitorImportDto {
//    <visitors>
//    <visitor>
//        <first_name>John</first_name>
//        <last_name>Smith</last_name>
//        <attraction_id>12</attraction_id>
//        <country_id>73</country_id>
//        <personal_data_id>61</personal_data_id>
//    </visitor>

    @XmlElement(name = "first_name")
    @Length(min = 2, max = 20)
    private String firstName;

    @XmlElement(name = "last_name")
    @Length(min = 2, max = 20)
    private String lastName;

    @XmlElement(name = "attraction_id")
    private long attraction;

    @XmlElement(name = "country_id")
    private long country;

    @XmlElement(name = "personal_data_id")
    private long personalData;

    public @Length(min = 2, max = 20) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Length(min = 2, max = 20) String firstName) {
        this.firstName = firstName;
    }

    public @Length(min = 2, max = 20) String getLastName() {
        return lastName;
    }

    public void setLastName(@Length(min = 2, max = 20) String lastName) {
        this.lastName = lastName;
    }

    public long getAttraction() {
        return attraction;
    }

    public void setAttraction(long attraction) {
        this.attraction = attraction;
    }

    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }

    public long getPersonalData() {
        return personalData;
    }

    public void setPersonalData(long personalData) {
        this.personalData = personalData;
    }
}