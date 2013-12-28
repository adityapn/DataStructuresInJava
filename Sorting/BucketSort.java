package Sorting;


public class BucketSort {
	
	private int minVal, maxVal; //holds the range of numbers to sort
	private Queue[] queues = null;
	
	//constructor, passed with the range of numbers to sort
    public BucketSort(int min, int max) {
    	this.minVal = min;
    	this.maxVal = max;
    	
    	//initializes the queues
    	this.queues = new Queue[this.maxVal - this.minVal + 1];
    	for(int i=0; i<this.queues.length; i++){
    		this.queues[i] = new Queue();
    	}
    }
    
    //sorts an array of integer
    public void sort(int[] array){
    	//stores each number in queue
    	for(int i=0; i<array.length; i++){
    		this.queues[array[i] - this.minVal].enqueue(array[i]);
    	}
    	
    	//writes number from each queue in order back at the array
    	int index = 0;
    	for(int i=0; i<this.queues.length; i++){
    		while(!this.queues[i].isEmpty()){
    			array[index++] = this.queues[i].dequeue();
    		}
    	}
    }
    
    //main function
    //test the bucket distribution sort implementation
    public static void main(String[] args){
    	//define the range of numbers with min and max
    	int minimumValue = 0, maximumValue = 200;
    	int[] arr = new int[] {170, 45, 24, 75, 90, 102, 24, 2, 66};
    	
    	BucketSort bs = new BucketSort(minimumValue, maximumValue);
    	bs.sort(arr);
    	
    	for(int i=0; i<arr.length; i++){
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
}

//Nodes Class is used by Queue
class Nodes{
	private int data;
	public Nodes next;
	
	public Nodes(int data){
		this.data = data;
		this.next = null;
	}
	
	public int getData(){
		return this.data;
	}
}

//Queue class is used to store data for Bucket Sort
class Queue{
	private Nodes front, rear; //indicates fron and rear of the queue
	private int size;
	
	public Queue(){
		this.size = 0;
		this.front = this.rear = null;
	}
	
	//get size of the queue
	public int size(){
		return this.size;
	}
	
	//check whether the queue is empty or not
	public boolean isEmpty(){
		return (this.size == 0);
	}
	
	//inserts an item at the end of the queue
	public void enqueue(int data){
		Nodes item = new Nodes(data);
		
		if(this.isEmpty()){ //previously, there's not item in the queue
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
			throw new NullPointerException("Queue is empty.");
		}
		
		return this.front.getData();
	}
	
	//returns the first item and removes it from the front
	public int dequeue(){
		int val = this.peek();
		this.front = this.front.next;
		
		if(this.front == null){ //if it was the only item, then front should be null now
			this.rear = null;
		}
		
		this.size--;
		return val;
	}
}
