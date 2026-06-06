//Partition the array into left and right, use mid formula to caluclate left elements and subtract from the total size to calculate the right elements, then assign 4 number and choose 2 from left and right and compare those value if the size is odd return max of left elements otherwise return max of left and min of right divide by 2.
 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int l=0;
        int h=m;
        while(l<=h){
            int x=l+(h-l)/2; //chossing the left elements
            int y=(m+n+1)/2-x; //choosing the right elements

            //chossing the left elements
            int x1=(x==0)?Integer.MIN_VALUE:nums1[x-1];
            int x2=(y==0)?Integer.MIN_VALUE:nums2[y-1];

            //choosing the right elements
            int x3=(x==m)?Integer.MAX_VALUE:nums1[x];
            int x4=(y==n)?Integer.MAX_VALUE:nums2[y];

            //if the arrays is sorted
            if(x1<=x4 && x2<=x3){
                if((m+n)%2==0){
                    return (Math.max(x1,x2)+Math.min(x3,x4))/2.0;
                }else{
                    return Math.max(x1,x2);
                }
            }

            if(x1>x4){
                h=x-1;
            }else{
                l=x+1;
            }
        }
        return -1;
    }
}