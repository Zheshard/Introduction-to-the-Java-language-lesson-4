
//Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
// является ли входная строка логически правильной.
// Входная строка логически правильная, если:
// 1) Открытые скобки должны быть закрыты скобками того же типа.
// 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
// открытую скобку того же типа.
// ()[] = true
// () = true
// {[()]} = true
// ()() = true
// )()( = false
import java.util.Deque;
import java.util.LinkedList;

public class ex_3 {
	public static void main(String[] args) {
		String str1 = "()[]";
		String str2 = "()";
		String str3 = "{[()]}";
		String str4 = "()()";
		String str5 = ")()(";

		System.out.println(validate(str1));
		System.out.println(validate(str2));
		System.out.println(validate(str3));
		System.out.println(validate(str4));
		System.out.println(validate(str5));
	}

	public static boolean validate(String str) {

		char[] ch = str.toCharArray();
		if (null == str || ((str.length() % 2) != 0)) {
			return false;
		} else {
			for (char c : ch) {
				if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
					return false;
				}
			}

			Deque<Character> dq = new LinkedList<>();
			for (char symb : str.toCharArray()) {
				if (symb == '{' || symb == '[' || symb == '(') {
					dq.addFirst(symb);
				} else {
					if (!dq.isEmpty()
							&& ((dq.peekFirst() == '{' && symb == '}')
									|| (dq.peekFirst() == '[' && symb == ']')
									|| (dq.peekFirst() == '(' && symb == ')'))) {
						dq.removeFirst();
					} else {
						return false;
					}
				}
			}
			return true;
		}
	}
}

// https://javascopes.com/java-balanced-brackets-algorithm-eebfd516/