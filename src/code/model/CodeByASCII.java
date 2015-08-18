package code.model;

/**
 * Created by Alexandr on 8/17/2015.
 */
public class CodeByASCII implements ICode{
    private String password;

    public CodeByASCII(String password) {
        this.password = password;
    }

    public String codePassword() {
        StringBuilder passwordChars = new StringBuilder();
        for (char c : password.toCharArray()) {
            int newCharCode = (int)c + 2;
            passwordChars.append((char)newCharCode);
        }

        return passwordChars.toString();
    }

    public String decodePassword() {
        StringBuilder passwordChars = new StringBuilder();
        for (char c : password.toCharArray()) {
            int newCharCode = (int)c - 2;
            passwordChars.append((char)newCharCode);
        }

        return passwordChars.toString();
    }
}
