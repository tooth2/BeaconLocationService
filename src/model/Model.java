package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import model.PositionDAO;
import databeans.Position;

public class Model {

    private PositionDAO positionDAO;

    public Model(ServletConfig config) throws ServletException {
        try {
            String jdbcDriver = config.getInitParameter("jdbcDriverName");
            String jdbcURL    = config.getInitParameter("jdbcURL");
            
            ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);

            positionDAO = new PositionDAO("Position", pool);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

    
	public PositionDAO getPositionDAO() {
		return positionDAO;
	}
}
