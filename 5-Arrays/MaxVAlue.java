public class MaxVAlue {
    public static void main(String[] args) {
        int[] arr = {23,54,7,60,2,4};
        max(arr,23);
        System.out.println(max(arr,23));
    }
    static int max(int[] arr,int m){
        m=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>m){
                m=arr[i];
            }
        }
        return m;
    }
}
