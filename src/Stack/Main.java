package Stack;

import java.util.*;
import Framework.*;

class MyStack
{
    Queue<Integer> _data = new LinkedList<Integer>();
    Queue<Integer> _temp = new LinkedList<Integer>();

    public void Push(Integer val)
    {
        _temp.add(val);
        while (_data.isEmpty() == false)
        {
            _temp.add(_data.remove());
        }

        while (_temp.isEmpty() == false)
        {
            _data.add(_temp.remove());
        }
    }

    public Integer Pop()
    {
        return _data.remove();
    }

    public String toString()
    {
        return _data.toString();
    }
}

public class Main extends BaseTest
{
    public void TestMyStack()
    {
        MyStack stack = new MyStack();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Push(4);

        Utility.Print(stack.toString());

        stack.Pop();
        Utility.Print(stack.toString());
    }

    public static void main(String[] args)
    {
        Main test = new Main();
        test.Run();
    }
}