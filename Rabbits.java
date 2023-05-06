/* There is a forest with an unknown number of rabbits... We asked n rabbits "How many rabbits have the same
color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the 
ith rabbit... Given the array answers, return the minimum number of rabbits that could be in the forest...
* Eg 1 : Array = [1,1,2]                                      Rabbits = 2 + 3 = 5
* Eg 2 : Array = [10,10,10]                                   Rabbits = 10 + 1 = 11
 */
import java.util.*;
public class Rabbits
{
      public int MinimumRabbitsInForest(int nums[])
      {
            int rabbit = 0;         //* Variable => O(1)
            Arrays.sort(nums);      //! Sorting => O(N log N)
            for(int i = 0; i < nums.length - 1; i++)      //! Linear Comparison => O(N)
            {
                  if(nums[i] != nums[i + 1])    // If the two adjacent rabbits have different color...
                        rabbit = rabbit + nums[i] + 1;    // Update the rabbit count...
            }
            if(nums[nums.length - 2] != nums[nums.length - 1])  // If the last rabbit color is different...
                  rabbit = rabbit + nums[nums.length - 1] + 1;  // Update the rabbit count...
            if(rabbit == 0)     // If all rabbits have same color...
                  rabbit = nums[0] + 1;     // Increment the number of rabbits by 1...
            return rabbit;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter the number of elements : ");
            x = sc.nextInt();
            int nums[] = new int[x];
            for(int i = 0; i < nums.length; i++)
            {
                  System.out.print("Enter data : ");
                  nums[i] = sc.nextInt();
            }
            Rabbits rabbits = new Rabbits();             // Object creation...
            x = rabbits.MinimumRabbitsInForest(nums);    // Function calling...
            System.out.print("The Minimum Number of Rabbits in the forest are : "+x);
            sc.close();
      }
}


//! Time Complexity => O(N log N)
//* Space Complexity => O(1)

/** //? DEDUCTIONS :-
 * ? Each x answering rabbit of one color, means there are (x+1) rabbit...
 * ? We can sort the array and then easily group the rabbits on the basis of colors (numbers)...
 * ? Then, we can increment the number of rabbits by +1 for every color...
 */