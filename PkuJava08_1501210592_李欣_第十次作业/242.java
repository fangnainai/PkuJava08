    public boolean isAnagram(String s, String t) {
    	// 做成判断t是否是s的子串了
    	/*if(s.equals(t)) return true;
    	for(int i = 0; i<s.length(); i++){
    		if(t.length() == 0) return false;
    		if(s.charAt(i) == t.charAt(0)){
    			if(s.substring(i, i+t.length()).equals(t))
    				return true;
    		}
    	}
        return false;*/
    	
    	// 判断t是否是s的异序词
    	if(s.length() == t.length()){
            char[] sc = s.toCharArray();
	    	char[] tc = t.toCharArray();
		    Arrays.sort(sc);
	    	Arrays.sort(tc);
	    	for(int i=0; i<s.length(); i++){
	    	    if(sc[i] != tc[i]){
	    	        return false;
	    	    }
	    	}
    		return true;
    	} 
    	return false;
    }