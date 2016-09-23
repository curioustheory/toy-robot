package au.com.rea.model;

public class TerrainData {
	private int width = 0;
	private int height = 0;
	
	public TerrainData(int width, int height) {
		this.height = height;
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
