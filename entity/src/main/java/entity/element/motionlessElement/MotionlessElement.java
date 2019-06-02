package entity.element.motionlessElement;

import entity.Map;
import entity.element.Element;
import entity.element.Position;

/**
 * <h1>The class MotionlessElement</h1>
 * It is used for non-moving elements
 *
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public abstract class MotionlessElement extends Element {
	/**
	 * The constructor
	 * @param map
	 * 				The map.
	 * @param position
	 * 				The location of the motionless element.
	 */
	public MotionlessElement(Map map, Position position){
		super(map, position);
	}
}
