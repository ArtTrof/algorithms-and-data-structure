package fractionalKnapsack;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);
        final Item[] items = {item1, item2, item3};
        Arrays.sort(items, Comparator.comparing(Item::valuePerUnitOfWeight).reversed());
        System.out.println(Arrays.toString(items));
        final int W = 7;
        int weightSoFar = 0;
        int valueSoFar = 0;
        int currentItem = 0;
        while (currentItem < items.length && weightSoFar != W) {
            if (weightSoFar + items[currentItem].getWeight() < W) {
                //we take full item
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            } else {
                //take only part of object
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight())
                        * items[currentItem].getValue();
                weightSoFar = W;//full pack
            }
            currentItem++;
        }
        System.out.println("Value of best pack:"+valueSoFar);
    }

}
