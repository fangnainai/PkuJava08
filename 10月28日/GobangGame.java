import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	

	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX <0 || posX >Chessboard.BOARD_SIZE|| posY < 0
				|| posY > Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于0,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋，遍历整个棋盘，对每个位置的方向进行判断，每个位置的优先级为白四>黑四>白三>黑三>白二>白一
	 */
	public int[] computerDo() {

        int[] result = hello(4,Chessman.WHITE.getChessman());
		if(result[0]==-1){
			result = hello(4,Chessman.BLACK.getChessman());
			if(result[0]==-1){
				result = hello(3,Chessman.WHITE.getChessman());
				if(result[0]==-1){
					result = hello(3,Chessman.BLACK.getChessman());
					if(result[0]==-1){
						result = hello(2,Chessman.WHITE.getChessman());
						if(result[0]==-1){
							result = hello(1,Chessman.WHITE.getChessman());
							if(result[0]==-1){
								String[][] board = chessboard.getBoard();
								int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
								int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
								while (board[posX][posY] != "十") {
									posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
									posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
								}
								return new int[]{ posX, posY };
							}
						}
					}
				}
			}
		}
		return result;
	}

	private int[] hello(int num,String color){
		num--;
		String[][] board = chessboard.getBoard();
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				if(board[i][j]!=color){
					continue;
				}
				int count1=0;
				int count2=0;
				int ii=i-1;
				//up&down start
				while(true){//up
					if(ii>=0&&board[ii][j]==color){
						count1++;
						if(count1==num){
							break;
						}
					}else{
						break;
					}
					ii--;
				}
				ii=i+1;
				while(true){//down
					if(ii<15&&board[ii][j]==color){
						count2++;
						if(count2==num){
							break;
						}
					}else{
						break;
					}
					ii++;
				}
				if(count1+count2==num)
				{
					if(i-count1-1>0&&board[i-count1-1][j]=="十"){
						return new int[]{i-count1-1,j};
					}
					if(i+count2+1<15&&board[i+count2+1][j]=="十"){
						return new int[]{i+count2+1,j};
					}
				}//up&down   end
				
				
				int jj=j-1;
				count1=0;
				count2=0;
				//left&right start
				while(true){//left
					if(jj>=0&&board[i][jj]==color){
						count1++;
						if(count1==num){
							break;
						}
					}else{
						break;
					}
					jj--;
				}
				jj=j+1;
				while(true){//right
					if(jj<15&&board[i][jj]==color){
						count2++;
						if(count2==num){
							break;
						}
					}else{
						break;
					}
					jj++;
				}
				if(count1+count2==num)
				{
					if(j-count1-1>0&&board[i][j-count1-1]=="十"){
						return new int[]{i,j-count1-1};
					}
					if(j+count2+1<15&&board[i][j+count2+1]=="十"){
						return new int[]{i,j+count2+1};
					}
				}//left&right   end
				
				ii=i-1;
				jj=j-1;
				count1=0;
				count2=0;
				//zuoshang youxia start
				while(true){//zuoshang
					if(ii>=0&&jj>=0&&board[ii][jj]==color){
						count1++;
						if(count1==num){
							break;
						}
					}else{
						break;
					}
					jj--;
					ii--;
				}
				jj=j+1;
				ii=i+1;
				while(true){//youxia
					if(ii<15&&jj<15&&board[ii][jj]==color){
						count2++;
						if(count2==num){
							break;
						}
					}else{
						break;
					}
					jj++;
					ii++;
				}
				if(count1+count2==num)
				{
					if(i-count1-1>0&&j-count1-1>0&&board[i-count1-1][j-count1-1]=="十"){
						return new int[]{i-count1-1,j-count1-1};
					}
					if(j+count2+1<15&&i+count2+1<15&&board[i+count2+1][j+count2+1]=="十"){
						return new int[]{i+count2+1,j+count2+1};
					}
				}//zuoshang youxia   end
				ii=i-1;
				jj=j+1;
				count1=0;
				count2=0;
				
				//youshang zuoxia start
				while(true){//youshang
					if(ii>=0&&jj<15&&board[ii][jj]==color){
						count1++;
						if(count1==num){
							break;
						}
					}else{
						break;
					}
					jj++;
					ii--;
				}
				jj=j-1;
				ii=i+1;
				while(true){//zuoxia
					if(ii<15&&jj>=0&&board[ii][jj]==color){
						count2++;
						if(count2==num){
							break;
						}
					}else{
						break;
					}
					jj--;
					ii++;
				}
				if(count1+count2==num)
				{
					if(i-count1-1>0&&j+count1+1<15&&board[i-count1-1][j+count1+1]=="十"){
						return new int[]{i-count1-1,j+count1+1};
					}
					if(j-count2-1>0&&i+count2+1<15&&board[i+count2+1][j-count2-1]=="十"){
						return new int[]{i+count2+1,j-count2-1};
					}
				}//zuoshang youxia   end
				
			}
		}
		
		int[] result = { -1, -1 };
		return result;
		
	}
	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int X ,Y,num1=1,num2=1,num3=1,num4=1;
		X=posX;
		Y=posY;
		String[][] board = chessboard.getBoard();
		/**
		 * 横
		 * 
		 */
		for(int i=1;i<5;i++){
			
			if(X+i>15){
				break;
			}
		    if(board[X+i][Y]==board[posX][posY]){
			    num1=num1+1;
			    if(num1>4){
					return true;
				}
		    }else{
		    	break;
		    }
		}
		for(int i=1;i<5;i++){
			
			if(X-i<0){
				break;
			}
		    if(board[X-i][Y]==board[posX][posY]){
			    num1=num1+1;
			    if(num1>4){
					return true;
				}
		    }else{
		    	break;
		    }
		}
		
		/**
		 * 竖
		 * 
		 */
       for(int i=1;i<5;i++){
			
			if(Y+i>15){
				break;
			}
		    if(board[X][Y+i]==board[posX][posY]){
			    num2=num2+1;
			    if(num2>4){
					return true;
				}
		    }else{
		    	break;
		    }
		}
		for(int i=1;i<5;i++){
			
			if(Y-i<0){
				break;
			}
		    if(board[X][Y-i]==board[posX][posY]){
			    num2=num2+1;
			    if(num2>4){
					return true;
				}
		    }else{
		    	break;
		    }
		}

		/**
		 *左斜 
		 * 
		 */
       for(int i=1;i<5;i++){
    	   
			if(X+i>15||Y+i>15){
				break;
			}
		    if(board[X+i][Y+i]==board[posX][posY]){
			    num3=num3+1;
			    if(num3>4){
					return true;
				}
		    }else{
		    	break;
		    }
		}
		for(int i=1;i<5;i++){
			
			if(X-i<0||Y-i<0 ){
				break;
			}
		    if(board[X-i][Y-i]==board[posX][posY]){
			    num3=num3+1;
			    if(num3>4){
					return true;
				}
		    }else{
		    	break;
		    }
		}

		
		/**
		 * 右斜
		 * 
		 */
        for(int i=1;i<5;i++){
        	
			if(X-i<0||Y+i>15){
				break;
			}
		    if(board[X-i][Y+i]==board[posX][posY]){
			    num4=num4+1;
			    if(num4>4){
					return true;
				}
		    }else{
		    	break;
		    }
		}
		for(int i=1;i<5;i++){
			
			if(X+i>15||Y-i<0 ){
				break;
			}
		    if(board[X+i][Y-i]==board[posX][posY]){
			    num4=num4+1;
			    if(num4>4){
					return true;
				}
		    }else{
		    	break;
		    }
		}
	 return false;
	}
