package view;

import java.util.Date;

public class TimeSetting {

	static int beginYear = 2010, beginMonth = 1, beginDay = 1;
	static int endYear = 2015, endMonth = 12, endDay = 1;
	
	static Date begin = new Date(beginYear-1900, beginMonth-1, beginDay);
	static Date end = new Date(endYear-1900, endMonth-1, endDay);
}
