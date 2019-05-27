package entity;

public class Element extends Entity {
	protected String sprite;
	protected char sprite_ref;
	protected int PosX;
	protected int PosY;
	protected static boolean traversableByPlayer;
	protected static boolean traversableByFalling;
	
	/**
	 * @author Etienne CARRE
	 */
	public Element() {
		
	}
	
	/**
	 * Constructor of the class Element
	 * @param x
	 * x LUL
	 * @param y
	 * @param sprite_ref
	 */
	public Element(int x, int y, String sprite_ref) {
		this.setPosX(x);
		this.setPosY(y);
	}
	
	public int getPosX() {
		return this.PosX;
	}
	public void setPosX(int x) {
		this.PosX=x;
	}
	
	public int getPosY() {
		return this.PosY;
	}
	public void setPosY(int y) {
		this.PosY=y;
	}
	
	public String getSprite() {
		return this.sprite;
	}
	public void setSprite(String sprite) {
		this.sprite=sprite;
	}
}
