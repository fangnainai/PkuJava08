/*
 * 每人每次至多拿走3颗石头。
 * 由我开始，当4颗时先手必输
 * 因此当初始是4的倍数时，后手的策略就是每次取（4-先手上步取的数量），这样最后先手会轮到4颗的局面，必输
 */
public class NimGame292 {
    public boolean canWinNim(int n) {    	
        return n%4 != 0;
    }

}
