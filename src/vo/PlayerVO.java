package vo;

import java.util.ArrayList;


/**
 * 
 * @author HalaWKS
 * @date 2015年3月9日 下午4:21:51
 *
 */
public class PlayerVO {
	
	/**
	 * 球员全身照(图片路径)
	 */
	String action = "D:/data/players/action/";
	
	/**
	 * 球员半身照(图片路径)
	 */
	String portrait = "D:/data/players/portrait/";
	
	/**
	 * 球员姓名
	 */
	String name;
	
	/**
	 * 球员号码
	 */
	String number;
	
	/**
	 * 球员位置
	 */
	String position;
	
	/**
	 * 球员身高
	 */
	String height;
	
	/**
	 * 球员体重
	 */
	String weight;
	
	/**
	 * 球员生日
	 */
	String birthday;
	
	/**
	 * 球员年龄
	 */
	String age;
	
	/**
	 * 球员球龄
	 */
	String exp;
	
	/**
	 * 毕业学校
	 */
	String school;
	
	/**
	 * 球员单场数据列表
	 */
	ArrayList<PlayerDataPerMatchVO> dataPerMatchList;
	
	/**
	 * 两双次数(得分，篮板，助攻，抢断，盖帽中任何两项)
	 */
	int doubleDouble;
	
	/**
	 * 场均上场时间
	 */
	String aveMinutes;
	
	/**
	 * 场均投篮命中数
	 */
	double aveScoreNum;
	
	/**
	 * 场均投篮出手数
	 */
	double aveShootNum;
	
	/**
	 * 场均三分命中数
	 */
	double aveThreePointerScoreNum;
	
	/**
	 * 场均三分出手数
	 */
	double aveThreePointerShootNum;
	
	/**
	 * 场均罚球命中数
	 */
	double aveFreeThrowScoreNum;
	
	/**
	 * 场均罚球出手数
	 */
	double aveFreeThrowShootNum;
	
	/**
	 * 场均进攻篮板数
	 */
	double aveOffensiveReboundsNum;
	
	/**
	 * 场均防守篮板数
	 */
	double aveDefensiveReboundsNum;
	
	/**
	 * 场均总篮板数
	 */
	double aveTotalReboundsNum;
	
	/**
	 * 场均助攻数
	 */
	double aveAssistNum;
	
	/**
	 * 场均盖帽数
	 */
	double aveBlockNum;

	/**
	 * 场均失误数
	 */
	double aveFaultNum;
	
	/**
	 * 场均犯规数
	 */
	double aveFoulNum;
	
	/**
	 * 场均个人得分
	 */
	double avePersonalPoints;
	
	public PlayerVO() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayerVO(String name, String number, String position, String height, String weight,
			String birthday, String age, String exp, String school) {
		// TODO Auto-generated constructor stub
		dataPerMatchList = new ArrayList<PlayerDataPerMatchVO>();
		
		action = action + name;
		portrait = portrait + name;
		
		this.name = name;
		this.number = number;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.age = age;
		this.exp = exp;
		this.school = school;
		
	}

	/**
	 * 统计该球员赛季单场数据(向数据列表中添加一条数据)
	 */
	public void addDataPerMatchList(MatchDataPerPlayerVO matchData) {
		//TODO 正在想办法
		PlayerDataPerMatchVO dataPerMatch = new PlayerDataPerMatchVO(matchData);
		dataPerMatchList.add(dataPerMatch);
	}

	/**
	 * 计算两双次数、各种场均数据
	 */
	public void setDoubleDouble() {
		//TODO
		doubleDouble = 0;
		for (PlayerDataPerMatchVO pvo : dataPerMatchList){
			if(pvo.isDoubleDouble){
				//两双次数
				doubleDouble++;
			}
			//总上场时间
			
		}
	}

	public void setAveMinutes(String aveMinutes) {
		this.aveMinutes = aveMinutes;
	}

	public void setAveScoreNum(double aveScoreNum) {
		this.aveScoreNum = aveScoreNum;
	}

	public void setAveShootNum(double aveShootNum) {
		this.aveShootNum = aveShootNum;
	}

	public void setAveThreePointerScoreNum(double aveThreePointerScoreNum) {
		this.aveThreePointerScoreNum = aveThreePointerScoreNum;
	}

	public void setAveThreePointerShootNum(double aveThreePointerShootNum) {
		this.aveThreePointerShootNum = aveThreePointerShootNum;
	}

	public void setAveFreeThrowScoreNum(double aveFreeThrowScoreNum) {
		this.aveFreeThrowScoreNum = aveFreeThrowScoreNum;
	}

	public void setAveFreeThrowShootNum(double aveFreeThrowShootNum) {
		this.aveFreeThrowShootNum = aveFreeThrowShootNum;
	}

	public void setAveOffensiveReboundsNum(double aveOffensiveReboundsNum) {
		this.aveOffensiveReboundsNum = aveOffensiveReboundsNum;
	}

	public void setAveDefensiveReboundsNum(double aveDefensiveReboundsNum) {
		this.aveDefensiveReboundsNum = aveDefensiveReboundsNum;
	}

	public void setAveTotalReboundsNum(double aveTotalReboundsNum) {
		this.aveTotalReboundsNum = aveTotalReboundsNum;
	}

	public void setAveAssistNum(double aveAssistNum) {
		this.aveAssistNum = aveAssistNum;
	}

	public void setAveBlockNum(double aveBlockNum) {
		this.aveBlockNum = aveBlockNum;
	}

	public void setAveFaultNum(double aveFaultNum) {
		this.aveFaultNum = aveFaultNum;
	}

	public void setAveFoulNum(double aveFoulNum) {
		this.aveFoulNum = aveFoulNum;
	}

	public void setAvePersonalPoints(double avePersonalPoints) {
		this.avePersonalPoints = avePersonalPoints;
	}

	public String getAction() {
		return action;
	}

	public String getPortrait() {
		return portrait;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getPosition() {
		return position;
	}

	public String getHeight() {
		return height;
	}

	public String getWeight() {
		return weight;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getAge() {
		return age;
	}

	public String getExp() {
		return exp;
	}

	public String getSchool() {
		return school;
	}

	public ArrayList<PlayerDataPerMatchVO> getDataPerMatchList() {
		return dataPerMatchList;
	}

	public int getDoubleDouble() {
		return doubleDouble;
	}

	public String getAveMinutes() {
		return aveMinutes;
	}

	public double getAveScoreNum() {
		return aveScoreNum;
	}

	public double getAveShootNum() {
		return aveShootNum;
	}

	public double getAveThreePointerScoreNum() {
		return aveThreePointerScoreNum;
	}

	public double getAveThreePointerShootNum() {
		return aveThreePointerShootNum;
	}

	public double getAveFreeThrowScoreNum() {
		return aveFreeThrowScoreNum;
	}

	public double getAveFreeThrowShootNum() {
		return aveFreeThrowShootNum;
	}

	public double getAveOffensiveReboundsNum() {
		return aveOffensiveReboundsNum;
	}

	public double getAveDefensiveReboundsNum() {
		return aveDefensiveReboundsNum;
	}

	public double getAveTotalReboundsNum() {
		return aveTotalReboundsNum;
	}

	public double getAveAssistNum() {
		return aveAssistNum;
	}

	public double getAveBlockNum() {
		return aveBlockNum;
	}

	public double getAveFaultNum() {
		return aveFaultNum;
	}

	public double getAveFoulNum() {
		return aveFoulNum;
	}

	public double getAvePersonalPoints() {
		return avePersonalPoints;
	}

	
	
	
}
