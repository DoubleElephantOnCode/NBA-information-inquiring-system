package constant;

/**
 * 
 * @author HalaWKS
 * @date 2015年3月12日 上午12:03:38
 *
 */
public class FilePath {
	public static  String path = "D:/data";
	public static  String matchPath = path+"/matches";
	public static  String playerActionPath = path+"/players/action/";
	public static  String playerInfoPath = path+"/players/info";
	public static  String playerPortaitPath = path+"/players/portrait/";
	public static  String teamPath = path+"/teams";
	public static  void changePath(String path2){
		 path = path2;
		 matchPath = path+"/matches";
		 playerActionPath = path+"/players/action/";
		 playerInfoPath = path+"/players/info";
		 playerPortaitPath = path+"/players/portrait/";
		 teamPath = path+"/teams";
	}
}
