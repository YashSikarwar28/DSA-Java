//Use map to store 't' character run i loop on String s and while expanding decrease the count and while count==0 start shrinking and remove the frequency by -1 and update the length as well.
//In end return substring as the answer 
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = t.length();
        int ans = Integer.MAX_VALUE;
        int j = 0;
        int ind = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) > 0) {
                count--;
            }
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) - 1);
            while (count == 0) {
                if (i - j + 1 < ans) {
                    ans = i - j + 1;
                    ind = j;
                }
                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
                if (hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j)) > 0) {
                    count++;
                }
                j++;
            }
        }
        if (ans == Integer.MAX_VALUE)
            return "";
        return s.substring(ind, ind + ans);
    }
}
