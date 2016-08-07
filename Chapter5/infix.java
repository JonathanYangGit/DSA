//StackX Class
class StackX{
  private int maxSize;
  private char[] stackArray;
  private int top;

  //constructor
  public StackX(int size){
    maxSize = size;
    stackArray = new char[maxSize];
    top = -1;
  }
  //push
  public void push(char c){
    stackArray[++top] = c;
  }
  //pop
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
  //get size
  public int getSize(){
    return maxSize;
  }
  //peekN
  public char peekN(int n){
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

class InToPost{
  private StackX operators;
  private String input;
  private String output = "";

  //contructor
  public InToPost(String input){
    this.input = input;
    operators = new StackX(input.length());
  }
  //doTrans
  public void doTrans(){
    for(int i = 0; i < input.length(); i++){
        char c = input.charAt(i);
        switch(c){
            case '+':
            case '-':
                gotOper(c, 1);
                break;
            case '*':
            case '/':
                gotOper(c, 2);
                break;
            case '(':
                operators.push(c);
                break;
            case ')':
                gotParen();
                break;
            default:
                output += c;
                break;
        }  
    }
    while(!operators.isEmpty()){
            output += operators.pop();
    }
  }
  //gotOper
  public void gotOper(char c, int thisPrec){
    if(!operators.isEmpty()){
      char topC = operators.pop();
      int topPrec = 0;
      if(topC == '+' || topC == '-'){
        topPrec = 1;
      }else if(topC == '*' || topC == '/'){
        topPrec = 2;
      }

      if(thisPrec <= topPrec){
        output += topC;
      }else{
        operators.push(topC);
      }
    }
    
    operators.push(c);
  }
  //gotParen
  public void gotParen(){
    while(true){
      char topC = operators.pop();
      if(topC == '('){
        break;
      }else{
        output += topC;
      }
    }
  }
  public String postFix(){
    return output;
  }

}