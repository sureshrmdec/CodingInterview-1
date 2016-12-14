import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their 
 * depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 
 * 1 + 4*2 + 6*3 = 27)
 * 
 * Tags: DFS
 * @author wendi
 *
 */
public class NestedListWeightSum {
	class NestedInteger {
		
		
		public boolean isInteger() {
			if (this.isInteger()) {
				return true;
			}
			return false;
		}
		
		public Integer getInteger() {
			
		}
		
		public List<NestedInteger> getList() {
			
		}
		
	}
	
	
	/**
	 * DFS
	 * @param List<NestedInteger> nestedList
	 * @return int
	 * Time: O(n)
	 * Space: O()
	 * Stack Space: O(n)
	 */
	public int nestedListWeightSum(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		return helper(nestedList, 1);
	}
	
	public int helper(List<NestedInteger> nestedList, int depth) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		int result = 0;
		for (NestedInteger num: nestedList) {
			if (num.isInteger()) {
				result += num.getInteger() * depth;
			}
			else {
				result += helper(num.getList(), depth + 1);
			}
		}
		return result;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedListWeightSum result = new NestedListWeightSum();
		System.out.println(result.nestedListWeightSum(nestedList));
	}

}
