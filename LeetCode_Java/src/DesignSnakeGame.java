/**
 * Design a Snake game that is played on a device with screen size = width x height. Play the game 
 * online if you are not familiar with the game.
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * You are given a list of food's positions in row-column order. When a snake eats the food, its 
 * length and the game's score both increase by 1.
 * Each food appears one by one on the screen. For example, the second food will not appear until 
 * the first food was eaten by the snake.
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block 
 * occupied by the snake.
 * Example:
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 * Snake snake = new Snake(width, height, food);
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * |S| | |
 * | | |F|
 * snake.move("R"); -> Returns 0
 * | |S| |
 * | | |F|
 * snake.move("D"); -> Returns 0
 * | | | |
 * | |S|F|
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food 
 * appears at (0,1) )
 * | |F| |
 * | |S|S|
 * snake.move("U"); -> Returns 1
 * | |F|S|
 * | | |S|
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * | |S|S|
 * | | |S|
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 * 
 * Tags: Design, Queue
 * @author wendi
 *
 */
public class DesignSnakeGame {
	private int width;
	private int height;
	private int[][] food;
	private int row;
	
	public DesignSnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		int m = food.length;
		int n = food[0].length;
		food = new int[m][n];
		for (int i = 0; i < food.length; i++) {
			this.food[i] = food[i];
		}
		this.row = 0;
	}
	
	
	public int move(String direction) {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignSnakeGame dsg = new DesignSnakeGame(1,1, new int[][] {{1,1}});

	}

}
