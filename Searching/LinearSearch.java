package Searching;

public class LinearSearch {
    
    public static void linear_search(int array[],int find){
        for(int element : array){
            if(element == find){
                System.out.println("Element found");
                return;
            }
        }
        System.out.println("Element not found!");
    }
    
    public static void main(String a[]){
        int elements[] = {1,2,3,4,5,6};
        linear_search(elements, 4);
    }
    
}
