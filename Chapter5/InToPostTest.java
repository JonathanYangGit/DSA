import java.io.*;
// Test infix.java
class InToPostTest{
  public static void main(String[] args) throws IOException{
    while(true){
      String input = getInput();
      if(input.equals("exit")){
        break;
      }
      InToPost itp = new InToPost(input);
      itp.doTrans();
      System.out.println(itp.postFix());
    }
  }

  public static String getInput() throws IOException{
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String line = br.readLine();
    return line; 
  }
}
