package Queue;

import java.util.*;
import Framework.*;

class MyQueue
{
    Stack<Integer> _data = new Stack<Integer>();
    Stack<Integer> _temp = new Stack<Integer>();

    public void Enqueue(Integer val)
    {
        while (_data.isEmpty() == false)
        {
            _temp.push(_data.pop());
        }
        _temp.push(val);

        while (_temp.isEmpty() == false)
        {
            _data.push(_temp.pop());
        }
    }

    public Integer Dequeue()
    {
        return _data.pop();
    }

    public String toString()
    {
        return Utility.ToString(Utility.Reverse(_data.toArray()));
    }
}

public class Main extends BaseTest
{
    public void TestQueueByStack()
    {
        MyQueue queue = new MyQueue();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);

        Utility.Print(queue.toString());

        queue.Dequeue();
        Utility.Print(queue.toString());
    }

    public static void main(String[] args)
    {
        Main test = new Main();
        test.Run();
    }
}