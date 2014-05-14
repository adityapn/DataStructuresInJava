package Trees;

import java.util.*;
/*
 * All binary search tree operations :
 * 
 * 1)  Adding value to tree                                                                 [DONE]
 * 2)  Deleting value from tree and balancing the tree by replacing with appropriate node 
 * 3)  Size of tree or Number of nodes                                                      [DONE]
 * 4)  Clone the bst [ create another bst with similar str ]
 * 5)  Check if two trees are same 
 * 6)  Check if given tree is full and complete trees 
 * 7)  Height of the tree                                                                   [DONE]
 * 8)  Two elements are swapped by mistake , rearrange them to make tree balanced
 * 9)  Construct tree using inorder , pre and post orders
 * 10) Based on inorder values find if tree is fully balanced or not 
 * 11) Inorder Successor in Binary Search Tree
 * 12) Preorder , Inorder and  Postorder  Traversal                                         [DONE]
 * 13) Level and Reverse Level order Traversal (BFS and DFS)                                [DONE]
 * 14) Morris Traversal 
 * 15) Solving Mathematical Expressions using binary trees
 * 16) Mirror a given Binary Tree
 * 17) Find Min and Max element                                                             [DONE]
 * 18) Remove elements Outside The Range {min and max} and balance tree
 * 19) Find if tree is balanced or not                                                      [DONE]
 * 20) Find triplet [ Sum of 3 numbers = 0 ex: {-13, 6, 7}] in bst
 * 21) Print all possible paths from root to all leafs                                      [DONE]
 * 22) Lowest/Least Common Ancestor of a Binary Search Tree (BST) and BT                    [DONE]
 * 23) Find if given sum is formed using two elements [ like 5+4 = 9 ]                      [DONE]
 * 24) Convert given BST to linkedlist [ In place and clone ]
 * 25) Balance tree or AVL  operations on the bst
 * 26) Find the diameter of the tree.                                                       [DONE]
 * 27) Convert binary tree to sum binary tree [Node = sum of it's left and right node]
 * 28) Check if the tree is bst or not                                                      [DONE]
 * 29) Search an element in the tree                                                        [DONE]
 * 30) Find next right node of a given key 
 */

public class BinarySearchTree {
    
    class Node{
        int value;
        Node left;
        Node right;
        public Node(int d){
            this.value = d;
        }                

    }
    Node root = null;
    public void add(int data){
        root = add_value(data,root);
    }
    private Node add_value(int data,Node node){
        if(node == null){
            node = new Node(data);            
            node.left = null;            
            node.right = null;            
        }else if( data > node.value ){
            node.right = add_value(data, node.right);
        }else{
            node.left = add_value(data,node.left);
        }
        return node;
    }
    
    /* 
     * Traversals :
     * 1) In-Order 
     * 2) Pre-Order 
     * 3) Post-Order 
     * 4) Level Order 
     * 5) Revese Level Order  
     * 6) Morrison Traversal [With out recurrsion]
     */    
    // 1) In-Order
    public void inorder(){
        in(root);
    }
    private void in(Node n){        
        if(n == null){
            return;
        }
        in(n.left);
        System.out.println(""+n.value);
        in(n.right);
    }    
    // 2) Pre-Order
    public void preorder(){
        pre(root);
    }
    private void pre(Node n){
        if(n == null){
            return;
        }
        System.out.println(""+n.value);
        pre(n.left);
        pre(n.right);
    }
    
    // 3) Post-Order
    public void postorder(){
        post(root);
    }
    private void post(Node n){
        if(n == null)
            return;
        post(n.left);
        post(n.right);
        System.out.println(""+n.value);                   
    }
    
