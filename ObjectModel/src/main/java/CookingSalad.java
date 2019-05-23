import java.text.DecimalFormat;
import java.util.*;

interface CookingSalad extends ReadWrite  {

    default void searchByParamenters(ArrayList<ObjectModel.Ingredient> salad, String color, String name, int weight){
        ArrayList<ObjectModel.Ingredient> searchResults = new ArrayList<>(salad.size());

        for (ObjectModel.Ingredient ingredient : salad) {
            int checksForSearch = 0;
            if (color.equals(ingredient.color) || color.equals("")){
                checksForSearch++;
            } else {continue;}
            if (name.equals(ingredient.name) || name.equals("")) {
                checksForSearch++;
            } else {continue;}
            if (weight == ingredient.weight || weight == 0) {
                checksForSearch++;
            } else {continue;}
            if (checksForSearch == 3) {
                searchResults.add(ingredient);
            }
        }

        for (ObjectModel.Ingredient result: searchResults) {
            getInfo(result);
        }

        if(searchResults.isEmpty()) {
            System.out.println("No records found.");
        }
    }

    default ArrayList<ObjectModel.Ingredient> prepareSalad(String salad, Map saladsList) throws EmptyArrayListException {

        ArrayList<ObjectModel.Ingredient> list = new ArrayList<>();
        Iterator<Map.Entry<String, ArrayList>> iterator = saladsList.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList> pair = iterator.next();
            String name = pair.getKey();

            if (saladsList.containsKey(salad)) {
                if (name.equals(salad)) {
                    list = pair.getValue();
                    if (list.isEmpty()) {
                        throw new EmptyArrayListException(list);
                    }

                    //prepare each ingredient for cooking
                    for (ObjectModel.Ingredient ingredient : list) {
                        getIngredientForCooking(ingredient);
                    }
                    System.out.println("Please add spices and sauses if it is required");
                    System.out.println(salad + " has been prepared. Mamma-mia!");
                }


            } else {
                System.out.println("Sorry, salad is not in our menu. Please, use constructor.");
            }
        }

