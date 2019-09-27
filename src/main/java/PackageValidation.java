import com.mobiquityinc.exception.APIException;

import java.util.ArrayList;
import java.util.List;

public class PackageValidation {

    double maxWeight = 0;
    List<Item> itemList = new ArrayList<>();


    public void validationMaxWeight(Package packageOfItems) throws APIException {

        if(packageOfItems.getMaxWeight() <= 0 || packageOfItems.getMaxWeight() > 100)
        {
            throw new APIException("Max Package is not Valid");
        }

    }
    public void validationItems(Package packageOfItems) throws APIException
    {
       if(packageOfItems.getItems().size() <= 0 || packageOfItems.getItems().size() >15 )
       {
           throw new APIException("Item List is not Valid");
       }

    }
    public void validateItemIndex(Item item) throws APIException
    {
        if (item.getIndex() <= 0)
        {
            throw new APIException("Item Index is not Valid");
        }

    }
    public void validateCost(Item item) throws APIException {
        if (item.getCost() <= 0 || item.getCost() >100 )
        {
            throw new APIException("Item Cost is not Valid");
        }
    }


    public void validateWeight(Item item) throws APIException {

        if (item.getWeight() <= 0 || item.getWeight() >100 )
        {
            throw new APIException("Item Weight is not Valid");
        }
    }
}
