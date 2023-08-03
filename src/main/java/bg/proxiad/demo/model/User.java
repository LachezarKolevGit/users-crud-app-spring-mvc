package bg.proxiad.demo.model;

import org.springframework.stereotype.Component;
import bg.proxiad.demo.utils.IdCounterAtomic;
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

    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private final Long id;

    private String name;

    private int age;

    private Address address;

    public User() {
        this.id = IdCounterAtomic.assignId();
    }

    public User(String name, int age, Address address) {
        this.id = IdCounterAtomic.assignId();
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
