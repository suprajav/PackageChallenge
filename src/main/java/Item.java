public class Item {

    private int index;
    private double weight;
    private double cost;

    public Item(int index, double weight, double cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }
    public int getWeightInGrams() {
        return (int) (weight * 1000);
    }

    public int getCostInCents() {
        return (int) (weight * 1000);
    }
        @Override
    public String toString() {
        return "Item{" +
                "index=" + index +
                ", weight='" + weight + '\'' +
                ", cost=" + cost +
                '}';
    }

}
