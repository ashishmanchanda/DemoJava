package DataStructuresPractice.greedyalgo;

// Java program to solve job sequencing
// problem with maximum profit
import java.util.*;

class GfG {
    static boolean comp1(Pair a, Pair b) {
        if (a.second == b.second) return a.first > b.first;
        return a.second < b.second;
    }

    static ArrayList<Integer> jobSequencing(int[] id,
                                            int[] deadline, int[] profit) {
        int n = id.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0); // ans[0]: count of jobs
        ans.add(0); // ans[1]: total profit

        // pair the profit and deadline of all the jobs together
        ArrayList<Pair> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Pair(profit[i], deadline[i]));
        }

        // sort the jobs based on deadline in ascending order
        jobs.sort((a, b) -> comp1(a, b) ? -1 : 1);

        // to maintain the scheduled jobs based on profit
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Pair job : jobs) {
            // if job can be scheduled within its deadline
            if (job.second > pq.size()) {
                pq.add(job.first);
            }
            // Replace the job with the lowest profit
            else if (!pq.isEmpty() && pq.peek() < job.first) {
                pq.poll();
                pq.add(job.first);
            }
        }

        while (!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4, 5};
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        ArrayList<Integer> ans = jobSequencing(id, deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
