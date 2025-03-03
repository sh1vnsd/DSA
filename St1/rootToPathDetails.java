import java.util.ArrayList;

static void printAllPaths(Node root) {
      if(root == null) return;
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      ArrayList<Integer> path = new ArrayList<>();
      dfs(root, path, ans);
      for(var it : ans){
          for(var val : it){
              System.out.print(val + " ");
          }
          System.out.println(it.size() - 1);
      }
      System.out.print(ans.size());
  }
static void dfs(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
    if(root == null) return;
    path.add(root.data);
    if(node.left == null && node.right == null){
        ans.add(new ArrayList<>(path));
    }
    else{
        dfs(root.left, path, ans);
        dfs(root.right, path, ans);
    }
    path.remove(path.size() - 1);
}
