import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    int m = nums2.length;

    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int sum = nums1[i] + nums2[j];

        if (maxHeap.size() < k) {
          maxHeap.offer(new int[] { sum, i, j });
        } else if (sum < maxHeap.peek()[0]) {
          maxHeap.poll();
          maxHeap.offer(new int[] { sum, i, j });
        } else {
          break;
        }
      }
    }

    List<List<Integer>> res = new ArrayList<>();

    while (!maxHeap.isEmpty()) {
      int[] top = maxHeap.poll();

      res.add(Arrays.asList(nums1[top[1]], nums2[top[2]]));
    }

    return res;
  }
}
