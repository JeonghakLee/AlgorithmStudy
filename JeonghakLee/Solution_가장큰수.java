package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution_가장큰수 {
	public String solution(int[] numbers) {
		String answer = "";
		int sum = 0;

		for (int num : numbers) {
			sum += num;
		}

		if (sum == 0)
			return "0";

		List<String> strList = Arrays.stream(numbers).boxed().map(i -> String.valueOf(i)).collect(Collectors.toList());

		Collections.sort(strList, (o1, o2) -> {
			String t1 = o1 + o2;
			String t2 = o2 + o1;
			return t1.compareTo(t2);
		});

		for (String str : strList) {
			answer = str + answer;
		}

		return answer;
	}
}