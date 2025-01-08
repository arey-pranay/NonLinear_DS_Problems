class Solution {
    public boolean checkValidString(String s) {
        return function(s, 0, 0);
    }
    public boolean function(String s, int i, int closingNeeded){
        if(closingNeeded < 0) return false;
        if(i == s.length()) return true;
        if(s.charAt(i)==')') return function(s, i+1, closingNeeded-1);
        else if(s.charAt(i)=='(') return function(s, i+1, closingNeeded+1);
        else {
            return function(s, i+1, closingNeeded-1) || function(s, i+1, closingNeeded+1) || function(s, i+1, closingNeeded);
        }
    }
}
