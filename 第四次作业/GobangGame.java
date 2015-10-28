package com.zhuanzhuan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的Y坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	// 定义方向
	private static int dx[]={1,1,1,0,0,-1,-1,-1};
	private static int dy[]={1,0,-1,1,-1,1,0,-1};

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
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
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
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		
		int posX = 0;
		int posY = 0;
		int maxScore=-1;
		int nowScore=0;
		for(int i=0;i<Chessboard.BOARD_SIZE;i++) {
			for(int j=0;j<Chessboard.BOARD_SIZE;j++) {
				nowScore = Math.max(getScore(i,j,Chessman.WHITE.getChessman()),getScore(i,j,Chessman.BLACK.getChessman()));
				if(nowScore>maxScore) {
					maxScore = nowScore;
					posX = i;
					posY = j;
				}
			}
		}
		System.out.println((posX+1)+" "+(posY+1)+" "+maxScore);
		int[] result = { posX, posY };
		return result;
	}
	/*因为电脑下棋时随机的，给每一个位置都设定一个分数，会往分数最高的地方下棋子*/
	private int getScore(int posx, int posy, String ico) {
		int score =0;
		int left=0;
		int right=0;
		int []type = {0,0,0,0};
		String[][] board = chessboard.getBoard();
		if(board[posx][posy]!="十") {
			return -10000;//有棋子的时候就不可以再下了所以得分设立的很低
		}
		for(int i=0; i<4; i++) {
			left = numInDir(posx,posy,ico,i);
			right = numInDir(posx,posy,ico,7-i);//在同一条直线的另一个方向
			int endPoint =0;
			int tx = posx+dx[i]*(left+1);
			int ty = posy+dy[i]*(left+1);
			if(tx>=0&&tx<Chessboard.BOARD_SIZE&&ty>=0&&ty<Chessboard.BOARD_SIZE && board[tx][ty]=="十") {
				endPoint++;
			}
			tx = posx+dx[7-i]*(right+1);
			ty = posy+dy[7-i]*(right+1);
			if(tx>=0&&tx<Chessboard.BOARD_SIZE&&ty>=0&&ty<Chessboard.BOARD_SIZE && board[tx][ty]=="十") {
				endPoint++;
			}
			int tmp = left+right+1;
			if (tmp>5) {
				tmp=5;
			}
			if(tmp==5) {
				type[i]=10;
			} else {
				if(endPoint==2) type[i]=tmp*2;
				else if(endPoint == 1) type[i]=tmp*2-1;
				else type[i]=0;
			}
		}
		int []typeNum = new int[11];
		for(int i=0;i<11;i++) {
			typeNum[i]=0;
		}
		for(int i=0;i<4;i++) {
			typeNum[type[i]]++;
		}
		if(typeNum[10]>0) {
			score =200;
		} else if(typeNum[8]>=1||typeNum[7]>=2||(typeNum[7]>=1&&typeNum[6]>=1)) {
			score =180;
		} else if(typeNum[6]>=2) {
			score =160;
		} else if(typeNum[6]>=1&&typeNum[5]>=1) {
			score =140;
		} else if(typeNum[7]>=1) {
			score =120;
		} else if(typeNum[6]>=1) {
			score =100;
		} else if(typeNum[4]>=2) {
			score =80;
		} else if(typeNum[5]>=1) {
			score =60;
		} else if(typeNum[4]>=1) {
			score =40;
		} else if(typeNum[3]>=1) {
			score =20;
		} else {
			score =0;
		}
		if(ico == Chessman.BLACK.getChessman()) {
			score -=10;
		}
		return score;
	}
	/*  dir定义8个方向用来判断是否为5个，ico表示的是黑棋子还是白棋子*/
	private int numInDir(int posx, int posy, String ico, int dir) {
		int num =0;
		int tx = posx+dx[dir];
		int ty = posy+dy[dir];
		String[][] board = chessboard.getBoard();
		while(tx>=0&&tx<Chessboard.BOARD_SIZE&&ty>=0&&ty<Chessboard.BOARD_SIZE) {
			
			if(board[tx][ty]==ico) {
				num++;
				tx = tx+dx[dir];
				ty = ty+dy[dir];
			} else {
				break;
			}
		}
		return num;
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
		for(int i=0;i<4;i++) {
			if(numInDir(posX,posY,ico,i)+numInDir(posX,posY,ico,7-i) + 1>=WIN_COUNT) {
				System.out.println(ico);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
