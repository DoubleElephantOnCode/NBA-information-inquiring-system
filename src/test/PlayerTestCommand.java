package test;

/**
 * 
 * @author HalaWKS
 * @date 2015年4月2日 下午8:06:31
 *
 */
public class PlayerTestCommand {

	/**
	 * 是否为计算平均数值
	 */
	boolean isAvg = true;
	
	/**
	 * 是否要求所有球员的数据
	 */
	boolean isAll = true;
	
	/**
	 * 默认筛选球员的数量
	 */
	int number = 50;
	
	public PlayerTestCommand() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 解析输入的命令
	 * @param command
	 */
	public void analysisCommand(String[] command){
		
		for(int i = 0; i < command.length; i++){
			if(command[i].contains("total")){
				
			}
		}
		
	}
	
	
}
