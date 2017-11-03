package Greedy;

import Framework.*;
import java.util.*;

public class Main extends BaseTest
{
    public void TestGiveChange()
    {
        int[] rmb = new int[] {200,100,20,10,5,1};
        int money = 628;
        int num = 0;
        for (int i = 0; i < rmb.length; ++i)
        {
            int currentRmbNum = money / rmb[i];
            int remainMoney = money - currentRmbNum * rmb[i];
            num += currentRmbNum;
            money = remainMoney;
            Utility.Print(String.format(
                "rmb(%d) rmbNum(%d) remain(%d)",
                rmb[i],
                currentRmbNum,
                remainMoney
            ));
            if (money == 0)
                break;
        }
        Utility.Print("NUM: " + num);
    }

    public void TestCandy()
    {
        int[] reqs = new int[] {5,10,2,9,15,9};
        int[] candys = new int[] {6,1,20,3,8};
        Arrays.sort(reqs);
        Arrays.sort(candys);
        Utility.Print(Utility.ToString(reqs));
        Utility.Print(Utility.ToString(candys));

        int reqIndex = 0;
        int candyIndex = 0;
        int finishedNum = 0;
        while (reqIndex < reqs.length && candyIndex < candys.length)
        {
            int candy = candys[candyIndex];
            int req = reqs[reqIndex];
            if (candy>=req)
            {
                candyIndex++;
                reqIndex++;
                finishedNum++;
                continue;
            }
            candyIndex++;
        }
        Utility.Print("Finished: " + finishedNum);
    }

    public void TestMaxWiggleLen()
    {
        int[] set = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};

        int wiggleLen = 0;
        int maxWiggleLen = 0;

        int preWiggleSign = 0;
        int wiggleSign = 0;

        int wiggleLeftNum = 0;
        int wiggleRightNum = 0;

        int setIndex = 1;
        wiggleLeftNum = set[0];

        for (;setIndex < set.length; setIndex++)
        {
            wiggleRightNum = set[setIndex];
            wiggleSign = wiggleRightNum > wiggleLeftNum ? 1 : -1;

            // Utility.Print(String.format(
            //     "PreSign:%d Sign%d",
            //     preWiggleSign,
            //     wiggleSign
            // ));

            if (preWiggleSign == 0)
            {
                // First sub set 
                wiggleLen = 1;
            }
            else if (preWiggleSign != wiggleSign)
            {
                wiggleLen++;
            }
            else 
            {
                // New sub set started
                if (wiggleLen > maxWiggleLen)
                    maxWiggleLen = wiggleLen;
                wiggleLen = 1;
            }

            wiggleLeftNum = wiggleRightNum;
            preWiggleSign = wiggleSign;
        }

        maxWiggleLen = maxWiggleLen == 0 ? wiggleLen : maxWiggleLen;
        Utility.Print("WiggleLen: " + maxWiggleLen);
    }

    public enum State {
        BEGIN,
        DOWN,
        UP, 
    }
    public void TestSubSetMaxWiggleLen()
    {
        int[] set = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};

        int wiggleLeftNum = set[0];
        int wiggleRightNum = 0;
        int wiggleLen = 0;

        int wiggleSign = 0;
        int preWiggleSign = 0;
        int DOWN = -1;
        int UP = 1;

        State state = State.BEGIN;
        int setIndex = 1;
        for (;setIndex<set.length;++setIndex)
        {
            wiggleRightNum = set[setIndex];
            wiggleSign = wiggleRightNum > wiggleLeftNum ? UP : DOWN;

            switch (state)
            {
                case BEGIN:
                    wiggleLen = wiggleLen + 1;
                    if (wiggleSign == UP)
                        state = State.UP;
                    else
                        state = State.DOWN;
                    break;
                
                case UP:
                    if (wiggleSign != UP)
                    {
                        state = State.DOWN;
                        wiggleLen++;
                    }
                    break;

                case DOWN:
                    if (wiggleSign != DOWN)
                    {
                        state = State.UP;
                        wiggleLen++;
                    }
                    break;
            }

            preWiggleSign = wiggleSign;
            wiggleLeftNum = wiggleRightNum;
        }
        if (state == State.DOWN || state == State.UP)
            wiggleLen++;

        Utility.Print("WiggleLen: " + wiggleLen);
    }

    public static void main(String[] args)
    {
        Main test = new Main();
        test.Run();
    }
}