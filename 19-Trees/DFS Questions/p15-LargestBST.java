//Take the smallest value from the right greater than root and largest value from left smaller than root.

class NodeValue{
    public int max,min,size;
    NodeValue(int max,int min,int size){
        this.max=max;
        this.min=min;
        this.size=size;
    }
}

class Solution {
    static NodeValue nn(Node root) {
        if(root==null){
            return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        }
        NodeValue left=nn(root.left);
        NodeValue right=nn(root.right);
        if(root.data<right.min && root.data>left.max){
            return new NodeValue(Math.max(root.data,right.max),Math.min(root.data,left.min),left.size+right.size+1);
        }
        return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.size,right.size));
    }


    static int largestBst(Node root){
        return nn(root).size;
    }
}
