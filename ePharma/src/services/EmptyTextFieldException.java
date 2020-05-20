package services;

public class EmptyTextFieldException extends Exception {
    public EmptyTextFieldException() {
        super("Žiadne pole nemôže byť prázdne!");
    }
}
