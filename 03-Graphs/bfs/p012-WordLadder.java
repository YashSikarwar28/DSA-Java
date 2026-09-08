//We will create hashset for storing the list of string, if it does not contains endword return 0, make a pair of queue for storing the individual string use bfs algorithm and loop through the characters and update theh char by running a loop of 26 char and if the string is present remove from the hashset and add in queue.
class Pair{
    String str;
    int count;
    Pair(String str,int count){
        this.str=str;
        this.count=count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hm=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            hm.add(wordList.get(i));
        }
        if(!hm.contains(endWord)) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        hm.remove(beginWord);
        while(!q.isEmpty()){
            Pair p=q.poll();
            String word=p.str;
            int steps=p.count;
            if(word.equals(endWord)) return steps;
            char[] ch=word.toCharArray();
            for(int i=0;i<ch.length;i++){
                char c=ch[i];
                for(char j='a';j<='z';j++){
                    if(j==c) continue;
                    ch[i]=j;
                    String newWord=new String(ch);
                    if(hm.contains(newWord)){
                        hm.remove(newWord);
                        q.add(new Pair(newWord,steps+1));
                    }
                }
                ch[i]=c;
            }
        }
        return 0;
    }
}
