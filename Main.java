import java.util.Optional;

// Define the UserService interface
interface UserService {
    // Default method to return a welcome message
    default String getWelcomeMessage() {
        return "Welcome, Guest!";
    }

    // Method to get the user's name wrapped in an Optional
    Optional<String> getUser(String name);
}

// Implement the UserService interface
class UserServiceImpl implements UserService {
    @Override
    public Optional<String> getUser(String name) {
        return Optional.ofNullable(name);
    }

    // Method to get the final welcome message
    public String getPersonalizedWelcomeMessage(String name) {
        return getUser(name).map(n -> "Welcome, " + n + "!")
                            .orElse(getWelcomeMessage());
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        
        System.out.println(userService.getPersonalizedWelcomeMessage("John")); // Output: Welcome, John!
        System.out.println(userService.getPersonalizedWelcomeMessage(null));    // Output: Welcome, Guest!
    }
}
