package test;

import java.io.PrintStream;
import java.util.ArrayList;

import model.dataLogic.PlayerList;
import model.dataLogic.SelectPlayer;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import vo.PlayerVO;

/**
 * 
 * @author HalaWKS
 * @date 2015年4月2日 下午8:06:31
 * 
 */
public class PlayerTestCommand {

	/**
	 * 是否为计算平均数值（默认为true）
	 */
	boolean isAvg = true;

	/**
	 * 是否要求所有球员的数据（默认为true）
	 */
	boolean isAll = true;

	/**
	 * 是否要求热点（进步最快）
	 */
	boolean isHot = false;
	
	/**
	 * 是否要求数据王
	 */
	boolean isKing = false;
	
	/**
	 * 是否升序排列
	 */
	boolean isPositiveSequence = false;

	/**
	 * 是否要求基本数据（默认为true）
	 */
	boolean isBasic = true;
	
	/**
	 * 是否要求赛季数据（默认为true）
	 */
	boolean isSeason = true;

	/**
	 * 筛选球员的数量（默认为50）
	 */
	int selectNum = 50;
	
	/**
	 * 筛选热点球员数量（默认为5）
	 */
	int kingOrHotNum = 5;
	
	/**
	 * 筛选热点球员(进步最快)依据（默认为0）
	 */
	int selectHotField = 0;
	
	/**
	 * 筛选热点球员(进步最快)依据
	 */
	String hotField = "";
	
	/**
	 * 筛选数据王依据（默认为0）
	 */
	int selectKingField = 0;
	
	/**
	 * 筛选数据王依据
	 */
	String kingField = "";
	
	/**
	 * 球员排序依据（默认看情况，基础数据或者高阶数据不一样）
	 */
	String sortFiled = "";
	
	/**
	 * 筛选的球员位置（默认为ALL）
	 */
	String position = "ALL";
	
	/**
	 * 筛选的球员联盟（默认为ALL）
	 */
	String league = "ALL";
	
	/**
	 * 筛选的球员年龄
	 */
	String age = "ALL";
	
	/**
	 * 排序依据List
	 */
	ArrayList<SortFieldAndOrder> sortList = new ArrayList<SortFieldAndOrder>();
	
	
	PlayerHotInfo playerHotInfo = new PlayerHotInfo();
	PlayerHighInfo playerHighInfo = new PlayerHighInfo();
	PlayerKingInfo playerKingInfo = new PlayerKingInfo();
	PlayerNormalInfo playerNormalInfo = new PlayerNormalInfo();
	
	public PlayerTestCommand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 解析输入的命令
	 * 
	 * @param command
	 */
	public void analysisCommand(PrintStream out, String[] command) {
		//解析分析命令
		
		for (int i = 1; i < command.length;) {
			i = analysisString(command, i);
		}
		
		if(sortList.size() == 0){
			SortFieldAndOrder defaultOrder = new SortFieldAndOrder(28, isPositiveSequence);
			this.sortList.add(defaultOrder);
		}

		if(isAll){	//全部球员进行筛选
			if(isBasic){	//基础数据
				ArrayList<PlayerVO> playerList = SelectPlayer.selectPlayerForTest(
						PlayerList.getPlayers(), position, league, age, sortList);
				if(isAvg){	//场均数据
					System.out.println("hehe1");
					for (int i = 0; i < selectNum && i < playerList.size(); i++) {
						playerNormalInfo = playerList.get(i).getNormalAvgInfo();
						out.println(i+1);
						out.print(playerNormalInfo.toString());
					}
				} else {
					for (int i = 0; i < selectNum && i < playerList.size(); i++) {
						playerNormalInfo = playerList.get(i).getNormalAllInfo();
						out.println(i+1);
						out.print(playerNormalInfo.toString());
					}
				}
			} else {	//高阶数据
				ArrayList<PlayerVO> playerList = SelectPlayer.selectPlayerForTest(
						PlayerList.getPlayers(), position, league, age, sortList);
				for (int i = 0; i < selectNum && i < playerList.size(); i++) {
					playerHighInfo = playerList.get(i).getHighInfo();
					out.println(i+1);
					out.print(playerHighInfo.toString());
				}
			}
			
		} else if(isHot){	//进步最快球员筛选
			ArrayList<PlayerVO> playerList = SelectPlayer.selectProgressPlayer(
					PlayerList.getPlayers(), selectHotField);
			for (int i = 0; i < kingOrHotNum && i < playerList.size(); i++) {
				playerHotInfo = playerList.get(i).getHotInfo(hotField);
				out.println(i+1);
				out.print(playerHotInfo.toString());
			}
		} else {	//数据王球员筛选
			ArrayList<PlayerVO> playerList = SelectPlayer.selectHotPlayers(
					PlayerList.getPlayers(), isSeason, selectKingField);
			for (int i = 0; i < kingOrHotNum && i < playerList.size(); i++) {
				playerKingInfo = playerList.get(i).getKingInfo(kingField);
				out.println(i+1);
				out.print(playerKingInfo.toString());
			}
		}

	}

