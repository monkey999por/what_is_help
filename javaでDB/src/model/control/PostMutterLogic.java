package model.control;

import dao.MutterDAO;
import model.Mutter;

public class PostMutterLogic {
	public void excute(Mutter mutter) {
		MutterDAO mutterDAO=new MutterDAO();
		mutterDAO.create(mutter);
	}
}
