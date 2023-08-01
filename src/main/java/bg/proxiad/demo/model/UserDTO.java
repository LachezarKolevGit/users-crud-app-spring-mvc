package bg.proxiad.demo.model;

import java.util.Optional;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO { // not sure if I dont need an no-args constructor
  @NotNull private Optional<Long> id;
  @NotBlank private String name;

  @Min(5)
  @Max(100)
  private int age;

  @NotNull private Address address;
}
