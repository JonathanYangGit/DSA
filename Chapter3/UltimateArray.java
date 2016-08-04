import java.util.*;
//ArrayWithSort.java
class UltimateArray{
	private long[] a;
	private int numElems = 0;
	private int max;

	//constructor
	public UltimateArray(int max){
		a = new long[max];
		this.max = max;
	}

	public int getMax(){
		return max;
	}
	//insert
	public void insert(long value){
		if(numElems + 1 > max){
			System.out.print("Exceed maximum number of items" + "\n");
		}else{
			a[numElems] = value;
			numElems ++;
			//System.out.print(value + " successfully added \n");
		}
	}

	//delete
	public void delete(long value){
		int i;
		boolean found = false;
		for(i = 0; i < numElems; i ++){
			if(a[i] == value){
				found = true; 
				break;
			} 
		}
		if(found == true){
			for(int j = i; j < numElems - 1; j ++){
				a[j] = a[j + 1];
			}
			numElems --;
		}else{
			System.out.print("Item not found. \n");
		}
	}

	public void display(){
		for(int i = 0; i < numElems; i ++){
			System.out.print(a[i] + " ");
		}
		System.out.print("\n End \n ");
	}

	private void swap(int ind1, int ind2){
		long temp = a[ind1];
		a[ind1] = a[ind2];
		a[ind2] = temp;
	}


	public void bubbleSort(){
		int i;
		int j;
		for(i = numElems - 1; i > 0; i --){
			for(j = 0; j < i; j ++){
				if(a[j] > a[j + 1]){
					swap(j, (j+1));
					// long temp = a[j];
					// a[j] = a[j + 1];
					// a[j + 1] = temp;
				}
			}
		}
	}

	public void selectSort(){
		int i;
		int j;
		for(i = 0; i < numElems; i ++){
			int min = i;
			for(j = i + 1; j < numElems; j ++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			long temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}

	public void insertSort(){
		int out;
		int in;
		for(out = 1; out < numElems; out++){
			long temp = a[out];
			in = out;
			// the order of evaluation matters! (a[in - 1] > temp && in > 0) will generate index out of bound error!		
			while(in > 0 && a[in - 1] > temp ){ 
				a[in] = a[in - 1];
				in--;
			}
			a[in] = temp;
		}
	}
	
	//C3 Q1 Bidirectional Bubble Sort
	public void biBubbleSort(){
		int leftOut = 0;
		int rightOut = numElems - 1;

		while(leftOut < rightOut){
			int in = leftOut;
			
			while(in < rightOut){
				if(a[in] > a[in + 1]){
					swap(in, (in + 1));
				}
				in++;
			}
			rightOut--;
			
			while(in > leftOut){
				if(a[in] < a[in - 1]){
					swap(in, (in - 1));
				}
				in--;
			}
			leftOut++;
		}
	}

	//C3 Q2
	// public long median(){
	// 	long[] b = Arrays.copyOf(a, a.length);
	// 	long median;
	// 	int out = 0;
	// 	int in;
	// 	while(out <= numElems/2){
	// 		int min = out;
	// 		for(in = out; in < numElems; in++){
	// 			if(b[in] < b[min]){
	// 				min = in;
	// 			}
	// 		}
	// 		long temp = b[in];
	// 		b[in] = b[out];
	// 		b[out]  = temp;
	// 	}

	// 	if(numElems%2 == 0){
	// 		median = (b[out] + b[out - 1])/2;
	// 	}else{
	// 		median = b[out];
	// 	}

	// 	return median;
	// }


	public void noDups(){
		long[] temp = new long[numElems];
		temp[0] = a[0];
		int insertInd = 1;
		for(int i = 1; i < numElems; i++){
			if(a[i] != a[i - 1]){
				temp[insertInd] = a[i];
				insertInd++;
			}
		} 
		a = Arrays.copyOf(temp, insertInd);
		numElems = insertInd;
	}

	//C3 Q4
	public void oddEvenSort(){
		int numSorts = (numElems + 1)/2; //to round up the result
		int numPairs = numElems/2; //to round down
		for(int out = 0; out < numSorts; out++){
			//sort odd
			for(int in = 0; in < numPairs; in++){
				if(a[2*in + 1] > a[2*in + 2]){
					swap(2*in + 1, 2*in + 2);
				}
			}
			//even sort
			for(int in = 0; in < numPairs; in++){
				if(a[2*in] > a[2*in + 1]){
					swap(2*in, 2*in + 1);
				}
			}
		}
	}

	
}

class UltimateArrayApp{
	public static void main(String args[]){

		UltimateArray uArr = new UltimateArray(11);
		Random rand = new Random();

		for(int i = 0; i < uArr.getMax(); i ++){
			uArr.insert(rand.nextInt(100));
		}

		// uArr.insert(1);
		// uArr.insert(4);
		// uArr.insert(4);
		// uArr.insert(2);
		// uArr.insert(3);
		// uArr.insert(5);
		// uArr.insert(6);
		// uArr.insert(4);
		// uArr.insert(3);
		// uArr.insert(1);


		//System.out.print(uArr.median());
		uArr.display();
		//uArr.display(); 
		long startTime = System.nanoTime();
		uArr.oddEvenSort();
		long endTime = System.nanoTime();

		uArr.display();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		//uArr.display();


	}
}
