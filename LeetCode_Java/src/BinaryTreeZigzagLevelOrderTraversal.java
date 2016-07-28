import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left 
 * to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
 * return its zigzag level order traversal as:
		[
		  [3],
		  [20,9],
		  [15,7]
		]
 * 
 * Tags: Tree, BFS, Stack
 * @author wendi
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * BFS(level traverse template), reverse level value when it's odd level.
	 * @param TreeNode root
	 * @return List<List<Integer>>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<List<Integer>> binaryTreeZigzagLevelOrderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelResult = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (level % 2 == 0) {  
					levelResult.add(curr.val);   // even level, not reverse
				}
				else {
					levelResult.add(0, curr.val);// odd level, reverse
				}
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			result.add(levelResult);
			level++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeZigzagLevelOrderTraversal result = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = TreeNode.generateCBT(new int[] {3, 9, 20, 15, 7});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeZigzagLevelOrderTraversal(root));
	}

}
