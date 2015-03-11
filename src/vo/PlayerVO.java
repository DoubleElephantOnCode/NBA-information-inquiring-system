package vo;

import java.io.File;
import java.util.ArrayList;

import constant.FilePath;


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
	private String action = FilePath.fileName + "/players/action/";
	
	/**
	 * 球员半身照(图片路径)
	 */
	private String portrait = FilePath.fileName + "/players/portrait/";
	
	/**
	 * 球员姓名
	 */
	private String name;
	
	/**
	 * 球员号码
	 */
	private String number;
	
	/**
	 * 球员位置
	 */
	private String position;
	
	/**
	 * 球员身高
	 */
	private String height;
	
	/**
	 * 球员体重
	 */
	private String weight;
	
	/**
	 * 球员生日
	 */
	private String birthday;
	
	/**
	 * 球员年龄
	 */
	private String age;
	
	/**
	 * 球员球龄
	 */
	private String exp;
	
	/**
	 * 毕业学校
	 */
	private String school;
	
	/**
	 * 球员单场数据列表
	 */
	private ArrayList<PlayerDataPerMatchVO> dataPerMatchList;
	
	/**
	 * 两双次数(得分，篮板，助攻，抢断，盖帽中任何两项)
	 */
	private int doubleDouble = 0;
	
	/**
	 * 场均上场时间
	 */
	private String aveMinutes;
	
	/**
	 * 场均投篮命中数
	 */
	private double aveScoreNum = 0;
	
	/**
	 * 场均投篮出手数
	 */
	private double aveShootNum = 0;
	
	/**
	 * 场均三分命中数
	 */
	private double aveThreePointerScoreNum = 0;
	
	/**
	 * 场均三分出手数
	 */
	private double aveThreePointerShootNum = 0;
	
	/**
	 * 场均罚球命中数
	 */
	private double aveFreeThrowScoreNum = 0;
	
	/**
	 * 场均罚球出手数
	 */
	private double aveFreeThrowShootNum = 0;
	
	/**
	 * 场均进攻篮板数
	 */
	private double aveOffensiveReboundsNum = 0;
	
	/**
	 * 场均防守篮板数
	 */
	private double aveDefensiveReboundsNum = 0;
	
	/**
	 * 场均总篮板数
	 */
	private double aveTotalReboundsNum = 0;
	
	/**
	 * 场均助攻数
	 */
	private double aveAssistNum = 0;
	
	/**
	 * 场均抢断数
	 */
	private double aveStealNum = 0;
	
	/**
	 * 场均盖帽数
	 */
	private double aveBlockNum = 0;

	/**
	 * 场均失误数
	 */
	private double aveTurnoverNum = 0;
	
	/**
	 * 场均犯规数
	 */
	private double aveFoulNum = 0;
	
	/**
	 * 场均个人得分
	 */
	private double avePersonalPoints = 0;
	
	//计算场均数据
	private double scoreNum = 0;
	private double shootNum = 0;
	private double threePointerScoreNum = 0;
	private double threePointerShootNum = 0;
	private double freeThrowScoreNum = 0;
	private double freeThrowShootNum = 0;
	private double offensiveReboundsNum = 0;
	private double defensiveReboundsNum = 0;
	private double totalReboundsNum = 0;
	private double assistNum = 0;
	private double stealNum = 0;
	private double blockNum = 0;
	private double turnoverNum = 0;
	private double foulNum = 0;
	private double personalPoints = 0;
	
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
		//TODO
		PlayerDataPerMatchVO pvo = new PlayerDataPerMatchVO(matchData);
		dataPerMatchList.add(pvo);
		
		//两双次数
		if(pvo.isDoubleDouble()){
			doubleDouble++;
		}
		//总投篮命中数
		scoreNum = scoreNum + pvo.getScoreNum();
		//总出手数
		shootNum = shootNum + pvo.getShootNum();
		//总三分命中数
		threePointerScoreNum = threePointerScoreNum + pvo.getThreePointerScoreNum();
		//总三分出手数
		threePointerShootNum = threePointerShootNum + pvo.getThreePointerShootNum();
		//总罚球命中数
		freeThrowScoreNum = freeThrowScoreNum + pvo.getFreeThrowScoreNum();
		//总罚球出手数
		freeThrowShootNum = freeThrowShootNum + pvo.getFreeThrowShootNum();
		//总进攻篮板数
		offensiveReboundsNum = offensiveReboundsNum + pvo.getOffensiveReboundsNum();
		//总防守篮板数
		defensiveReboundsNum = defensiveReboundsNum + pvo.getDefensiveReboundsNum();
		//总篮板数
		totalReboundsNum = totalReboundsNum + pvo.getTotalReboundsNum();
		//总助攻数
		assistNum = assistNum + pvo.getAssistNum();
		//总抢断数
		stealNum = stealNum + pvo.getStealNum();
		//总盖帽数
		blockNum = blockNum + pvo.getBlockNum();
		//总犯规数
		turnoverNum = turnoverNum + pvo.getTurnoverNum();
		//总失误数
		foulNum = foulNum + pvo.getFoulNum();
		//个人总得分
		personalPoints = personalPoints + pvo.getPersonalPoints();
		
		
	}

	/**
	 * 计算场均数据
	 */
	public void calAveData(){
		double matchNum = dataPerMatchList.size();
		
		aveScoreNum = scoreNum / matchNum;
		aveShootNum = shootNum / matchNum;
		aveThreePointerScoreNum = threePointerScoreNum / matchNum;
		aveThreePointerShootNum = threePointerShootNum / matchNum;
		aveFreeThrowScoreNum = freeThrowScoreNum / matchNum;
		aveFreeThrowShootNum = freeThrowShootNum / matchNum;
		aveOffensiveReboundsNum = offensiveReboundsNum / matchNum;
		aveDefensiveReboundsNum = defensiveReboundsNum / matchNum;
		aveTotalReboundsNum = totalReboundsNum / matchNum;
		aveAssistNum = assistNum / matchNum;
		aveStealNum = stealNum / matchNum;
		aveBlockNum = blockNum / matchNum;
		aveTurnoverNum = turnoverNum / matchNum;
		aveFoulNum = foulNum / matchNum;
		avePersonalPoints = personalPoints / matchNum;
	}
	
	/**
	 * 获取球员全身照
	 * @return
	 */
	public File getPlayerAction(){
		File actionFile = new File(action);
		return actionFile;
	}
	
	/**
	 * 获取球员半身照
	 * @return
	 */
	public File getPlayerPortrait(){
		File portraitFile = new File(portrait);
		return portraitFile;
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

	public double getAveTurnoverNum() {
		return aveTurnoverNum;
	}

	public void setAveTurnoverNum(double aveTurnoverNum) {
		this.aveTurnoverNum = aveTurnoverNum;
	}

	public double getAveFoulNum() {
		return aveFoulNum;
	}

	public double getAvePersonalPoints() {
		return avePersonalPoints;
	}

	public double getAveStealNum() {
		return aveStealNum;
	}

	public void setAveStealNum(double aveStealNum) {
		this.aveStealNum = aveStealNum;
	}

	
	
	
}
