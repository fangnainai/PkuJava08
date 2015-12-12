
public class WinNim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8;
		System.out.println(canWinNim( n));

	}

		 
	    public static boolean canWinNim(int n) {
	        if(n % 4 == 0) return false; else return true;
	    }
}
