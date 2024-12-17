class GFG{
    public static int H[]=new int[10009];
    public static int s=-1;
    
    public int parent(int i){
        return (i-1)/2;
        
    }
    public int leftChild(int i){
        return ((2*i)+1);
    }
    public int rightChild(int i){
        return ((2*i)+2);
    }
    public void shiftUp(int i){
        while(i>0 && H[parent(i)] < H[i]){
            int temp=H[i];
            H[i]=H[parent(i)];
            H[parent(i)]=temp;
            i=parent(i);
        }
    }
    
    public void shiftDown(int i){
        int maxIndex=i;
        int l=leftChild(i);
        if(l<=s && H[l]>H[maxIndex] ){
            maxIndex=l;
        }
        int r=rightChild(i);
        
        if(r<=s && H[r]>H[maxIndex] ){
            maxIndex=r;
        }
        if(i!=maxIndex){
            int temp=H[i];
            H[i]=H[maxIndex];
            H[maxIndex]=temp;
            shiftDown(maxIndex);
        }
    }
    
    public void insert(int p){
        s=s+1;
        H[s]=p;
        shiftUp(s);
    }

    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        GFG ob=new GFG();
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            for(int i=0;i<N;i++){
                int k=sc.nextInt();
                ob.insert(k);
            }
            
            Solution obj=new Solution();
            System.out.println("Node with maximum priority : "+ obj.extractMax());
            System.out.print("Priority queue after extracting maximum : ");
            int j=0;
            while(j<=ob.s){
                System.out.print(ob.H[j]+" ");
                j++;
            }
            System.out.println();
    }
}

class Solution {
  public int extractMax(){
        // static variables like the array H, have the same value for all objects of a class.
        GFG random=new GFG();
        int val = random.H[0];
        deleteNode(random);
        return val;
    }
    public void deleteNode(GFG obj){
        //step 1 to exchange first and last elements.
        obj.H[0] = obj.H[obj.s];
        obj.s--;
        obj.shiftDown(0);
        return;
    }
}
