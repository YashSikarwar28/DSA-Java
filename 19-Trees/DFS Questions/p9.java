// LC 297 - Serialize and Deserialize Binary Tree
//Serialize means converting tree to string and deserialize means converting string to tree
//Serialize is similar to level order traversal


import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class p9 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t == null) {
                str.append("n ");
                continue;
            }
            str.append(t.val + " ");
            q.add(t.left);
            q.add(t.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> q=new LinkedList<>();
        String[] arr=data.split(" ");
        TreeNode t=new TreeNode(Integer.parseInt(arr[0]));
        q.add(t);
        for(int i=1;i<arr.length;i++){
            TreeNode temp=q.poll();
            if(!arr[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(arr[i]));
                temp.left=left;
                q.add(left);
            }
            if(!arr[++i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
                temp.right=right;
                q.add(right);
            }
        }
        return t;
    }