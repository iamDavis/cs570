import java.io.*;
import java.util.Scanner;  
public class QueueArray {  
	public static Scanner inp = new Scanner(System.in);
    Object[] a; //对象数组，队列最多存储a.length-1个对象     
    int front;  //队首下标     
    int rear;   //队尾下标     
    public QueueArray(){     
        this(10); //调用其它构造方法     
    }     
    public QueueArray(int size){     
        a = new Object[size];     
        front = 0;     
        rear =0;     
    }   
    public boolean isEmpty() {
        if(front==rear){
        return true;
    }
        return false;
    }
    /**    
     * 将一个对象追加到队列尾部    
     * @param obj 对象    
     * @return 队列满时返回false,否则返回true    
     */   
    public boolean isFull(){
        if((rear+1)%a.length==front){
            return true;
        }
        else{
            return false;
        }
    }
//    public Object enQueue(Object obj) {
//        if(isFull()==false){
//            rear=(rear+1)%a.length;
//            a[rear]=obj; 
//            return obj;
//        }
//        else{
//           
////           	rear =0 ; 	
////           	rear=(rear+1)%a.length;
////            a[rear]=obj; 
//           	front = (front+1)%a.length;
//           	a[front]=obj; 
//            //System.out.println("ERROR:Queue is Full");
//           	
//            return obj;
//        }
//        
//    }
   public boolean enqueue(Object obj){     
       if((rear+1)%a.length==front){  
            a[front]=obj;  
            System.out.println("cnmgdxg");
            System.out.println(front);
//            return false;     
        }     
      a[rear]=obj;            
      rear = (rear+1)%a.length; 
      System.out.println("cnm");
           return true;     
    }     
    /**    
     * 队列头部的第一个对象出队    
     * @return 出队的对象，队列空时返回null    
     */    
    public Object dequeue(){     
        if(rear==front){ 
        	//System.out.println("ERROR:Queue is Full");
            return null;     
        }     
        Object obj = a[front];     
        front = (front+1)%a.length;     
        return obj;     
    }     
    public Object size() {
		return a.length-1;
    	
    }
    public static void main(String[] args) {     
        QueueArray q = new QueueArray(5);
        int r = (int) q.size();
        boolean good =false;
        while(!good) {
       
        System.out.println("plz input num to queue, the size is 12, enter quit to quit and print the queue: ");
		String input = inp.next();
		
		if(!input.equals("quit")) {
			
			System.out.println(q.enqueue(input)); 
		}
		if(input.equals("quit")) {
			
			for(int i=0;i<r;i++){     
	            System.out.println(q.dequeue());     
	        }
			good =  true;
		}
        }
//        System.out.println(q.enqueue("张三"));     
//        System.out.println(q.enqueue("李斯"));     
//        System.out.println(q.enqueue("赵五"));     
//        System.out.println(q.enqueue("王一"));//无法入队列，队列满     
//        for(int i=0;i<4;i++){     
//            System.out.println(q.dequeue());     
//        }     
    }     
}   