//p128
import java.io.*;

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

class BracketChecker{
	private String input;

	public BracketChecker(String input){
		this.input = input;
	}

	public void check(){
		int length = input.length();
		StackX stack = new StackX(length);
		char ch;

		for(int i = 0; i < length; i++){
			ch = input.charAt(i);

			switch(ch){
				case '{':
				case '[':
				case '(':
					stack.push(ch);
					break;
				case '}':
				case ']':
				case ')':
					if(stack.isEmpty()){
						System.out.print("Error at: " + i + "\n");
						break;
					}else{
						char popped = stack.pop();
						if(	(ch == '{' && popped != '}') ||
							(ch == '[' && popped != ']') ||
							(ch == '(' && popped != ')')){
							System.out.print("Error at: " + i + "\n");
							break;
						}	
					}
			}

		}
		if(!stack.isEmpty()){
			System.out.print("There are unclosed brackets" + "\n");
		}
	}
}

class BracketCheckApp{
	public static void main(String[] args) throws IOException{
		BracketChecker bc;
		while(true){
			System.out.flush();
			String line = getInput();

			if(line.equals("exit")){ 
				break;
			}else{
				bc = new BracketChecker(line);
				bc.check();
			}
		} 

	}

	private static String getInput() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		return line;
	}
}