        return list;
    }

    default ArrayList<ObjectModel.Ingredient> prepareSalad() throws EmptyArrayListException {

        // User select ingredients by console
        ArrayList<ObjectModel.Ingredient> salad = new ArrayList<>();
        getIngredientsList();
        //add ingredients
        addIngredientInSalad(salad);

        try {
            if (salad.isEmpty()) {
                throw new EmptyArrayListException(salad);

            } else {
                System.out.println("Let's prepare salad!");
                for (ObjectModel.Ingredient ingredient : salad) {
                    System.out.println(ingredient.name + " " + ingredient.weight);
                }

                for (ObjectModel.Ingredient ingredient : salad) {
                    getIngredientForCooking(ingredient);
                }

                System.out.println("Please add spices and sauses if it is required");
                System.out.println("Your salad has been prepared. Mamma-mia!");
            }
        } catch (Exception e) {
            System.out.println("You've not specified ingredients for salad");

        }
        return salad;
    }

    default ArrayList<ObjectModel.Ingredient> prepareSaladFromSource(String sourceName) {
        ArrayList<ObjectModel.Ingredient> salad = new ArrayList<>();
        Map<Integer, Integer> valuesFromSource = new HashMap<>();

        switch (sourceName) {
            case "file":
                valuesFromSource = readDataFromFileForSaladIngredients("C://Users//Siarhei_Shyshparonak//Desktop//WriteInFileTest.txt");
                break;
            case "xml" :
                valuesFromSource = readDataForSaladFromXMLFile("C://Users//Siarhei_Shyshparonak//Desktop/XMLtestfile.xml");
                break;
            case "DB":
                valuesFromSource = getDataFromDBTable();
                break;

                default: System.out.println("No source.");
                break;
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = valuesFromSource.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator.next();
            int ingredientCode = pair.getKey();
            int weight = pair.getValue();

            switch (ingredientCode) {
                case 1:
                    salad.add(new ObjectModel.Tomato(weight));
                    break;
                case 2:
                    salad.add(new ObjectModel.Cucumber(weight));
                    break;
                case 3:
                    salad.add(new ObjectModel.Salad(weight));
                    break;
                case 4:
                    salad.add(new ObjectModel.Corn(weight));
                    break;
                case 5:
                    salad.add(new ObjectModel.Cabbage(weight));
                    break;
                case 6:
                    salad.add(new ObjectModel.Paprika(weight));
                    break;
                case 7:
                    salad.add(new ObjectModel.Onion(weight));
                    break;
                case 8:
                    salad.add(new ObjectModel.Carrot(weight));
                    break;
                case 9:
                    salad.add(new ObjectModel.Beetroot(weight));
                    break;
                default:
                    System.out.println("Please, select number 1-9.");
            }
        }

        //add ingredients
        System.out.println("Let's prepare salad!");
        for (ObjectModel.Ingredient ingredient : salad) {
            System.out.println(ingredient.name + " " + ingredient.weight);
        }

        for (ObjectModel.Ingredient ingredient : salad) {
            getIngredientForCooking(ingredient);
        }

        System.out.println("Please add spices and sauses if it is required");
        System.out.println("Your salad has been prepared. Mamma-mia!");

        return salad;
    }

    default void addIngredientInSalad (ArrayList<ObjectModel.Ingredient> salad) {

        // add ingredients manually by console

        Scanner sc = new Scanner(System.in);
        System.out.println("Input + for new ingredient selection");

        while (true) {
            String operation = sc.next();
            if (!operation.equals("+") || operation.equals("")) {
                break;
            } else {
                try {
                    System.out.println("Please, specify ingredient number:");
                    int number = sc.nextInt();
                    System.out.println("Please, specify weight:");
                    int weight = sc.nextInt();

                    switch (number) {
                        case 1:
                            salad.add(new ObjectModel.Tomato(weight));
                            break;
                        case 2:
                            salad.add(new ObjectModel.Cucumber(weight));
                            break;
                        case 3:
                            salad.add(new ObjectModel.Salad(weight));
                            break;
                        case 4:
                            salad.add(new ObjectModel.Corn(weight));
                            break;
                        case 5:
                            salad.add(new ObjectModel.Cabbage(weight));
                            break;
                        case 6:
                            salad.add(new ObjectModel.Paprika(weight));
                            break;
                        case 7:
                            salad.add(new ObjectModel.Onion(weight));
                            break;
                        case 8:
                            salad.add(new ObjectModel.Carrot(weight));
                            break;
                        case 9:
                            salad.add(new ObjectModel.Beetroot(weight));
                            break;
                        default:
                            System.out.println("Please, select ingredient number 1-9.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please, input number");
                }
            }
        }
    }

    default void getIngredientForCooking (ObjectModel.Ingredient ingredient) {
        //Cookers instruction for each ingredient
        if (ingredient instanceof ObjectModel.RootCrop) {
            if (((ObjectModel.RootCrop) ingredient).isNeedToBoil) {
                System.out.println("Please, boil a " + ingredient.name);
            }
            if (((ObjectModel.RootCrop) ingredient).isNeedToPeel) {
                System.out.println("Please, don't forget remove a peel from " + ingredient.name);
            }
            if (((ObjectModel.RootCrop) ingredient).isNeedToCut) {
                System.out.println("Please, cut a " + ingredient.name);
            }

        } else if (ingredient instanceof ObjectModel.Vegetable) {
            if (((ObjectModel.Vegetable) ingredient).isNeedToWash) {
                System.out.println("Please, wash a " + ingredient.name);
            }

            if (((ObjectModel.Vegetable) ingredient).isNeedToCut) {
                System.out.println("Please, cut a " + ingredient.name);
            }
        }
    }

    default Map<String, ArrayList> getSaladsList() throws EmptyMapException {

        Map<String, ArrayList> saladsLists = new TreeMap<>();
        //Salad No1
        ArrayList<ObjectModel.Vegetable> saladNo1 = new ArrayList<>();
        saladNo1.add(new ObjectModel.Tomato(20));
        saladNo1.add(new ObjectModel.Cucumber(20));
        saladNo1.add(new ObjectModel.Salad(20));
        saladNo1.add(new ObjectModel.Cabbage(12));
        saladsLists.put("Salad #1", saladNo1);

        //Salad No2
        ArrayList<ObjectModel.Vegetable> saladNo2 = new ArrayList<>();
        saladNo2.add(new ObjectModel.Tomato(20));
        saladNo2.add(new ObjectModel.Cucumber(15));
        saladNo2.add(new ObjectModel.Carrot(20));
        saladNo2.add(new ObjectModel.Beetroot(12));
        saladsLists.put("Salad #2", saladNo2);

        if (saladsLists.isEmpty()) {
            throw new EmptyMapException(saladsLists);
        }
        return saladsLists;
    }

    default void calculateSaladCalories(ArrayList<ObjectModel.Ingredient> salad) {
        try {
            double calories = 0;
            int weight = 0;
            for (ObjectModel.Ingredient ingredient : salad) {
                calories = calories + ingredient.caloriesForOnePiece;
                weight = weight + ingredient.weight;
            }

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Calories: " + df.format(calories));
            System.out.println("Weight: " + weight);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    default TreeMap<Integer, ObjectModel.Ingredient> getIngredientsList() {
        TreeMap<Integer, ObjectModel.Ingredient> ingredientsList = new TreeMap<>();
        ingredientsList.put(1, new ObjectModel.Tomato());
        ingredientsList.put(2, new ObjectModel.Cucumber());
        ingredientsList.put(3, new ObjectModel.Salad());
        ingredientsList.put(4, new ObjectModel.Corn());
        ingredientsList.put(5, new ObjectModel.Cabbage());
        ingredientsList.put(6, new ObjectModel.Paprika());
        ingredientsList.put(7, new ObjectModel.Onion());
        ingredientsList.put(8, new ObjectModel.Carrot());
        ingredientsList.put(9, new ObjectModel.Beetroot());

        Iterator<Map.Entry<Integer, ObjectModel.Ingredient>> iterator = ingredientsList.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, ObjectModel.Ingredient> pair = iterator.next();
            int number = pair.getKey();
            String name = pair.getValue().name;
            System.out.println("Number: " + number + " Ingredient name: " + name);
        }

        return ingredientsList;
    }

    default void getInfo (ObjectModel.Ingredient ingredient) {

        System.out.println("Name: " + ingredient.name);
        System.out.println("Color: " + ingredient.color);
        System.out.println("Weight: " + ingredient.weight);

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Calories: " + df.format(ingredient.caloriesForOnePiece));
        System.out.println("CaloriesPer100gramm: " + ingredient.caloriesPer100gramm);

        if (ingredient instanceof ObjectModel.Vegetable) {
            System.out.println("Need to wash: " + ((ObjectModel.Vegetable) ingredient).isNeedToWash);
            System.out.println("Need to cut: " + ((ObjectModel.Vegetable) ingredient).isNeedToCut);
        }


        if (ingredient instanceof ObjectModel.Onion) {
            System.out.println("Need to cry: " + ((ObjectModel.Onion) ingredient).isNeedToCry);
        }

        if (ingredient instanceof ObjectModel.Paprika) {
            System.out.println("Need to remove ceeds: " + ((ObjectModel.Paprika) ingredient).isNeedToRemoveCeed);
        }

        if (ingredient instanceof ObjectModel.RootCrop) {
            System.out.println("Need to peel: " + ((ObjectModel.RootCrop) ingredient).isNeedToPeel);
            System.out.println("Need to boil: " + ((ObjectModel.RootCrop) ingredient).isNeedToBoil);
        }

        System.out.println();
    }
}
