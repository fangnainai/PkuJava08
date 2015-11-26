
public class BestTimeBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices={1,1,2,9,6,4};
		System.out.println(maxProfit(prices));
	}
	/**
	 * 最大收益其实就是最大两个数的差值
	 * 用low来表示最小的数，如果比最小的数还小那就改变最小数的值
	 * 比最小数大，则计算差值为profit，如果比上一个的差值大则将这个差值作为新的最大差值
	 * @param prices
	 * @return
	 */
	 public static int maxProfit(int[] prices) {
		 if(prices.length == 0) return 0;
		 int low = prices[0];
		 int profit = 0;
		 for(int i=1; i<prices.length; i++){
		    if(prices[i] < low) low = prices[i];
		      else if(prices[i] - low > profit)  profit= prices[i] - low;
		    }
		    return profit;
	    }
}
