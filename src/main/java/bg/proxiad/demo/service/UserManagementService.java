package bg.proxiad.demo.service;

import java.util.Map;
import bg.proxiad.demo.model.User;

public interface UserManagementService {

  Map<Long, User> getUsers();

  void addUser(User user, Long userId);

  void deleteUser(Long userId);

  void modifyUser(User user, Long userId);
}
