//1. 给一个乱序数组，写个算法，使其左侧为非负数，右侧为负数
//比如:
//input:
//[1,-2,3,-4,2,3,1]
//output:
//[1,1,2,3,3,-2,-4] two pointer
public class zhengfushu {
	public static void main(String args[]) 
	{
		 int in[] = {1,-2,3,-4,2,3,1};
        
         solution(in);
         for(int i:in) {
        	 System.out.println(i);
         };
	}

	public static int[] solution(int[]array) {
		 int length = array.length ;  
	        int low = 0;  
	        int high = length -1 ;  
	          
	        while (low <high) {  
	            while(array[low]>0 && low <high){  
	                low ++ ;  
	            }  
	            while(array[high]<0 && low<high){  
	                high-- ;  
	            }  
	            int temp = array[low];  
	            array[low] = array[high];  
	            array[high] = temp;  
	        }  
	        return array;	
	}
}

