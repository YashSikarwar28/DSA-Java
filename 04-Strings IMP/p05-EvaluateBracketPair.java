//LC 1807
//This question is like string processing keep moving the index and keep updating the string, take an ans for the main answer and temp for updating the string and adding to the answer.
//Good use and implementation of HashMap and Stringbuilder
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            hm.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean add = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                add = true;
                temp.setLength(0);
                continue;
            }
            if (s.charAt(i) == ')') {
                ans.append(hm.getOrDefault(temp.toString(), "?"));
                add = false;
                continue;
            }
            if (add) {
                temp.append(s.charAt(i));
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
