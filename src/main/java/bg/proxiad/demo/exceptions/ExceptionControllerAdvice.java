package bg.proxiad.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ModelAndView handleIllegalArgumentException(IllegalArgumentException exception) {
    return new ModelAndView(
        "redirect:/WEB-INF/views/illegal-argument-exception-page.jsp",
        "exceptionMessage",
        exception.getMessage());
  }

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(
      value = HttpStatus.BAD_REQUEST,
      reason = "User with the entered id can't be found")
  public ModelAndView handleUserNotFoundException(HttpServletRequest request) {

    return new ModelAndView("redirect:/WEB-INF/views/user-not-found-exception-page.jsp");
  }
}
