/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321

 * click to show spoilers.
 * Have you thought about this?

 * If the integer's last digit is 0, what should the output be? 
 * ie, cases such as 10, 100.

 * Did you notice that the reversed integer might overflow? 
 * Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. 
 * How should you handle such cases?

 * For the purpose of this problem, assume that your function returns 0 
 * when the reversed integer overflows.
 * @author wendi
 * Tag: Math
 */
public class ReverseInteger {

	/**
	 * get the last digit of x as the first digit of res using res=res*10+x%10.
	 * @param int x
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int reverseInteger(int x) {
		if (x == 0) {
			return 0;
		}
		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
			if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
				return 0;
			}
		}
		return (int)result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger result = new ReverseInteger();
		System.out.println(result.reverseInteger(-123));
		System.out.println(-23 % 10);
	}

}
