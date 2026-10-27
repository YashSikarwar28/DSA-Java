//Question of unbounded knapsack
//Slightly different question where we are given value for each index and we want the max value and the sum should be equal to the length of the array.
//One more diffrent thing is its 1 based indexing so we have to take care of that as well and have a look at the base case as well.
class Solution {
    public int cutRod(int[] price) {
        int[][] dp=new int[price.length][price.length+1];
        for(int i=0;i<=price.length;i++){
            dp[0][i]=price[0]*i;
            //price[0]*price.length
        }
        for(int i=1;i<price.length;i++){
            for(int j=0;j<=price.length;j++){
                int not_take=dp[i-1][j];
                int take=0;
                int rodlen=i+1;
                if(rodlen<=j){
                    take=price[i]+dp[i][j-rodlen];
                }
                dp[i][j]=Math.max(take,not_take);
            }
        }
        return dp[price.length-1][price.length];
    }
}


//memoization
class Solution {
	public int cutRod(int[] price) {
		int[][] dp = new int[price.length][price.length + 1];
		for (int i = 0; i<price.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return check(price, price.length, price.length - 1, dp);
	}
	private int check(int[] price, int max, int ind, int[][] dp) {
		if (ind == 0) {
			return price[ind]*max;
		}
		int not_take = check(price, max, ind - 1, dp);
		int take = 0;
		int rodlen = ind + 1;
		if (dp[ind][max] != -1)
			return dp[ind][max];
		if (rodlen <= max) {
			take = price[ind]+check(price, max - rodlen, ind, dp);
		}
		return dp[ind][max] = Math.max(take, not_take);
	}
}

//recursion
class Solution {
    public int cutRod(int[] price) {
        return check(price,price.length,price.length-1);
    }
    private int check(int[] price,int max,int ind){
        if(ind==0){
            return price[ind]*max;
        }
        int not_take=check(price,max,ind-1);
        int take=0;
        int rodlen=ind+1;
        if(rodlen<=max){
            take=price[ind]+check(price,max-rodlen,ind);
        }
        return Math.max(take,not_take);
    }
}
