package Linkedlist;

public class Circular {
    
    class Node{
        Node link;
        char data;
    }
    Node head = null;
    public void append(char d){
       if(head == null){
           head = new Node();
           head.data = d;
           head.link = head;
           return;
       }
       Node temp = head;
       while(temp.link != head){           
           temp = temp.link;
       }
       Node add = new Node();
       add.data = d;
       add.link = head;       
       temp.link = add;
    }
    public boolean isCyclic(){        
        Node fast = head;
        Node slow = head;
        int count = 1;
        while(fast != null){            
            fast = fast.link;
            if(count%2 == 0){
                slow = slow.link;
            }
            if(fast == slow){
                return true;
            }            
            count++;            
        }
        
        return false;
    }
    
    public void show(){
        Node temp = head;
        while(temp.link != head){
            System.out.print(" "+temp.data);
            temp = temp.link;
        }
        System.out.println(" "+temp.data);
    }
    
    public static void main(String args[]){
        Circular c = new Circular();
        c.append('a');
        c.append('b');
        c.append('c');
        
        
    }
    
}
