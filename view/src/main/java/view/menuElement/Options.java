package view.menuElement;

import contract.MenuActions;

public class Options extends MenuElement {

	public Options(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public MenuActions MenuRequest() {
		if(this.isSelected()) {
			return MenuActions.Options;
		}
		return MenuActions.Nop;
	}

}
