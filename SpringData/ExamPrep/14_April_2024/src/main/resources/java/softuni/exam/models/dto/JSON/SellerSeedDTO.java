package softuni.exam.models.dto.JSON;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class SellerSeedDTO implements Serializable {

    @Expose
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @Expose
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @Expose
    @NotNull
    @Size(min = 3, max = 6)
    private String personalNumber;
}
