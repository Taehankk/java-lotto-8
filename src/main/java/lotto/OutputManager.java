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
}
