public class TestThree{
    public static void main(String args[]){
        try{
            System.out.println("Outer try block");
            try{
                System.out.println("Inner try block");
                System.out.println(10/0);
            }catch(ArithmeticException e){
                System.out.println("Inner block exception handled");
            }
            int[] arr = new int[3];
            System.out.println(arr[4]);
        }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Outer block exception hnadled");
        }
    }
}