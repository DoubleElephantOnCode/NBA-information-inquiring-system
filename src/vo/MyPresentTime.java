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
	
	public MyPresentTime minus(MyPresentTime anotherTime){
		int tempSecond = 0;
		int tempMinute = 0;
		if(second >= anotherTime.second){
			tempSecond = second - anotherTime.second;
			tempMinute = minute - anotherTime.minute;
		}else{
			tempSecond = 60 + second - anotherTime.second;
			tempMinute = minute - anotherTime.minute - 1;
		}
		return new MyPresentTime(tempMinute, tempSecond);
	}
	
	/**
	 * 得到以秒为单位的时间
	 * @return
	 */
	public int getTimeBySecond(){
		return minute*60 + second;
	}
	
	/**
	 * 得到以分钟为单位的时间
	 * @return
	 */
	public double getTimeByMinute(){
		return minute + second/60.0;
	}
	
	public boolean equals(MyPresentTime anotherTime){
		if(second == anotherTime.second && minute == anotherTime.minute){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 把double形式的时间转换成“分：秒”
	 * @param timeOfMinutes 若干分钟（double形）
	 * @return
	 */
	public static MyPresentTime toTimeFormat(double timeOfMinutes){
		String time = Double.toString(timeOfMinutes);
//		System.out.println("time = " + time);
		String[] timeStr = time.split("\\.");
		int min = Integer.parseInt(timeStr[0]);
		String second = Double.toString(Double.parseDouble("0." + timeStr[1]) * 60).split("\\.")[0];
		int sec = Integer.parseInt(second);
		return new MyPresentTime(min, sec);
	}

}
