package lotto;

import java.util.*;

public class LottoCalculator {
	private Map<Winner, Integer> winningStats = new HashMap<>();
	
	OutputManager om = new OutputManager();
	
	LottoCalculator() {
		for(Winner w : Winner.values()) {
			winningStats.put(w, 0);
		}
	}
	
	public Winner determineWinner(List<Integer> winning, List<Integer> lotto, int bonusNum) {
		int matchedCnt = 0;
		for(int i = 0; i < 6; i++) {
			if(winning.contains(lotto.get(i))) {
				matchedCnt++;
			}
		}
		
		if(matchedCnt == 5 && isSecond(lotto, bonusNum)) {
			matchedCnt = 50;
		}
		
		return intToWinner(matchedCnt);
	}
	
	public Winner intToWinner(int matchedCnt) {
		if(matchedCnt == 3) return Winner.FIFTH;
				
		if(matchedCnt == 4) return Winner.FOURTH;
		
		if(matchedCnt == 5) return Winner.THIRD;
		
		if(matchedCnt == 50) return Winner.SECOND;
		
		if(matchedCnt == 6) return Winner.FIRST;
		
		return null;
	}
	
	public boolean isSecond(List<Integer> lotto, int bonusNum) {
		return lotto.contains(bonusNum);
	}
	
	public void saveWinningResult(Winner result) {
		int count = winningStats.get(result);
		winningStats.put(result, count + 1);
	}
	
	public void getLottoResult(int money) {
		om.printResult(winningStats, calcReturnRate(money));
	}
	
	public String calcReturnRate(int money) {
		float prize = 0;
		for(Winner w : Winner.values()) {
			prize += w.getPrize() * winningStats.get(w);
		}
		
		return String.format("%.1f", prize / money * 100);
	}
}
