package security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHash {
    public String createHashedPassword(String pass) throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[32];
        MessageDigest messageDigest =
                MessageDigest.getInstance("SHA-512");
        messageDigest.update(salt);
        byte[] hashedPassword = messageDigest
                .digest(pass.getBytes(StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        for (byte hs : hashedPassword) {
            stringBuilder.append(String.format("%02x", hs));
        }
        return stringBuilder.toString();
    }

    public boolean checkEqualityOfHashedPasswords(String enteredPass, String databasePass) throws NoSuchAlgorithmException {
        return databasePass.equals(this.createHashedPassword(enteredPass));
    }
}
