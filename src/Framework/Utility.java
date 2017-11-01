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

    public static <T> T[] Reverse(T[] array)
    {
        int middle = array.length/2;
        for (int i = 0; i < middle; ++i)
        {
            T temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public static <T> String ToString(T[] array)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; ++i)
        {
            sb.append(array[i].toString());
            if (i != array.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}