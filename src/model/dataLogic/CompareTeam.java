package model.dataLogic;
import java.util.Comparator;

import vo.TeamVO;
public class CompareTeam {
	Comparator[] compartor;
	Comparator[] hotCompartor;
	public CompareTeam(boolean isPositiveSequence){
	boolean b = isPositiveSequence;
	compartor = new Comparator[]{			
		new SortByMatchNum(b),
		new SortByTotalScoreNum(b),
		new SortByTotalShootNum(b),
		new SortByTotalThreePointScoreNum(b),
		new SortByTotalThreePointShootNum(b),
		new SortByTotalFreeThrowScoreNum(b),
		new SortByTotalFreeThrowShootNum(b),
		new SortByTotalOffensiveReboundsNum(b),
		new SortByTotalDefensiveReboundsNum(b),
		new SortByTotalTotalReboundsNum(b),
		new SortByTotalAssistNum(b),
		new SortByTotalStealNum(b),
		new SortByTotalBlockNum(b),
		new SortByTotalTurnoverNum(b),
		new SortByTotalFoulNum(b),
		new SortByTotalScore(b),
		new SortByTotalScoreRate(b),
		new SortByTotalThreePointRate(b),
		new SortByTotalFreeThrowRate(b),
		new SortByTotalWinningRate(b),
		new SortByTotalAttackRound(b),
		new SortByTotalAttackEfficiency(b),
		new SortByTotalDefendEfficiency(b),
		new SortByTotalAttackReboundEfficiency(b),
		new SortByTotalDefensiveReboundEfficiency(b),
		new SortByTotalStealEfficiency(b),
		new SortByTotalAssistRate(b),
		new SortByAveScoreNum(b),
		new SortByAveShootNum(b),
		new SortByAveThreePointScoreNum(b),
		new SortByAveThreePointShootNum(b),
		new SortByAveFreeThrowScoreNum(b),
		new SortByAveFreeThrowShootNum(b),
		new SortByAveOffensiveReboundsNum(b),
		new SortByAveDefensiveReboundsNum(b),
		new SortByAveTotalReboundsNum(b),
		new SortByAveAssistNum(b),
		new SortByAveStealNum(b),
		new SortByAveBlockNum(b),
		new SortByAveTurnoverNum(b),
		new SortByAveFoulNum(b),
		new SortByAveScore(b),		
	};
	
	hotCompartor = new Comparator[]{
		new SortByAveScore(b),
		new SortByAveTotalReboundsNum(b),
		new SortByAveAssistNum(b),
		new SortByAveBlockNum(b),
		new SortByAveStealNum(b),
		new SortByTotalThreePointRate(b),
		new SortByTotalScoreRate(b),
		new SortByTotalFreeThrowRate(b)
	};
	}
	
	public class SortByMatchNum  implements Comparator{
		boolean isPositiveSequence;
		public SortByMatchNum(boolean isPositiveSequence){
			this.isPositiveSequence = isPositiveSequence;
		}
		
			
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			int result = -1;
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.matchNum >= p2.matchNum){
				result = 1;
			}
			if(!isPositiveSequence){
				result = -result;
			}
			return result;
		}
	
	}
	
	public class SortByTotalScoreNum  implements Comparator{
		boolean isPositiveSequence;
		public SortByTotalScoreNum(boolean isPositiveSequence){
			this.isPositiveSequence = isPositiveSequence;
		}
		
		
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			int result = -1;
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalScoreNum >= p2.totalScoreNum){
				result = 1;
			}
			if(!isPositiveSequence){
				result = -result;
			}
			return result;
		}
	
	}
	
	public class SortByTotalShootNum  implements Comparator{
		boolean isPositiveSequence;
		public SortByTotalShootNum(boolean isPositiveSequence){
			this.isPositiveSequence = isPositiveSequence;
		}
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			int result = -1;
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalShootNum >= p2.totalShootNum){
				result = 1;
			}
			if(!isPositiveSequence){
				result = -result;
			}
			return result;
		}
	
	}
	
	public class SortByTotalThreePointScoreNum  implements Comparator{
		boolean isPositiveSequence;
		public SortByTotalThreePointScoreNum(boolean isPositiveSequence){
			this.isPositiveSequence = isPositiveSequence;
		}
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			int result = -1;
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalThreePointScoreNum >= p2.totalThreePointScoreNum){
				result = 1;
			}
			if(!isPositiveSequence){
				result = -result;
			}
			return result;
		}
	
	}
	
	public class SortByTotalThreePointShootNum  implements Comparator{
		boolean isPositiveSequence;
		public SortByTotalThreePointShootNum(boolean isPositiveSequence){
			this.isPositiveSequence = isPositiveSequence;
		}
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			int result = -1;
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalThreePointShootNum >= p2.totalThreePointShootNum){
				result = 1;
			}
			if(!isPositiveSequence){
				result = -result;
			}
			return result;
		}
	
	}
	
	
public class SortByTotalFreeThrowScoreNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalFreeThrowScoreNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			int result = -1;
			TeamVO p1 = (TeamVO) o1;
			TeamVO p2 = (TeamVO) o2;
			if(p1.totalFreeThrowScoreNum >= p2.totalFreeThrowScoreNum){
				result = 1;
			}
			if(!isPositiveSequence){
				result = -result;
			}
			return result;
		}
	
	}

public class SortByTotalFreeThrowShootNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalFreeThrowShootNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalFreeThrowShootNum >= p2.totalFreeThrowShootNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalOffensiveReboundsNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalOffensiveReboundsNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalOffensiveReboundsNum >= p2.totalOffensiveReboundsNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalDefensiveReboundsNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalDefensiveReboundsNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalDefensiveReboundsNum >= p2.totalDefensiveReboundsNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalTotalReboundsNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalTotalReboundsNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalTotalReboundsNum >= p2.totalTotalReboundsNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalAssistNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalAssistNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAssistNum >= p2.totalAssistNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalStealNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalStealNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalStealNum >= p2.totalStealNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalTotalThreePointShootNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalTotalThreePointShootNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalThreePointShootNum >= p2.totalThreePointShootNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalBlockNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalBlockNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalBlockNum >= p2.totalBlockNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalTurnoverNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalTurnoverNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalTurnoverNum >= p2.totalTurnoverNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalFoulNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalFoulNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalFoulNum >= p2.totalFoulNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalScore  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalScore(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalScore >= p2.totalScore){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalScoreRate  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalScoreRate(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalScoreRate >= p2.totalScoreRate){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByTotalThreePointRate  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalThreePointRate(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalThreePointRate >= p2.totalThreePointRate){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalFreeThrowRate  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalFreeThrowRate(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalFreeThrowRate >= p2.totalFreeThrowRate){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalWinningRate  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalWinningRate(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalWinningRate >= p2.totalWinningRate){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalAttackRound  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalAttackRound(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAttackRound >= p2.totalAttackRound){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalAttackEfficiency  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalAttackEfficiency(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAttackEfficiency >= p2.totalAttackEfficiency){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalDefendEfficiency  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalDefendEfficiency(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalDefendEfficiency >= p2.totalDefendEfficiency){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalAttackReboundEfficiency  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalAttackReboundEfficiency(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAttackReboundEfficiency >= p2.totalAttackReboundEfficiency){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalDefensiveReboundEfficiency  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalDefensiveReboundEfficiency(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalDefensiveReboundEfficiency >= p2.totalDefensiveReboundEfficiency){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalStealEfficiency implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalStealEfficiency(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalStealEfficiency >= p2.totalStealEfficiency){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByTotalAssistRate  implements Comparator{
	boolean isPositiveSequence;
	public SortByTotalAssistRate(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.totalAssistRate >= p2.totalAssistRate){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveScoreNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveScoreNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveScoreNum >= p2.aveScoreNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveShootNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveShootNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveShootNum >= p2.aveShootNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveThreePointScoreNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveThreePointScoreNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveThreePointScoreNum >= p2.aveThreePointScoreNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveThreePointShootNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveThreePointShootNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveThreePointShootNum >= p2.aveThreePointShootNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveFreeThrowScoreNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveFreeThrowScoreNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveFreeThrowScoreNum >= p2.aveFreeThrowScoreNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveFreeThrowShootNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveFreeThrowShootNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveFreeThrowShootNum >= p2.aveFreeThrowShootNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveOffensiveReboundsNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveOffensiveReboundsNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveOffensiveReboundsNum >= p2.aveOffensiveReboundsNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveDefensiveReboundsNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveDefensiveReboundsNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveDefensiveReboundsNum >= p2.aveDefensiveReboundsNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveTotalReboundsNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveTotalReboundsNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveTotalReboundsNum >= p2.aveTotalReboundsNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveAssistNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveAssistNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveAssistNum >= p2.aveAssistNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveStealNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveStealNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveStealNum >= p2.aveStealNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveBlockNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveBlockNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveBlockNum >= p2.aveBlockNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveTurnoverNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveTurnoverNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveTurnoverNum >= p2.aveTurnoverNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}


public class SortByAveFoulNum  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveFoulNum(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveFoulNum >= p2.aveFoulNum){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

public class SortByAveScore  implements Comparator{
	boolean isPositiveSequence;
	public SortByAveScore(boolean isPositiveSequence){
		this.isPositiveSequence = isPositiveSequence;
	}
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
		if(p1.aveScore >= p2.aveScore){
			result = 1;
		}
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}

}


