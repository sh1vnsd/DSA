import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] arr = new int[26];

    for (var it : tasks) {
      arr[it - 'A']++;
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    for (int i = 0; i < 26; i++) {
      if (arr[i] > 0) {
        maxHeap.add(tasks[i]);
      }
    }

    int time = 0;

    while (!maxHeap.isEmpty()) {

      ArrayList<Integer> temp = new ArrayList<>();

      for (int i = 1; i <= n + 1; i++) {

        if (!maxHeap.isEmpty()) {
          int freq = maxHeap.peek();
          maxHeap.poll();

          freq--;

          temp.add(freq);
        }
      }

      for (var f : temp) {
        if (f > 0) {
          maxHeap.add(f);
        }
      }

      if (maxHeap.isEmpty()) {
        time += temp.size();
      } else {
        time += n + 1;
      }
    }

    return time;
  }
}
