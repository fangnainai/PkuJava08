    public boolean isAnagram(String s, String t) {
    	// �����ж�t�Ƿ���s���Ӵ���
    	/*if(s.equals(t)) return true;
    	for(int i = 0; i<s.length(); i++){
    		if(t.length() == 0) return false;
    		if(s.charAt(i) == t.charAt(0)){
    			if(s.substring(i, i+t.length()).equals(t))
    				return true;
    		}
    	}
        return false;*/
    	
    	// �ж�t�Ƿ���s�������
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