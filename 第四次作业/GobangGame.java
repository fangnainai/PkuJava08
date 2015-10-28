package com.zhuanzhuan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������Y����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;
	// ���巽��
	private static int dx[]={1,1,1,0,0,-1,-1,-1};
	private static int dy[]={1,0,-1,1,-1,1,0,-1};

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
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
	/*��Ϊ��������ʱ����ģ���ÿһ��λ�ö��趨һ������������������ߵĵط�������*/
	private int getScore(int posx, int posy, String ico) {
		int score =0;
		int left=0;
		int right=0;
		int []type = {0,0,0,0};
		String[][] board = chessboard.getBoard();
		if(board[posx][posy]!="ʮ") {
			return -10000;//�����ӵ�ʱ��Ͳ��������������Ե÷������ĺܵ�
		}
		for(int i=0; i<4; i++) {
			left = numInDir(posx,posy,ico,i);
			right = numInDir(posx,posy,ico,7-i);//��ͬһ��ֱ�ߵ���һ������
			int endPoint =0;
			int tx = posx+dx[i]*(left+1);
			int ty = posy+dy[i]*(left+1);
			if(tx>=0&&tx<Chessboard.BOARD_SIZE&&ty>=0&&ty<Chessboard.BOARD_SIZE && board[tx][ty]=="ʮ") {
				endPoint++;
			}
			tx = posx+dx[7-i]*(right+1);
			ty = posy+dy[7-i]*(right+1);
			if(tx>=0&&tx<Chessboard.BOARD_SIZE&&ty>=0&&ty<Chessboard.BOARD_SIZE && board[tx][ty]=="ʮ") {
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
	/*  dir����8�����������ж��Ƿ�Ϊ5����ico��ʾ���Ǻ����ӻ��ǰ�����*/
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
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
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
