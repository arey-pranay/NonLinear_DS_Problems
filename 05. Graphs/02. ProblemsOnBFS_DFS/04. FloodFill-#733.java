class Solution {
    int original;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        original = image[sr][sc];  
        if(original==color) return image;
        func(sr,sc, image, color);
        return image;
    }
    public void func(int r, int c, int[][] image, int color){
        image[r][c] = color;
        if(r!=0 && image[r-1][c]==original){
            func(r-1,c,image, color);
        }
         if(c!=0 && image[r][c-1]==original){
            func(r,c-1,image, color);
        }
        if(r!=image.length-1 && image[r+1][c]==original){
            func(r+1,c,image, color);
        }
         if(c!=image[0].length-1 && image[r][c+1]==original){
            func(r,c+1,image, color);
        }
        return;
    }
        
}
