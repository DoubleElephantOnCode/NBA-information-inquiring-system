package vo;
/**
 * 比分类 
 * @author ZSK
 * @data 2015年3月10日 上午10:57:30
 */
public class ScoreVO {
	/**
	 * 前一个数据
	 */
	public int former;
	
	/**
	 * 后一个数据
	 */
	public int latter;
	
	/**
	 * 
	 * @param score 格式为10-20
	 */
	public ScoreVO(String score){
		former = Integer.parseInt(score.split("-")[0]);
		latter = Integer.parseInt(score.split("-")[1]);
	}
	
	public ScoreVO(int former,int latter){
		this.former = former;
		this.latter = latter;
	}
}
