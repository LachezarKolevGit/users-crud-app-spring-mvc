package bg.proxiad.demo.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import bg.proxiad.demo.model.User;
import bg.proxiad.demo.model.UserDTO;
import bg.proxiad.demo.service.UserManagementService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserManagementController {

  private final UserManagementService userManagementService;

  public UserManagementController(UserManagementService userManagementService) {
    this.userManagementService = userManagementService;
  }

  @GetMapping("/user")
  public String printUsers(Model model, HttpServletRequest request) {
    Map<Long, User> users = userManagementService.getUsers();
    model.addAttribute("usersMap", users);

    return "/WEB-INF/views/users-get-page.jsp";
  }

  @PostMapping("/user")
  public ModelAndView addUser(@ModelAttribute User user) {
    userManagementService.addUser(user);

    return new ModelAndView("redirect:/");
  }

  @DeleteMapping("/user")
  public ModelAndView DeleteUser(@RequestParam String userId) {
    userManagementService.deleteUser(Long.valueOf(userId));

    return new ModelAndView("redirect:/");
  }

  @PutMapping("/user")
  public ModelAndView modifyUsers(@ModelAttribute UserDTO userDTO) {
    User user = new User(userDTO.getId(), userDTO.getName());
    userManagementService.modifyUser(user);

    return new ModelAndView("redirect:/");
  }
}
