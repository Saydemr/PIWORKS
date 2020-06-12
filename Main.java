/*
    ABDULLAH SAYDEMIR


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

            for (int i = 0; i < lines.size(); i++) {

                String[] strings = lines.get(i).split(" ");

                for (int j = 0; j < strings.length; j++) {
                    arr[i][j] = Integer.parseInt(strings[j]);
                }
            }

            PathFinder pathFinder = new PathFinder(arr, 0, 0);
            int result = pathFinder.maxSum;

            System.out.println("Result : " + result);
            System.out.println();

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please give the input as a pyramid.");
            main(args);
        }

    }
}


