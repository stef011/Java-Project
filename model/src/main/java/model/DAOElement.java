package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.element.Element;

public class DAOElement extends DAOEntity<Element> {

	public DAOElement(Connection connection) throws SQLException {
		super(connection);
	}

	@Override
	public boolean create(Element entity) {
		// Not implemented
		return false;
	}

	@Override
	public boolean delete(Element entity) {
		// Not implemented
		return false;
	}

	@Override
	public boolean update(Element entity) {
		// Not implemented
		return false;
	}

	public char find(int id_map, int x, int y) {
		char elementSprite_ref = '_';
		
		try {
			final String sql = "{call getElementByXY(?, ?, ?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id_map);
			call.setInt(2, x);
			call.setInt(3, y);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if(resultSet.first()) {
				elementSprite_ref = resultSet.getString("sprite_ref").charAt(0);
			}
			return elementSprite_ref;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return elementSprite_ref;
	}

	@Override
	public Element find(String code) {
		// Not implemented
		return null;
	}

	@Override
	public Element find(int id) {
		// Not implemented
		return null;
	}

}
