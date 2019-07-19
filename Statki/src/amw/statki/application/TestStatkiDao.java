package amw.statki.application;

import java.util.List;

import amw.statki.model.Port;
import amw.statki.model.dao.PortDao;
import amw.statki.model.dao.PortDaoImpl;

public class TestStatkiDao {

	public static void main(String[] args) {
		PortDao portDao = new PortDaoImpl();
		List<Port> lista = portDao.findAll();
		for (Port p : lista) {
			System.out.println(p);
		}

	}

}
