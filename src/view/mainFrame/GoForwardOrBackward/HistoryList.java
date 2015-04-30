package view.mainFrame.GoForwardOrBackward;

import java.util.ArrayList;

public class HistoryList {

	ArrayList<InformationForHistory> list;
	int pointer = -1;
	
	public static boolean inWay = false;//需要add的为true，否则为false
	
	public HistoryList(){
		list = new ArrayList<InformationForHistory>();
		pointer = -1;
	}
	
	public void add(InformationForHistory item){
		if(inWay){//由用户点击响应的需要add
			clearAfterPointer();
			list.add(item);
			pointer++;
		}
		else{
			inWay = false;
		}
		
	}
	
	public void clearAfterPointer(){
		for(int i = pointer+1; i < list.size(); i++){
			list.remove(i);
		}
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public boolean isLast(){
		return (pointer == (list.size()-1));
	}
	
	public boolean isFirst(){
		return (pointer == 0);
	}
	
	public void goForwardPanel(){
		if(!isLast() && !isEmpty()){
			inWay = true;
			list.get(++pointer).openThePanel();
		}
	}
	
	public void goBackwardPanel(){
		if(!isFirst() && !isEmpty()){
			inWay = true;
			list.get(--pointer).openThePanel();
		}
	}
	
}
