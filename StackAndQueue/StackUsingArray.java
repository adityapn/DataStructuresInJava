package StackAndQueue;

public class StackUsingArray {
    
    int stack[] = new int[10];
    int top = 10;
    int counter = -1;
    
    public void push(int data){
          if(counter<top){
              counter++;
              stack[counter] = data;
          }else{
              System.out.println("Out of Boundry ");
          }
          
    }
    public void pop(){
        int data ;
        if(counter>=0){
            data = stack[counter];
            counter--;
            System.out.println(""+data);
        }
        
        
    }
    public static void main(String s[]){
           StackUsingArray stacks = new StackUsingArray();
           stacks.push(1);
           stacks.push(2);
           stacks.push(3);
           stacks.push(4);
           
           stacks.pop();
           stacks.pop();
           stacks.pop();
           stacks.pop();
           
    }
    
}
