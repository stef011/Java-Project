package view.menuElement;

import contract.MenuActions;

public class MainMenu extends MenuElement {

	public MainMenu(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public MenuActions MenuRequest() {
		if(this.isSelected()) {
			return MenuActions.Mainmenu;
		}
		return MenuActions.Nop;
	}
}
