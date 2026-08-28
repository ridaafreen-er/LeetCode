class Solution {
    public int maxProfit(int[] prices) {
        int  output=0;
        int  min_prices= prices[0];

        for(int i=0; i<prices.length; i++){
            if( prices[i] <min_prices){
                min_prices =prices[i];}
            else{
                output= Math.max(output,prices[i]-min_prices);
            }
        }return output;
    }
}