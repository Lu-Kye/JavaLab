package Recursion;

import java.util.*;
import Framework.*;

public class Main extends BaseTest
{
    public void TestSubsets()
    {
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(2);
        set.add(1);
        set.add(2);
        set.add(2);
        set.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2)
            {
                return i1 - i2; 
            }
        });

        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        _TestSubsets(set, 0, new ArrayList<Integer>(), subsets);

        for (int i = 0; i < subsets.size(); ++i)
        {
            Utility.Print(Utility.ToString(subsets.get(i).toArray()));
        }
    }
    @SuppressWarnings({"unchecked"})
    void _TestSubsets(ArrayList<Integer> set, Integer index, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> subsets)
    {
        if (index >= set.size())
            return;

        // Put current number
        subset.add(set.get(index));
        if (Utility.Contains(subsets, subset) == false)
            subsets.add((ArrayList<Integer>)subset.clone());
        _TestSubsets(set, index + 1, subset, subsets);

        // Not put current number
        subset.remove(subset.size() - 1);
        if (index == 0)
            subsets.add((ArrayList<Integer>)subset.clone());
        _TestSubsets(set, index + 1, subset, subsets);
    }

    public static void main(String[] args)
    {
        Main test = new Main();
        test.Run();
    }
}