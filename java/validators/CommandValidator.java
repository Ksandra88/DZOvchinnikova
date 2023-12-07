package validators;

public class CommandValidator {
    public static boolean isValidate(String commandStr, Enum[] Commands) {
        for (Enum commands1 : Commands) {
            if (commands1.name().equals(commandStr)) {
                return true;
            }
        }
        return false;
    }
}