package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Databases;

public class DatabasesDao {

	private Connection c;
	
	public DatabasesDao() {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	public List<Databases> listaDb() throws SQLException{
		List<Databases> lista = new ArrayList<Databases>();
		String sql = "SELECT dbid, name, CONVERT(CHAR(10), crdate, 103) AS crdate FROM sys.sysdatabases";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Databases db = new Databases();
			db.setId(rs.getInt("dbid"));
			db.setName(rs.getString("name"));
			db.setCrdate(rs.getString("crdate"));
			lista.add(db);
		}
		ps.close();
		rs.close();
		return lista;
	}
	
	public Databases Db(int dbid) throws SQLException{
		Databases db = new Databases();
		String sql = "SELECT dbid, name, CONVERT(CHAR(10), crdate, 103) AS crdate FROM sys.sysdatabases WHERE dbid = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, dbid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			db.setId(rs.getInt("dbid"));
			db.setName(rs.getString("name"));
			db.setCrdate(rs.getString("crdate"));
		}
		ps.close();
		rs.close();
		return db;
	}
}
