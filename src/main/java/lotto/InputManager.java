package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	
	public int moneyInput() {
		int money;
		
		System.out.println("구입 금액을 입력해 주세요.");
		try {
			money = Integer.parseInt(Console.readLine());		
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력해주세요.");
		}
		
		if(money <= 0) {
			throw new IllegalArgumentException("양수의 숫자를 입력해주세요.");
		}		
		
		return money;
	}
}
