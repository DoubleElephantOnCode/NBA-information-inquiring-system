package control;

import model.readData.ReadMatchData;

/**
 * 
 * @author ZSK
 * @date 2015年4月28日 下午11:58:43
 */
public class ChangePageController {
	public void changePageToMainFrame(){
		ReadMatchData.readMatch.setCurrentView(null);
	}
}
