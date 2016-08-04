import java.io.*;

//reverse.java p124
class StackX{
	private int maxSize;
	private char[] stackArray;
	private int top;
	// constructor
	public StackX(int max){
		maxSize = max;
		stackArray = new char[max];
		top = -1;
	}

	//push (adding)
	public void push(char c){
		stackArray[++top] = c;
	}
	//poping (deleting)
	public char pop(){
		return stackArray[top--];
	}
	//peek
	public char peek(){
		return stackArray[top];
	}
	//isEmpty
	public boolean isEmpty(){
		return top == -1;
	}
	//isFull
	public boolean isFull(){
		return top == maxSize - 1;
	}
}


class Reverser{
	private String input;
	private String output = "";

	//constructor
	public Reverser(String input){
		this.input = input;
	}

	//doRev, adding the input to stack, then poping until its empty
	public String doRev(){
		int length = input.length();
		StackX charStack = new StackX(length);

		for(int i = 0; i < length; i++){
			char ch = input.charAt(i);
			charStack.push(ch);
		}

		while(!charStack.isEmpty()){
			char ch = charStack.pop();
			output = output + ch;
		}

		return output;
	}
}

class ReverseApp{
	public static void main(String[] args) throws IOException{
		Reverser rev;
		while(true){
			String input = getString();
			if(input.equals("")){
				break;
			}else{
				rev = new Reverser(input);
				System.out.print("Reversed:" + rev.doRev() + "\n");
			}
		}
	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input = br.readLine();
		return input;
	}
}