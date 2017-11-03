package Calculator;

import java.util.*;
import Framework.*;

class Computer
{
    static final int BEGIN = 0;
    static final int NUMBER = 1;
    static final int OPERATION = 2;

    Stack<Integer> _numbers = new Stack<Integer>();
    Stack<Character> _ops = new Stack<Character>();

    public Integer Compute(String s)
    {
        int compute_flag = 0;
        int state = BEGIN;
        char[] cs = s.toCharArray();
        for (Integer i = 0; i < cs.length; ++i)
        {
            Character c = cs[i];
            switch (state) 
            {
                case BEGIN:
                    if (c < '0' || c > '9')
                    {
                        // Not number
                        state = OPERATION;
                    }
                    else
                    {
                        state = NUMBER;
                    }
                    i--;
                    break;
                
                case NUMBER:
                    Integer[] iWrapper = new Integer[] {i};
                    Integer number = Utility.GetInteger(cs, iWrapper);
                    i = iWrapper[0] - 1;
                    _numbers.push(number);

                    Boolean isRightBracket = (i+1) > cs.length - 1 ? false :
                        (cs[i+1] == ')');
                    if (compute_flag == 1 || isRightBracket)
                    {
                        compute_flag = 0;
                        this.ComputeStack();
                    }
                    state = BEGIN;                    
                    break; 
                
                case OPERATION:
                    char op = cs[i];
                    if (op == '+' || op == '-')
                    {
                        _ops.push(op);
                        state = BEGIN;
                        compute_flag = 1;
                        break;
                    }
                    else if (op == '(')
                    {
                        state = BEGIN;
                        compute_flag = 0;
                        break;
                    }
                    break;
            }
        }
        while (_ops.isEmpty() == false) this.ComputeStack();
        return _numbers.isEmpty() ? 0 : _numbers.pop();
    }

    void ComputeStack()
    {
        // Utility.Print("Begin" + _numbers.toString() + " " + _ops.toString());

        Integer num2 = _numbers.pop();
        Integer num1 = _numbers.pop();
        char op = _ops.pop();

        Integer num = 0;
        if (op == '+')
            num = num1 + num2;
        else if (op == '-')
            num = num1 - num2;
        _numbers.push(num);

        // Utility.Print("End" + _numbers.toString() + " " + _ops.toString());
    }
}

public class Main extends BaseTest
{
    public void TestGetNumber()
    {
        String s = "12345(";
        Integer i = 0;
        Integer[] iWrapper = new Integer[] {i};
        Integer number = Utility.GetInteger(s.toCharArray(), iWrapper);
        Utility.Print("i: " + iWrapper[0]+ ";" + "num: " + number);
    }

    public void TestCompute()
    {
        String s = "1+121 - (14+(5-6) )";
        Computer computer = new Computer();
        Utility.Print("result: " + computer.Compute(s));
    }

    public static void main(String[] args)
    {
        Main test = new Main();
        test.Run();
    }
}