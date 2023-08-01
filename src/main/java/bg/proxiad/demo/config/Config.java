package bg.proxiad.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import bg.proxiad.demo.model.Address;
import bg.proxiad.demo.model.User;
import bg.proxiad.demo.model.UserDTO;

@Configuration
@ComponentScan(
    basePackages = {
      "bg.proxiad.demo.controller",
      "bg.proxiad.demo.service",
      "bg.proxiad.demo.model",
      "bg.proxiad.demo.exceptions"
    })
@EnableWebMvc
@ImportResource("classpath:beans.xml")
public class Config implements WebMvcConfigurer {

  /*@Override  //edit later
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new AddressParamToAddressDTOConverter());
    WebMvcConfigurer.super.addFormatters(registry);
  }*/

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    TypeMap<UserDTO, User> userDTOUserTypeMap = modelMapper.getTypeMap(UserDTO.class, User.class);
    if (userDTOUserTypeMap == null) {
      userDTOUserTypeMap = modelMapper.createTypeMap(UserDTO.class, User.class);
    }
    userDTOUserTypeMap.setProvider(
        (request) -> {
          UserDTO userDTO = UserDTO.class.cast(request.getSource());
          if (userDTO.getId().isPresent()) {
            Long userId = userDTO.getId().get();
            int userAge = userDTO.getAge();
            Address address = userDTO.getAddress();
            System.out.println(address);
            User user = new User(userId, userDTO.getName(), userAge, address);

            return user;
          } else {
            return new User(userDTO.getName());
          }
        });

    return modelMapper;
  }
}
