Very intelligent and somewhat slow algorithm to do the following.

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
Works with negative numbers as well.

According to above rules the maximum sum of the numbers from top to bottom in below example is 4.

       *1
      6 *1
     4 2 *1
    2 2 2 *1
  
Though the sum on the left-most arm is 1+6+4 = 11 it is not considered as the deserved path since there is a longer path in the tree. So
longer path is prior to greater sum.

-----------------------------------------------------------------------------------------------------------------------------------------

To run the jar file please write "java -jar ./PIWORKS.jar < input.txt" to console in the same directory with jar file.

Remember to check your java PATH variable whether it is correctly set.
