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
	
	public ScoreVO(int former,int latter){
		this.former = former;
		this.latter = latter;
	}
}
