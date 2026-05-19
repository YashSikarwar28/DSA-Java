//we will compare adjacent values and check whether even or odd indices are present on the right

class Solution {
    public int singleNonDuplicate(int[] a) {
        int low=0;
        int high=a.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            boolean even=false;
            if((high-mid)%2==0){
                even=true;
            }else{
                even=false;
            }

            if(a[mid]==a[mid+1]){
                if(even){
                    low=mid+2;
                }else{
                    high=mid-1;
                }
            }
            else{
                if(even){
                    high=mid;
                }else{
                    low=mid+1;
                }
            }
        }
        return a[low];
    }
}