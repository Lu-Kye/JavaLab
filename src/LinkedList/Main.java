import Framework.*;

class LinkedNode
{
    public Integer val;
    public LinkedNode next;
    public String toString()
    {
        return this.val.toString();
    }
    
    public LinkedNode(Integer val)
    {
        this.val = val;
    }
}

public class Main extends BaseTest
{
    public void TestReverse()
    {
        LinkedNode a = new LinkedNode(1);
        LinkedNode b = new LinkedNode(2);
        LinkedNode c = new LinkedNode(3);
        LinkedNode d = new LinkedNode(4);
        LinkedNode e = new LinkedNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // Print origin
        LinkedNode head = a;
        while (head != null)
        {
            Utility.Print(head.toString());
            head = head.next;
        }

        // Reverse
        head = a;
        LinkedNode newHead = null;
        while (head != null)
        {
            LinkedNode oldNext = head.next;
            head.next = newHead;
            newHead = head;
            head = oldNext;
        }

        // Print reversed
        head = newHead;
        while (head != null)
        {
            Utility.Print(head.toString());
            head = head.next;
        }
    }    

    public void TestReverseBetween()
    {
        LinkedNode a = new LinkedNode(1);
        LinkedNode b = new LinkedNode(2);
        LinkedNode c = new LinkedNode(3);
        LinkedNode d = new LinkedNode(4);
        LinkedNode e = new LinkedNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // Print origin
        LinkedNode head = a;
        while (head != null)
        {
            Utility.Print(head.toString());
            head = head.next;
        }

        // Reverse (index start from 0)
        int m = 1;
        int n = 2;
        int len = n - m + 1;
        // Move forward m steps
        head = a;
        LinkedNode modifyHeadPreNode = null;
        while (m-- > 0)
        {
            modifyHeadPreNode = head;
            head = head.next;
        }
        LinkedNode modifyTail = head;

        LinkedNode modifyHead = null;
        while (head != null && len-- > 0)
        {
            LinkedNode next = head.next;
            head.next = modifyHead;
            modifyHead = head;
            head = next;
        }
        modifyTail.next = head;
        modifyHeadPreNode.next = modifyHead;

        // Print reversed
        head = a;
        while (head != null)
        {
            Utility.Print(head.toString());
            head = head.next;
        }
    }

    public void TestFindCircle()
    {
        LinkedNode a = new LinkedNode(1);
        LinkedNode b = new LinkedNode(2);
        LinkedNode c = new LinkedNode(3);
        LinkedNode d = new LinkedNode(4);
        LinkedNode e = new LinkedNode(5);
        LinkedNode f = new LinkedNode(6);
        LinkedNode g = new LinkedNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e; 
        e.next = f;
        f.next = g;
        g.next = c;
        // 1->2->3->4->5->6
        // ->7->3

        LinkedNode fastPtr = a; int fastStep = 2;
        LinkedNode slowPtr = a; int slowStep = 1;
        do
        {

            for (int i = 0; i < slowStep; ++i)
            {
                slowPtr = slowPtr.next;
            } 
            for (int i = 0; i < fastStep; ++i)
            {
                fastPtr = fastPtr.next;
            } 

        } while (fastPtr == slowPtr);
        Utility.Print(fastPtr.toString());
    }


    public static void main(String[] args) 
    {
        Main test = new Main();
        test.Run();
    }
}