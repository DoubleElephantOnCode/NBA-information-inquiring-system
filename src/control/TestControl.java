package control;

import model.GetPlayerInfo;

/**
 * 
 * @author HalaWKS
 *
 */
public class TestControl implements TestControlService{

	GetPlayerInfo getInfo;
	
	public TestControl() {
		// TODO Auto-generated constructor stub
		getInfo = new GetPlayerInfo();
	}
	
	public void showPlayerInfo(String name) {
		// TODO Auto-generated method stub
		getInfo.showPlayerInfo(name);
	}
	
	
}
