
import java.util.Scanner;

public class CircularQueueLab {
    private Node front;
    private Node rear;
    private Node current;
    private int size;
    
    public void CircularQueue(){//intial 
     front = null;
       rear = null;
      size = 0;
     }
    private class Node{ //intial 
    	  String data;
    	  Node next;
    	 }
    public boolean isEmpty() {// empty or not 
     return (front == null);
      }
 
 public void enqueue(String s){ // input data to queue
     Node temp = new Node();
     temp.data = s;
      if(size < 12){ // fix size 
      if(front == null){
       front = temp;
      }else{
       rear.next = temp;
      }
      size++;
      rear = temp;
      rear.next = front;
      }else{
   if(size == 12){//fix size 
    current = front;
    current.data = s;
    current = current.next;
       }else{
      current.data = s;
       current = current.next;
      }
   size++;
   
    }
 }
 
 public String dequeue(){ // delete queue
     if(isEmpty()){
       return "empty queue";
  }
  String s;
     if(front == rear){
      s = front.data;
      front = null;
      rear = null;
     //System.out.println("ful "); 
     }else{
      Node temp = front;
      s = temp.data;
      front = front.next;
      rear.next = front;
    } 
  return s;
 }
 
       public static void main(String[] args) {
        CircularQueueLab q = new CircularQueueLab();
        @SuppressWarnings("resource")
          Scanner scanner = new Scanner(System.in); 
        while(true){
           System.out.println("Please input the number, type 'quit' to quit "); 
              String ss = scanner.nextLine();
         if(ss.equals("quit")){
            while(!q.isEmpty()){
                String current = q.dequeue();
                  System.out.println(current);
           
                }
          return;
         }
         q.enqueue(ss);
        }
    }
}