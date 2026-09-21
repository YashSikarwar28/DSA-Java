//First assign indices to all email individually - use union by rank
//Now assign all of them into groups like a particular index contaning all the e-mails using ultimate parent
//Now sort the emails and return the answer look at the syntax carefully at this step
class Disjoint {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    public Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    public int superParent(int n){
        if(parent.get(n)==n) return n;
        int ulp=superParent(parent.get(n));
        //n,ulp confusion
        parent.set(n,ulp);
        return parent.get(n);
    }
    public void unionByRank(int u,int v){
        int ulp_u=superParent(u);
        int ulp_v=superParent(v);
        if(ulp_u==ulp_v){
            return;
        }
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_u,ulp_v);
            int r=rank.get(ulp_v);
            rank.set(ulp_v,r+1);
        }
    } 
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        Disjoint dsu=new Disjoint(n);
        //Step 1-Matching email by their index individually
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(!hm.containsKey(email)){
                    hm.put(email,i);
                }else{
                    dsu.unionByRank(i,hm.get(email));
                }
            }
        }
        //Step 2-Grouping the mail and index together
        HashMap<Integer,ArrayList<String>> merged=new HashMap<>();
        for(String email:hm.keySet()){
            int ind=hm.get(email);
            int parent=dsu.superParent(ind);
            if(!merged.containsKey(parent)){
                merged.put(parent,new ArrayList<>());
            }
            merged.get(parent).add(email);
        }
        //Step 3-Sort the emails and return the answer
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<String>> i:merged.entrySet()){
            int parent=i.getKey();
            ArrayList<String> email=i.getValue();
            Collections.sort(email);
            ArrayList<String> name=new ArrayList<>();
            name.add(accounts.get(parent).get(0));
            name.addAll(email);
            ans.add(name);
        }
        return ans;
    }
}
