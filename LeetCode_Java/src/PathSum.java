import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class PathSum {

	/**
	 * Method2: DFS(Iteration) (Preorder template)
	 * Two stacks: nodes to save the nodes that can pop in preorder, sums to save the cooccurrence 
	 * path sum, not include curr.val. Check whether curr is leaf, if it's, 
	 * check currSum==curr.val. Otherwise, push curr left or right to stacks. 
	 * @param TreeNode root, int sum
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean pathSumI(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Stack<TreeNode> nodes = new Stack<>();
		Stack<Integer> sums = new Stack<>();
		nodes.push(root);
		sums.push(sum);
		while (!nodes.isEmpty()) {
			TreeNode currNode = nodes.pop();
			int currSum = sums.pop();
			if (currNode.left == null && currNode.right == null && currSum == currNode.val) {  // if it's leaf and sum-val=0
				return true;
			}
			if (currNode.right != null) {
				nodes.push(currNode.right);
				sums.push(currSum - currNode.val);
			}
			if (currNode.left != null) {
				nodes.push(currNode.left);
				sums.push(currSum - currNode.val);
			}
		}
		return false;
	}
	
	/**
	 * Method1: DFS(recursion). Find the leaf, check sum. If it's 0, then find the path.
	 * @param TreeNode root, int sum
	 * @return boolean
	 * Time: O(n) n is the number of nodes
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean pathSum(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null) return sum == root.val;
		return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum result = new PathSum();
		TreeNode root = TreeNode.generateCBT(new int[] {5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 0, 1});
		TreeNode.printCBT(root);
//		System.out.println(result.pathSum(root, 22));
		System.out.println(result.pathSumI(root, 22));
	}

}
