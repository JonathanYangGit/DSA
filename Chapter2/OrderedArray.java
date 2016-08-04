//orderedArray.java

class OrderedArray{
	private long[] a;
	private int numElems;

	//constructor
	public OrderedArray(int max){
		a = new long[max];
		numElems = 0;
	}

	//size getter
	public int getSize(){
		return numElems;
	}

	//find, using binary tree
	public boolean find(long searchKey){
		int lowerLimit = 0;
		int upperLimit = numElems - 1;
		int curser;
		boolean stop = false;
		boolean found = false;

		while(!stop){
			curser = (lowerLimit + upperLimit)/2;
			if(upperLimit < lowerLimit){
				stop = true;
			}

			if(a[curser] == searchKey){
				stop = true;
				found = true;
			}else if(a[curser] > searchKey){
				upperLimit = curser - 1;
			}else if(a[curser] < searchKey){
				lowerLimit = curser + 1;
			}
		}
		return found;
	}
	//insert, using binary tree
	public void insert(long value){
		int lowerLimit = 0;
		int upperLimit = numElems - 1;
		int curser;
		//boolean stop = false;
		int insertLocation = 0;

		while(true){

			if(numElems == 0){
				insertLocation = 0;
				break;
			}
			
			curser = (lowerLimit + upperLimit)/2;

			if(a[curser] ==  value){
				insertLocation = curser;
				break;
			}else{
				if(a[curser] > value){
					upperLimit = curser - 1;
					if(upperLimit < lowerLimit){
						insertLocation = curser;
						break;
					}
				}else if(a[curser] < value){
					lowerLimit = curser + 1;
					if(upperLimit < lowerLimit){
						insertLocation = curser + 1;
						break;
					}
				}
			}
		}



		// while(!stop){
		// 	curser = (lowerLimit + upperLimit)/2;

		// 	if(curser + 1 == numElems){
		// 		stop = true;
		// 		insertLocation = numElems;
		// 	}else if(lowerLimit > upperLimit){
		// 		stop = true;
		// 	}else if(a[curser] < value && a[curser + 1] > value){
		// 		stop = true;
		// 		insertLocation = curser + 1;
		// 	}else if(a[curser] > value){
		// 		upperLimit = curser - 1;
		// 	}else if(a[curser] < value){
		// 		lowerLimit = curser + 1;
		// 	}
		// }

		for(int k = numElems; k > insertLocation; k --){
			a[k] = a[k-1];
		}
		a[insertLocation] = value;
		numElems ++; 
	}

	//delete, using binary tree


	//display
	public void display(){
		for(int i = 0; i < numElems; i++)
			System.out.print(a[i] + "\n");
	}


}



class OrderedArrayApp{
	public static void main(String[] args){
		int max = 10;
		OrderedArray ordArr;
		ordArr = new OrderedArray(max);

		ordArr.insert(2);
		ordArr.insert(3);
		ordArr.insert(452);
		ordArr.insert(34);
		ordArr.insert(54);
		ordArr.insert(65423);
		ordArr.insert(2);
		ordArr.insert(0);
		ordArr.display();

		if(ordArr.find(452)){
			System.out.print("Found" + "\n");
		}else{
			System.out.print("Not Found" + "\n");
		}
		
		if(ordArr.find(333)){
			System.out.print("Found" + "\n");
		}else{
			System.out.print("Not Found" + "\n");
		}	}
}