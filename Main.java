/*

VERY INTELLIGENT AND VERY BAD ALGORITHM TO DO THE FOLLOWING

You will have an orthogonal triangle input from a file and you need to find the maximum sum of the numbers according to given rules below;

1. You will start from the top and move downwards to an adjacent number as in below.
2. You are only allowed to walk downwards and diagonally.
3. You can only walk over NON PRIME NUMBERS.
4. You have to reach at the end of the pyramid as much as possible.
5. You have to treat your input as pyramid.

According to above rules the maximum sum of the numbers from top to bottom in below example is 24.

      *1
     *8 4
    2 *6 9
   8 5 *9 3

As you can see this has several paths that fits the rule of NOT PRIME NUMBERS; 1>8>6>9, 1>4>6>9, 1>4>9>9
1 + 8 + 6 + 9 = 24.  As you see 1, 8, 6, 9 are all NOT PRIME NUMBERS and walking over these yields the maximum sum.

 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       try {
           ArrayList<String> lines = new ArrayList<>();
           Scanner console = new Scanner(System.in);

           while (console.hasNextLine()) {
               String line = console.nextLine();
               lines.add(line);
           }

           int[][] arr = new int[lines.size()][lines.size()];

           for (int i = 0 ; i < lines.size() ; i++) {

               String[] strings = lines.get(i).split(" ");

               for (int j = 0; j < strings.length ; j++ ) {
                   arr[i][j] = Integer.parseInt(strings[j]);
               }
           }

           PathFinder pathFinder = new PathFinder(arr,0,0);
           int result = pathFinder.maxSum;

           System.out.println("Result : " + result);
           System.out.println();

       } catch (IndexOutOfBoundsException e) {
           System.out.println("Please give the input as a pyramid.");
           main(args);
       }

    }

//    static int percolate(int[][] integerArray,int x, int y) {
//        boolean reach = false;
//        if (x == integerArray.length - 1) // if the position is at the end return the value in this position
//            return integerArray[x][y];
//        else {
//            if (primeCheck(integerArray[x + 1][y]) && primeCheck(integerArray[x + 1][y + 1]))
//                return integerArray[x][y];            // if both left and right positions have prime numbers stop here
//            else if (primeCheck(integerArray[x + 1][y]))
//                return integerArray[x][y] + percolate(integerArray,x + 1, y + 1);   // if left is prime go right
//            else if (primeCheck(integerArray[x + 1][y + 1]))
//                return integerArray[x][y] + percolate(integerArray,x + 1, y);         // if right is prime go left
//            else
//                return integerArray[x][y] + Math.max(percolate(integerArray,x + 1, y), percolate(integerArray,x + 1, y + 1)); // else return max
//        }
//
//    }
//    static boolean primeCheck(int a) {
//
//        if ( a < 2)
//            return false;
//
//         for (int i = 2 ; i <= a/2 ; i++) {
//            if (a % i == 0)
//                return false;
//        }
//        return true;
//    }

//    static void primeAdjust(int[][] arr) {
//        for (int i = 0; i < arr.length ; i++) {
//
//            for (int j = 0 ; j < arr[0].length ; j++) {
//                if (primeCheck(arr[i][j]))
//                {
//                    arr[i][j] = 0;
//                }
//
//            }
//        }
//
//    }

    static void arrPrint(int[][] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.println();
            for (int j = 0 ; j < arr[0].length ; j++) {
                    System.out.print(arr[i][j] + " ");

            }
        }

    }
}
