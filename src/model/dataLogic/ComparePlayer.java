package model.dataLogic;

import java.util.Comparator;

import vo.PlayerVO;

/**
 * 根据球员信息排序
 * 
 * @author HalaWKS
 * @date 2015年3月15日 下午4:14:14
 * 
 */
public class ComparePlayer {

	// "姓名","所属球队", "位置", "参赛场数", "先发场数", "两双次数", "总上场时间", "场均上场时间",
	// "总篮板", "场均篮板", "总进攻篮板", "场均进攻篮板", "总防守篮板", "场均防守篮板", "总助攻", "场均助攻",
	// "投篮命中率", "三分命中率", "罚球命中率", "赛季总抢断", "场均抢断", "赛季总盖帽", "场均盖帽",
	// "赛季总失误数", "场均失误数", "赛季总犯规数", "场均犯规数", "赛季总得分", "场均得分",
	// "效率", "GmSc效率值", "真实命中率", "投篮效率", "篮板率", "进攻篮板率", "防守篮板率",
	// "助攻率", "抢断率", "盖帽率", "失误率", "使用率"
	
	public class SortByName implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 球队名排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getName().compareTo(p2.getName()) >= 0){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByTeamName implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 球队名排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTeamName().compareTo(p2.getTeamName()) >= 0){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByPosition implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 位置排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getPosition().compareTo(p2.getPosition()) >= 0){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByEntryNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 上场次数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getEntryNum() >= p2.getEntryNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByStartingNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 首发次数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getStartingNum() >= p2.getStartingNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByDoubleDoubleNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 两双次数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getDoubleDouble() >= p2.getDoubleDouble()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByPlayTime implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总上场时间排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTotalMinutes().getTimeByMinute() >= p2.getTotalMinutes().getTimeByMinute()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAvePlayTime implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均上场时间排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveMinutes().getTimeByMinute() >= p2.getAveMinutes().getTimeByMinute()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByTotalReboundsNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总篮板数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTotalReboundsNum() >= p2.getTotalReboundsNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}

	public class SortByAveTotalReboundsNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均总篮板数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveTotalReboundsNum() >= p2.getAveTotalReboundsNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByOffReboundsNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总进攻篮板数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getOffensiveReboundsNum() >= p2.getOffensiveReboundsNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAveOffReboundsNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均进攻篮板数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveOffensiveReboundsNum() >= p2.getAveOffensiveReboundsNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByDefReboundsNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总防守篮板数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getDefensiveReboundsNum() >= p2.getDefensiveReboundsNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAveDefReboundsNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均防守篮板数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveDefensiveReboundsNum() >= p2.getAveDefensiveReboundsNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAssistNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总助攻数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAssistNum() >= p2.getAssistNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAveAssistNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均助攻数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveAssistNum() >= p2.getAveAssistNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByScoreRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 投篮命中率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getScoreRate() >= p2.getScoreRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByThreePointScoreRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 三分命中率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getThreePointScoreRate() >= p2.getThreePointScoreRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByFreeThrowScoreRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 罚球命中率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getFreeThrowScoreRate() >= p2.getFreeThrowScoreRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByStealNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总抢断数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getStealNum() >= p2.getStealNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAveStealNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均抢断数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveStealNum() >= p2.getAveStealNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByBlockNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总盖帽数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getBlockNum() >= p2.getBlockNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAveBlockNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均盖帽数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveBlockNum() >= p2.getAveBlockNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByFoulNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总失误数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getFoulNum() >= p2.getFoulNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAveFoulNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均失误数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveFoulNum() >= p2.getAveFoulNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByTurnoverNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总犯规数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTurnoverNum() >= p2.getTurnoverNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAveTurnoverNum implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均犯规数排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveTurnoverNum() >= p2.getAveTurnoverNum()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByPersonalPoints implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 赛季总个人得分排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getPersonalPoints() >= p2.getPersonalPoints()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAvePersonalPoints implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 场均个人得分排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAvePersonalPoints() >= p2.getAvePersonalPoints()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByEfficienty implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 效率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getEfficiency() >= p2.getEfficiency()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByGmsc implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO GmSc排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getGmSc() >= p2.getGmSc()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByTrueShootingPercentage implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 真实命中率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTrueShootingPercentage() >= p2.getTrueShootingPercentage()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByShootingEfficiency implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 投篮效率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getShootingEfficiency() >= p2.getShootingEfficiency()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByTotalReboundRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 篮板率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getReboundRate() >= p2.getReboundRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByOffReboundRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 进攻篮板率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getOffensiveReboundRate() >= p2.getOffensiveReboundRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByDefReboundRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 防守篮板率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getDefensiveReboundRate() >= p2.getDefensiveReboundRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByAssistRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 助攻率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAssistRate() >= p2.getAssistRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByStealRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 抢断率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getStealRate() >= p2.getStealRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByBlockRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 盖帽率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getBlockRate() >= p2.getBlockRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByTurnOverRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 失误率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTurnoverRate() >= p2.getTurnoverRate()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}
	
	public class SortByUseRate implements Comparator {

		public int compare(Object o1, Object o2) {
			// TODO 使用率排序
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getUseRate() >= p2.getUseRate()){
				return 1;
			} else {
				return -1;
			}
		}

	}

}
