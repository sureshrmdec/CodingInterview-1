import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words 
 * that can be built one character at a time by other words in words. If there is more than one 
 * possible answer, return the longest word with the smallest lexicographical order.
 * If there is no answer, return the empty string.
 * Example 1:
 * Input: 
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation: 
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input: 
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation: 
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is 
 * lexicographically smaller than "apply".
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 * @author wendi
 *
 */
public class LongestWordinDictionary {
	
	
	
	
	/**
	 * Method1: Brute force
	 * For each word, check if all prefixes word[0:k] are present. We can use a Set structure to 
	 * check this quickly.
	 * @param String[] words
	 * @return String
	 * Time: O(nk) n is the length of words, k is the average length of each word
	 * Space: O(n)
	 */
	public String longestWordinDictionary(String[] words) {
		if (words == null || words.length == 0) return "";
		String res = new String();
		Set<String> wordSet = new HashSet<>();
		for (String word: words) wordSet.add(word);
		for (String word: words) {
			if (res.length() < word.length() || 
				res.length() == word.length() && res.compareTo(word) > 0) {
				boolean find = true;
				for (int i = word.length() - 1; i > 0; i--) {
					if (!wordSet.contains(word.substring(0, i))) {
						find = false;
						break;
					}
				}
				if (find) res = word;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestWordinDictionary result = new LongestWordinDictionary();
		System.out.println(result.longestWordinDictionary
				(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
	}

}
