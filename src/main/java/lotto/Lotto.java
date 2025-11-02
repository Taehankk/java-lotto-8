package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        
        for(int i = 0; i < 6; i++) {
        	if(numbers.get(i) < 1 || numbers.get(i) > 45) {
        		throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하의 자연수입니다.");
        	}
        }
    }
    
    public List<Integer> getNumbers() {
    	return numbers;
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
    	return numbers.toString();
    }
}
