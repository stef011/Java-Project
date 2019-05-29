package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Map;
/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private Map map;
	private char elementSpriteRef[][];

	/**
	 * Instantiates a new model.
	 */
	public Model(String MapName) {
		this.map = new Map();
		this.loadMap(MapName);
		
		elementSpriteRef = new char[this.getMap().getLength()][this.getMap().getWidth()];
		for(int y=0; y<this.getMap().getWidth(); y++) {
			for(int x=0; x<this.getMap().getLength(); x++) {
				elementSpriteRef[x][y] = this.loadElementSpriteRef(this.getMap().getId(), x, y);
			}
		}
		map = new Map(this.getMap(), elementSpriteRef);
		
		// Test
		for(int y=0; y<this.getMap().getWidth(); y++) {
			for(int x=0; x<this.getMap().getLength(); x++) {
				System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getSprite_ref());
			}
			System.out.print("\n");
		}
		// Test
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Map getMap() {
		return this.map;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setMap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(final String name) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.find(name));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	public char loadElementSpriteRef(int id_map, int x, int y) {
		try {
			final DAOElement daoElement = new DAOElement(DBConnection.getInstance().getConnection());
			return daoElement.find(id_map, x, y);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return '_';
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

}
