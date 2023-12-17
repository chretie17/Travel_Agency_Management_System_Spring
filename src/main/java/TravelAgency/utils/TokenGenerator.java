import java.util.UUID;

public class TokenGenerator {

    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        String token = generateToken();
        System.out.println("Generated Token: " + token);
    }
}
