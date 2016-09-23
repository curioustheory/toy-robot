package au.com.rea.model;

/**
 * A terrain object that holds information about the terrain
 * 
 * @author Tony Wang
 *
 */
public class TerrainData {
	private int width = 0;
	private int height = 0;
	
	/**
	 * Default constructor
	 * @param width
	 * @param height
	 */
	public TerrainData(int width, int height) {
		this.height = height;
		this.width = width;
	}

	/**
	 * Get the width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Get the  height
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set the height
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
