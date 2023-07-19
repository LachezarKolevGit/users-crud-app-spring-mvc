package bg.proxiad.demo.model;

import bg.proxiad.demo.utils.IdCounterAtomic;

public class User {
  private final Long id;
  private String name;

  public User() {
    this.id = IdCounterAtomic.assignId();
  }

  public User(String name) {
    this.id = IdCounterAtomic.assignId();
    this.name = name;
  }

  public User(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "User [name=" + name + "]";
  }

  public void setName(String name) {
    this.name = name;
  }
}
