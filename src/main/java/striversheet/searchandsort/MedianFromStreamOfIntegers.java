package striversheet.searchandsort;

import java.util.PriorityQueue;
import java.util.ArrayList;

class MedianGfG {
    static ArrayList<Double> getMedian(int[] arr) {

        // Max heap to store the smaller half of numbers
        PriorityQueue<Integer> s = new PriorityQueue<>((a, b) -> b - a);

        // Min heap to store the greater half of numbers
        PriorityQueue<Integer> g = new PriorityQueue<>();

        ArrayList<Double> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // Insert new element into max heap
            s.add(arr[i]);

            // Move the top of max heap to min heap to maintain order
            int temp = s.poll();
            g.add(temp);

            // Balance heaps if min heap has more elements
            if (g.size() > s.size()) {
                temp = g.poll();
                s.add(temp);
            }

            // Compute median based on heap sizes
            double median;
            if (s.size() != g.size())
                median = s.peek();
            else
                median = (s.peek() + g.peek()) / 2.0;

            res.add(median);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 2, 8};
        ArrayList<Double> res = getMedian(arr);
        System.out.printf("%.2f", res.get(0));

        for (int i = 1; i < res.size(); i++) {
            System.out.printf(" %.2f", res.get(i));
        }
    }
}