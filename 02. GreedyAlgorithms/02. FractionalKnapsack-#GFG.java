class Solution {
    
    // A class to store the value, weight, and value-to-weight ratio of an item
    static class Item {
        int value, weight;
        double ratio;
        
        // Constructor to initialize an item
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double)value / weight;  // value-to-weight ratio
        }
    }
    
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // Step 1: Create a list of items
        int n = val.size();
        List<Item> items = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            items.add(new Item(val.get(i), wt.get(i)));
        }
        
        // Step 2: Sort the items based on value-to-weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));
        
        // Step 3: Greedily pick items
        double totalValue = 0.0;
        int currentCapacity = capacity;
        
        for (Item item : items) {
            if (currentCapacity == 0) {
                break;  // No more capacity left in the knapsack
            }
            
            if (item.weight <= currentCapacity) {
                // Take the whole item
                totalValue += item.value;
                currentCapacity -= item.weight;
            } else {
                // Take the fraction of the item that fits
                totalValue += item.value * ((double) currentCapacity / item.weight);
                currentCapacity = 0;  // Knapsack is now full
            }
        }
        
        return totalValue;
    }
}
