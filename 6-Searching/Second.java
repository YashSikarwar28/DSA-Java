public class Second {
    public static void main(String[] args) {
        String str = "fnkgbhbenqwfdw";
        char s = 'b';
        System.out.println(isChar(str, s));
    }
    static boolean isChar(String str, char s){
        if (str.length()==0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==s) {
                return true;
            }
        }
        return false;
    }
}
