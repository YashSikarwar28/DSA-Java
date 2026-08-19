class Solution {
    public String findOrder(String[] words) {
      //creating the present array
        boolean[] present=new boolean[26];
        for(String word:words){
            for(char c:word.toCharArray()){
                present[c-'a']=true;
            }
        }
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<26;i++){
            l.add(new ArrayList<>());
        }
      //creating the arraylist
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
      //creating the indegree array
        int[] indegree=new int[26];
        for(int i=0;i<26;i++){
            for(int j:l.get(i)){
                indegree[j]++;
            }
        }
        StringBuilder sb=new StringBuilder();
        Queue<Integer> q=new LinkedList<>();
      //counting the totalchar and checking indegree==0 to add it in queue
      //this step is only different when compared to dfs approach, here we are counting the totalchar as well
        int totalchar=0;
        for(int i=0;i<indegree.length;i++){
            if(present[i]){
                totalchar++;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
      //bfs approach
        while(!q.isEmpty()){
            int node=q.poll();
            sb.append((char)(node+'a'));
            for(int k:l.get(node)){
                indegree[k]--;
                if(indegree[k]==0){
                    q.add(k);
                }
            }
        }
      //if length not equal return ""
        if(sb.length()!=totalchar){
            return "";
        }
        return sb.toString();
    }
}
