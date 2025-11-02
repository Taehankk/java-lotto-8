package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	List<Lotto> lottos;
	Lotto winningLotto;
	int bonusNum;
	
	InputManager im = new InputManager();
	OutputManager om = new OutputManager();
	LottoCalculator lc = new LottoCalculator();
	
	public void purchaseLotto() {
		int money;
		
		while(true) {
			try {
				money = im.moneyInput();

				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e);
			}	
		}
		
		if(money % 1000 != 0) {
			throw new IllegalArgumentException("[Error] 1000원 단위로 입력해주세요.");
		}
		
		lottos = drawingLotto(money / 1000);
	}
	
	public List<Lotto> drawingLotto(int lottoCnt) {
		List<Lotto> lottos = new ArrayList<>();
		
		for(int i = 0; i < lottoCnt; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(numbers);
			Lotto lotto = new Lotto(numbers);
			
			lottos.add(lotto);
		}

		om.printLottos(lottos);
		
		return lottos;
	}
	
	public void pickWinningNums() {		
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
	
	public void checkLottos() {
		List<Integer> winningNums = winningLotto.getNumbers();
		List<Integer> pickNums;
		
		Winner result;
		for(int i = 0; i < lottos.size(); i++) {
			pickNums = lottos.get(i).getNumbers();
			result = lc.determineWinner(winningNums, pickNums, bonusNum);
			saveResult(result);
		}
	}
	
	public void saveResult(Winner result) {
		if(result == null) return;
		
		lc.saveWinningResult(result);
	}
}
