package game;

/**
 * 
 */
public class Wall extends Building {

	private static final long serialVersionUID = 1L;

	public Wall(int number, int locationX, int locationY){
		super(10, 10, 10, number, locationX, locationY);
	}
}