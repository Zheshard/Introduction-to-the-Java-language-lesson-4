
// Дан Deque состоящий из последовательности цифр.
// Необходимо проверить, что последовательность цифр является палиндромом
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ex_1 {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(6, 5, 4, 3, 4, 5, 6));

		boolean res = checkOn(deque);
		System.out.println(res ? "Палиндром" : "Не палиндром");
	}

	public static boolean checkOn(Deque<Integer> deque) {
		for (int i = 0; i < deque.size() / 2; i++) {
			int f = deque.pollFirst();
			int l = deque.pollLast();
			if (f != l) {
				return false;
			}
		}
		return true;
	}

}
