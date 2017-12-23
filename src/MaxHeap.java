import java.util.Arrays;
import java.util.Scanner;

public class MaxHeap {
	public static Scanner inp = new Scanner(System.in);


	

	public static int[] heap;
	public static int size;


	    public void maxHeapify(int index) {
	        int largest = index;
	        int leftIndex = 2 * index + 1;
	        int rightIndex = 2 * index + 2;

	        if (leftIndex < size && heap[index] < heap[leftIndex]) {
	            largest = leftIndex;
	        }
	        if (rightIndex < size && heap[largest] < heap[rightIndex]) {
	            largest = rightIndex;
	        }

	        if (largest != index) {
	            swap(index, largest);
	            maxHeapify(largest);
	        }
	    }

	   
	    public void buildMaxHeap() {
	        for (int i = size / 2 - 1; i >= 0; i--) {
	            maxHeapify(i);
	        }
	    }

	    /**
	     * Insert a new element into the heap satisfying
	     * the heap property.
	     * 
	     * 
	     * @param elem
	     */
	    public void insert(int elem) {
	        // increase heap size
	    	if(heap == null){
				heap = new int[1];
				heap[0] = elem;
				size++;
			}else{
	        heap = Arrays.copyOf(heap, size + 1);
	      
	        int i = size;
	        int parentIndex = (int) Math.floor((i - 1) / 2);
	        // move up through the heap till you find the right position
	        while (i > 0 && elem > heap[parentIndex]) {
	            heap[i] = heap[parentIndex];
	            i = parentIndex;
	            parentIndex = (int) Math.floor((i - 1) / 2);
	        }
	        heap[i] = elem;
	        size++;
	    }
	    }

	    public int findMax() {
	        if (size == 0) {
	            return -1;
	        } else {
	            return heap[0];
	        }
	    }

	    public int extractMax() {
	        if (size == 0) return -1;

	        int min = heap[0];
	        heap[0] = heap[size - 1];
	        size--;
	        maxHeapify(0);
	        return min;
	    }

	    public int getSize() {
	        return size;
	    }

	    public int[] getHeap() {
	        return heap;
	    }

	    public void printHeap() {
	        if (heap == null)
	            System.out.print("null");
	        int iMax = size - 1, i;
	        if (iMax == -1)
	            System.out.print("[]");

	        StringBuilder b = new StringBuilder();
	        b.append('[');
	        for (i = 0; i < iMax; i++) {
	            b.append(heap[i]);
	            b.append(", ");
	        }
	        System.out.println(b.append(heap[i]).append(']').toString());
	    }

	    private void swap(int firstIndex, int secondIndex) {
	        int temp = heap[firstIndex];
	        heap[firstIndex] = heap[secondIndex];
	        heap[secondIndex] = temp;
	    }
	    public void print(){
			for(int i = 0; i < heap.length; i++){
				System.out.println(extractMax());
			}
		}
	    // test cases
	    public static void main(String[] args) {

	        MaxHeap m = new MaxHeap();
			Scanner s = new Scanner(System.in);
			int n = 10;
			for(int i = 0; i < n; i++){
				System.out.println("Input a number:");
				String temp = s.nextLine();
				m.insert(Integer.parseInt(temp));
			}
			m.buildMaxHeap();
			
			m.print();
			//s.close();
	}
}

