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
			throw new IllegalArgumentException("[Error] 숫자를 입력해주세요.");
		}
		
		if(money <= 0) {
			throw new IllegalArgumentException("[Error] 양수의 숫자를 입력해주세요.");
		}		
		
		return money;
	}
	
	public Lotto winningNumsInput() {
		List<Integer> winningLotto = new ArrayList<>();
		
		System.out.println("당첨 번호를 입력해 주세요.(comma(,)로 구분하여 입력해주세요.)");
		String[] input = Console.readLine().replace(" ", "").split(",");

		for(int i = 0; i < input.length; i++) {
			try {				
				int num = Integer.parseInt(input[i]);
				winningLotto.add(num);
			} catch(NumberFormatException e) {
				throw new IllegalArgumentException("[Error] comma(,)로 구분한 숫자 6개를 입력해 주세요.");
			}
		}
		System.out.println();
		
		Collections.sort(winningLotto);
		
		return new Lotto(winningLotto);
	}
	
	public int bonusNumInput() {
		int bonusNum;
		
		System.out.println("보너스 번호를 입력해 주세요.");		
		try {
			bonusNum = Integer.parseInt(Console.readLine());
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("[Error] 보너스 번호 오류 : 로또 번호는 1 이상 45 이하의 자연수입니다.");
		}
		
		if(bonusNum < 1 || bonusNum > 45) {
			throw new IllegalArgumentException("[Error] 보너스 번호 오류 : 1에서 45 사이의 숫자 1개를 입력해 주세요.");
		}
		System.out.println();
		
		return bonusNum;
	}
}
