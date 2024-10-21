package ServiceImp;

import java.sql.SQLException;

import Service.AdminService;
 
import daoImplemet.AdminDAOImp;
import model.Admin;

public class AdminServiceImp implements AdminService {

	// add admin method
	@Override
	public boolean addAdmin(Admin admin)throws SQLException {
		return new AdminDAOImp().addAdmin(admin);
		 
	}

	/// validate admin method
	@Override
	public boolean validateAdmin(Admin admin)throws SQLException {
		 
		return new AdminDAOImp().validateAdmin(admin);
	}

}
