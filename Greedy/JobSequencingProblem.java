class Solution {
    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = id.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(id[i], deadline[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit); // Sort jobs in decreasing order of profit

        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1); // Mark all slots as free

        int totalProfit = 0, count = 0;

        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) { // Find the latest available slot
                if (result[j] == -1) {
                    result[j] = job.id;
                    totalProfit += job.profit;
                    count++;
                    break;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);
        return ans;
    }
}

