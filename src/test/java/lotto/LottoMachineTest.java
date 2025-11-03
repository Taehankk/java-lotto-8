package lotto;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

class LottoMachineTest {
	LottoMachine lm;
	@BeforeAll
	void setUp() {
		lm = new LottoMachine();
	}
	
	@DisplayName("요청한 개수만큼 로또 반환하는 지 테스트")
	@Test
	void drawingCntTest() {
		int count = 5;
		
		List<Lotto> lottos = lm.drawingLotto(count);
		assertEquals(count, lottos.size());
	}
}
