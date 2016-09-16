import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / 
 * operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * 
 * Tags: String
 * @author wendi
 *
 */
public class BasicCalculatorII {
	
	/**
	 * Method3: Do last operation when get operator. (Can't not do opeartion when get num, ' 1 01' case )
	 * Use multi to record the last num, if op is * or /, call back.
	 * If op = '+', res += num, multi = num.
	 * If op = '-', res -= num, multi = -num.
	 * If op = '*', res = res - multi + multi * num.
	 * If op = '/', res = res - multi + multi / num.
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int basicCalculatorIIII(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}		
		int result = 0;
		char op = '+';
		int num = 0;
		int multi = 0;
		char[] S = s.toCharArray();
		for (int i = 0; i <= S.length; i++) {
			char c = i == S.length ? ']' : S[i];
			if (c == ' ') continue;
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}
			else {
				if (op == '+') {
					result += num;
					multi = num;
				}
				else if (op == '-') {
					result -= num;
					multi = - num;
				}
				else if (op == '*') {
					result = result - multi + multi * num;
					multi *= num;
				}
				else if (op == '/') {
					result = result - multi + multi / num;
					multi /= num;
				}
				op = c;
				num = 0;
			}
		}
		return result;
	}

	
	/**
	 * Method2: Do last last operation when get operator.
	 * Use pre to record the num before op, and curr to record the num after op.
	 * If op = '+', res += pre, pre = curr.
	 * If op = '-', res += pre, pre = -curr.
	 * If op = '*', pre *= curr; (not calculate res directly, update pre first, find next curr)
	 * If op = '/', pre /= curr;
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int basicCalculatorIII(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}		
		int result = 0;
		int pre = 0;
		int curr = 0;
		char op = '+';
		for (int i = 0; i <= s.length(); i++) {
			char c = i == s.length() ? ']' : s.charAt(i);
			if (c != ' ' && Character.isDigit(c)) {
				curr = curr * 10 + c - '0';
			}
			if (c != ' ' && !Character.isDigit(c)) {
				if (op == '+') {
					result += pre;
					pre = curr;
				}
				else if (op == '-') {
					result += pre;
					pre = -curr;
				}
				else if (op == '*') {
					pre *= curr;
				}
				else if (op == '/') {
					pre /= curr;
				}
				curr = 0;
				op = c;
			}
		}
		return result + pre;
	}
	
	
	/**
	 * Method1: Stack: do last operation when get operator.
	 * use stack to save num, op is prev operation, not current c.
	 * If op is '+', push num into stack.
	 * If op is '-', push -num into stack.
	 * If op is '*', pop pre from stack and then push pre * num into stack.
	 * If op is '/', 
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int basicCalculatorII (String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		char op = '+';
		int num = 0;
		Stack<Integer> stack = new Stack<>();	
		for (int i = 0; i <= s.length(); i++) {
			char c = i == s.length() ? ']' : s.charAt(i); // in order to do the last operator
			if (c != ' ' && Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}
			if (c != ' ' && !Character.isDigit(c)) {
				if (op == '+') {
					stack.push(num);
				}
				else if (op == '-') {
					stack.push(-1 * num);
				}
				else if (op == '*') {
					stack.push(stack.pop() * num);
				}
				else if (op == '/') {
					stack.push(stack.pop() / num);
				}
				num = 0;
				op = c;
			}
		}
		for (int res: stack) {
			result += res;
		}		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculatorII result = new BasicCalculatorII();
		System.out.println(result.basicCalculatorII("  12 - 3 * 3 + 0  1 0   "));
		System.out.println(result.basicCalculatorII("  3 + 2 - 1 + 2 * 2 - 1   "));
		System.out.println(result.basicCalculatorIII("  12 - 3 * 3 + 0  1 0   "));
		System.out.println(result.basicCalculatorIII("  3 + 2 - 1 + 2 * 2 - 1   "));
		System.out.println(result.basicCalculatorIIII("  12 - 3 * 3 + 0  1 0   "));
		System.out.println(result.basicCalculatorIIII("  3 + 2 - 1 + 2 * 2 - 1   "));
	}

}
