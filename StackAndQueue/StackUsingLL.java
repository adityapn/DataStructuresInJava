package StackAndQueue;

public class StackUsingLL {
    
    class Node{
        int data;
        Node link;
        Node prev;
    }

    Node first,top;

    public StackUsingLL(){
        first = null;
        
     }
    
    public void push(int data){
        
        if(first == null){
            first = new Node();
            top = new Node();
            first.data = data;
            first.link = null;
            first.prev = null;
            top = first;
            return;
        }
        
        Node temp = first;
        while(temp.link != null){
            temp = temp.link;
        }
        Node add = new Node();
        add.data = data;
        add.link = null;// mark
        add.prev = temp;
        temp.link = add;
        top = add;
    }

    public int pop(){
        
        int data = -1;
        data = top.data;
        top = top.prev;
        if(data == -1)
            return -1;
        
        return data;
    }
    
    public static void main(String s[]){
        
            StackUsingLL stack = new StackUsingLL();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            System.out.println("Pop 1 : "+stack.pop());
            System.out.println("Pop 2 : "+stack.pop());
            System.out.println("Pop 3 : "+stack.pop());
    
    }
    
    
}