	private int analysisString(String[] command, int i) {

		switch (command[i]) {
		case "-avg":
			i++;
			isAvg = true;
			return i;
		case "-total":
			i++;
			isAvg = false;
			return i;
		case "-all":
			i++;
			isAll = true;
			isHot = false;
			isKing = false;
			return i;
		case "-hot":
			i++;
			isAll = false;
			isHot = true;
			isKing = false;
			setSelectHotPlayerField(command[i]);
			i++;
			return i;
		case "-king":
			i++;
			isAll = false;
			isHot = false;
			isKing = true;
			setSelectKingPlayerField(command[i]);
			i++;
			return i;
		case "-season":
			i++;
			isSeason = true;
			return i;
		case "-daily":
			i++;
			isSeason = false;
			return i;
		case "-n":
			i++;
			setSelectNum(command[i]);
			i++;
			return i;
		case "-high":
			i++;
			isBasic = false;
			return i;
		case "-filter":
			i++;
			setFilterPlayerField(command[i]);
			i++;
			return i;
		case "-sort":
			i++;
			setSortPlayerField(command[i]);
			i++;
			return i;

		default:
			break;
		}

		return 0;
	}
	
	/**
	 * 设置筛选数量
	 * @param selectNumber 筛选数量
	 */
	private void setSelectNum(String selectNumber){
		this.selectNum = Integer.parseInt(selectNumber);
	}
	
	/**
	 * 设置热点球员筛选依据(根据近五场提升)
	 * @param field 筛选依据
	 */
	private void setSelectHotPlayerField(String field){
		//TODO 设置热点球员筛选依据
		this.hotField = field;
		switch (field) {
		case "score": this.selectHotField = 0; break;
		case "rebound": this.selectHotField = 1; break;
		case "assist": this.selectHotField = 2; break;
		default: break;
		}
	}
	
	/**
	 * 设置数据王球员筛选依据
	 * @param field 筛选依据
	 */
	private void setSelectKingPlayerField(String field){
		//TODO 设置数据王球员筛选依据
		this.kingField = field;
		switch (field) {
		case "score": this.selectKingField = 0; break;
		case "rebound": this.selectKingField = 1; break;
		case "assist": this.selectKingField = 2; break;
		default: break;
		}
	}
	
	/**
	 * 设置筛选球员依据
	 * @param command 命令们（field.value,多个field.value之间用","隔开）
	 */
	private void setFilterPlayerField(String command){
		String[] field_value = command.split(",");
		
		for (int j = 0; j < field_value.length; j++) {
			//分割field.value
			String[] commandSplit = field_value[j].split(".");
			String field = commandSplit[0];
			String value = commandSplit[1];
			if(field.equalsIgnoreCase("position")){	//按位置筛选
				this.position = value;
			} else if(field.equalsIgnoreCase("league")){	//按球员联盟筛选
				switch (value) {
				case "East": this.league = "E"; break;
				case "West": this.league = "W"; break;
				default: break;
				}
			} else if(field.equalsIgnoreCase("age")){		//按球员年龄筛选	
				this.age = value;
			}
		}
	}
	
	/**
	 * 设置球员排序依据
	 * @param command
	 */
	private void setSortPlayerField(String command){
		//TODO 设置球员排序依据
		String[] field_order = command.split(",");
		
		for (int i = 0; i < field_order.length; i++) {
			//分割field.value
			String[] commandSplit = field_order[i].split(".");
			String field = commandSplit[0];
			String order = commandSplit[1];
			if(order.equalsIgnoreCase("asc")){	//升序排列
				this.isPositiveSequence = true;
			} else {
				this.isPositiveSequence = false;
			}
			SortFieldAndOrder sort = new SortFieldAndOrder(
					setSortField(field), this.isPositiveSequence);
			sortList.add(sort);
		}
	}
	
	/**
	 * 设置排序依据（转化成int）
	 * @param field String类型的Field
	 */
	private int setSortField(String field){
		switch (field) {
		case "point": if(isAvg) return 28;else return 27;
		case "rebound": if(isAvg) return 9; else return 8;
		case "assist": if(isAvg) return 15; else return 14;
		case "blockShot": if(isAvg) return 22; else return 21;
		case "steal": if(isAvg) return 20; else return 19;
		case "foul": if(isAvg) return 24; else return 23;
		case "fault": if(isAvg) return 26; else return 25;
		case "minute": if(isAvg) return 7; else return 6;
		case "efficient": return 29;
		case "shot": return 16;
		case "three": return 17;
		case "penalty": return 18;
		case "doubleTwo": return 5;
		case "realShot": return 31;
		case "GmSc": return 30;
		case "shotEfficient": return 32;
		case "reboundEfficient": return 33;
		case "offendReboundEfficient": return 34;
		case "defendReboundEfficient": return 35;
		case "assistEfficient": return 36;
		case "stealEfficient": return 37;
		case "blockShotEfficient": return 38;
		case "faultEfficient": return 39;
		case "frequency": return 40;
		}
		return 0;
	}
}
