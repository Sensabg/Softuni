package softuni.exam.models.dto.JSON;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import lombok.Getter;
import lombok.Setter;
import softuni.exam.util.LocalDateTimeAdapterToJSON;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class SaleSeedDto implements Serializable {

    @Expose
    private boolean discounted;

    @Expose
    @Size(min = 7, max = 7)
    private String number;

    @Expose
    @JsonAdapter(LocalDateTimeAdapterToJSON.class)
    private LocalDateTime saleDate;

    @Expose
    private Long seller;
}