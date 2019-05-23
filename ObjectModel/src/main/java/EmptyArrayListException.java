import java.util.ArrayList;

//Custom Exception for empty Ingredients list
public class EmptyArrayListException extends Exception {
    public EmptyArrayListException(ArrayList<ObjectModel.Ingredient> list) {
        super("Arraylist" + list + " is empty");
    }
}

