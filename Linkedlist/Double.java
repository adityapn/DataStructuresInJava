
package Linkedlist;

public class Double {
    
    class Node{
        Node next,prev;
        char data;
    }
    Node head = null;
    public void add_first(char d){
        Node temp = new Node();
        temp.data = d;
        temp.next = head;
        temp.prev = null;
        head = temp;
    }
    public void add_after(char d, int pos){
        Node temp = head;
        int count = 0;
        while(temp.next != null){
            if(count == pos){
                Node node = new Node();
                node.data = d;
                node.next = temp.next;
                node.prev = temp;
                temp.next = node;
                return;
            }
            count++;
            temp = temp.next;
        }
        System.out.println("position not found!");
    }
    public void append(char d){
        if(head == null){
            head = new Node();
            head.data = d;
            head.next = null;
            head.prev = null;
            return;
        }        
        Node temp = head;
        while(temp.next != null){
            temp = temp.next ;
        }
        Node insert = new Node();
        insert.data = d;
        insert.next = null;
        insert.prev = temp;
        temp.next = insert;
    }
    public void show(){
        Node temp = head;
        while(temp != null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
    }
    public void show_reverse(){
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        Node last = temp;
        while(last != null){
            System.out.print(" "+last.data);
            last = last.prev;
        }
    }
    public void reverse(){
        Node temp = head;
        Node extra = null;
        while(temp != null){
            extra = temp.prev;
            temp.prev = temp.next;
            temp.next = extra;
            temp = temp.prev;
        }
        if(extra != null)
            head = extra.prev;
    }
    public static void main(String args[]){
        Double d = new Double();        
        d.append('d');
        d.append('i');        
        d.append('y');
        d.append('a');
        d.append(' ');
        d.append('p');
        d.append(' ');
        d.append('n');
        d.add_first('a');
        d.add_after('t', 2);   
        System.out.println("Before reverse : ");
        d.show();
        d.reverse();
        System.out.println("After reverse : ");
        d.show();
    }
    
}