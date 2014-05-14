package Sorting;

public class MergeSort {

    public MergeSort() {
    	//default empty constructor
    }
    
    private void merge(int[] array, int startIndex, int splitIndex, int endIndex){
    	
    	int[] tmpArray = new int[endIndex - startIndex + 1]; //new temporary array for storing merged elements
    	int tmpIndex = 0; //index to iterate over temporary array

    	int i=startIndex, j=splitIndex+1;
    	while(i<=splitIndex || j<=endIndex){ //while there are any items in the array part
    		if(i <= splitIndex && j<=endIndex){ //of there are items in both left and right parts
    			if(array[i] < array[j]){ //if left part is smaller
    				tmpArray[tmpIndex++] = array[i++];
    			}
    			else{ //if right part is smaller
    				tmpArray[tmpIndex++] = array[j++];
    			}
    		}
    		else if(i <= splitIndex){ //if there are items only in left part
    			tmpArray[tmpIndex++] = array[i++];
    		}
    		else{ //if there are items only in right part
    			tmpArray[tmpIndex++] = array[j++];
    		}
    	}
    	
    	//copy the merged items from temporary array to the main array
    	for(i=startIndex, tmpIndex=0; tmpIndex<tmpArray.length; i++, tmpIndex++){
    		array[i] = tmpArray[tmpIndex];
    	}
    	
    	tmpArray = null;
    }
    
    //merge sort algorithm
    //sort an array part from startIndex to endIndex by splitting the array in to two parts in each recursion.
    private void sort(int[] array, int startIndex, int endIndex){
    	if(startIndex == endIndex){ //for only one element to sort. nothing to do. it's trivial and sorted
    		return;
    	}
    	
    	int splitIndex = (startIndex + endIndex) / 2; //gets an index in the middle to split the array
    	
    	this.sort(array, startIndex, splitIndex); //sort the left part of the array
    	this.sort(array, splitIndex + 1, endIndex); //sort the right part of the array
    	
    	this.merge(array, startIndex, splitIndex, endIndex); //merge the two sorted parts
    }
    
    public void sort(int[] array){
    	if(array==null || array.length==0){ //if there's nothing in the, do nothing
    		return;
    	}
    	
    	this.sort(array, 0, array.length-1); //sort the array using the overloaded merge sort method
    }
    
    //main method
    //test merge sort
    public static void main (String[] args) {
    	int[] arr = new int[]{
    		3, 2, 1, 5, 6, 2, 9, 4
    	};
    	
    	MergeSort ms = new MergeSort();
    	ms.sort(arr);
    	
    	System.out.println ("Array after sorting:");
    	for(int i=0; i<arr.length; i++){
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
	}
}