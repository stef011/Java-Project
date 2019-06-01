package view.menuElement;

import contract.MenuActions;

public class Play extends MenuElement {
	
	public Play(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public MenuActions MenuRequest() {
		if(this.isSelected()) {
			return MenuActions.Play;
		}
		return MenuActions.Nop;
	}
}
