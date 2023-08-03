package bg.proxiad.demo.model;

import java.util.Optional;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
  @NotNull private Optional<Long> id;
  @NotBlank(message = "Name is required") private String name;

  @NotNull(message = "Age is required")
  @Min(value = 5, message = "Min age is 5")
  @Max(value = 100, message = "Age must not be above 100")
  private Integer age;

  @Valid
  @NotNull(message = "Address is required") private AddressDTO addressDTO;
}
