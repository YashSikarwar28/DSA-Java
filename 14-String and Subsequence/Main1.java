//removing particular character from string

public class Main1 {
    public static void main(String[] args) {
        String a="aabdcae";
        String s="";
        remove(s, a);
    }
    static void remove(String s,String a){
        if (a.isEmpty()) {
            System.out.println(s);
            return;
        }
        char ch=a.charAt(0);
        if (ch=='a') {
            remove(s, a.substring(1));
        }
        else{
            remove(s+ch, a.substring(1));
        }
    }
}


// public class Main1 {
//     public static void main(String[] args) {
//         String s="aabdcae";
//         String a="";
//     }
//     static void remove(String s,String a,int i){
//         if(i==s.length()){
//             System.out.println(a);
//             return;
//         }
//         if (s.charAt(i)=='a') {
//              remove(s, a, i++);
//              //System.out.println(a);
//         }else{
//              a=a+s.charAt(i);
//              remove(s, a, i++);
//         }
//         }
//     }