package softuni.exam.models.dto.JSON;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.DecimalMin;
import org.hibernate.validator.constraints.Length;

public class CountryImportDto {
    @Expose
    @Length(min = 3, max = 40)
    private String name;

    @Expose
    @DecimalMin(value = "0.00")
    private double area;

    public @Length(min = 3, max = 40) String getName() {
        return name;
    }

    public void setName(@Length(min = 3, max = 40) String name) {
        this.name = name;
    }

    @DecimalMin(value = "0.00")
    public double getArea() {
        return area;
    }

    public void setArea(@DecimalMin(value = "0.00") double area) {
        this.area = area;
    }
}