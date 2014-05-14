package Sorting;

public class QuickSort {

    public QuickSort() {
    	//default empty constructor
    }
    
    private int partition(int[] array, int left, int right){
    	
    	int pivot = array[(left + right) / 2]; //take a pivot element to compare with
    	
    	while(left <= right){
    		
    		while(array[left] < pivot) //place left to a position where element is greater than (or equal to) pivot
    			left++;
    			
    		while(array[right] > pivot) //place right to a position where element is less than (or equal to) pivot
    			right--;
    		
    		if(left <= right){ //if left did not cross right (when current array part is sorted, they will cross)
    			int tmp = array[left]; //swap the left and right elements
    			array[left] = array[right];
    			array[right] = tmp;
    			left++;
    			right--;
    		}
    	}
    	
    	return left; //returns the index to partition the array
    }
    
    //main quick sort overload.
    //left and right indicates the part of array to sort
    private void sort(int[] array, int left, int right){
    	int partitionIndex = this.partition(array, left, right); //get the index to partition the array
    	
    	if(left < partitionIndex - 1){ //partition is greater than left by 1. otherwise, left part is sorted
    		this.sort(array, left, partitionIndex); //quick sort the left part
    	}
    	if(right > partitionIndex){ //partition is less that right. otherwise, right part is sorted
    		this.sort(array, partitionIndex, right); //quick sort the right part
    	}
    }
    
    //public method to call quick sort
    //takes an array and makes it sorted.
    public void sort(int[] array){
    	if(array == null || array.length==0){ //if array has nothing in it
    		return;
    	}
    	
    	this.sort(array, 0, array.length-1); //sort the array using quick sort
    }
    
    //main method
    //test quick sort
    public static void main (String[] args) {
    	int[] arr = new int[]{
    		3, 2, 1, 5, 6, 2, 9, 4
    	};
    	
    	QuickSort qs = new QuickSort();
    	qs.sort(arr);
    	
    	System.out.println ("Array after sorting:");
    	for(int i=0; i<arr.length; i++){
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
	}
}