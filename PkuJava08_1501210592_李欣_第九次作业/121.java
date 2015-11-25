	public int maxProfit(int[] prices) {
		if(prices.length < 2) return 0;
		int maxPro = 0;
		int lowPrice = prices[0];
		for(int i = 1; i<prices.length; i++){
			if(prices[i] < lowPrice){
				lowPrice = prices[i];
			}
			if(prices[i] - lowPrice > maxPro){
				maxPro = prices[i] - lowPrice;
			}
		}
		return maxPro;
	}