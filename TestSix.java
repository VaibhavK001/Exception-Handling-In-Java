import java.util.*;

class Calculator{
    void add() throws ArithmeticException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int number1 = sc.nextInt();
        System.out.print("Enter second number : ");
        int number2 = sc.nextInt();
        System.out.println(number1/number2);
    }
}

public class TestSix{
    public static void main(String[] args) {
      Calculator cr = new Calculator();
      try{
        cr.add();
      }
      catch(ArithmeticException e){
        e.printStackTrace();
      }
      System.out.println("Program executed successfully.");
    }
}