    // 4) Level Order 
    public void levelOrder(){
        Queue<Node> queue = new PriorityQueue<Node>(size(),cmp);        
        queue.add(root);        
        while(queue != null){
            Node temp = queue.poll();
            if(temp != null){
                System.out.print(" "+temp.value);                
                if(temp.left != null){                
                    queue.add( temp.left );                
                }
                if(temp.right != null){                
                    queue.add( temp.right );                
                }            
            }else{
                return;
            }
         }
    }
    private Comparator<Node> cmp = new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            if(o1 != o2){
                return 1;
            }
            return 0;
        }
    };
    
    // 5) Reverse Level Order 
    public void reverseLevelOrder(){
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Node> queue = new PriorityQueue<Node>(size(),cmp);
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp != null){
                stack.add(temp.value);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        System.out.println("");
        while(!stack.isEmpty()){
            System.out.print(" "+stack.pop());
        }
    }
    /*
     * Min and Max values of the tree
     */
    public int min(){
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.value;
    }
    public int max(){
        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.value;
    }
    /* Searching an element in the tree */
    public void search(int data){
        isPresent(data, root);
    }
    private void isPresent(int data , Node n){
        if(n == null){
            System.out.println("Element does not present");
            return;
        }
        if(data > n.value ){
            isPresent(data, n.right);
        }else if(data < n.value){
            isPresent(data, n.left);
        }else{
            System.out.println("Element is present");
        }        
    }
    
    /*Size of the tree*/
    public int size(){
        return count(root,0);
    }
    private int count(Node n , int c){
        if(n == null){
            return c;
        }   
        c++;
        c  = count(n.left,c);
        c  = count(n.right,c);  
        return c;
    }
    
    // Is given tree Binary Search Tree or not 
    public boolean isBST(){
        return isbst(root,true);
    }
    private boolean isbst(Node node, boolean flag){
        if(node != null){
            
            if(node.left != null && node.right != null  ){
                if(node.left.value <= node.value && node.right.value >= node.value){
                    isbst(node.left,flag);
                    isbst(node.right,flag);                
                }else{
                    flag =  false;
                    return flag;
            }
            }else if(node.left != null && node.right == null  ){
                if(node.left.value <= node.value){
                    isbst(node.left,flag);
                }else{
                    flag = false;
                    return flag;
                }
            }else if(node.left == null && node.right != null  ){
                if(node.right.value >= node.value){
                    isbst(node.right,flag);
                }else{
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }
    // Find two nodes that form the given sum 
    List<Integer> elements = new ArrayList<Integer>();
    public void TwoElementsThatFormTheSum(int sum){
        getElements(root);
        int end = elements.size()-1;
        int start = 0;
        while(start <= end){
            int temp = elements.get(start)+elements.get(end);
            if(temp == sum){
                System.out.println("Elements are : "+elements.get(start)+","+elements.get(end));
                break;
            }else if(temp < sum){
                start++;
            }else{
                end++;
            }
        }
    }
    private void getElements(Node node){
        if(node != null){
            getElements(node.left);
            elements.add(node.value);
            getElements(node.right);
        }        
    }
    // Height of the tree 
    public int height(){
        return maxDepth(root);
    }    
    private int maxDepth(Node node){
       if(node == null){
           return 0;
       }else{
           return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
           /*
            *   
            *   Explanation of the above code :
            * 
                int leftDepth = maxDepth(node.left);
                int rightDepth = maxDepth(node.right);
                if(leftDepth > rightDepth)
                    return (leftDepth+1);
                else
                    return (rightDepth+1);
           */
       }   
    }
    /* Diameter of the tree [Highest number of nodes between two nodes ] 
     * 1) Diameter need not to pass through the root node 
     */
    public int diameter(){
        return findDiameter(root);
    }
    private int findDiameter(Node n){
        if(n == null){
            return 0;
        }else{
            int leftTree = maxDepth(n.left);
            int rightTree = maxDepth(n.right);
            int lDiameter = findDiameter(n.left);
            int rDiameter = findDiameter(n.right);
            return Math.max((leftTree+rightTree+1),Math.max(lDiameter,rDiameter));
        }
    }
    public boolean isBalanced(){
        
        int leftSubtree = maxDepth(root.left);
        int rightSubtree = maxDepth(root.right);        
        if(Math.abs(leftSubtree-rightSubtree)>1){
            return false;
        }
        return true;
    }
    // Lowest Common Ancestor      
    public void leastCommonAncestor(int left,int right){
        lca(root,left,right);
    }
    /*
     * Inorder to be LCA both the nodes should present on the same side of the tree
     * if not then current node is the lca 
     */
    private void lca(Node node , int left ,int right){
        if(node == null)   
            return;
        if(node.left != null && node.right != null){
            if(left < node.value && right < node.value){
                lca(node.left,left,right);
            }else if(left > node.value && right > node.value){
                lca(node.right,left,right);
            }else{
                System.out.println("LCA is "+node.value);
            }
        }
    }
    // All possible paths from root to leafs 
    String path = "";
    public void allPossiblePaths(){
        allPaths(path, root);        
    }
    private void allPaths(String path,Node node){
        if(node == null){
            return ;
        }
        if(node.left == null && node.right == null){
            path += ""+node.value;
        }else{
            path += ""+node.value+"->";
        }
        
        allPaths(path,node.left);
        allPaths(path, node.right);        
        if(node.left == null && node.right == null){
            System.out.println(" "+path);
        }
    }
    /*
     * For example, consider the following Binary Tree. Output for 2 is 6, 
     * output for 4 is 5. Output for 10, 6 and 5 is NULL.

                  10
               /      \
	          2         6
           /   \         \ 
	 	  8      4          5

     * */
    public void right_brother(){
    	Node crawl = this.root;
    	Queue<BinarySearchTree.Node> queue = new PriorityQueue<BinarySearchTree.Node>();
    	HashMap<Integer, Integer> levels = new HashMap<Integer, Integer>();
    	queue.add(crawl);
    	int level = 0;
    	while(!queue.isEmpty()){
    		Node temp = queue.poll();
    		if(!temp.left.equals(null)){
    			queue.add(temp.left);    			
    		}
    		if(!temp.right.equals(null)){
    			queue.add(temp.right);    			
    		}
    	}
    	System.out.println("Items in queue "+queue);
    }
    // Main function to run the program
    public static void main(String args[]){        
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(2);
        bst.add(6);
        bst.add(8);
        bst.add(4);
        bst.add(5);
        bst.right_brother();
    }
}