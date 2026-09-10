//First part is similar to word ladder 1 where we have to store the words and traverse and try all the combinations here the difference is that we need to store steps as well along with the word for that we will use hashmap.
//After the traversal if our hashmap contains the endword then we will apply dfs and backtracking concept from the endword to start, this traversal is also similar where we explore all the different characters and check whether that character is present and that satisfies the steps condition, then we can apply the backtrack concept.
//It uses bfs for storing the words and steps involved then it uses dfs backtracking concept to store all the sequence words.
//A lot of different variables are used which makes it difficult to understand.
//This code is tough to understand have a look and keep revising!!
class Solution {
    HashMap<String,Integer> hm=new HashMap<>();
    List<List<String>> ans=new ArrayList<>();
    String b;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        b=beginWord;
        HashSet<String> hs=new HashSet<>();
        for(String i:wordList){
            hs.add(i);
        }
        Queue<String> q=new LinkedList<>();
        int steps=1;
        q.add(beginWord);
        hm.put(beginWord,1);
        hs.remove(beginWord);
        while(!q.isEmpty()){
            String st=q.poll();
            if(st.equals(endWord)) break;
            char[] ch=st.toCharArray();
            for(int i=0;i<ch.length;i++){
                char c=ch[i];
                for(char j='a';j<='z';j++){
                    ch[i]=j;
                    String str=new String(ch);
                    if(hs.contains(str)){
                        q.add(str);
                        hm.put(str,hm.get(st)+1);
                        hs.remove(str);
                    }
                }
                ch[i]=c;
            }
        }
        ans=new ArrayList<>();
        if(hm.containsKey(endWord)){
            List<String> seq=new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }
  
    private void dfs(String word,List<String> seq){
        if(seq.contains(b)){
            List<String> l=new ArrayList<>(seq);
            Collections.reverse(l);
            ans.add(l);
            return;
        }
        int steps=hm.get(word);
        char[] cc=word.toCharArray();
        for(int i=0;i<word.length();i++){
            char c1=cc[i];
            for(char j='a';j<='z';j++){
                cc[i]=j;
                String neww=new String(cc);
                if(hm.containsKey(neww) && hm.get(neww)+1==steps){
                    seq.add(neww);
                    dfs(neww,seq);
                    seq.remove(seq.size()-1);
                }
            }
            cc[i]=c1;
        }
    }
}
