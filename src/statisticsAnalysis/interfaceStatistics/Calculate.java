package statisticsAnalysis.interfaceStatistics;

import java.util.ArrayList;

public class Calculate {
	CalF c;
	double alpha = 0.1;
	public Calculate(){
		c = new CalF();
	}
	public double calAve(ArrayList<Double> dataArr){
		double sum = 0;
		for(int i=0;i<dataArr.size();i++){
			sum+=dataArr.get(i);
		}
		return sum/(double)dataArr.size();
	}
	
	public double calVar(ArrayList<Double> dataArr){
		double ave = calAve(dataArr);
		double sum = 0;
		for(int i=0;i<dataArr.size();i++){
			sum+=(dataArr.get(i)-ave)*(dataArr.get(i)-ave);
		}
		return sum/((double)dataArr.size()-1);
	}
	
	public int compareVar(ArrayList<Double> dataArr1,ArrayList<Double> dataArr2){
		double var1 = calVar(dataArr1);
		double var2 = calVar(dataArr2);
		double low = var1/var2/getF(alpha/2.0,dataArr1.size()-1,dataArr2.size()-1);
		double high = var1/var2/getF(1-alpha/2.0,dataArr1.size()-1,dataArr2.size()-1);
		if(low>1){
			return 1;
		}else if(high<1){
			return -1;
		}else{
			return 0;
		}
	}
	
	public double getF(double alpha,int free1,int free2){
		return c.fdistinv(1-alpha, free1, free2);
	}
	
	public int compareAve(ArrayList<Double> dataArr1,ArrayList<Double> dataArr2){
		double ave1 = calAve(dataArr1);
		double ave2 = calAve(dataArr2);
		
		double var1 = calVar(dataArr1);
		double var2 = calVar(dataArr2);
		
		double temp = Math.sqrt(var1/(double)dataArr1.size()+var2/(double)dataArr2.size());
		double low = ave1 - ave2 + temp*getN(alpha/2.0);
		double high = ave1 - ave2 + temp*getN(alpha/2.0);
		
		if(low>0){
			return 1;
		}else if(high<0){
			return -1;
		}else{
			return 0;
		}
	}
	
	public double getN(double alpha){
		if(alpha == 0.05){
			return 1.64485;
		}else if(alpha == 0.025){
			return 1.95996;
		}else if(alpha == 0.10){
			return 1.28155;
		}
		System.out.println("error in Calculate getN");
		return 0 ;
		
	}
	
	
}
