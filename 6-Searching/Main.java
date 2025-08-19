public class Main {
    public static void main(String[] args) {
        int[] arr = {1,5,67,3,34,21,90};
        int tar = 6;
        System.out.println(linearSearch(arr, tar));
    }
    static int linearSearch(int[] arr, int tar){
        if (arr.length<0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==tar) {
                return i;
            }
        }
        return -1;
    }
}
