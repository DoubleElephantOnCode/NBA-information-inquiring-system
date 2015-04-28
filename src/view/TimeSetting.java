package view;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSetting {

	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static int beginYear = 2010, beginMonth = 1, beginDay = 1;
	public static int endYear = 2015, endMonth = 12, endDay = 1;
	
	public final static Date begin = new Date(beginYear-1900, beginMonth-1, beginDay);
	public final static Date end = new Date(endYear-1900, endMonth-1, endDay);
	
	public final static String split = "-";
	
	public final static String startDate = "2010-01-01";
	public final static String endDate = "2015-12-01";
}
