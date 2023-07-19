package bg.proxiad.demo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import bg.proxiad.demo.exceptions.UserNotFoundException;
import bg.proxiad.demo.model.User;

@Service
public class UserManagementService {

  private final Map<Long, User> users = new HashMap<Long, User>();

  public Map<Long, User> getUsers() {
    return users;
  }

  public void addUser(User user) {
    if (user == null) {
      throw new IllegalArgumentException("User can't be null");
    }
    users.put(user.getId(), user);
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

  public void modifyUser(User user) {
    if (user == null) {
      throw new IllegalArgumentException("User can't be null");
    }

    if (!users.containsKey(user.getId())) {
      throw new UserNotFoundException("User with that id does not exist");
    }

    User savedUser = users.get(user.getId());
    savedUser.setName(user.getName());

    users.put(savedUser.getId(), savedUser);
  }
}
