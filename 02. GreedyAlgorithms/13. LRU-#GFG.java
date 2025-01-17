class Solution{
    static int pageFaults(int N, int C, int[] pages) {
        // To store pages currently in memory
        Set<Integer> memory = new HashSet<>();
        
        // To track the order of pages in memory (using a LinkedList to act as a queue)
        LinkedList<Integer> pageOrder = new LinkedList<>();
        
        // To count the number of page faults
        int pageFaults = 0;
        
        // Process each page in the page sequence
        for (int page : pages) {
            // If the page is not already in memory, it's a page fault
            if (!memory.contains(page)) {
                pageFaults++;
                
                // If memory is full, remove the Least Recently Used (LRU) page
                if (memory.size() >= C) {
                    // The first element in pageOrder is the LRU page
                    int lruPage = pageOrder.removeFirst();
                    memory.remove(lruPage); // Remove the LRU page from memory
                }
                
                // Add the new page to memory and mark it as the most recently used
                memory.add(page);
                pageOrder.add(page);
            } else {
                // If the page is already in memory, move it to the most recently used position
                pageOrder.remove(Integer.valueOf(page));
                pageOrder.add(page);
            }
        }
        
        return pageFaults;
    }
}
