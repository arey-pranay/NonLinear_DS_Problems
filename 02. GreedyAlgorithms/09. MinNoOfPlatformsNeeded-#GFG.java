        // Sort the arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        // Initialize pointers for arrival and departure
        int i = 1;  // Pointer for arrival times
        int j = 0;  // Pointer for departure times
        
        // To store the result (maximum number of platforms)
        int platforms_needed = 1;
        int max_platforms = 1;
        
        // Traverse through all arrival and departure times
        while (i < arr.length && j < dep.length) {
            // If the next arrival is before or at the same time as the next departure
            if (arr[i] <= dep[j]) {
                platforms_needed++;  // We need another platform
                i++;  // Move to the next arrival
            } else {
                platforms_needed--;  // A platform is freed
                j++;  // Move to the next departure
            }
            
            // Update the maximum platforms needed
            max_platforms = Math.max(max_platforms, platforms_needed);
        }
        
        return max_platforms;
