package contract;


public interface IMap {
	IMap getMap();
	void loadMap(String name);
	String getName();
	int getId();
	int getWidth();
	int getLength();
	int getGoal();
}
