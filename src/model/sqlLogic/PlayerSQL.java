package model.sqlLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.readData.ReadPlayerData;

public class PlayerSQL {

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
	
	
	
	public PlayerSQL() {
		// TODO Auto-generated constructor stub
		
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "select * from players";
			
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 插入一条球员信息
	 * ('姓名', '号码', '位置', '身高', '体重', '生日', '年龄', '球龄', '学校')
	 * ('WKS', '4', 'DMF', '1.75', '75kg', '1995-10-12', '19', '5', 'NJU')
	 * @param playerInfo
	 */
	public void insertPlayerInfo(String name, String number, String position, String height,
			String weight, String birthday, String age, String exp, String school){
		
		name = dealWithString(name);
		school = dealWithString(school);
		
		String playerInfo = "('" + name + "', '" + number + "', '" + position + "', '" + height +
				"', '" + weight + "', '" + birthday + "', '" + age + "', '" + exp + "', '" +
				school + "')";
		System.out.println(playerInfo);
		String sqlCommand = "INSERT INTO `nba`.`players` (`Name`, `Number`, `Position`, `Height`, `Weight`, `Birth`, `Age`, `Exp`, `School`) VALUES " + playerInfo;
		
		//检查是否链接上数据库
		if(conn == null){
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sqlCommand);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deletAll(){
		String sqlCommand = "truncate table nba.players";
		Statement statement;
		try {
			statement = conn.createStatement();	
			statement.executeUpdate(sqlCommand);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String dealWithString(String s){
		String[] temp = s.split("'");
		if(temp.length > 1){
			String s1 = temp[0] + "\\'" + temp[1];
			System.out.println(s1);
			return s1;
		}
		return s;
	}
	
	public void createPlayerTable(){
		String sqlCmd = "CREATE TABLE `nba`.`new_table` ("
				+ "`Name` VARCHAR(45) NOT NULL,"
				+ "`Number` VARCHAR(45) NOT NULL,"
				+ "`Position` VARCHAR(45) NOT NULL,"
				+ "`Height` VARCHAR(45) NOT NULL,"
				+ "`Weight` VARCHAR(45) NOT NULL,"
				+ "`Birth` VARCHAR(45) NOT NULL,"
				+ "`Age` VARCHAR(45) NOT NULL,"
				+ "`Exp` VARCHAR(45) NOT NULL,"
				+ "`School` VARCHAR(200) NOT NULL,"
				+ "PRIMARY KEY (`Name`));";
	}
	
	public static void main(String[] args) {
		ReadPlayerData readPlayer = new ReadPlayerData();
		readPlayer.readPlayerData();
//		PlayerSQL sql = new PlayerSQL();
//		sql.deletAll();
	}
}
