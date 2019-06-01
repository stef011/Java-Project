package view.menuElement;

import contract.MenuActions;

public class Resume extends MenuElement {

	public Resume(String content, int size, int alpha) {
		super(content, size, alpha);
	}
	
	@Override
	public MenuActions MenuRequest() {
		if(this.isSelected()) {
			return MenuActions.Resume;
		}
		return MenuActions.Nop;
	}

}
