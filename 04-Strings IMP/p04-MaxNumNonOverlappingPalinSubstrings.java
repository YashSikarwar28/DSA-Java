//LC 2472
//We have to return the count of non overlapping palindrome substrings
//For finding palindrome substrings we will use the same idea as done in LC 5 centre exapansion, to find non overlapping we will have a lastind=-1 and when the lengthbecomes>=k then we will assign its value to r which is the rightmost index of palin substring.
//When we find a substring to get the next overlapping substring the end of the first substring must be greater than the start of the next substring.
class Solution {
    public int maxPalindromes(String s, int k) {
        int c = 0;
        int lastind = -1;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k && l > lastind) {
                    lastind = r;
                    c++;
                    break;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k && l > lastind) {
                    lastind = r;
                    c++;
                    break;
                }
                l--;
                r++;
            }
        }
        return c;
    }
}
