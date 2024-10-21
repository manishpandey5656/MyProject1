package dao;

import java.sql.SQLException;

import model.Admin;
public interface AdminDao {

	public boolean addAdmin(Admin admin)throws SQLException;
	
	public boolean validateAdmin(Admin admin) throws SQLException;
}
