public class PathFinder {

    int reach;
    int[][] integerArray;
    int x, y;
    int maxSum;

    public PathFinder(int[][] integerArray,int x, int y) {
        this.integerArray = integerArray;
        this.reach = x;
        this.x = x;
        this.y = y;
        this.maxSum = percolate(integerArray,x,y);
    }

    int percolate(int[][] integerArray,int i, int j) {

          if (i == integerArray.length - 1) {
              this.reach = integerArray.length;
              return integerArray[i][j]; // if the position is at the end return the value in this position
          }
          else {
              PathFinder path1 = new PathFinder(integerArray,i+1,j);
              PathFinder path2 = new PathFinder(integerArray,i+1,j+1);
              if (primeCheck(integerArray[i + 1][j]) && primeCheck(integerArray[i + 1][j + 1])) {
                this.reach++;
                return integerArray[i][j];            // if both left and right positions have prime numbers stop here
              }
              else if (primeCheck(integerArray[i + 1][j])) {
                  this.reach += path2.reach + 1;
                  return integerArray[i][j] + path2.maxSum;   // if left is prime go right
              }
              else if (primeCheck(integerArray[i + 1][j + 1])) {
                  this.reach += path1.reach +1;
                  return integerArray[i][j] + path1.maxSum;   // if right is prime go left
              }
              else {                                                                  // if both not prime
                  if (path1.reach == path2.reach) { // lengths are the same choose max
                      this.reach += path1.reach + 1;
                      return integerArray[i][j] + Math.max(path1.maxSum, path2.maxSum);
                  }
                  else if (path1.reach < path2.reach) { // if path2 longer choose it
                      this.reach += path2.reach + 1;
                      return integerArray[i][j] + path2.maxSum;
                  }
                  else {                               // if path1 longer choose it
                      this.reach += path1.reach +1;
                      return integerArray[i][j] + path1.maxSum;
                  }

              }

          }
    }

    boolean primeCheck(int a) {

        if ( a < 2)
            return false;

        for (int i = 2 ; i <= a/2 ; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }

    void arrPrint(int[][] arr) {
        for (int i = 0; i < integerArray.length ; i++) {
            System.out.println();
            for (int j = 0 ; j < integerArray[0].length ; j++)
                System.out.print(arr[i][j] + " ");
        }
    }
}

