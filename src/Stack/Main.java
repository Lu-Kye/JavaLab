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

    public Integer Top()
    {
        return _data.element();
    }

    public String toString()
    {
        return _data.toString();
    }
}

class MinStack
{
    Stack<Integer> _data = new Stack<Integer>();
    Stack<Integer> _minData = new Stack<Integer>();

    public void Push(Integer val)
    {
        _data.push(val);
        if (_minData.isEmpty() || val <= _minData.peek())
            _minData.push(val);
    }

    public Integer Pop()
    {
        if (_data.peek() == _minData.peek())
            _minData.pop();
        return _data.pop();
    }

    public Integer GetMin()
    {
        return _minData.peek();
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

    public void TestMinStack()
    {
        MinStack stack = new MinStack();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Push(4);
        stack.Push(-1);
        stack.Push(-1);

        Utility.Print(stack.GetMin().toString());

        stack.Pop();
        stack.Pop();
        Utility.Print(stack.GetMin().toString());

        stack.Pop();
        stack.Pop();
        stack.Pop();
        Utility.Print(stack.GetMin().toString());
    }

    public static void main(String[] args)
    {
        Main test = new Main();
        test.Run();
    }
}