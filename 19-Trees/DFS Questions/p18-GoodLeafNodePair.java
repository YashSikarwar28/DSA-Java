//We will traverse till leaf node and from there we will send the information to the node's parent about the distance, at how much distance the leaf node are located and how many are there. For this we will take left and right array and call dfs respectivey.
//We will take leafdist array of size 11 in that we will update that how many nodes are there at left and right at a particular level.
//BFS version is also available checkout in graph repo.
class Solution {
    int res=0;
    public int[] dfs(TreeNode root,int distance){
        int[] leafdist=new int[11];
        if(root==null){
            return leafdist;
        }else if(root.left==null && root.right==null){
            leafdist[1]=1;
            return leafdist;
        }
        int[] left=dfs(root.left,distance);
        int[] right=dfs(root.right,distance);

        for(int i=0;i<=distance;i++){
            for(int j=0;j<=distance;j++){
                if(i+j<=distance){
                    res+=left[i]*right[j];
                }
            }
        }
        //return message from child to parent
        for(int i=1;i<11;i++){
            leafdist[i]=left[i-1]+right[i-1];
        }
        return leafdist;
    }
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return res;
    }
}
