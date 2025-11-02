package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	LottoMachine lm = new LottoMachine();
    	
    	lm.purchaseLotto();
    	lm.pickWinningNums();
    	lm.checkLottos();
    }
}
