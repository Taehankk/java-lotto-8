package lotto;

import java.util.*;

public class OutputManager {
	public void printLottos(List<Lotto> lottos) {
		System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
		for(Lotto lotto : lottos) {
			System.out.println(lotto);
		}
		System.out.println();
	}
	
	public void printResult(Map<Winner, Integer> winningStats, String rate) {
		System.out.println("당첨 통계\n---");
		System.out.println(Winner.FIFTH.getPrintContents() + winningStats.get(Winner.FIFTH) + "개");
		System.out.println(Winner.FOURTH.getPrintContents() + winningStats.get(Winner.FOURTH) + "개");
		System.out.println(Winner.THIRD.getPrintContents() + winningStats.get(Winner.THIRD) + "개");
		System.out.println(Winner.SECOND.getPrintContents() + winningStats.get(Winner.SECOND) + "개");
		System.out.println(Winner.FIRST.getPrintContents() + winningStats.get(Winner.FIRST) + "개");
	
		System.out.println("총 수익률은 " + rate + "%입니다.");
	}
}
