package Heap;

import Framework.*;
import java.util.*;

class Heap
{
    ArrayList<Integer> _data = new ArrayList<Integer>();

    public Boolean MinHeap = false;

    public void Push(Integer e)
    {
        _data.add(e);
        int index = _data.size() - 1;
        this.shiftUp(index, e);
    }

    public void Pop()
    {
        this.swap(0, _data.size()-1);
        _data.remove(_data.size()-1);
        this.shiftDown(0, _data.get(0));
    }

    void shiftUp(Integer index, Integer e)
    {
        while (index > 0)
        {
            Integer parentIndex = (index+1)/2 - 1;
            Integer parent = _data.get(parentIndex);
            Boolean shouldSwap = this.MinHeap ? parent > e : parent < e;
            if (shouldSwap)
                this.swap(index, parentIndex);
            index = parentIndex;
        }
    }

    void shiftDown(Integer index, Integer e)
    {
        while ((index+1)*2 - 1 < _data.size())
        {
            Integer leftChildIndex = (index+1)*2 - 1;
            Integer rightChildIndex = (index+1)*2;
            Boolean rightChildExists = rightChildIndex < _data.size();

            Integer moveIndex = -1;
            Integer leftChild = _data.get(leftChildIndex);
            if (this.MinHeap ? leftChild < e : leftChild > e)
            {
                moveIndex = leftChildIndex;
            }
            if (rightChildExists)
            {
                Integer rightChild = _data.get(rightChildIndex);
                if (this.MinHeap ? rightChild < leftChild : rightChild > leftChild)
                    moveIndex = rightChildIndex;
            }
            if (moveIndex == -1)
                break;
            
            this.swap(index, moveIndex);
            index = moveIndex;
        }
    }

    void swap(Integer i1, Integer i2)
    {
        // Utility.Print("Swap " + i1 + " " + i2);

        Integer preI1 = _data.get(i1);
        _data.set(i1, _data.get(i2));
        _data.set(i2, preI1);
    }

    public String toString()
    {
        return _data.toString();
    }
}

public class Main extends BaseTest
{
    public void TestMinHeap()
    {
        Heap heap = new Heap();
        heap.Push(6);
        heap.Push(10);
        heap.Push(1);
        heap.Push(7);
        heap.Push(99);
        heap.Push(4);
        heap.Push(33);
        heap.Push(1000);

        Utility.Print(heap.toString());

        heap.Pop();
        heap.Pop();
        heap.Pop();
        Utility.Print(heap.toString());
    }

    public void TestKthNumber()
    {
        // Bigger heap
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return -(o1 - o2);
            }
        });
        heap.add(6);
        heap.add(10);
        heap.add(1);
        heap.add(7);
        heap.add(99);
        heap.add(4);
        heap.add(33);
        heap.add(1000);
        Utility.Print(heap.toString());

        heap.clear();
        Integer[] data = new Integer[] {3,2,1,5,6,4};
        Integer k = 2;
        for (int i = 0; i < data.length; ++i)
        {
            if (i < k)
            {
                heap.add(data[i]);
                continue;
            }

            if (heap.peek() > data[i])
            {
                heap.remove();
                heap.add(data[i]);
            }
        }

        Utility.Print(heap.toString());
    }

    public void TestFindMidNumber()
    {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return -(o1 - o2);
            }
        });
        PriorityQueue<Integer> rightHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return (o1 - o2);
            }
        });

        Integer[] data = new Integer[] {3,2,1};
        for (int i = 0; i < data.length; ++i)
        {
            Integer e = data[i];
            if (rightHeap.isEmpty())
            {
                rightHeap.add(e);
                continue;
            }

            if (leftHeap.size() < rightHeap.size())
            {
                if (leftHeap.isEmpty() || e < leftHeap.peek())
                {
                    leftHeap.add(e);
                }
                else
                {
                    leftHeap.add(rightHeap.remove());
                    rightHeap.add(e);
                }
                continue;
            }
            else if (rightHeap.size() < leftHeap.size())
            {
                if (e > rightHeap.peek())
                {
                    rightHeap.add(e);
                }
                else
                {
                    rightHeap.add(leftHeap.remove());
                    leftHeap.add(e);
                }
                continue;
            }

            if (e <= leftHeap.peek())
            {
                leftHeap.add(e);
            }
            else if (e > rightHeap.peek())
            {
                rightHeap.add(e);
            }
        }

        Utility.Print("left: " + leftHeap.toString());
        Utility.Print("right: " + rightHeap.toString());
        if (leftHeap.size() == rightHeap.size())
        {
            Utility.Print("MiddleAvg: " + (leftHeap.peek() + rightHeap.peek()) / 2);
        }
        else if (leftHeap.size() > rightHeap.size())
        {
            Utility.Print("MiddleLeft: " + (leftHeap.peek() + leftHeap.peek()) / 2);
        }
        else if (leftHeap.size() < rightHeap.size())
        {
            Utility.Print("MiddleRight: " + (rightHeap.peek() + rightHeap.peek()) / 2);
        }
    }

    public static void main(String[] args)
    {
        Main test = new Main();
        test.Run();
        // test.TestFindMidNumber();
    }
}