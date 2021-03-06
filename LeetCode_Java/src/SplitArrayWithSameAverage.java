/**
 * In a given integer array A, we must move every element of A to either list B or list C. (B and C 
 * initially start empty.)
 * Return true if and only if after such a move, it is possible that the average value of B is equal 
 * to the average value of C, and B and C are both non-empty.
 * Example :
 * Input: 
 * [1,2,3,4,5,6,7,8]
 * Output: true
 * Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the 
 * average of 4.5.
 * Note:
 * 1. The length of A will be in the range [1, 30].
 * 2. A[i] will be in the range of [0, 10000].
 * @author wendi
 *
 */
public class SplitArrayWithSameAverage {
	
	/**
	 * 
	 * @param int[] A
	 * @return boolean
	 * Time: O()
	 * Space: O()
	 */
	public boolean splitArrayWithSameAverage(int[] A) {
		if (A == null || A.length == 0) return true;
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitArrayWithSameAverage result = new SplitArrayWithSameAverage();
		System.out.println(result.splitArrayWithSameAverage(new int[] {1,2,3,4,5,6,7,8}));
	}

}
