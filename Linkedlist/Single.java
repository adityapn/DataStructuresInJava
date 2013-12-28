package Linkedlist;

/*
 * 1) Appending                                               [Done]
 * 2) Add first                                               [Done]
 * 3) Add at particular location                              [Done]
 * 4) Delete a node at 1st and nth position                   [Done]
 * 5) Swap [ all the alternative nodes ]
 * 6) Reverse [whole list] {recurrsion and iteratice method}  [Done]
 * 7) If linked list is palindrome 
 * 8) Sort [ Merge sort , Quick Sort ]
 * 9)Cyclic or not [ Find loop in linkedlist ]                [Done]
 * 10)Find middle node                                        [Done]
 * 11)Find merge point of two linked lists 
 * 12)Copy Linked list with orbit pointer
 * 13)Merge two linked lists
 * 14)Count all nodes                                         [Done]
 * 15)Disply all nodes                                        [Done]
 * 16)Reverse [partial list]{recurrsion and iteratice method} [Done]
 */
public class Single {
    class Node{
        Node link;
        char data;
    }
    Node head = null;
    
    public void add_first(char data){
        Node temp = new Node();
        temp.data = data;
        temp.link = head.link;
        head = temp;
    }
    public boolean add_after(char data,int pos){
        int count = 0;
        
        for(Node temp = head;temp != null;temp = temp.link,count++){
            if(count == pos){
                Node add = new Node();
                add.data = data;
                add.link = temp.link;
                temp.link = add;
                return true;
            }
        }
        
        return false;
        
    }    
    public void append(char d){
        if(head == null){
            head = new Node();
            head.link = null;
            head.data = d;
        }
        else{
           Node temp = head;
           while(temp.link != null){
               temp = temp.link;
           }
           Node newNode = new Node();
           newNode.data = d;
           newNode.link = null;
           temp.link = newNode;
        }
        
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
    public char middle_node(){
        Node slow = head;
        Node fast = head;
        int count = 1;
        while(fast != null){
            if(count%2 == 0){
                slow = slow.link;
            }
            count++;
            fast = fast.link;
        }
        return slow.data;
    }
    public void show(){
        Node temp = head;
        while(temp != null){
            System.out.print(" "+temp.data);
            temp = temp.link;
        }
    }
    private void show_rev(Node t){
        if(t == null){
            return;
        }
        show_rev(t.link);
        System.out.print(""+t.data);
    }
    public void show_reverse(){
        show_rev(head);   
        System.out.println("");
    }
    // Using iterative way
    public void reverse_loop(){
        Node temp = head;
        Node prev = null;
        Node next = null;
        while(temp != null){
            next = temp.link;
            temp.link = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
    }
    // Using recusion
    private void reverse_recc(Node t){
        if(t.link == null){
            head = t;
            return;
        }
        reverse_recc(t.link);
        Node next = t.link;
        next.link = t;
        t.link = null;
    }
    public void reverse_recursion(){
        reverse_recc(head);
    }
    
    public int count(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.link;
        }
        return count;
    }
    public static void main(String args[]){
        Single list = new Single();
        list.append('b');
        list.append('d');        
        list.append('t');
        list.append('y');
        list.append('a');        
        list.add_first('a');
        list.add_after('i',1);
        System.out.println("is Cyclic : "+list.isCyclic());
        System.out.println("Middle node is : "+list.middle_node()+"\nReverse:");
        list.reverse_recursion();
        list.show();
        System.out.println("\nCount : "+list.count());
    }
}