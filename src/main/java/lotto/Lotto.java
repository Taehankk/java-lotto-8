package lotto;

import java.util.*;

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
        
        validateDuplication(numbers);
    }
    
    // TODO: 추가 기능 구현
    public void validateDuplication(List<Integer> numbers) {
    	Set<Integer> numberSet = new HashSet<>();
    	
    	for(int num : numbers) {
    		numberSet.add(num);
    	}
    	
    	if(numberSet.size() != 6) {
    		throw new IllegalArgumentException("[ERROR] 중복된 값을 입력하셨습니다.");
    	}
    }
    
    public List<Integer> getNumbers() {
    	return numbers;
    }

    @Override
    public String toString() {
    	return numbers.toString();
    }
}
