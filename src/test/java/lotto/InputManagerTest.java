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
	
	@DisplayName("로또 번호 유효성 테스트(6개 당첨 번호) - 구분자 잘못 입력")
	@Test
	void notCommaInput() {
		String[] input = new String[] {"1.3", "4", "43", "21","11"};
		
		assertThatIllegalArgumentException()
				.isThrownBy(() -> im.stringToInt(input))
				.withMessage("[ERROR] comma(,)로 구분한 숫자 6개를 입력해 주세요.");
	}
	
	@DisplayName("로또 번호 유효성 테스트(보너스 번호) - 입력값이 음수일 때")
	@Test
	void minusBonusNumberFailTest() {
		int num = -21;
		
		assertThatIllegalArgumentException()
				.isThrownBy(() -> im.validBonusNum(num))
				.withMessage("[ERROR] 1에서 45 사이의 숫자 1개를 입력해 주세요.");
	}
}
