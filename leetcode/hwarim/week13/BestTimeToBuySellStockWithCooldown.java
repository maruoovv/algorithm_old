class Solution {
    //Discuss보고 품.
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1) return 0;
        int[] buy=new int[prices.length];
        int[] sell= new int[prices.length];

        buy[0]=-prices[0];
        buy[1]=Math.max(buy[0],-prices[1]);
        sell[1]=Math.max(buy[0]+prices[1],0);

        for(int i=2; i<prices.length;i++){
            buy[i]=Math.max(sell[i-2]-prices[i],buy[i-1]);//...cool->buy/...->cool
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);//...->cool/buy->sell
        }
        return Math.max(buy[prices.length-1],sell[prices.length-1]);
    }
}