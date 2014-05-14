package Sorting;
// Complexity n2
public class InsertionSort {
    // We compare the present element with previous elements 
    public static void main(String s[]){
    
        int nums[] = {21,6,2,9,11};   
        
        for (int i = 1; i < nums.length; i++){
             int j = i;
             int B = nums[i];    
             while ((j > 0) && (nums[j-1] > B)){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = B;
       }
        
        // Printing 
        for(int a=0;a<nums.length;a++)
            System.out.print(nums[a]+"  ");
            
    }    
}
