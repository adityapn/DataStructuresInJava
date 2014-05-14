package Sorting;

public class SelectionSort {
    
    public static void main(String s[]){
    
        int numbers [] = {4,2,8,1,7};
        int temp;
        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                if(numbers[j]< numbers[i]){
                      temp = numbers[j];
                      numbers[j] = numbers[i];
                      numbers[i] = temp;
                }
            }
        }
        for(int a=0;a<numbers.length;a++){
            System.out.println("  "+numbers[a]);
        }    
    }    
}
