package model;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 测试读出数据的部分
 * @author zsk
 *
 */
public class GetInfoTest {
	public void getInfo(){
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/info/Aaron Brooks"));
			String data = br.readLine();
			while(data != null){
				System.out.println(data);
				data = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		(new GetInfoTest()).getInfo();
	}
}
