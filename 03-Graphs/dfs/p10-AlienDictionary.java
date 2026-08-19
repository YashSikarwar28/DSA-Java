//First we will traverse through thr string array and check the 2 adjacent strings the first character which is different we will add it in graph but in integer format char-'a'.
//One more important thing is we will create a 26 size array and add the char values which are only presnt in the string array.
//Then we will run dfs loop topo sort one and check whether the particular char is unvisited or not add the values in stack, pop the values and add it in ans string.
// 0 - unvisited, 1 - visited, 2 - safe

class Solution {
    public String findOrder(String[] words) {
        int[] visited=new int[26];
        boolean[] present=new boolean[26];
        List<List<Integer>> l=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(String word:words){
            for(char c:word.toCharArray()){
                present[c-'a']=true;
            }
        }
        for(int i=0;i<26;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<words.length-1;i++){
            String a=words[i];
            String b=words[i+1];
            int min=Math.min(a.length(),b.length());
            for(int j=0;j<min;j++){
                if(a.charAt(j)!=b.charAt(j)){
                    l.get(a.charAt(j)-'a').add(b.charAt(j)-'a');
                    break;
                }
            }
        }
        for(int i=0;i<26;i++){
            if(present[i]==true && visited[i]==0){
                if(!dfs(l,present,visited,i,st)){
                    return "";
                }
            }
        }
        String ans="";
        while(!st.isEmpty()){
            int k=st.pop();
            ans=ans+(char)(k+'a');
        }
        return ans;
    }
    private boolean dfs( List<List<Integer>> l,boolean[] present,int[] visited,int i,Stack<Integer> st){
        visited[i]=1;
        for(int j:l.get(i)){
            if(visited[j]==1){
                return false;
            }
            if(visited[j]==0){
                if(!dfs(l,present,visited,j,st)){
                    return false;
                }
            }
        }
        visited[i]=2;
        st.add(i);
        return true;
    }
}

// class Solution {
//     public String findOrder(String[] words) {
//         List<List<Integer>> l=new ArrayList<>();
//         int[] visited=new int[26];
//         boolean[] present=new boolean[26];
//         Stack<Integer> st=new Stack<>();
//         String ans="";
//         for(int i=0;i<26;i++){
//             l.add(new ArrayList<>());
//         }
//         for(String word:words){
//             for(char i:word.toCharArray()){
//                 present[i-'a']=true;
//             }
//         }
//         for(int i=0;i<words.length-1;i++){
//             String a=words[i];
//             String b=words[i+1];
//             int j=0;
//             while(j<a.length() && j<b.length() && a.charAt(j)==b.charAt(j)){
//                 j++;
//             }
//             if(j==b.length() && a.length()>b.length()){
//                 return "";
//             }
//             if(j<a.length() && j<b.length()){
//                 l.get(a.charAt(j)-'a').add(b.charAt(j)-'a');
//             }
//         }
//         for(int i=0;i<26;i++){
//             if(present[i] && visited[i]==0){
//                 if(!check(visited,l,st,i)){
//                     return "";
//                 }
//             }
//         }
//         while(!st.isEmpty()){
//             int k=st.pop();
//             ans=ans+(char)('a'+k);
//         }
//         return ans;
//     }
//     private boolean check(int[] visited,List<List<Integer>> l,Stack<Integer> st,int i){
//         visited[i]=1;
//         for(int j:l.get(i)){
//             if(visited[j]==1){
//                 return false;
//             }
//             if(visited[j]==0){
//                 if(!check(visited,l,st,j)){
//                     return false;
//                 }
//             }
//         }
//         visited[i]=2;
//         st.add(i);
//         return true;
//     }
// }
