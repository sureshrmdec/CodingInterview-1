import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', 
 * '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we 
 * can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the 
 * wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum 
 * total number of turns required to open the lock, or -1 if it is impossible.
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * Example 4:
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 * Note:
 * 1. The length of deadends will be in the range [1, 500].
 * 2. target will not be in the list deadends.
 * 3. Every string in deadends and the string target will be a string of 4 digits from the 10,000 
 * possibilities '0000' to '9999'.
 * @author wendi
 *
 */
public class OpentheLock {
	
	
	/**
	 * BFS
	 * @param String[] deadends, String target
	 * @return int
	 * Time: O(9^4)
	 * Space: O(9^4)
	 */
	public int openLock(String[] deadends, String target) {
		Set<String> deads = new HashSet<>(Arrays.asList(deadends));
		if (deads.contains("0000")) return -1;
		Queue<String> queue = new LinkedList<>();
		queue.offer("0000");
		Set<String> visited = new HashSet<>();
		visited.add("0000");
		int turns = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String curr = queue.poll();
				if (curr.equals(target)) return turns;
				for (int i = 0; i < 4; i++) {
					char c = curr.charAt(i);
					String s1 = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1, 4);
					String s2 = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i + 1, 4);
					if (!deads.contains(s1) && !visited.contains(s1)) {
						queue.offer(s1);
						visited.add(s1);
					}
					if (!deads.contains(s2) && !visited.contains(s2)) {
						queue.offer(s2);
						visited.add(s2);
					}
				}
			}
			turns++;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpentheLock result = new OpentheLock();
		System.out.println(result.openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
	}

}
