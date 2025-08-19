public class Second {
    public static void main(String[] args) {
        char[] arr = {'a','b','c'};
        char tar = 'c';
        System.out.println(ceiling(arr, tar));
    }
    static char ceiling(char[] arr,char tar){
        int start = 0;
        int end = arr.length-1;
        while (start<=end) {
            int mid  = start + (end-start)/2;
            if(tar<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return arr[start%arr.length];
    }
}
