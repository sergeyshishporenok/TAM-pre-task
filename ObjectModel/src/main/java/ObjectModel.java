import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class ObjectModel {

    public static void main(String[] args) {
        /*
        Ingredient tomato = new Tomato();
        tomato.getInfo();

        Ingredient cucumber = new Cucumber();
        cucumber.getInfo();

        Ingredient salad = new Salad();
        salad.getInfo();

        Ingredient onion = new Onion();
        onion.getInfo();

        Ingredient corn = new Corn();
        corn.getInfo();

        Ingredient cabbage = new Cabbage();
        cabbage.getInfo();

        Ingredient paprika = new Paprika();
        paprika.getInfo();

        Ingredient carrot = new Carrot();
        carrot.getInfo();

        Ingredient beetroot = new Beetroot();
        beetroot.getInfo();
        */

        //Vegetables sorted by parameter
        getSortedView();
    }

    public static void getSortedView(){
        try {
            System.out.println(getIngredientSort("name"));
            System.out.println(getIngredientSort("color"));
            System.out.println(getIngredientSort("calories"));
            System.out.println(getIngredientSort("test"));
        } catch (InvalidSortingParameter e) {
            System.out.println(e.getMessage());
        } catch (EmptyArrayListException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Ingredient> getIngredientSort(String parameterName) throws InvalidSortingParameter, EmptyArrayListException  {
        //Sorting by parameters
        ArrayList<Ingredient> list = getIngredientsList();

            Comparator<Ingredient> comparator;

            if (parameterName.equalsIgnoreCase("name")) {
                comparator = Comparator.comparing(obj -> obj.name);
                list.sort(comparator);
            } else if (parameterName.equalsIgnoreCase("color")) {
                comparator = Comparator.comparing(obj -> obj.color);
                list.sort(comparator);
            } else if (parameterName.equalsIgnoreCase("calories")) {
                comparator = Comparator.comparing(obj -> obj.caloriesPer100gramm);
                list.sort(comparator);
            } else {
                throw new InvalidSortingParameter(parameterName);
            }
            return list;

    }

    public static abstract class Ingredient  {
        protected String color;
        protected String name;
        protected int weight; //weight of one vegetable in gramms
        protected double caloriesForOnePiece;
        protected int caloriesPer100gramm;

        public void getInfo() {

            System.out.println("Name: " + name);
            System.out.println("Color: " + color);
            System.out.println("Weight: " + weight);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Calories: " + df.format(caloriesForOnePiece));
            System.out.println("CaloriesPer100gramm: " + caloriesPer100gramm);

            System.out.println();
        }
    }

    public static abstract class Vegetable extends Ingredient {

        public boolean isNeedToWash;
        public boolean isNeedToCut;


        @Override
        public void getInfo() {

            System.out.println("Name: " + name);
            System.out.println("Color: " + color);
            System.out.println("Weight: " + weight);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Calories: " + df.format(caloriesForOnePiece));
            System.out.println("CaloriesPer100gramm: " + caloriesPer100gramm);

            System.out.println("Need to wash: " + isNeedToWash);
            System.out.println("Need to cut: " + isNeedToCut);

        }
    }

    public static class Tomato extends Vegetable  {

        public Tomato(int weight) {
            this.caloriesPer100gramm = 20;
            this.color = "red";
            this.name = "tomato";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = true;
            this.isNeedToCut = true;
        }

        public Tomato() {
            this.name = "tomato";
            this.color = "red";
            this.caloriesPer100gramm = 20;
            this.isNeedToWash = true;
            this.isNeedToCut = true;
        }
    }

    public static class Cucumber extends Vegetable {
        public Cucumber(int weight) {
            //7 parameters
            this.caloriesPer100gramm = 15;
            this.color = "green";
            this.name = "cucumber";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = true;
            this.isNeedToCut = true;
        }

        public Cucumber() {
            // 5 parameters
            this.name = "cucumber";
            this.color = "green";
            this.caloriesPer100gramm = 15;
            this.isNeedToWash = true;
            this.isNeedToCut = true;
        }
    }

    public static class Salad extends Vegetable {
        public Salad(int weight) {
            this.caloriesPer100gramm = 12;
            this.color = "green";
            this.name = "salad";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = true;
            this.isNeedToCut = true;
        }

        public Salad() {
            this.name = "salad";
            this.caloriesPer100gramm = 12;
            this.color = "green";
            this.isNeedToWash = true;
            this.isNeedToCut = true;
        }
    }

    public static class Corn extends Vegetable {
        public Corn(int weight) {
            this.caloriesPer100gramm = 123;
            this.color = "yellow";
            this.name = "corn";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = false; //corn from cans
            this.isNeedToCut = false;

        }

        public Corn() {
            this.name = "corn";
            this.color = "yellow";
            this.caloriesPer100gramm = 123;
            this.isNeedToWash = false; //corn from cans
            this.isNeedToCut = false;
        }
    }

    public static class Cabbage extends Vegetable {
        public Cabbage(int weight) {
            this.caloriesPer100gramm = 27;
            this.color = "green";
            this.name = "cabbage";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = true;
            this.isNeedToCut = true;

        }

        public Cabbage() {
            this.name = "cabbage";
            this.color = "green";
            this.caloriesPer100gramm = 27;
            this.isNeedToWash = true;
            this.isNeedToCut = true;
        }
    }

    public static class Paprika extends Vegetable {
        protected boolean isNeedToRemoveCeed;

        public Paprika(int weight) {
            this.caloriesPer100gramm = 27;
            this.color = "red";
            this.name = "paprika";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = true;
            this.isNeedToCut = true;
            this.isNeedToRemoveCeed = true;
        }

        public Paprika() {
            this.name = "paprika";
            this.color = "red";
            this.caloriesPer100gramm = 27;
            this.isNeedToWash = true;
            this.isNeedToCut = true;
            this.isNeedToRemoveCeed = true;}

        @Override
        public void getInfo() {

            System.out.println("Name: " + name);
            System.out.println("Color: " + color);
            System.out.println("Weight: " + weight);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Calories: " + df.format(caloriesForOnePiece));
            System.out.println("CaloriesPer100gramm: " + caloriesPer100gramm);

            System.out.println("Need to wash: " + isNeedToWash);
            System.out.println("Need to cut: " + isNeedToCut);

            System.out.println("Need to remove ceeds: " + isNeedToRemoveCeed);

        }
    }

    public static class Onion extends Vegetable {
        protected boolean isNeedToCry;

        public Onion(int weight) {
            this.caloriesPer100gramm = 47;
            this.color = "white";
            this.name = "onion";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = true;
            this.isNeedToCut = true;
            this.isNeedToCry = true;
        }

        public Onion() {
            this.name = "onion";
            this.color = "white";
            this.caloriesPer100gramm = 47;
            this.isNeedToWash = true;
            this.isNeedToCut = true;
            this.isNeedToCry = true;
        }

        @Override
        public void getInfo() {

            System.out.println("Name: " + name);
            System.out.println("Color: " + color);
            System.out.println("Weight: " + weight);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Calories: " + df.format(caloriesForOnePiece));
            System.out.println("CaloriesPer100gramm: " + caloriesPer100gramm);

            System.out.println("Need to wash: " + isNeedToWash);
            System.out.println("Need to cut: " + isNeedToCut);

            System.out.println("Need to cry: " + isNeedToCry);

        }
    }

    public static class Carrot extends RootCrop {
        public Carrot(int weight) {
            this.caloriesPer100gramm = 25;
            this.color = "orange";
            this.name = "carrot";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = true;
            this.isNeedToCut = true;
            this.isNeedToBoil = true;
            this.isNeedToPeel = true;
        }

        public Carrot() {
            this.name = "carrot";
            this.color = "orange";
            this.caloriesPer100gramm = 25;
            this.isNeedToWash = true;
            this.isNeedToCut = true;
            this.isNeedToBoil = true;
            this.isNeedToPeel = true;
        }
    }

    public static class Beetroot extends RootCrop {
        public Beetroot(int weight) {
            this.caloriesPer100gramm = 49;
            this.color = "purple";
            this.name = "beetroot";
            this.weight = weight;
            this.caloriesForOnePiece = ((double) weight / 100) * ((double) caloriesPer100gramm);
            this.isNeedToWash = true;
            this.isNeedToCut = true;
            this.isNeedToBoil = true;
            this.isNeedToPeel = true;
        }

        public Beetroot() {
            this.name = "beetroot";
            this.color = "purple";
            this.caloriesPer100gramm = 49;
            this.isNeedToWash = true;
            this.isNeedToCut = true;
            this.isNeedToBoil = true;
            this.isNeedToPeel = true;
        }
    }

    public static class RootCrop extends Vegetable {
        protected boolean isNeedToBoil;
        protected boolean isNeedToPeel;

        @Override
        public void getInfo() {

            System.out.println("Name: " + name);
            System.out.println("Color: " + color);
            System.out.println("Weight: " + weight);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Calories: " + df.format(caloriesForOnePiece));
            System.out.println("CaloriesPer100gramm: " + caloriesPer100gramm);

            System.out.println("Need to wash: " + isNeedToWash);
            System.out.println("Need to cut: " + isNeedToCut);

            System.out.println("Need to boil: " + isNeedToBoil);
            System.out.println("Need to remove a peel: " + isNeedToPeel);

        }
    }

    public static ArrayList<Ingredient> getIngredientsList() throws EmptyArrayListException{
        ArrayList<Ingredient> ingredientsList = new ArrayList<>();

        ingredientsList.add(new ObjectModel.Tomato());
        ingredientsList.add(new ObjectModel.Cucumber());
        ingredientsList.add(new ObjectModel.Salad());
        ingredientsList.add(new ObjectModel.Corn());
        ingredientsList.add(new ObjectModel.Cabbage());
        ingredientsList.add(new ObjectModel.Paprika());
        ingredientsList.add(new ObjectModel.Onion());
        ingredientsList.add(new ObjectModel.Carrot());
        ingredientsList.add(new ObjectModel.Beetroot());


        if (ingredientsList.isEmpty()) {
           throw new EmptyArrayListException(ingredientsList);
        }

        return ingredientsList;
    }

}

