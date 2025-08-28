import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
  public int[][] sortMatrix(int[][] grid) {
    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        int key = i - j;
        map.putIfAbsent(key, key >= 0 ? new PriorityQueue<>((a, b) -> b - a) 
                              : new PriorityQueue<>());
        
        map.get(key).add(grid[i][j]);
      }
    }
    
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        int key = i - j;
        
        grid[i][j] = map.get(key).poll();
      }
    }
    
    return grid;
  }
}
