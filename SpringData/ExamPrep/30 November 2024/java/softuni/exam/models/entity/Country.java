package softuni.exam.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Basic
    private double area;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    @NotNull
    private Set<Attraction> attractions;

    public Country() {
        this.attractions = new HashSet<>();
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @NotNull Set<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(@NotNull Set<Attraction> attractions) {
        this.attractions = attractions;
    }
}