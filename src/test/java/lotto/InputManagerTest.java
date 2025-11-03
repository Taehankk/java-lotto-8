package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.*;

class InputManagerTest {
	InputManager im;
	
	@BeforeEach
	void setUp() {
		im = new InputManager();
	}
	
	@DisplayName("구매 금액 유효성 확인 테스트 - 음수값 입력")
	@Test
	void minusInputFailTest() {
		int money = -3000;		
		
		assertThatIllegalArgumentException()
				.isThrownBy(() -> im.validInputMoney(money))
				.withMessage("[ERROR] 양수의 숫자를 입력해주세요.");
	}
	
	@DisplayName("구매 금액 유효성 확인 테스트 - 1000 단위가 아닌 경우")
	@Test
	void notThousandInputFailTest() {
		int money = 12500;
		
		assertThatIllegalArgumentException()
				.isThrownBy(() -> im.validInputMoney(money))
				.withMessage("[ERROR] 1000원 단위로 입력해주세요.");
	}
}
