package Framework;

public class Utility 
{
    public static void Print(String msg) 
    {
        try 
        {
            System.out.println(new String(msg.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println(String.format("Print error e(%s)", e.getMessage()));
        }
    }
}