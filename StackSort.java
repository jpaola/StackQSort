package stack;

import java.util.Random;
import java.util.Stack;

/**
 * This class simulates a stack of integer
 * numbers, s, and sorts them in ascending order.
 *
 * (b) The running time complexity is O(NlogN) since the original stack gets 
 *     halved and each half is recursively sorted which means we traverse the list.
 *     Both are then combined at the end including a median value. 
 *
 * @author Paola Jiron 06/10/15
 */
/*
 * I hereby certify that this work is my own and none of it is the work of any 
 * other person.
 *
 * E-signature: Paola Jiron
 */
public class StackSort
{
    /**
     * A recursive approach to sort a stack of integers.
     * @param s the stack to be sorted.
     * @return the sorted stack.
     */
    public static Stack<Integer> sort(Stack<Integer> s)
    {
        if (s.isEmpty())    // check if the stack is empty
        {
            return s;
        }
        else                // otherwise...
        {
            int slinky = s.pop();

            // divide the s stack into 2 parts
            Stack<Integer> low = new Stack<>();
            Stack<Integer> high = new Stack<>();

            while (!s.isEmpty())
            {
                int i = s.pop();
                if (i < slinky)
                {
                    low.push(i);
                }
                else
                {
                    high.push(i);
                }
            }  
            // sort both stacks
            sort(low);
            sort(high);

            // combine low and high values
            Stack<Integer> t = new Stack<>();
            while (!high.isEmpty())          // push high values first
            {
                t.push(high.pop());
            }
            t.push(slinky);                 //.. then the middle values
            while (!low.isEmpty())            //...following the small values
            {
                t.push(low.pop());
            }
            while (!t.isEmpty())         // push values into s
            {
                s.push(t.pop());
            }                                 
        }
        return s;           // s is now sorted
    }
    // tests the StackSort function
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        
        Random generate = new Random();
        
        for (int i = 0; i < 20; i++)        // add values to s
        {
            s.push(generate.nextInt(50));
        }

        System.out.println(StackSort.sort(s));      
    }
} // end of StackSort class definitions
