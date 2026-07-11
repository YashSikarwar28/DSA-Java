// LC 297 - Serialize and Deserialize Binary Tree
//Serialize means converting tree to string and deserialize means converting string to tree
//Serialize is similar to level order traversal
//LC 449 same copy paste


import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class p9 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            if(str.length()>0) str.append(",");
            if(t==null) str.append("n");
            else{
                str.append(t.val);
                q.add(t.left);
                q.add(t.right);
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty() || data.equals("n")) return null;
        String[] parts=data.split(",");
        TreeNode t=new TreeNode(Integer.parseInt(parts[0]));
        int i=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(t);
        while(!q.isEmpty() && i<parts.length){
            TreeNode tt=q.poll();
            if(!parts[i].equals("n")){
                TreeNode temp=new TreeNode(Integer.parseInt(parts[i]));
                tt.left=temp;
                q.add(temp);
            }
            i++;
            if(!parts[i].equals("n") && i<parts.length){
                TreeNode temp=new TreeNode(Integer.parseInt(parts[i]));
                tt.right=temp;
                q.add(temp);
            }
            i++;
        }
        return t;
    }
    }
