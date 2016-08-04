//highArray.java
class HighArray{
	private long[] a;
	private int numElems;
//constructor
	public HighArray(int max){
		a = new long[max];
		numElems = 0;
	}

//find a specified value
	public boolean find(long searchKey){
		int j;
		for(j = 0; j < numElems; j++)
			if(a[j]==searchKey)
				break;
		if(j == numElems)
			return false;
		else
			return true;
	}

//insert a value
	public void insert(long value){
		a[numElems] = value;
		numElems ++;
	}

//delete a value
	public boolean delete(long value){
		int j;
		for(j = 0; j < numElems; j ++)
			if(a[j] == value)
				break;
		if(j == numElems){
			System.out.print("Key not found");
			return false;
		}
		else{
			for(int k = j; k < numElems; k ++ )
				a[k] = a[k+1];
			numElems --;
			return true;
		}
	}
//get the maximum value, return -1 if the array is empty
	public long getMax(){
		long max = -1; 
		int j;

		for(j = 0; j < numElems; j ++){
			if(a[j] > max){
				max = a[j];
			}
		}
		return max;
	}

//return and remove the max
	public long removeMax(){
		long max = -1; 
		int maxIndex = -1;

		int j;

		for(j = 0; j < numElems; j ++){
			if(a[j] > max){
				max = a[j];
				maxIndex = j;
			}
		}

		if(max != -1){
			for(int k = maxIndex; k < numElems; k ++){
				a[k] = a[k+1];
			numElems --;
			}
		}

		return max;
	}


//display all value
	public void display(){
		int j;
		for(j = 0; j < numElems; j++)
			System.out.print(a[j] + " ");
		System.out.print(" " + "\n");
	}
}

class HighArrayApp{
	public static void main(String[] args){
		int maxSize = 100;
		HighArray arr = new HighArray(maxSize);

		arr.insert(1);
		arr.insert(2);
		arr.insert(3);
		arr.insert(4);
		arr.insert(5);
		arr.insert(6);
		arr.insert(7);
		arr.insert(8);
		arr.insert(9);
		arr.insert(10);
		arr.insert(231);
		arr.insert(0);

		arr.display();

		int searchKey = 8;
		if(arr.find(searchKey) == true)
			System.out.print("Found" + searchKey);
		else
			System.out.print("Not Found" + searchKey);
		System.out.print("\n");


		arr.delete(10);
		arr.display();
		System.out.print("\n");

		System.out.print(arr.getMax() + "\n");

		//sorting the original array into another array
		HighArray sortedArr = new HighArray(maxSize);

		boolean empty = false;
		while(!empty){
			long max = arr.removeMax();
			if(max == -1){
				empty = true;
			}
			else{
				sortedArr.insert(max);
			}
		}

		sortedArr.display();




	}
}