package core.interpreter;

public class SyntaxException extends RuntimeException {
    public SyntaxException() {
    }

    public SyntaxException(String msg) {
        super(msg);
    }
}