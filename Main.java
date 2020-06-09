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
           int result = percolate(arr,0,0);

           System.out.println("Result : " + result);
           System.out.println();

       } catch (IndexOutOfBoundsException e) {
           System.out.println("Please give the input as a pyramid.");
           main(args);
       }

    }

    static int percolate(int[][] integerArray,int x, int y) {

        if (x == integerArray.length - 1) // if the position is at the end return the value in this position
            return integerArray[x][y];
        else {
            if (primeCheck(integerArray[x + 1][y]) && primeCheck(integerArray[x + 1][y + 1]))
                return integerArray[x][y];            // if both left and right positions have prime numbers stop here
            else if (primeCheck(integerArray[x + 1][y]))
                return integerArray[x][y] + percolate(integerArray,x + 1, y + 1);   // if left is prime go right
            else if (primeCheck(integerArray[x + 1][y + 1]))
                return integerArray[x][y] + percolate(integerArray,x + 1, y);         // if right is prime go left
            else
                return integerArray[x][y] + Math.max(percolate(integerArray,x + 1, y), percolate(integerArray,x + 1, y + 1)); // else return max
        }

    }
    static boolean primeCheck(int a) {

        if ( a < 2)
            return false;

        for (int i = 2 ; i <= a/2 ; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }
}
