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
	String birth;
	
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
	
	
	public PlayerVO(String name) {
		// TODO Auto-generated constructor stub
		action = action + name;
		portrait = portrait + name;
		
	}
	
	
	
	
}
