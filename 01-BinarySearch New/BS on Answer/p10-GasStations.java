//Check double type thats important thing in this question!!
//Calculate the distance between stations then divide the distance with mid value and add the value compar it it should be less than equal to the provided stations.

class Solution {
    public double minMaxDist(int[] stations, int K) {
        double low=0;
        double high=1000000;
        while((high-low)>1e-6){
            double mid=low+(high-low)/2;
            if(check(stations,K,mid)){
                high=mid;
            }else{
                low=mid+1e-6;
            }
        }
        return high;
    }
    private boolean check(int[] stations,int K,double mid){
        int stReq=0;
        for(int i=0;i<stations.length-1;i++){
            int dist=stations[i+1]-stations[i];
            int st=(int)(dist/mid);
            stReq+=st;
        }
        return stReq<=K;
    }
}
