package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "devices")
public class Device extends BaseEntity {

    @Column(name = "brand",nullable = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType deviceType;

    @Column(name = "model", nullable = false, unique = true)
    private String model;

    @Column(name = "price")
    private double price;

    @Column(name = "storage")
    private int storage;

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;
}
