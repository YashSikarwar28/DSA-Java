class Solution {
    public boolean searchMatrix(int[][] a, int tar) {
        for(int i=0;i<a.length;i++){
            int l=0;
            int h=a[i].length-1;
            while(l<=h){
                int mid=l+(h-l)/2;
                if(a[i][mid]==tar) return true;
                else if(a[i][mid]>tar){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return false;
    }
}