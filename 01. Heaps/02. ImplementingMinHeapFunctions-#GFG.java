class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

   
   int extractMin() { 
        if (heap_size <= 0) return -1;
        //separately store the top value to return it later
        int val = harr[0];
        
        // put the last value at the top (swap)
        harr[0] = harr[heap_size - 1];
        heap_size--;
        
        // since the top is changed, we need to update the heap again top-to-bottom
        MinHeapify(0);  
        
        return val;
    }

   void insertKey(int k) {
        // put the element at last index, and move up, and update the size
        insertAndMoveUp(heap_size, k);
        heap_size++;
    }

    
   void deleteKey(int i) {
       // to delete ith index, put the MIN_VALUE at ith index and put it at the appropriate position, which is the top position
       insertAndMoveUp(i, Integer.MIN_VALUE); 
       //after the MIN_VALUE reaches the top position, just remove it and heapify, by the extractMin function
       extractMin(); 
    }


    void insertAndMoveUp(int i, int new_val){
        //assign new_val to ith position 
        harr[i] = new_val;
        //and keep comparing that value to parents to make it reach the appropriate location / index
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        
        // if a smaller child is present
        if (smallest != i) {
            // swap the ith and smallest child
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            
            // call heapify again with the new smallest child
            MinHeapify(smallest);
        }
    }
}
