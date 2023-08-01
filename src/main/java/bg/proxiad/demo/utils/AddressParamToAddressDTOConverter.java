package bg.proxiad.demo.utils;

import org.springframework.core.convert.converter.Converter;
import bg.proxiad.demo.model.Address;

public class AddressParamToAddressDTOConverter implements Converter<String, Address> {

  @Override
  public Address convert(String source) {
    Address address = new Address();
    String[] parts = source.split(" ");

    address.setCity(parts[0]);
    address.setStreet(parts[1]);
    address.setNumber(Integer.valueOf(parts[2]));

    return address;
  }
}