//	/**
//	 * 求当前假定落子点的权值
//	 * @param posX
//	 * @param posY
//	 * @return
//	 */
//    public int getQuan(int posX, int posY){
//    	int q=0;
//    	q+=getQuan0(posX,posY);
//    	q+=getQuan90(posX,posY);
//    	q+=getQuan135(posX,posY);
//    	q+=getQuan45(posX,posY);
//    	return q;
//    	
//    }
//    /**
//     * 水平权值
//     * @param posX
//     * @param posY
//     * @return
//     */
////    public int getQuan0(int posX, int posY){
////    	int samechessNumS=0;//相同棋子的个数
////    	int samechessNumF=0;
////    	int blankNumS=0;//空子的个数
////    	int blankNumF=0;
////    	int  q=0,qS=0,qF=0;//qS为进攻，qF为防守
////    	int[][] XY0=new int[2][2];//计算权值用的
////    	XY0[0][0]=XY0[0][1]=posX;
////    	XY0[1][0]=XY0[1][1]=posY;
////    	samechessNumS=getsamechessNum0(XY0,1);
////    	//得到白子数目
////    	if(XY0[1][0]>=0){
////    		
////    		
////    	}
////    	
   	
    	
    	
//		return posY;
    	
//    }
    private int getsamechessNum0(int[][] xY0, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getQuan90(int posX, int posY){
		return posY;
    	
    }
    public int getQuan135(int posX, int posY){
		return posY;
    	
    }
    public int getQuan45(int posX, int posY){
		return posY;
    	
    }
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
