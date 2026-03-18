public class TestOne{
    public static void main (String[] args){
        try{
            System.out.println("Resource opened");
            System.out.println(10/0);
        }
        catch(Exception e){
            System.out.println("Exception handled by vaibhav");
        }
        finally{
            System.out.println("Resource closed");
        }
    }
}