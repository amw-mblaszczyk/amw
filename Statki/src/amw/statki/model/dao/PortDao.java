package amw.statki.model.dao;

import java.util.Date;
import java.util.List;

import amw.statki.model.Port;
import amw.statki.model.Statek;

public interface PortDao extends Dao<Integer, Port> {
	/**
	 * Zwraca plan wejścia statków do portu.
	 * @param statki lista statków planujących wejścia
	 * @param plany daty planowanych wejść
	 * @return iloĹść planowanych wejść
	 */
	int getWejscia(List<Statek> statki, List<Date> plany);

}
