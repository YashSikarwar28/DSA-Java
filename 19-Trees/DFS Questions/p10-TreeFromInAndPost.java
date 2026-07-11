//Similar to previous traversal just the diffrence is that the root is now at the last instead of front.

class Solution {
    int j;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        j=postorder.length-1;
        return build(inorder,postorder,0,inorder.length-1);
    }
    private TreeNode build(int[] inorder, int[] postorder,int l,int h){
        if(l>h) return null;
        int ind=postorder[j];
        int mid=0;
        j--;
        for(int i=0;i<inorder.length;i++){
            if(ind==inorder[i]){
                mid=i;
            }
        }
        TreeNode tt=new TreeNode(inorder[mid]);
        tt.right=build(inorder,postorder,mid+1,h);
        tt.left=build(inorder,postorder,l,mid-1);
        return tt;
    }
}
