package view.menuElement;


import contract.MenuActions;

public class MenuElement {
	private String content;
	private int size;
	private int alpha;
	private boolean selected;
	
	public MenuElement(String content, int size, int alpha) {
		this.setContent(content);
		this.setSize(size);
		this.setAlpha(alpha);
	}
	
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getAlpha() {
		return this.alpha;
	}
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public MenuActions MenuRequest() {
		return MenuActions.Nop;
	}
}
