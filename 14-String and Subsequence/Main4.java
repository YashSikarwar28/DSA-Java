//printing subsequence and ascii values.

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args) {
        System.out.println(ascii("", "ab"));
    }
    static ArrayList<String> ascii(String a,String b){
        if(b.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(a);
            return list;
        }
        char ch=b.charAt(0);

        ArrayList<String> first=ascii(a+ch,b.substring(1));
        ArrayList<String> second=ascii(a,b.substring(1));
        ArrayList<String> third=ascii(a+(ch+0),b.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;
    }
}

            // public class Main4 {
            //     public static void main(String[] args) {
            //         ascii("", "ab");        
            //     }
            //     static void ascii(String a,String b){
            //         if (b.isEmpty()) {
            //             System.out.println(a);
            //             return;
            //         }
            //         char ch=b.charAt(0);
            //         ascii(a, b.substring(1));
            //         ascii(a+ch, b.substring(1));
            //         ascii(a+(ch+0), b.substring(1));
            //     }
            // }