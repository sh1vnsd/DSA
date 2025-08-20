import java.util.PriorityQueue;

class Solution {
  public long totalCost(int[] costs, int k, int candidates) {
    long ans = 0;
    int hired = 0;

    int n = costs.length;
    int i = 0;
    int j = n - 1;

    PriorityQueue<Integer> minHeapOne = new PriorityQueue<>();
    PriorityQueue<Integer> minHeapTwo = new PriorityQueue<>();

    while (hired < k) {

      while (minHeapOne.size() < candidates && i <= j) {
        minHeapOne.offer(costs[i]);
        i++;
      }

      while (minHeapTwo.size() < candidates && j >= i) {
        minHeapTwo.offer(costs[j]);
        j--;
      }

      int minOne = minHeapOne.isEmpty() ? Integer.MAX_VALUE : minHeapOne.peek();
      int minTwo = minHeapTwo.isEmpty() ? Integer.MAX_VALUE : minHeapTwo.peek();

      if (minOne <= minTwo) {
        ans += minOne;
        minHeapOne.poll();
      } else {
        ans += minTwo;
        minHeapTwo.poll();
      }

      hired++;
    }

    return ans;
  }
}
