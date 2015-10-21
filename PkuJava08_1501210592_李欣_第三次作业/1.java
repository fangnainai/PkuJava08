	public int[] twoSum2(int[] nums, int target) {
		int[] index = new int[2];
		HashMapInteger,Integer map = new HashMapInteger,Integer();
		for(int i = 0; inums.length; i++){
			if(map.containsKey(target - nums[i])){
				index[0] = map.get(target - nums[i]);
				index[1] = i+1;
				break;
			}else{
				map.put(nums[i],i+1); 注意，以值为key，下标为value
			}			
		}
		int[] index = new int[]{0,nums.length-1};
		Arrays.sort(nums);
		while(target != nums[index[0]]+nums[index[1]] && index[0]index[1]){
			if(target  nums[index[0]]+nums[index[1]]) index[0]++;
			else index[1]--;
		}
		if(index[0]=index[1]){
			index[0] = 0;
			index[1] = 0;
		}else{
			index[0]++;
			index[1]++;
		}
		return index;
	}