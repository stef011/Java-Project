package view.menuElement;

import contract.MenuActions;

public class QuitGame extends MenuElement {

	public QuitGame(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public MenuActions MenuRequest() {
		if(this.isSelected()) {
			return MenuActions.Quitgame;
		}
		return MenuActions.Nop;
	}

}
