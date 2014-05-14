package Sorting;

//Nod Class is used by Queues

class Nod{
	
	private int data;
	public Nod next;
	
	public Nod(int data){
		this.data = data;
		this.next = null;
	}
	
	public int getData(){
		return this.data;
	}
}

//Queues class is used to store data for Radix Sort

class Queues{
	
	private Nod front, rear; //indicates fron and rear of the Queues
	private int size;
	
	public Queues(){
		this.size = 0;
		this.front = this.rear = null;
	}
	
	//get size of the Queues
	public int size(){
		return this.size;
	}
	
	//check whether the Queues is empty or not
	public boolean isEmpty(){
		return (this.size == 0);
	}
	
	//inserts an item at the end of the Queues
	public void enQueues(int data){
		Nod item = new Nod(data);
		
		if(this.isEmpty()){ //previously, there's not item in the Queues
			this.front = this.rear = item;
		}
		else{ //add the item to the end.
			this.rear.next = item;
			this.rear = item;
		}
		
		this.size++;
	}
	
	//returns the first item without removing it
	public int peek(){
		if(this.isEmpty()){
			throw new NullPointerException("Queues is empty.");
		}
		
		return this.front.getData();
	}
	
	//returns the first item and removes it from the front
	public int deQueues(){
		int val = this.peek();
		this.front = this.front.next;
		
		if(this.front == null){ //if it was the only item, then front should be null now
			this.rear = null;
		}
		
		this.size--;
		return val;
	}
}

public class RadixSort {
	//Queues to hold numbers in each pass
	private Queues[] Queuess = null;
	
    public RadixSort() {
    	this.Queuess = new Queues[10];
    	//initialize Queuess
    	for(int i=0; i<10; i++){
    		this.Queuess[i] = new Queues();
    	}
    }
    
    //sort the array depending on a digit
    private void pass(int[] array, int digit){
    	int multiplier = (int)Math.pow(10, digit);
    	
    	//puts each number in proper Queues
    	for(int i=0; i<array.length; i++){
    		int index = (array[i]/multiplier)%10;
    		this.Queuess[index].enQueues(array[i]);
    	}
    	
    	//puts the numbers back to array in proper order
    	int index = 0;
    	for(int i=0; i<this.Queuess.length; i++){
    		while(!this.Queuess[i].isEmpty()){
    			array[index++] = this.Queuess[i].deQueues();
    		}
    	}
    }
    
    //sort overload
    //sorts an array of int numbers with maximum number of digits in any number specified.
    private void sort(int[] array, int maxNumOfDigits){
    	for(int i=0; i<maxNumOfDigits; i++){
    		this.pass(array, i);
    	}
    }
    
    //find and returns the maximum number of digits in any number in the array
    private int getMaxNumOfDigits(int[] array){
    	int max = 0;
    	//find the maximum number of the array
    	for(int i=0; i<array.length; i++){
    		if(i==0 || max < array[i])
    			max = array[i];
    	}
    	
    	//return the number of digits in the maximum number
    	return (int)(Math.log10(max) + 1);
    }
    
    public void sort(int[] array){
    	//if there is nothing to do
    	if(array==null || array.length==0){
    		return;
    	}
    	
    	//sort the array using the overload sort method
    	this.sort(array, this.getMaxNumOfDigits(array));
    }
    
    //main function
    //test the radix distribution sort implementation
    public static void main(String[] args){
    	int[] arr = new int[] {170, 45, 75, 90, 802, 24, 2, 66};
    	
    	RadixSort rs = new RadixSort();
    	rs.sort(arr);
    	
    	for(int i=0; i<arr.length; i++){
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
}