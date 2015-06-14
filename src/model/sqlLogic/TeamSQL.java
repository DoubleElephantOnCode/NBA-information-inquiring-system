package model.sqlLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.dataLogic.TeamList;
import vo.TeamVO;
import constant.FilePath;

public class TeamSQL {
	/**
	 * 驱动程序名
	 */
	private static String driver = "com.mysql.jdbc.Driver";

	/**
	 * URL指向要访问的数据库名scutcs
	 */
	private static String url = "jdbc:mysql://127.0.0.1:3306/nba";

	/**
	 * MySQL配置时的用户名
	 */
	private static String user = "root";

	/**
	 * MySQL配置时的密码
	 */
	private static String password = "951012";

	/**
	 * 链接数据库
	 */
	private Connection conn;
	
	public TeamSQL(){
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void readTeamInfoToSql(){
		File teamFile = new File(FilePath.teamPath+"/teams");
		InputStreamReader insReader =null;
		BufferedReader reader = null;
		String tempString=null;
		try{
			insReader =  new InputStreamReader(new FileInputStream(teamFile) ,"UTF-8");
			reader = new BufferedReader(insReader);
			int i =0;
			while((tempString = reader.readLine())!=null){
				if(tempString.charAt(2)=='═'){
					continue;
				}
				tempString = tempString.substring(1, tempString.length()-1);
				//tempString.replace("║", "");
				String[] strings = tempString.split("│");
				addTeam(strings[0].trim(), strings[1].trim(), strings[2].trim(), strings[3].trim(), strings[4].trim(), strings[5].trim(), strings[6].trim());
				
			}
		}catch(IOException exception){

		}
	}
	
	public void addTeam(String name, String abbreviation, String location,
			String competion, String partition, String homeCourt,
			String buildTime){
		if(conn == null){
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 要执行的SQL语句
        String sql = "INSERT INTO `nba`.`team` (`teamName`, `Abbreviation`, `location`, `competion`, `partition`, `homecourt`, `buildtime`) VALUES ";
		String TeamInfo = "('" + name + "', '" + abbreviation + "', '" + location + "', '" + competion +
				"', '" + partition + "', '" + homeCourt + "', '" + buildTime +  "')";
        
		 try { 
		// statement用来执行SQL语句
	        Statement statement = conn.createStatement();
	        statement.executeUpdate(sql+TeamInfo);
        
		 } catch (Exception e) {
				e.printStackTrace();
		}		 
	}
	
	public void deletAll(){
		String sqlCommand = "truncate table nba.team";
		Statement statement;
		try {
			statement = conn.createStatement();	
			statement.executeUpdate(sqlCommand);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void readTeam(){
		String sqlCommand = "select * from nba.team";
		try{
			Statement statement= conn.createStatement();
			ResultSet rs = statement.executeQuery(sqlCommand);
			while (rs.next()){
				//TODO 改成加到TeamList中
				TeamVO teamVO =new TeamVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				TeamList.addTeamVO(teamVO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
