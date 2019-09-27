import com.mobiquityinc.exception.APIException;

import javax.imageio.IIOException;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Packar {

    static List<Package> packages = new ArrayList<>();
    static Package packageOfItems;

    public static void main(String[] args) throws APIException {

        //reading a file
        pack("package.txt");
        Calculator calculator = new Calculator();

    }

    public static String pack(String filePath) throws APIException {
        List<String> lines = new ArrayList<>();

        try {
            Path path = Paths.get(filePath);
            lines = Files.readAllLines(path);
        } catch (IOException io) {
            throw new APIException("Could not read the file");
        }
        for (String line : lines) {
            Package aPackage = parseLine(line);
            validate(aPackage);
            packages.add(aPackage);
        }
        // System.out.println(lines);
        return  packages.toString();
    }

    private static void validate(Package aPackage) throws APIException {

        PackageValidation packageValidation = new PackageValidation();
        packageValidation.validationMaxWeight(aPackage);
        packageValidation.validationItems(aPackage);
        for (Item item : aPackage.getItems()) {
            packageValidation.validateItemIndex(item);
            packageValidation.validateCost(item);
            packageValidation.validateWeight(item);
        }

    }

    public static Package parseLine(String lineToBeParsed) {
        String[] packageStr = lineToBeParsed.split(":");
        double maxWeight = Double.parseDouble(packageStr[0]);
        System.out.println(maxWeight);
        String[] itemStr = packageStr[1].split(" ");
        List<Item> itemList = new ArrayList<>();
        for (String item : itemStr) {
            // System.out.println(item);
            if (item.length() > 0) {
                String itemWithoutParenthesis = item.substring(1, item.length() - 1);
                String[] itemAsArray = itemWithoutParenthesis.split(",");
                String cost = itemAsArray[2].replace("€", "");
                Item item1 = new Item(Integer.parseInt(itemAsArray[0]), Double.parseDouble(itemAsArray[1]), Double.parseDouble(cost));
                itemList.add(item1);
            }
        }

        itemList.sort(Comparator.comparing((Item i) -> i.getWeight()));
        //System.out.println(itemList.toString());
        new Package(maxWeight, itemList);
        return packageOfItems;
    }

}
