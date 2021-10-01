package codingpatterns.kwaymerge;
import java.util.*;

class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        // TODO: Write your code here
        int n = matrix.length;
        int len = matrix[0].length;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                if (queue.size() == k) {
                    int num = queue.poll();
                    if (matrix[i][j] < num) queue.add(matrix[i][j]);
                    else queue.add(num);
                } else queue.add(matrix[i][j]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
