public class TestFour{
    public static void main(String [] args){
       
       try {
             try{
                System.out.println("Start");
                int arr[] = new int[2];
                System.out.println(arr[5]);
             }catch(Exception e){
                System.out.println("Handled for inner block");
             }
                System.out.println("End");
                System.out.println(10/0);
           } 
        catch (Exception e) {
                System.out.println("Handled for outer block");
           }
        
    }
}