package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputManager {	
	public int moneyInput() {
		int money;
		
		System.out.println("구입 금액을 입력해 주세요.");
		try {
			money = Integer.parseInt(Console.readLine());		
		} catch (NumberFormatException e) {			
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
		}
				
		return validInputMoney(money);
	}
	
	public int validInputMoney(int money) {
		if(money <= 0) {
			throw new IllegalArgumentException("[ERROR] 양수의 숫자를 입력해주세요.");
		}
		
		if(money % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
		}
		
		return money;
	}
	
	public Lotto winningNumsInput() {
		System.out.println("당첨 번호를 입력해 주세요.(comma(,)로 구분하여 입력해주세요.)");
		String[] input = Console.readLine().replace(" ", "").split(",");
		
		return new Lotto(stringToInt(input));
	}
	
	public List<Integer> stringToInt(String[] input) {
		List<Integer> winningLotto = new ArrayList<>();
		
		for(int i = 0; i < input.length; i++) {
			try {
				winningLotto.add(Integer.parseInt(input[i]));
			} catch(NumberFormatException e) {
				throw new IllegalArgumentException("[ERROR] comma(,)로 구분한 숫자 6개를 입력해 주세요.");
			}
		}
		System.out.println();
		
		Collections.sort(winningLotto);
		return winningLotto;
	}
	
	public int bonusNumInput() {
		int bonusNum;
		
		System.out.println("보너스 번호를 입력해 주세요.");		
		try {
			bonusNum = Integer.parseInt(Console.readLine());
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자 1개를 입력해 주세요.");
		}
		System.out.println();
		
		return validBonusNum(bonusNum);
	}
	
	public int validBonusNum(int bonusNum) {
		if(bonusNum < 1 || bonusNum > 45) {
			throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자 1개를 입력해 주세요.");
		}
		
		return bonusNum;
	}
}
