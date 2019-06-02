package entity.element;

/**
 * TraverableByAlive Enumeration
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public enum TraversableByAlive {
	/**
	 * An {@link entity.element.aliveElement.AliveElement} can traverse it.
	 */
	Traversable,
	/**
	 * An {@link entity.element.aliveElement.AliveElement} can break it.
	 */
	Breakable,
	/**
	 * It blocks an {@link entity.element.aliveElement.AliveElement}.
	 */
	Blocking,
	/**
	 * The {@link entity.element.aliveElement.Player} can push it.
	 */
	Pushable,
	/**
	 * The {@link entity.element.aliveElement.Player} can pick it.
	 */
	Pickable,
	/**
	 * The element is a {@link entity.element.aliveElement.Mob}.
	 */
	Mob,
	/**
	 * The element is a {@link entity.element.aliveElement.Player}.
	 */
	Player
}
