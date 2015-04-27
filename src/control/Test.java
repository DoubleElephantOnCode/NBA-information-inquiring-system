package control;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date d = new Date(2015-1900,12-1,1);
		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		System.out.println(d.getDay());
		System.out.println(sdf.format(d));
	}
}
