// Peak element in a mountain array

public class Fourth {
    public static void main(String[] args) {
        int[] a = {0,1,2,0};
        System.out.println(mtnArr(a));
    }
    static int mtnArr(int[] a){
        int start = 0;
        int end = a.length-1;
        while (start<=end) {
            int mid = start+(end-start)/2;
            if (a[mid]>a[mid+1]) {
                end=mid;
            }
            if(a[mid]<a[mid+1]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return start;
    }
}
