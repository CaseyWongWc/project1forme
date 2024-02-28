package project1forme;

import java.util.Arrays;

public class BagDriver 
{
    
    /** 
     * @param args
     * Creates and bags the new string arrays.
     * Afterwards, uses the methods union, intersection, and difference
     * on the arrays and returns their outputs. Unlike the original difference program,
     * this one prints out both string array entries after the they have been modified.
     */
    public static void main(String[] args) 
    {

        //BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();

        /*bag1.add("a");
        bag1.add("b");
        bag1.add("c");*/

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        String[] array1 = { "a", "b", "c"};
        //String[] array2 = { "b", "b", "d", "e" };   

        BagInterface<String> bag1 = toBag(array1);
        //BagInterface<String> bag2 = toBag(array2);
        

        BagInterface<String> everything = bag1.union(bag2);
        BagInterface<String> commonItems = bag1.intersection(bag2);
        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

        print(everything);
        print(commonItems);
        print(leftOver1);
        print(leftOver2);


    }
    
    private static  BagInterface<String> toBag(String[] content)
    {
        BagInterface<String> aBag = new LinkedBag<>();
        for (int i=0; i < content.length;i++)
        {   
            aBag.add(content[i]);
        }
        return aBag;
    }

    private static void print(BagInterface<String> abag)
    {
        System.out.println(Arrays.toString(abag.toArray()));
    }
}