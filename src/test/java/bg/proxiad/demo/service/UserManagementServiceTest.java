package bg.proxiad.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import bg.proxiad.demo.exceptions.UserNotFoundException;
import bg.proxiad.demo.model.Address;
import bg.proxiad.demo.model.User;

public class UserManagementServiceTest {

    private final UserManagementServiceImpl userManagementService = new UserManagementServiceImpl();

    @Test
    @DisplayName("Test .getUsers() for returning correct users")
    void testGetUsers() {
        User user1 = new User("Georgi", 30, new Address("Sofia", "Vitoshka", 5));
        User user2 = new User("Petko", 25, new Address("Sofia", "Vitoshka", 5));
        User user3 = new User("Mitko", 20, new Address("Sofia", "Vitoshka", 5));

        Map<Long, User> expectedMap =
                Map.ofEntries(
                        Map.entry(user1.getId(), user1),
                        Map.entry(user2.getId(), user2),
                        Map.entry(user3.getId(), user3));

        userManagementService.addUser(user1, user1.getId());
        userManagementService.addUser(user2, user2.getId());
        userManagementService.addUser(user3, user3.getId());

        Map<Long, User> actualMap = userManagementService.getUsers();

        assertThat(expectedMap)
                .as("Expected hashmap's contents does not match actual hashmap's contents")
                .containsExactlyInAnyOrderEntriesOf(actualMap);
    }

    @Test
    @DisplayName("Test adding new user in the .addUser() method")
    void testAddingNewUser() {
        User expectedUser = new User("Georgi", 30,
                new Address("Sofia", "Vitoshka", 5));

        Long expectedUserId = expectedUser.getId();

        userManagementService.addUser(expectedUser, expectedUserId);
        Map<Long, User> users = userManagementService.getUsers();
        User actualUser = users.get(expectedUserId);

        assertThat(expectedUser)
                .as("Expected user added is not the same as actual user added")
                .usingRecursiveComparison()
                .isEqualTo(actualUser);
    }

    @Test
    @DisplayName("Test deleting a user in .deleteUser() method")
    void testRemovingUser() {
        User newUser = new User("Georgi", 30,
                new Address("Sofia", "Vitoshka", 5));
        userManagementService.addUser(newUser, newUser.getId());

        userManagementService.deleteUser(newUser.getId());
        Map<Long, User> users = userManagementService.getUsers();
        assertThat(users.containsKey(newUser.getId()))
                .as("User was expected to be deleted, but still remains")
                .isFalse();
    }

    @Test
    @DisplayName("Test modifying saved user in .modifyUser() method")
    void testModifyingUser() {
        Address address = new Address("Sofia", "Vitoshka", 5);
        User expectedUser = new User(1L, "Georgi", 22, address);
        userManagementService.addUser(expectedUser, expectedUser.getId());

        expectedUser.setName("Petko");
        userManagementService.modifyUser(expectedUser, expectedUser.getId());
        Map<Long, User> users = userManagementService.getUsers();
        User actualUser = users.get(expectedUser.getId());

        assertThat(expectedUser)
                .as("Expected modified user is not the same as actual modified user")
                .usingRecursiveAssertion()
                .isEqualTo(actualUser);
    }

    @Test
    @DisplayName("Test .deleteUser() throws IllegalArgumentException being passed null")
    void testDeleteUserPassingNullAsArgument() {
        assertThatThrownBy(() -> userManagementService.deleteUser(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("UserId can't be null");
    }

    @Test
    @DisplayName(
            "Test .deleteUser() throws UserNotFoundException being passed non-existent id of a user")
    void testDeleteUserWithInvalidId() {
        assertThatThrownBy(() -> userManagementService.deleteUser(100L))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User with that id does not exist");
    }

    @Test
    @DisplayName("Test .modifyUser() throws IllegalArgumentException being passed null")
    void testModifyUserPassingNullAsArgument() {
        assertThatThrownBy(
                () -> {
                    userManagementService.modifyUser(null, 1L);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User can't be null");
    }

    @Test
    @DisplayName("Test .modifyUser() throws UserNotFoundException being passed non-added a user")
    void testModifyUserWithInvalidId() {
        assertThatThrownBy(
                () -> {
                    Address address = new Address("Sofia", "Vitoshka", 5);
                    int userAge = 22;
                    User user = new User(100L, "Georgi", userAge, address);
                    userManagementService.modifyUser(user, user.getId());
                })
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User with that id does not exist");
    }
}
