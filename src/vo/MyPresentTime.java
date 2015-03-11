package vo;

/**
 * 
 * @author ZSK
 * @data 2015年3月9日 下午4:38:27
 */


public class MyPresentTime{
	int minute;
	int second;
	
	/**
	 * 
	 * @param time 格式为 10:30
	 */
	public MyPresentTime(String time){
		minute = Integer.parseInt(time.split(":")[0]);
		second = Integer.parseInt(time.split(":")[1]);
	}
	
	public MyPresentTime(int second){
		this(second/60, second%60);
	}
	
	public MyPresentTime(int minute,int second){
		this.minute = minute;
		this.second = second;
	}
	
	/**
	 * 加法
	 * @param anotherTime
	 * @return
	 */
	public MyPresentTime add(MyPresentTime anotherTime){
		int tempSecond = (second + anotherTime.second)%60;
		int tempMinute = minute + anotherTime.minute + (second + anotherTime.second)/60;
		return new MyPresentTime(tempMinute, tempSecond);
	}
	
	public MyPresentTime divide(int n){
		return new MyPresentTime(getTimeBySecond()/n);
	}
	
	/**
	 * 得到以秒为单位的时间
	 * @return
	 */
	public int getTimeBySecond(){
		return minute*60 + second;
	}
}
