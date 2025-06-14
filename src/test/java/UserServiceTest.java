
import org.example.User;
import org.example.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testRegisterByEmail() {
        User user = userService.registerByEmail("Matvey", "matvey@gmail.com", "password123");
        assertNotNull(user);
        assertEquals("Matvey", user.getUsername());
        assertEquals("matvey@gmail.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertNull(user.getPhone());
        assertNull(user.getSocialProvider());
    }

    @Test
    public void testRegisterByPhone() {
        User user = userService.registerByPhone("Dmitry", "89262533595", "pass123");
        assertNotNull(user);
        assertEquals("Dmitry", user.getUsername());
        assertEquals("89262533595", user.getPhone());
        assertEquals("pass123", user.getPassword());
        assertNull(user.getEmail());
        assertNull(user.getSocialProvider());
    }

    @Test
    public void testRegisterBySocial() {
        User user = userService.registerBySocial("Alex", "vk");
        assertNotNull(user);
        assertEquals("Alex", user.getUsername());
        assertEquals("vk", user.getSocialProvider());
        assertNull(user.getEmail());
        assertNull(user.getPhone());
        assertNull(user.getPassword());
    }

    @Test
    public void testResetPasswordByEmail() {
        userService.registerByEmail("Matvey", "matvey@gmail.com", "oldPassword");
        userService.resetPasswordByEmail("matvey@gmail.com", "newPassword");
        User user = userService.getUserByUsername("Matvey");
        assertEquals("newPassword", user.getPassword());
    }

    @Test
    public void testResetPasswordByEmail_UserNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.resetPasswordByEmail("unknown@mail.com", "newPassword");
        });
        assertEquals("User with email unknown@mail.com not found", exception.getMessage());
    }

    @Test
    public void testResetPasswordByPhone() {
        userService.registerByPhone("Dmitry", "89262533595", "oldPass");
        userService.resetPasswordByPhone("89262533595", "newPass");
        User user = userService.getUserByUsername("Dmitry");
        assertEquals("newPass", user.getPassword());
    }

    @Test
    public void testResetPasswordByPhone_UserNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.resetPasswordByPhone("00000000000", "newPass");
        });
        assertEquals("User with phone 00000000000 not found", exception.getMessage());
    }
}


