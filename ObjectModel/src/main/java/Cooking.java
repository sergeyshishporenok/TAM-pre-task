import java.util.*;

public class Cooking implements CookingSalad  {
    public static void main(String [] args){

        //Create salad from already prepared list
        createSaladFromList();

        //Create salad by ingredients selection
        createSaladByIngredientSelection();

        //Search by parameters
        searchByParametersInSalad();

        // Calculate calories for salad
        calculateCaloriesForSalad();

        //Write Data to file
        Cooking cooking = new Cooking();
        //cooking.writeIngredientListDataInFile(cooking.getIngredientsList(), "C://Users//Siarhei_Shyshparonak//IdeaProjects//pre-tasks for TAM//src//ObjectModel//src//WriteInFileTest.txt");

        //Read Data from file
        //get salad ingredients
        cooking.prepareSaladFromSource("file");

        //Read Data from XML file
        cooking.prepareSaladFromSource("xml");

        //Read Data from DB file
        cooking.prepareSaladFromSource("DB");

    }

    public static void createSaladFromList(){
        //Create salad from already prepared list
        Cooking cooking = new Cooking();
        try {
            cooking.prepareSalad("Salad #1", cooking.getSaladsList());
            cooking.prepareSalad("Salad #2", cooking.getSaladsList());
        } catch (EmptyMapException e) {
            System.out.println(e.getMessage());
        } catch (EmptyArrayListException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createSaladByIngredientSelection() {
        //Create salad by ingredients selection
            Cooking cooking = new Cooking();
        try {
            cooking.prepareSalad();
        } catch (EmptyArrayListException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void searchByParametersInSalad() {
        //Search by parameters
        Cooking cooking = new Cooking();
        try {
            Map<String, ArrayList> saladList = cooking.getSaladsList();
            cooking.searchByParamenters(saladList.get("Salad #1"), "orange", "", 0);
        } catch (EmptyMapException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void calculateCaloriesForSalad() {
        Cooking cooking = new Cooking();
       try {
           Map<String, ArrayList> saladList1 = cooking.getSaladsList();
           cooking.calculateSaladCalories(saladList1.get("Salad #1"));
           cooking.calculateSaladCalories(cooking.prepareSalad());
       } catch (EmptyMapException e) {
           System.out.println(e.getMessage());
       } catch (EmptyArrayListException e) {
           System.out.println(e.getMessage());
       }

    }
}




