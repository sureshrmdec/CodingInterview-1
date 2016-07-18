/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *  compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 
 * units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * 
 * Tags: Array, Stack, Two Pointers 
 * @author wendi
 *
 */
public class TrappingRainWater {

	/**
	 * Two pointers: Find the highest number in the height, then this number is the right edge of
	 * left part and the left edge of right part. On the left part, try to find the left edge of current
	 * height[i](excludes i). If left edge > height[i], means in this bar can trap rain water.
	 * The same on the right part.
	 * @param int[] height
	 * @return int
	 * Time: O(n)
	 * Space:
	 */
	public int trappingRainWater(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}
		int result = 0;
		// find the highest bar, the highest is index
		int highest = 0;
		for (int i = 1; i < height.length; i++) {
			highest = height[i] > height[highest] ? i : highest;
		}
		// calculate the left trapping rain water
		int left = 0;
		for (int i = 1; i < highest; i++) {
			if (height[left] - height[i] > 0) {
				result += height[left] - height[i];
			}
			else {
				left = i;
			}
		}
		// calculate the right trapping rain water
		int right = height.length - 1;
		for (int i = height.length - 2; i > highest; i--) {
			if (height[right] - height[i] > 0) {
				result += height[right] - height[i];
			}
			else {
				right = i;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater result = new TrappingRainWater();
		System.out.println(result.trappingRainWater(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}

}
