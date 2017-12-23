


public class solution {
	public static int maxnumber(int []a) {
		int res =0;
		for(int i=0;i<a.length;i++) {
			int tmp = a[i];
			int ii = tmp;
			int tmp2= 1;
			while(ii<a.length) {
				if(a[ii++]==tmp)
					tmp2++;}
			res= Math.max(res,tmp2 );
		}
		return res;
	}
	public static void main(String[] args) {
	int []a = new int[] {1,2,2,2,4,4,5};
	
//	    maxnumber(a);
	    System.out.print(maxnumber(a));  
	}
}
	
