package bg.proxiad.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import bg.proxiad.demo.model.Address;
import bg.proxiad.demo.model.User;
import bg.proxiad.demo.model.UserDTO;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomePageController {

  private final WebApplicationContext context;

  public HomePageController(WebApplicationContext context) {
    this.context = context;
  }

  @GetMapping("/users")
  public ModelAndView getDisplayUsersPage(HttpServletResponse response) {
    return new ModelAndView("redirect:/user");
  }

  @GetMapping("/create-user")
  public String getCreateUserPage(Model model) {
    model.addAttribute("userDTO", new UserDTO());

    return "/WEB-INF/views/user-post-page.jsp";
  }

  @GetMapping("/delete-user")
  public String getDeleteUserPage() {
    return "/WEB-INF/views/user-delete-page.jsp";
  }

  @GetMapping("/edit-user")
  public String getModifyUserPage() {
    return "/WEB-INF/views/user-modify-page.jsp";
  }

  @GetMapping("/context") // just for demonstration purposes
  public ModelAndView getContext() {
    String[] beans = context.getBeanDefinitionNames();
    for (int i = 0; i < beans.length; i++) {
      System.out.println(beans[i]);
    }
    Address address = context.getBean(Address.class);
    System.out.println(address.getStreet());
    User user = context.getBean("user2", User.class);
    System.out.println("User name is " + user.getName());
    return new ModelAndView("redirect:/");
  }
}
