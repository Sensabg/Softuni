package softuni.exam.models.dto.XML;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.hibernate.validator.constraints.Length;
import softuni.exam.util.LocalDateAdapter;

import java.time.LocalDate;

@XmlRootElement(name = "personal_data")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDataImportDto {
    //    <personal_datas>
//    <personal_data>
//        <age>33</age>
//        <gender>M</gender>
//        <birth_date>1991-05-12</birth_date>
//        <card_number>123456789</card_number>
//    </personal_data>
    @XmlElement
    @Min(1)
    @Max(100)
    private int age;

    @XmlElement
    private char gender;

    @XmlElement(name = "birth_date")
    @Past
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthDate;

    @XmlElement(name = "card_number")
    @Length(min = 9, max = 9)
    private String cardNumber;

    @Min(1)
    @Max(100)
    public int getAge() {
        return age;
    }

    public void setAge(@Min(1) @Max(100) int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public @Past LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@Past LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @Length(min = 9, max = 9) String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(@Length(min = 9, max = 9) String cardNumber) {
        this.cardNumber = cardNumber;
    }
}