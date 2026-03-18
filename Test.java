public class Test{
    public static void main(String[] args) {
        int[] arr = new int[3];
        try {
             System.out.println(arr[5]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
             System.out.println("Array index error");
        } 
        catch (Exception e) {
             System.out.println("General error");
        }
       
    }
}