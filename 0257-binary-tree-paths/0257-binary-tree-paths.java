class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        TreePaths(root, new StringBuilder(), result);
        return result;
    }

    void TreePaths(TreeNode root, StringBuilder path, List<String> result) {
        int len = path.length();   // save state for backtracking

        path.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            if (root.left != null) TreePaths(root.left, path, result);
            if (root.right != null) TreePaths(root.right, path, result);
        }

        path.setLength(len); // backtrack (removes val and "->")
    }
}