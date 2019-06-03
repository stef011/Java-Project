package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.GameState;
import contract.IModel;
import entity.Map;
/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The Map. */
	private Map map;
	/** The Table of sprite references */
	private char elementSpriteRef[][];
	/** The game state */
	private GameState gameState;
	
	/**
	 * Instantiates a new model.
	 */
	public Model(String MapName) {
		this.loadMap(MapName);
		
		elementSpriteRef = new char[this.getMap().getLength()][this.getMap().getWidth()];
		for(int y=0; y<this.getMap().getWidth(); y++) {
			for(int x=0; x<this.getMap().getLength(); x++) {
				elementSpriteRef[x][y] = this.loadElementSpriteRef(this.getMap().getId(), x, y);
			}
		}
		map = new Map(this.getMap(), elementSpriteRef);
	}

	/**
     * Gets the map.
     *
     * @return the Map
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
     * Sets the Map.
     *
     * @param map
     *            the new map
     */
	public void setMap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}
	

	/**
     * Load map.
     *
     * @param name
     *            The name of the map
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

	public GameState getGameState() {
		return this.gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
}
