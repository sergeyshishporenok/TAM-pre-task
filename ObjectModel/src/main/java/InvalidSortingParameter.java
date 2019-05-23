
public class InvalidSortingParameter extends Exception {
    public InvalidSortingParameter(String parameter) {
        super("Parameter " + parameter + " is invalid");
    }
}
