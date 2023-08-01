package bg.proxiad.demo.controller;

import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import bg.proxiad.demo.model.User;
import bg.proxiad.demo.model.UserDTO;
import bg.proxiad.demo.service.UserManagementService;
import jakarta.validation.Valid;

@Controller
public class UserManagementController {

  private final UserManagementService userManagementService;

  private final ModelMapper modelMapper;

  @Autowired
  public UserManagementController(
      UserManagementService userManagementService, ModelMapper modelMapper) {
    this.userManagementService = userManagementService;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/user")
  public String printUsers(Model model) {
    Map<Long, User> users = userManagementService.getUsers();
    model.addAttribute("usersMap", users);

    return "/WEB-INF/views/users-get-page.jsp";
  }

  @PostMapping("/user")
  public String addUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {
    if (result.hasErrors()) {
      return "/WEB-INF/views/user-post-page.jsp";
    }

    if (userDTO == null) { // might be unnecessary
      throw new IllegalArgumentException("User DTO can't be null");
    }

    User user = modelMapper.map(userDTO, User.class);
    userManagementService.addUser(user, user.getId());

    return "/WEB-INF/views/user-added-sucessfully.jsp";
  }

  @DeleteMapping("/user")
  public ModelAndView DeleteUser(@RequestParam(required = true) String userId) {
    userManagementService.deleteUser(Long.valueOf(userId));

    return new ModelAndView("redirect:/");
  }

  @PutMapping("/user")
  public ModelAndView modifyUsers(@ModelAttribute UserDTO userDTO) {
    User user = modelMapper.map(userDTO, User.class);
    userManagementService.modifyUser(user, user.getId());

    return new ModelAndView("redirect:/");
  }
}
