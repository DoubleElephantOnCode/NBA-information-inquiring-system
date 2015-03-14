package model.dataLogic;

import java.util.Comparator;

import vo.TeamVO;

public class CompareTeamData implements Comparator{
	int i;
	boolean isPositiveSequence;
	public CompareTeamData(int i ,boolean isPositiveSequence){
		this.i = i;
		this.isPositiveSequence = isPositiveSequence;
	}
		
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int result = -1;
		TeamVO p1 = (TeamVO) o1;
		TeamVO p2 = (TeamVO) o2;
				
		switch(i){
		case 0: if(p1.matchNum >= p2.matchNum) result = 1; break;
		case 1: if(p1.totalScoreNum >= p2.totalScoreNum) result = 1; break;
		case 2: if(p1.totalShootNum >= p2.totalShootNum) result = 1; break;
		case 3: if(p1.totalThreePointScoreNum >= p2.totalThreePointScoreNum) result = 1; break;
		case 4: if(p1.totalThreePointShootNum >= p2.totalThreePointShootNum) result = 1; break;
		case 5: if(p1.totalFreeThrowScoreNum >= p2.totalFreeThrowScoreNum) result = 1; break;
		case 6: if(p1.totalFreeThrowShootNum >= p2.totalFreeThrowShootNum) result = 1; break;
		case 7: if(p1.totalOffensiveReboundsNum >= p2.totalOffensiveReboundsNum) result = 1; break;
		case 8: if(p1.totalDefensiveReboundsNum >= p2.totalDefensiveReboundsNum) result = 1; break;
		case 9: if(p1.totalTotalReboundsNum >= p2.totalTotalReboundsNum) result = 1; break;
		case 10: if(p1.totalAssistNum >= p2.totalAssistNum) result = 1; break;
		case 11: if(p1.totalStealNum >= p2.totalStealNum) result = 1; break;
		case 12: if(p1.totalBlockNum >= p2.totalBlockNum) result = 1; break;
		case 13: if(p1.totalTurnoverNum >= p2.totalTurnoverNum) result = 1; break;
		case 14: if(p1.totalFoulNum >= p2.totalFoulNum) result = 1; break;
		case 15: if(p1.totalScore >= p2.totalScore) result = 1; break;
		case 16: if(p1.totalScoreRate >= p2.totalScoreRate) result = 1; break;
		case 17: if(p1.totalThreePointRate >= p2.totalThreePointRate) result = 1; break;
		case 18: if(p1.totalFreeThrowRate >= p2.totalFreeThrowRate) result = 1; break;
		case 19: if(p1.totalWinningRate >= p2.totalWinningRate) result = 1; break;
		case 20: if(p1.totalAttackRound >= p2.totalAttackRound) result = 1; break;
		case 21: if(p1.totalAttackEfficiency >= p2.totalAttackEfficiency) result = 1; break;	
		case 22: if(p1.totalDefendEfficiency >= p2.totalDefendEfficiency) result = 1; break;
		case 23: if(p1.totalAttackReboundEfficiency >= p2.totalAttackReboundEfficiency) result = 1; break;
		case 24: if(p1.totalDefensiveReboundEfficiency >= p2.totalDefensiveReboundEfficiency) result = 1; break;
		case 25: if(p1.totalStealEfficiency >= p2.totalStealEfficiency) result = 1; break;
		case 26: if(p1.totalAssistRate >= p2.totalAssistRate) result = 1; break;
		case 27: if(p1.aveScoreNum >= p2.aveScoreNum) result = 1; break;
		case 28: if(p1.aveShootNum >= p2.aveShootNum) result = 1; break;
		case 29: if(p1.aveThreePointScoreNum >= p2.aveThreePointScoreNum) result = 1; break;
		case 30: if(p1.aveThreePointShootNum >= p2.aveThreePointShootNum) result = 1; break;
		case 31: if(p1.aveFreeThrowScoreNum >= p2.aveFreeThrowScoreNum) result = 1; break;
		case 32: if(p1.aveFreeThrowShootNum >= p2.aveFreeThrowShootNum) result = 1; break;
		case 33: if(p1.aveOffensiveReboundsNum >= p2.aveOffensiveReboundsNum) result = 1; break;
		case 34: if(p1.aveDefensiveReboundsNum >= p2.aveDefensiveReboundsNum) result = 1; break;
		case 35: if(p1.aveTotalReboundsNum >= p2.aveTotalReboundsNum) result = 1; break;
		case 36: if(p1.aveAssistNum >= p2.aveAssistNum) result = 1; break;
		case 37: if(p1.aveStealNum >= p2.aveStealNum) result = 1; break;
		case 38: if(p1.aveBlockNum >= p2.aveBlockNum) result = 1; break;
		case 39: if(p1.aveTurnoverNum >= p2.aveTurnoverNum) result = 1; break;	
		case 40: if(p1.aveFoulNum >= p2.aveFoulNum) result = 1; break;
		case 41: if(p1.aveScore >= p2.aveScore) result = 1; break;
		}
		
		if(!isPositiveSequence){
			result = -result;
		}
		return result;
	}

}
