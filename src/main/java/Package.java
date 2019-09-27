import java.util.List;

public class Package {


    private double maxWeight;
    private List<Item> items;

    public Package(double maxWeight, List<Item> items) {
        this.maxWeight = maxWeight;
        this.items = items;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getMaxWeightInGrams()
    {
        return (int)(maxWeight*1000);

    }


}
