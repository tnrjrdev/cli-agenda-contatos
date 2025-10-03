package service;

public class ContatoNotFoundException extends RuntimeException {
    public ContatoNotFoundException(String message) {
        super(message);
    }
}
