package exceptions;

public class InvalidShapeException extends Exception {
    public InvalidShapeException() {
        super("Invalid shape entered");
    }
}