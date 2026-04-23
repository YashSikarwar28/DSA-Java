//LC 105-Construct Binary Tree from Preorder and Inorder Traversal
//Similar to contruct BST from sorted array where we are given array and we have to create a tree from it.

class Solution {
    int index=0;
    public TreeNode buildTree(int[] pr, int[] in) {
        return create(pr,in,0,in.length-1);
    }
    private TreeNode create(int[] pr,int[] in,int start,int end){
        if(start>end) return null;
        int r=pr[index++];
        TreeNode tt=new TreeNode(r);
        int ind=start;
        for(int i=start;i<=end;i++){
            if(in[i]==r){
                ind=i;
                break;
            }
        }

        tt.left=create(pr,in,start,ind-1);
        tt.right=create(pr,in,ind+1,end);

        return tt;
    }
}