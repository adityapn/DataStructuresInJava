package Sorting;

public class BubbleSort {
    
    public static void main(String s[]){
    
        int nums[] = {5,2,6,12,41,86,1};
        
        for(int i=nums.length;i>-1;i--){
            for(int j=0;j<i-1;j++){
                  if(nums[j]<nums[j+1]){
                      int temp = nums[j];
                      nums[j]  = nums[j+1];
                      nums[j+1]  = temp;
                  }
            }
        }
	
        for(int i=0;i<nums.length;i++){
            System.out.println(" "+nums[i]);
        }
    }
    
}
