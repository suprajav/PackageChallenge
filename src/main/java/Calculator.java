public class Calculator {

    public void calculate(Package pkg,Item item) {

        int capacity = pkg.getMaxWeightInGrams();
        Item[] items = pkg.getItems().toArray(new Item[pkg.getItems().size()]);
        int value = item.getCostInCents();

        int NB_ITEMS = items.length;
// we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

// first line is initialized to 0
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

// we iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].getWeightInGrams() > j)
                    matrix[i][j] = matrix[i - 1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - items[i - 1].getWeightInGrams()] +
                            items[i - 1].getCostInCents());
            }
        }
    }
}
