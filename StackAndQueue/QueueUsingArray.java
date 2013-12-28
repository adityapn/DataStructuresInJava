package StackAndQueue;

public class QueueUsingArray {
    
    int queue[] = new int[10];
    int top = 10;
    int begin = 0;
    int counter = -1;
    
    public void enqueue(int data){
        if(counter<top){
            counter++;
            queue[counter]  = data;
        }else{
            System.out.println("No space for allocation");
        }
    }
    public void dequeue(){
           int data;
           if(begin<=counter){
                data = queue[begin];
                begin++;
                System.out.println(""+data);
           }else{
               System.out.println("No more elements ");
           }
    }
    public static void main(String a[]){
        QueueUsingArray q = new QueueUsingArray();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        
    }
    
}
