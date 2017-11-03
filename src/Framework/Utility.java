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
            Print(e);
        }
    }

    public static void Print(Exception e) 
    {
        System.out.println(String.format("Exception e(%s)", e.getMessage()));
        for (StackTraceElement ste : e.getStackTrace()) {
            System.out.println(ste.toString());
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

    public static Integer GetInteger(char[] cs, Integer[] startWrapper)
    {
        Integer number = 0;
        int i = startWrapper[0];
        for (; i < cs.length; ++i)
        {
            char c = cs[i];
            if (c >= '0' && c <= '9')
            {
                number = number * 10 + (c - '0');
                continue;
            }
            break; 
        }
        startWrapper[0] = i;
        return number;
    }
}