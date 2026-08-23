//We need to check powers and handle cases accordingly. Powers can be even, odd and negative.
class Solution {
    public double myPow(double x, int n) {
        return power(x,n);
    }
    private double power(double x,long n){
        if(n==0) return 1;
        if(n<0){
            return power(1/x,-n);
        }
        else if(n%2==0){
            return power(x*x,n/2);
        }
        return x*power(x*x,(n-1)/2);
    }
}
