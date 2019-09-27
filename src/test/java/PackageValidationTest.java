import com.mobiquityinc.exception.APIException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackageValidationTest {

    PackageValidation packageValidation = new PackageValidation();
    @Test
    void validationMaxWeight() {

        Package pkg  =new Package(0, Collections.EMPTY_LIST);
        assertThrows(APIException.class, () -> packageValidation.validationMaxWeight(pkg));
    }

    @Test
    void validationMaxWeightNeg1() {

        Package pkg  =new Package(-1, Collections.EMPTY_LIST);
        assertThrows(APIException.class, () -> packageValidation.validationMaxWeight(pkg));
    }
    @Test
    void validationMaxWeight99() throws APIException {

        Package pkg  =new Package(99, Collections.EMPTY_LIST);
        packageValidation.validationMaxWeight(pkg);
    }

    @Test
    void validationMaxWeight100() throws APIException {

        Package pkg  =new Package(100, Collections.EMPTY_LIST);
        packageValidation.validationMaxWeight(pkg);
    }

    @Test
    void validationMaxWeight100_01() throws APIException {

        Package pkg  =new Package(100.01, Collections.EMPTY_LIST);
        assertThrows(APIException.class, () -> packageValidation.validationMaxWeight(pkg));
    }

    @Test
    void validationItemsZero()
    {
        Item  item =new Item(10,10,10);

        Package pkg = new Package(0,Collections.EMPTY_LIST);
        assertThrows(APIException.class, () -> packageValidation.validationItems(pkg));
    }
    @Test
    void validationItems16()
    {
        Item  item =new Item(10,10,10);
        List<Item> item1 = List.of(item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item);
        Package pkg = new Package(0,item1);
        assertThrows(APIException.class, () -> packageValidation.validationItems(pkg));
    }
    @Test
    void validationItems15() throws APIException {
        Item  item =new Item(10,10,10);
        List<Item> item1 = List.of(item, item, item, item, item, item, item, item, item, item, item, item, item, item, item);
        Package pkg = new Package(0,item1);
        packageValidation.validationItems(pkg);
    }
    @Test
    void validationIndexZero() throws APIException {
        Item  item =new Item(0,10,10);

        assertThrows(APIException.class, () ->  packageValidation.validateItemIndex(item));
    }
    @Test
    void validationIndexNeg1() throws APIException {

        Item  item =new Item(-1,10,10);

        assertThrows(APIException.class, () ->  packageValidation.validateItemIndex(item));
    }

    @Test
    void validationIndexPositive() throws APIException {

        Item  item =new Item(1,10,10);
        packageValidation.validateItemIndex(item);
    }

    @Test
    void validationCostZero() throws APIException {

        Item  item =new Item(10,10,0);

        assertThrows(APIException.class, () ->  packageValidation.validateCost(item));
    }

    @Test
    void validationCost100_01() throws APIException {

        Item  item =new Item(10,10,100.01);

        assertThrows(APIException.class, () ->  packageValidation.validateCost(item));
    }
    @Test
    void validationCost100() throws APIException {

        Item  item =new Item(10,10,100);

        packageValidation.validateCost(item);
    }
    @Test
    void validationCost90() throws APIException {

        Item  item =new Item(10,10,90);
        packageValidation.validateCost(item);
    }

//Test for WEight
    @Test
    void validationWeightZero() throws APIException {

        Item  item =new Item(10,0,0);

        assertThrows(APIException.class, () ->  packageValidation.validateWeight(item));
    }

    @Test
    void validationWeight100_01() throws APIException {

        Item  item =new Item(10,100.01,100.01);

        assertThrows(APIException.class, () ->  packageValidation.validateCost(item));
    }
    @Test
    void validationWeight100() throws APIException {

        Item  item =new Item(10,100,100);

        packageValidation.validateCost(item);
    }
    @Test
    void validationWeight90() throws APIException {

        Item  item =new Item(10,90,90);
        packageValidation.validateCost(item);
    }

}
