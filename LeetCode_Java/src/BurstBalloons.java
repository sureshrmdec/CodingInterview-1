import java.util.Arrays;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented 
 * by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get 
 * nums[left] * nums[i] * nums[right] coins. 
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes 
 * adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note: 
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * Given [3, 1, 5, 8]
 * Return 167
		    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
		   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
		   
 * Tags: Divided and Conquer, DP
 * @author wendi
 *
 */
public class BurstBalloons {

	/**
	 * DP: 
	 * dp[s][e]: the maximal coins for range [s,...,e]
	 * dp[s][e] = max(dp[s][i-1] + n[s-1]*n[i]*n[e+1] + dp[i+1][e]) (i=s,...,e) i is the last balloon 
	 * to burst between [s,...,e], the result should be dp[0][n-1]
	 * @param int[] nums
	 * @return int
	 * Time:O(n^3)
	 * Space: O(n^2)
	 */
	public int burstBallons(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[][] dp = new int[n][n];
		for (int len = 1; len <= n; len++) {
			for (int start = 0; start <= n - len; start++) {
				int end = len + start - 1;
				System.out.println("start: " + start + ", end: " + end);
				for (int i = start; i <= end; i++) {  // i is the last balloon to burst in [start, ..,end]
					int curr = (start - 1 < 0 ? 1 : nums[start - 1]) * nums[i] * (end + 1 >= n ? 1 : nums[end + 1]); // Deal with num[-1] and num[num.length]
					curr += i == start ? 0 : dp[start][i - 1]; // If not start, we can add subRes from start to i-1.
					curr += i == end ? 0 : dp[i + 1][end];  // If not end, we can add subRes from i+1 to end.
					System.out.println("i: " + i + ", curr: " + curr);
					dp[start][end] = Math.max(curr, dp[start][end]);
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return dp[0][n - 1];
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BurstBalloons result = new BurstBalloons();
		System.out.println(result.burstBallons(new int[] {3, 1, 5, 8}));
	}

}
