package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	List<Lotto> lottos;
	Lotto winningLotto;
	int bonusNum;
	
	InputManager im = new InputManager();
	
	public void start() {
		int lottoCnt;
		
		while(true) {
			try {
				int money = im.moneyInput();
				lottoCnt = purchaseLotto(money);

				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e);
			}	
		}
		
		lottos = drawingLotto(lottoCnt);
		
		while(true) {
			try {
				winningLotto = im.winningNumsInput();
				break;
			} catch(IllegalArgumentException e) {
				System.out.println(e);
			}
		}
		
		while(true) {
			try {				
				bonusNum = im.bonusNumInput();
				break;
			} catch(IllegalArgumentException e) {
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
	
	public List<Lotto> drawingLotto(int lottoCnt) {
		List<Lotto> lottos = new ArrayList<>();
		
		for(int i = 0; i < lottoCnt; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(numbers);
			Lotto lotto = new Lotto(numbers);
			
			lottos.add(lotto);
		}
		
		return lottos;
	}
}
