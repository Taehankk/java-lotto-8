package lotto;

public class LottoMachine {
	LottoMachine() {}
	
	InputManager im = new InputManager();
	
	public void start() {
		while(true) {
			try {
				int money = im.moneyInput();
				int lottoCnt = purchaseLotto(money);
				System.out.println(lottoCnt);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e);
			}
		
		}
	}
	
	public void end() {
		
	}
	
	public int purchaseLotto(int money) {		
		if(money % 1000 != 0) {
			throw new IllegalArgumentException("[Error] 1000원 단위로 입력해주세요.");
		}
		
		return money / 1000;
	}
}
