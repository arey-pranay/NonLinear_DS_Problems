import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Step 1: If the end word isn't in the word list, return 0
        int temp = wordList.indexOf(endWord);
        if (temp == -1) return 0;

        // Step 2: Initialize necessary variables
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);  // Make sure the begin word is also in the set.
        
        // Step 3: Use a visited set to avoid revisiting words
        Set<String> visited = new HashSet<>();
        
        // Step 4: Initialize a queue for BFS
        Queue<Combo> queue = new LinkedList<>();
        queue.offer(new Combo(beginWord, 1));  // Starting word with level 1
        visited.add(beginWord);
        
        // Step 5: BFS traversal to find the shortest transformation sequence
        while (!queue.isEmpty()) {
            Combo current = queue.poll();
            String currentWord = current.str;
            int currentLevel = current.call;

            // Check all possible transformations for currentWord
            for (int i = 0; i < currentWord.length(); i++) {
                char[] wordArray = currentWord.toCharArray();
                
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String newWord = new String(wordArray);

                    // If it's a valid transformation and we haven't visited it yet
                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        if (newWord.equals(endWord)) {
                            return currentLevel + 1;  // Found the end word
                        }

                        // Add the new word to the queue and mark it as visited
                        queue.offer(new Combo(newWord, currentLevel + 1));
                        visited.add(newWord);
                    }
                }
            }
        }

        // If no transformation path is found, return 0
        return 0;
    }

    // Helper class to store the word and its transformation level
    class Combo {
        String str;
        int call;
        Combo(String str, int call) {
            this.str = str;
            this.call = call;
        }
    }
}





// DFS approach, but with TLE 




// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
//         int temp = wordList.indexOf(endWord);
//         if(temp==-1) return 0;

//         // step-1 : find the next possible words. (i.e., only 1 different character)
//         LinkedHashSet<String> wordSet = new LinkedHashSet<>();

//         // for(String s : wordList) wordSet.add(s);
//         int ans = findNext(new Combo(beginWord,1), wordSet, wordList, endWord, Integer.MAX_VALUE);
//         if(ans==Integer.MAX_VALUE) return 0;
//         return ans;

//     }
//     public int findNext(Combo c, LinkedHashSet<String> wordSetOld, List<String> wordList, String endWord, int ans){
//         ArrayList<Combo> arr = new ArrayList<>();
//         LinkedHashSet<String> wordSet = new LinkedHashSet<>();
//         for(String S : wordSetOld) wordSet.add(S);
//         String str = c.str;
//         int call = c.call;
//         // System.out.println();
//         // System.out.println(call);
//         // System.out.println(str);
//         // System.out.println(wordSet);
//         wordSet.add(str);
//         if(str.equals(endWord)){
//             // System.out.println("found");
//             return call;
//         }
//         for(String S : wordList){
//             int temp =0;
//             if(wordSetOld.contains(S)) continue;
//             // System.out.print(S+ " ");
//             for(int i=0;i<S.length();i++){
//                 if(S.charAt(i)!=str.charAt(i)) temp++;
//                 if(temp > 1) break;
//             }
//             if(temp == 1){  
//                 arr.add(new Combo(S,call+1));
//             }
//         }
//         // System.out.println();
//         for(Combo tempCombo : arr){
//             int returnVal = findNext(tempCombo, wordSet, wordList, endWord, ans);
//             // System.out.println(tempCombo.str+" "+tempCombo.call+" "+returnVal);
//             ans = Math.min(ans, returnVal);
//         }

//         return ans;
//     }
//     class Combo{
//         String str;
//         int call;
//         Combo(String str, int call){
//             this.str = str;
//             this.call = call;
//         }
//     }
//     // store all strings in hs, and remove a string whenever you call a function with that string 
//     //  hit,1 -> ["hot,2"]
//     //  hot,2 -> ["lot,3","dot,3"]
//     //  lot,3 -> ["log,4"], dot -> ["dog,4"]
//     //  log,4 -> ["cog,5"], dog -> ["cog,5"]
//     //  cog,5 -> cog==cog return 5
// }
