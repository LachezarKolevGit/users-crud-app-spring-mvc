package bg.proxiad.demo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import bg.proxiad.demo.exceptions.UserNotFoundException;
import bg.proxiad.demo.model.User;

@Service
public class UserManagementServiceImpl implements UserManagementService {

  private final Map<Long, User> users = new HashMap<Long, User>();

  public Map<Long, User> getUsers() {
    return users;
  }

  public void addUser(User user, Long userId) {
    if (user == null) {
      throw new IllegalArgumentException("User can't be null");
    }
    if (userId == null) {
      throw new IllegalArgumentException("User id can't be null");
    }

    users.put(userId, user);
  }

  public void deleteUser(Long userId) {
    if (userId == null) {
      throw new IllegalArgumentException("UserId can't be null");
    }

    if (!users.containsKey(userId)) {
      throw new UserNotFoundException("User with that id does not exist");
    }

    users.remove(Long.valueOf(userId));
  }

  public void modifyUser(User modifiedUser, Long savedUserId) {
    if (modifiedUser == null) {
      throw new IllegalArgumentException("User can't be null");
    }

    if (!users.containsKey(savedUserId)) {
      throw new UserNotFoundException("User with that id does not exist");
    }

    // should perform validation on which field is changed and change only that field
  }
}
