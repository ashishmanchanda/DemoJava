package blind250.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {

    static class Project   {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

     public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
         int n = Profits.length;
         Project[] projects = new Project[n];
         for (int i = 0; i < n; i++) {
             projects[i] = new Project(Capital[i], Profits[i]);
         }
         Arrays.sort(projects, (a, b) -> a.capital - b.capital);
         PriorityQueue<Project> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
         int j = 0;
         for (int i = 0; i < k; i++) {
             while (j < n && projects[j].capital <= W) {
                 maxHeap.offer(projects[j]);
                 j++;
             }
             if (maxHeap.isEmpty()) {
                 break;
             }
             W += maxHeap.poll().profit;
         }
         return W;
     }



}
