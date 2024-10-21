package Service;

import java.sql.SQLException;

import model.Admin;

public interface AdminService {

public boolean addAdmin(Admin admin) throws SQLException;
	
public boolean validateAdmin(Admin admin) throws SQLException;
}
