package bg.proxiad.demo.config;

import bg.proxiad.demo.model.AddressDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    /*@Override  //custom converter
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
                    UserDTO userDTO = (UserDTO) request.getSource();
                    if (userDTO.getId().isPresent()) {  //refactor
                        Long userId = userDTO.getId().get();
                        int userAge = userDTO.getAge();
                        AddressDTO addressDTO = userDTO.getAddressDTO();
                        validateAddressDTO(addressDTO);

                        System.out.println("AddressDTO inside mapper " + addressDTO);
                        modelMapper.validate();  //check what it does

                        Address address = new Address();
                        modelMapper.map(addressDTO, address);
                        User user = new User(userId, userDTO.getName(), userAge, address);

                        return user;
                    } else {
                        Address address = new Address();
                        modelMapper.map(userDTO.getAddressDTO(), address);
                        return new User(userDTO.getName(), userDTO.getAge(), address);
                    }
                });

        return modelMapper;
    }

    public boolean validateAddressDTO(AddressDTO addressDTO) {  //see if it works with
        if (addressDTO.getCity().isBlank()) {
            throw new IllegalArgumentException();
        }
        if (addressDTO.getStreet().isBlank()) {
            throw new IllegalArgumentException();
        }
        if (addressDTO.getNumber() == null) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
