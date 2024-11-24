package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column(name = "discounted")
    private boolean discounted;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private Seller seller;

    @OneToMany(mappedBy = "sale")
    private List<Device> devices;

}
