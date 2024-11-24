package softuni.exam.models.dto.JSON;


import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class SaleSeedDTO implements Serializable {

    @Getter
    @Expose
    private boolean discounted;

    @Expose
    @Size(min = 7, max = 7)
    private String number;

    @Expose
    private String saleDate;

    @Expose
    private Long seller;

}