import java.io.*;
//StackX Class
class IntStackX{
  private int maxSize;
  private int[] stackArray;
  private int top;

  //constructor
  public IntStackX(int size){
    maxSize = size;
    stackArray = new int[maxSize];
    top = -1;
  }
  //push
  public void push(int c){
    stackArray[++top] = c;
  }
  //pop
  public int pop(){
    return stackArray[top--];
  }
  //peek
  public int peek(){
    return stackArray[top];
  } 
  //isEmpty
  public boolean isEmpty(){
    return top == -1;
  }
  //get size
  public int getSize(){
    return maxSize;
  }
  //peekN
  public int peekN(int n){
    return stackArray[n];
  }
  //display
  public void display(){
    System.out.println("From bottom to top:");
    for(int i = 0; i <= top; i++){
        System.out.print(stackArray[i] + " ");
    }
  }
}

class ParsePost{
    private IntStackX numStack;
    private String input;

    public ParsePost(String input){
        this.input = input;
    }

    public int doParse(){
        char c;
        int result;
        int len = input.length();
        numStack = new IntStackX(len);

        for(int i = 0; i < len; i++){
            c =  input.charAt(i);
            if(c <= '9' && c >= '0'){
                numStack.push((int) c - '0'); //??
            }else{
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                int temp = 0;
                switch(c){
                    case '+':
                        temp = num1 + num2;
                        break;
                    case '-':
                        temp = num1 - num2;
                        break;
                    case '*':
                        temp = num1 * num2;
                        break;
                    case '/':
                        temp = num1 / num2;
                        break;
                }
                numStack.push(temp);
            }
        }
        return numStack.pop();
    }
}

class TestParesePost{
    public static void main(String[] args) throws IOException{
        while(true){
            String input = getInput();

            if(input.equals("exit")){
                break;
            }else{
                InToPost itp = new InToPost(input);
                itp.doTrans();
                String post = itp.postFix();
                ParsePost pp = new ParsePost(post);
                System.out.println(pp.doParse());
            }
        }
    }

    public static String getInput() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}