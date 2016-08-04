//Queue.java
class Queue{
	private int maxSize;
	private int numItems;
	private int front;
	private int rear;
	private long[] myQueue;

	public Queue(int max){
		maxSize = max;
		numItems = 0;
		front = 0;
		rear = -1;
		myQueue = new long[maxSize];
	}

	public void insert(long value){
		if(rear == maxSize - 1){
			rear = -1;
		}
		myQueue[++rear] = value;
		numItems++;
	}

	public long remove(){
		long temp = myQueue[front++];
		if(front == maxSize){
			front = 0;
		}
		numItems--;
		return temp;
	}

	public long peekFront(){
		return myQueue[front];
	}

	public long peekRear(){
		return myQueue[rear];
	}

	public boolean isEmpty(){
		return numItems == 0;
	}

	public boolean isFull(){
		return numItems == maxSize;
	}

	public int getSize(){
		return numItems;
	}
}

class QueueApp{
	public static void main(String[] args){
		Queue theQueue = new Queue(5);
		theQueue.insert(10); 
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		
		System.out.print(theQueue.remove() + "\n");
		System.out.print(theQueue.remove() + "\n");
		System.out.print(theQueue.remove() + "\n");
		System.out.print(theQueue.remove() + "\n");
	}
}