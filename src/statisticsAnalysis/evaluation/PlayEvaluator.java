package statisticsAnalysis.evaluation;

/**
 * 
 * @author XYJ
 *
 */
public class PlayEvaluator {

	
public double factor1(double score, double rebound, double assist, double steal, double block, double turnover, double foul, double minute, double hitRate){
		
		double result = 0.918*score+0.157*rebound+0.819*steal-0.042*block-0.042*foul+0.864*minute-0.161*hitRate+0.275*(assist/turnover);
		
		return result;
	}
	
	public double factor2(double score, double rebound, double assist, double steal, double block, double turnover, double foul, double minute, double hitRate){
		
		double result = 0.065*score+0.805*rebound-0.312*steal+0.885*block+0.247*foul+0.187*minute+0.519*hitRate-0.249*(assist/turnover);
		
		return result;
	}
	
	public double factor3(double score, double rebound, double assist, double steal, double block, double turnover, double foul, double minute, double hitRate){
		
		double result = -0.106*score+0.231*rebound+0.178*steal+0.144*block+0.957*foul-0.061*minute+0.036*hitRate-0.068*(assist/turnover);
		
		return result;
	}
	
	public double factor4(double score, double rebound, double assist, double steal, double block, double turnover, double foul, double minute, double hitRate){
		
		double result = 0.023*score-0.206*rebound+0.222*steal-0.126*block-0.059*foul+0.218*minute-0.101*hitRate+0.917*(assist/turnover);
		
		return result;
	}
	
	public double factor5(double score, double rebound, double assist, double steal, double block, double turnover, double foul, double minute, double hitRate){
		
		double result = -0.136*score+0.291*rebound+0.232*steal+0.123*block+0.033*foul-0.168*minute+0.805*hitRate*20-0.081*(assist/turnover);
		
		return result;
	}
	
	
	public int doEvaluating(String position,double score, double rebound, double assist, double steal, double block, double turnover, double foul, double minute, double hitRate){
		
		int result = 0;
		
		double factor1 = factor1(score, rebound, assist, steal, block, turnover, foul, minute, hitRate);
		
		double factor2 = factor2(score, rebound, assist, steal, block, turnover, foul, minute, hitRate);
		
		double factor3 = factor3(score, rebound, assist, steal, block, turnover, foul, minute, hitRate);
		
		double factor4 = factor4(score, rebound, assist, steal, block, turnover, foul, minute, hitRate);
		
		double factor5 = factor5(score, rebound, assist, steal, block, turnover, foul, minute, hitRate);
		
		String posi = null;
		
		
		if(position.contains("G"))
			posi = "G";
		if(position.contains("F"))
			posi = "F";
		if(position.contains("C"))
			posi = "C";
		
		if(posi == null)
		    return 0;
		if(posi.equals("G"))
			result = (int)(factor1+factor2*0.9-factor3*8+factor4*2.3+factor5*4);
		else if(posi.equals("F"))
		    result = (int)(factor1+factor2*1.4-factor3*6+factor4*1.4+factor5*3);
		else if(posi.equals("C"))
			result = (int)(factor1*0.9+factor2*1.9-factor3*4+factor4+factor5*2);
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
