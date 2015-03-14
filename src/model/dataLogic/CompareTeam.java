package model.dataLogic;

import java.util.Comparator;

import vo.TeamVO;

public class CompareTeam {
	
	
	public class SortByMatchNum  implements Comparator{
		
		
			
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.matchNum >= p2.matchNum){
				return 1;
			}else{
				return -1;
			}
		}
	
	}
	
	public class SortByTotalScoreNum  implements Comparator{
		
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalScoreNum >= p2.totalScoreNum){
				return 1;
			}else{
				return -1;
			}
		}
	
	}
	
	public class SortByTotalShootNum  implements Comparator{
		
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalShootNum >= p2.totalShootNum){
				return 1;
			}else{
				return -1;
			}
		}
	
	}
	
	public class SortByTotalThreePointScoreNum  implements Comparator{
		
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalThreePointScoreNum >= p2.totalThreePointScoreNum){
				return 1;
			}else{
				return -1;
			}
		}
	
	}
	
	public class SortByTotalThreePointShootNum  implements Comparator{
		
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalThreePointShootNum >= p2.totalThreePointShootNum){
				return 1;
			}else{
				return -1;
			}
		}
	
	}
	
	
public class SortByTotalFreeThrowScoreNum  implements Comparator{
		
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalFreeThrowScoreNum >= p2.totalFreeThrowScoreNum){
				return 1;
			}else{
				return -1;
			}
		}
	
	}

public class SortByTotalFreeThrowShootNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalFreeThrowShootNum >= p2.totalFreeThrowShootNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByTotalOffensiveReboundsNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalOffensiveReboundsNum >= p2.totalOffensiveReboundsNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByTotalDefensiveReboundsNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalDefensiveReboundsNum >= p2.totalDefensiveReboundsNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByTotalTotalReboundsNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalTotalReboundsNum >= p2.totalTotalReboundsNum){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortBytotalAssistNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAssistNum >= p2.totalAssistNum){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortBytotalStealNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalStealNum >= p2.totalStealNum){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortByTotalTotalThreePointShootNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalThreePointShootNum >= p2.totalThreePointShootNum){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortBytotalBlockNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalBlockNum >= p2.totalBlockNum){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortBytotalTurnoverNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalTurnoverNum >= p2.totalTurnoverNum){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortBytotalFoulNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalFoulNum >= p2.totalFoulNum){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortBytotalScore  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalScore >= p2.totalScore){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortBytotalScoreRate  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalScoreRate >= p2.totalScoreRate){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortBytotalThreePointRate  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalThreePointRate >= p2.totalThreePointRate){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalFreeThrowRate  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalFreeThrowRate >= p2.totalFreeThrowRate){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalWinningRate  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalWinningRate >= p2.totalWinningRate){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalAttackRound  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAttackRound >= p2.totalAttackRound){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalAttackEfficiency  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAttackEfficiency >= p2.totalAttackEfficiency){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalDefendEfficiency  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalDefendEfficiency >= p2.totalDefendEfficiency){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalAttackReboundEfficiency  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAttackReboundEfficiency >= p2.totalAttackReboundEfficiency){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalDefensiveReboundEfficiency  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalDefensiveReboundEfficiency >= p2.totalDefensiveReboundEfficiency){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalStealEfficiency implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalStealEfficiency >= p2.totalStealEfficiency){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortBytotalAssistRate  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAssistRate >= p2.totalAssistRate){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveScoreNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveScoreNum >= p2.aveScoreNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveShootNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveShootNum >= p2.aveShootNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveThreePointScoreNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveThreePointScoreNum >= p2.aveThreePointScoreNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveThreePointShootNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveThreePointShootNum >= p2.aveThreePointShootNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveFreeThrowScoreNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveFreeThrowScoreNum >= p2.aveFreeThrowScoreNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveFreeThrowShootNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveFreeThrowShootNum >= p2.aveFreeThrowShootNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveOffensiveReboundsNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveOffensiveReboundsNum >= p2.aveOffensiveReboundsNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveDefensiveReboundsNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveDefensiveReboundsNum >= p2.aveDefensiveReboundsNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveTotalReboundsNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveTotalReboundsNum >= p2.aveTotalReboundsNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveAssistNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveAssistNum >= p2.aveAssistNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveStealNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveStealNum >= p2.aveStealNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveBlockNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveBlockNum >= p2.aveBlockNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveTurnoverNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveTurnoverNum >= p2.aveTurnoverNum){
			return 1;
		}else{
			return -1;
		}
	}

}


public class SortByaveFoulNum  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveFoulNum >= p2.aveFoulNum){
			return 1;
		}else{
			return -1;
		}
	}

}

public class SortByaveScore  implements Comparator{
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveScore >= p2.aveScore){
			return 1;
		}else{
			return -1;
		}
	}

}

}


