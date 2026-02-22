/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {//Tc=o(n) Sc=0(1) Morris appraoch
    public int kthSmallest(TreeNode root, int k) {
        int count=0; 
        TreeNode curr=root;
        while(curr!=null){
            //case 1 no left child
            if(curr.left==null){
                count++;
                if(count==k)return curr.val;
                curr=curr.right;
            }
            else{//case 2 has left child
                TreeNode pred=curr.left;
                //find inorder predecessor
                while(pred.right!=null && pred.right!=curr)pred=pred.right;
                if(pred.right==null){//make thread
                    pred.right=curr;
                    curr=curr.left;
                }
                else{//remove thread
                    pred.right=null;
                    count++;
                    if(count==k)return curr.val;
                    curr=curr.right;
                }
            }
        }
        return -1;//k is invalid
    }
}