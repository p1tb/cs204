package restanakin.demo;

public class JediNotFoundException extends RuntimeException {
    public JediNotFoundException(Long id) {
        super("Could not find Jedi " + id);
    }
}
