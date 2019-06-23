
package model.control;

import java.util.List;

import dao.MutterDAO;
import model.Mutter;

public class GetMutterLogic {
	public List<Mutter> excute() {
		MutterDAO mutterDAO=new MutterDAO();
		List<Mutter> mutterList= mutterDAO.findAll();
		return mutterList;
	}
}
