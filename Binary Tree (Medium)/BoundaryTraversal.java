//GFG
class Solution {
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void addLeftBoundary(Node node, ArrayList<Integer> ans) {
        Node current = node.left;
        while (current != null) {
            if (isLeaf(current) == false) {
                ans.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    void addLeaves(Node node, ArrayList<Integer> ans) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            ans.add(node.data);
        } else {
            addLeaves(node.left, ans);
            addLeaves(node.right, ans);
        }
    }

    void addRightBoundary(Node node, ArrayList<Integer> ans) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node current = node.right;
        while (current != null) {
            if (isLeaf(current) == false) {
                temp.add(current.data);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null) {
            return ans;
        }
        if (!isLeaf(node)) {
            ans.add(node.data);
        }
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }
}
