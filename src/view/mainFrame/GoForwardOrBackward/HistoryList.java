package view.mainFrame.GoForwardOrBackward;

import java.util.ArrayList;

public class HistoryList {

	ArrayList<InformationForHistory> list;
	int pointer = -1;
	
	public static boolean inWay = false;//点击方式为非前进后退为false, 是通过前进后退进入的为true
	
	public HistoryList(){
		list = new ArrayList<InformationForHistory>();
		pointer = -1;
	}
	
	public void add(InformationForHistory item){
		if(inWay){//由前进后退进入的不需要add
			inWay = false;
		}
		else{
			clearAfterPointer();
			list.add(item);
			pointer++;
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
