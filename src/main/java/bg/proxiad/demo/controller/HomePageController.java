package bg.proxiad.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomePageController {

  @GetMapping("/users")
  public ModelAndView getDisplayUsersPage(HttpServletResponse response) {
    return new ModelAndView("redirect:/user");
  }

  @GetMapping("/create-user")
  public String getCreateUserPage() {
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
}
