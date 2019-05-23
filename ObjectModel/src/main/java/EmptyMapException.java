import java.util.Map;

public class EmptyMapException extends Exception {
    public EmptyMapException(Map map) {
        super("Maplist" + map + "is empty");
    }
}

