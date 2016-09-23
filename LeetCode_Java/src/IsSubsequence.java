import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially a 
 * very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by deleting 
 * some (can be none) of the characters without disturbing the relative positions of the remaining 
 * characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true.
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false.
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by 
 * one to see if T has its subsequence. In this scenario, how would you change your code?
 * 
 * Tags: BinarySearch, DP, Greedy
 * @author wendi
 *
 */
public class IsSubsequence {

	/**
	 * Method2: Binary Search 
	 * @param String s, String t
	 * @return boolean
	 * Time: O(klog(n))
	 * Space: O(n^2)
	 */
	public boolean isSubsequenceI(String s, String t) {
		if (s == null || s.length() < t.length()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		List<Integer>[] array = new ArrayList[26];
//		int index = Collections.binarySearch(list, key)
		return false;
	}
	
	
	/**
	 * Method1: Brute Force
	 * @param String s, String t
	 * @return boolean
	 * Time: O(kn)  k is the times to call isSubsequence()
	 * Space: O(1)
	 */
	public boolean isSubsequence(String s, String t) {
		if (s == null || s.length() > t.length()) {
			return false;
		}
//		int is = 0;
//		int it = 0;
//		char[] S = s.toCharArray();
//		char[] T = t.toCharArray();
//		while (is < s.length() && it < t.length()) {
//			if (S[is] == T[it]) {
//				is++;
//			}
//			it++;
//		}
//		return is == s.length();
		
		// or (faster:2ms)
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			index = t.indexOf(s.charAt(i), index);
			if (index == -1) {
				return false;
			}
			index++;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsSubsequence result = new IsSubsequence();
		System.out.println(result.isSubsequence("ace", "abcde"));
		System.out.println(result.isSubsequenceI("ace", "abcde"));
	}

}