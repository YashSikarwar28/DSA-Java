//removing a string

public class Main2 {
    public static void main(String[] args) {
        System.out.println(remove("dknvdapplekldsf"));
    }
    static String remove(String s){
        if (s.isEmpty()) {
            return "";
        }
        if (s.startsWith("apple")) {
            return remove(s.substring(5));
        }
        else{
            return s.charAt(0)+remove(s.substring(1));
        }
    }
}