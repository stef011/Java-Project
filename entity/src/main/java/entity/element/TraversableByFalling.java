package entity.element;

/**
 * <h1>The Traversable by falling Enumeration.</h1>
 * Used by elements to know if a {@link entity.element.motionlessElement.fallingElement.FallingElement} can traverse it.
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public enum TraversableByFalling {
	/**
	 * Block the {@link entity.element.motionlessElement.fallingElement.FallingElement}
	 */
	Blocking,
	/**
	 * Make the {@link entity.element.motionlessElement.fallingElement.FallingElement} slip.
	 */
	Slippery,
	/**
	 * Get traversed by the {@link entity.element.motionlessElement.fallingElement.FallingElement}
	 */
	Traversable,
	/**
	 * Get killed by the {@link entity.element.motionlessElement.fallingElement.FallingElement}
	 */
	Alive
}
