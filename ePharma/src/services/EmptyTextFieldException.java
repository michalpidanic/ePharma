package services;

/**
 * Own exception for empty text field
 */
public class EmptyTextFieldException extends Exception {
    public EmptyTextFieldException() {
        super("Žiadne pole nemôže byť prázdne!");
    }
}
