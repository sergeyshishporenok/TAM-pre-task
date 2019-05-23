import java.io.*;
import java.util.*;

public interface WriterReaderFromFile  {

    default Map<Integer,Integer> readDataFromFileForSaladIngredients (String fileName){

        Map<Integer, Integer> keysFromFile = new HashMap<>();

        try
        {
            FileInputStream inputStream = new FileInputStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String strLine1, strLine2;

            while ((strLine1 = reader.readLine()) != null && (strLine2 = reader.readLine()) != null){
                System.out.println(strLine1);
                System.out.println(strLine2);

                try {
                    int ingredientCode = Integer.parseInt(strLine1);
                    int weight = Integer.parseInt(strLine2);

                    keysFromFile.put(ingredientCode, weight);

                }
                catch (NumberFormatException exception) {
                    System.out.println("Please, input integer value.");
                }
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return keysFromFile;
    }

    default void writeIngredientListDataInFile(TreeMap<Integer, ObjectModel.Ingredient> ingredientsList, String filePath) {

        Iterator<Map.Entry<Integer, ObjectModel.Ingredient>> iterator = ingredientsList.entrySet().iterator();
        String text = "";

        while (iterator.hasNext()) {
            Map.Entry<Integer, ObjectModel.Ingredient> pair = iterator.next();

            int key = pair.getKey();
            ObjectModel.Ingredient ingredient = pair.getValue();

            String addedText = "ID: "+key + " Name: " + ingredient.name + " Color: " + ingredient.color + " Calories: " + ingredient.caloriesPer100gramm + "\n";
            text = text + addedText;
        }

        try (FileOutputStream writer = new FileOutputStream(filePath))
        {
            //transfer data to bytes
            byte[] buffer = text.getBytes();
            writer.write(buffer, 0, buffer.length);

        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("The file has been written");
    }
}
