package bg.proxiad.demo.model;

import org.apache.tomcat.jakartaee.commons.lang3.builder.ToStringExclude;
import org.springframework.stereotype.Component;
import bg.proxiad.demo.utils.IdCounterAtomic;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

  @ToStringExclude
  @Setter(AccessLevel.NONE)
  @NotNull
  private final Long id;

  @NotBlank private String name;

  @Min(18)
  @Max(100)
  private int age;

  private Address address;

  public User() {
    this.id = IdCounterAtomic.assignId();
  }

  public User(String name) {
    this.id = IdCounterAtomic.assignId();
    this.name = name;
  }
}
