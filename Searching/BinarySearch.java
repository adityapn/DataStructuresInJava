package Searching;

public class BinarySearch {
    
    public static void binary_search(int elements[],int find){
        int start = 0;
        int end = elements.length - 1;
        while(start <= end){
            int middle = (start+end)/2;
            if(elements[middle] == find){
                System.out.println("Found");
                break;
            }else if( find > elements[middle] ){
                start = middle+1;                
            }else{
                end = middle-1;
            }
        }
    }
    public static void main(String a[]){
        int elements[] = {1,2,3,4,5,6};
        binary_search(elements, 5);
    }
    
    
}
