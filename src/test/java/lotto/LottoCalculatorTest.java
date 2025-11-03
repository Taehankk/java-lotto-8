package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;;

class LottoCalculatorTest {
	LottoCalculator lc;
	
	@BeforeAll
	void setUp() {
		lc = new LottoCalculator();
	}
	
	@DisplayName("로또 당첨 여부 확인 테스트")
	@Test
	void checkLottoTest() {
		List<Integer> winning = Arrays.asList(1, 10, 12, 15, 42, 44);
		List<Integer> lotto = Arrays.asList(1, 8, 10, 12, 15, 44);
		int bonusNum = 8;
		
		Winner result = lc.determineWinner(winning, lotto, bonusNum);
		assertEquals(result, Winner.SECOND);
	}
}
