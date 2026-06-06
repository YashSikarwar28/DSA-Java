//list the start and end time of fowers in 2 different arrays, sort them, run loop through people array and calculate the number of flowers bloomed and died for that particular person and return the answer;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] result=new int[people.length];
        int[] start=new int[flowers.length];
        int[] end=new int[flowers.length];
        for(int i=0;i<flowers.length;i++){
            start[i]=flowers[i][0];
            end[i]=flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        for(int i=0;i<people.length;i++){
            int upperbound=upper(start,people[i]);
            int lowerbound=lower(end,people[i]);
            result[i]=upperbound-lowerbound;
        }
        return result;
    }
    private int upper(int[] start,int tar){
        int l=0;
        int h=start.length-1;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(start[mid]<=tar){
                l=mid+1;
                //ans=mid;
            }else{
                h=mid-1;
            }
        }
        return l;
    }
    private int lower(int[] end,int tar){
        int l=0;
        int h=end.length-1;
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(end[mid]<tar){
                l=mid+1;
                //res=mid;
            }else{
                h=mid-1;
            }
        }
        return l;
    }
}