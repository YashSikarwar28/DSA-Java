//Initialize the list with initial values, after that find ultimate parent of a particular node, then for rank we will check the rank if rank is less connect the less with the bigger, check for both the nodes. If the size is equal we can connect any node and increase the rank by 1;
//For the size disjoint the same process will go we will check the size if its smaller we will connect the smaller to bigger and update the size list and add the size of the smaller node to the bigger node. In size the greater than and equal fall in one condition so we can add else condition directly.

//Union by rank
class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUltimateParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp=findUltimateParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void UnionByRank(int u,int v){
        int ulp_u=findUltimateParent(u);
        int ulp_v=findUltimateParent(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            //both equal connect anyone
            parent.set(ulp_u,ulp_v);
            int r=rank,get(ulp_v);
            rank.set(ulp_v,r+1);
        }
    }
}

//Union by size
class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUltimateParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp=findUltimateParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUltimateParent(u);
        int ulp_v=findUltimateParent(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
