//gfg
// class Solution {
//     public static void findPath(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
//         if(node == null) return;
//         path.add(node.data);
//         path.add("->");
//         if(node.left == null && node.right == null){
//             ans.add(new ArrayList<>(path));
//         }
//         else{
//         findPath(node.left, path, ans);
//         findPath(node.right, path, ans);            
//         }
//         path.remove(path.size() - 1);

//     }
//     public static ArrayList<ArrayList<Integer>> Paths(Node root) {
//         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//         findPath(root, new ArrayList<>(), ans);
//         return ans;
//     }
// }x

//leet code
class Solution {
    public static void findPath(TreeNode node, String path, List<String> ans){
        if(node == null) return;
        if(!path.isEmpty()){
            path += "->";
        }
        path += node.val;

        if(node.left == null && node.right == null){
            ans.add(path);
        }
        else{
            findPath(node.left, path, ans);
            findPath(node.right, path, ans);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        findPath(root, "", ans);
        return ans;
    }
}