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
	
	Comparator[] comparator;
	

	/**
	 * 全部球员排序的构造方法
	 * @param isPositiveSequence
	 */
	public ComparePlayer(boolean isPositiveSequence) {
		// TODO Auto-generated constructor stub
		boolean b = isPositiveSequence;
		
		comparator = new Comparator[]{
				new SortByName(b),
				new SortByTeamName(b),
				new SortByPosition(b),
				new SortByEntryNum(b),
				new SortByStartingNum(b),
				new SortByDoubleDoubleNum(b),
				new SortByPlayTime(b),
				new SortByAvePlayTime(b),
				new SortByTotalReboundsNum(b),
				new SortByAveTotalReboundsNum(b),
				new SortByOffReboundsNum(b),
				new SortByAveOffReboundsNum(b),
				new SortByDefReboundsNum(b),
				new SortByAveDefReboundsNum(b),
				new SortByAssistNum(b),
				new SortByAveAssistNum(b),
				new SortByScoreRate(b),
				new SortByThreePointScoreRate(b),
				new SortByFreeThrowScoreRate(b),
				new SortByStealNum(b),
				new SortByAveStealNum(b),
				new SortByBlockNum(b),
				new SortByAveBlockNum(b),
				new SortByFoulNum(b),
				new SortByAveFoulNum(b),
				new SortByTurnoverNum(b),
				new SortByAveTurnoverNum(b),
				new SortByPersonalPoints(b),
				new SortByAvePersonalPoints(b),
				new SortByEfficienty(b),
				new SortByGmsc(b),
				new SortByTrueShootingPercentage(b),
				new SortByShootingEfficiency(b),
				new SortByTotalReboundRate(b),
				new SortByOffReboundRate(b),
				new SortByDefReboundRate(b),
				new SortByAssistRate(b),
				new SortByStealRate(b),
				new SortByBlockRate(b),
				new SortByTurnOverRate(b),
				new SortByUseRate(b)
		};
	}
	
	public class SortByName implements Comparator {

		boolean b;
		public SortByName(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			
			// TODO 姓名排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
//			if(p1.getName().compareTo(p2.getName()) >= 0){
//				result = 1;
//			}
			result = p1.getName().compareTo(p2.getName());
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByTeamName implements Comparator {

		boolean b;
		public SortByTeamName(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 球队名排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
//			if(p1.getTeamName().compareTo(p2.getTeamName()) >= 0){
//				result = 1;
//			}
			result = p1.getTeamName().compareTo(p2.getTeamName());
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByPosition implements Comparator {

		boolean b;
		public SortByPosition(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 位置排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			result = p1.getPosition().compareTo(p2.getPosition());
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByEntryNum implements Comparator {

		boolean b;
		public SortByEntryNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 上场次数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getEntryNum() >= p2.getEntryNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByStartingNum implements Comparator {

		boolean b;
		public SortByStartingNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 首发次数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getStartingNum() >= p2.getStartingNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByDoubleDoubleNum implements Comparator {

		boolean b;
		public SortByDoubleDoubleNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 两双次数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getDoubleDouble() >= p2.getDoubleDouble()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByPlayTime implements Comparator {

		boolean b;
		public SortByPlayTime(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总上场时间排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTotalMinutes().getTimeByMinute() >= p2.getTotalMinutes().getTimeByMinute()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAvePlayTime implements Comparator {

		boolean b;
		public SortByAvePlayTime(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均上场时间排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveMinutes().getTimeByMinute() >= p2.getAveMinutes().getTimeByMinute()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByTotalReboundsNum implements Comparator {

		boolean b;
		public SortByTotalReboundsNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总篮板数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTotalReboundsNum() >= p2.getTotalReboundsNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}

	public class SortByAveTotalReboundsNum implements Comparator {

		boolean b;
		public SortByAveTotalReboundsNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均总篮板数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveTotalReboundsNum() >= p2.getAveTotalReboundsNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByOffReboundsNum implements Comparator {

		boolean b;
		public SortByOffReboundsNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总进攻篮板数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getOffensiveReboundsNum() >= p2.getOffensiveReboundsNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAveOffReboundsNum implements Comparator {

		boolean b;
		public SortByAveOffReboundsNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均进攻篮板数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveOffensiveReboundsNum() >= p2.getAveOffensiveReboundsNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByDefReboundsNum implements Comparator {

		boolean b;
		public SortByDefReboundsNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总防守篮板数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getDefensiveReboundsNum() >= p2.getDefensiveReboundsNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAveDefReboundsNum implements Comparator {

		boolean b;
		public SortByAveDefReboundsNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均防守篮板数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveDefensiveReboundsNum() >= p2.getAveDefensiveReboundsNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAssistNum implements Comparator {

		boolean b;
		public SortByAssistNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总助攻数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAssistNum() >= p2.getAssistNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAveAssistNum implements Comparator {

		boolean b;
		public SortByAveAssistNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均助攻数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveAssistNum() >= p2.getAveAssistNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByScoreRate implements Comparator {

		boolean b;
		public SortByScoreRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 投篮命中率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getScoreRate() >= p2.getScoreRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByThreePointScoreRate implements Comparator {

		boolean b;
		public SortByThreePointScoreRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 三分命中率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getThreePointScoreRate() >= p2.getThreePointScoreRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByFreeThrowScoreRate implements Comparator {

		boolean b;
		public SortByFreeThrowScoreRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 罚球命中率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getFreeThrowScoreRate() >= p2.getFreeThrowScoreRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByStealNum implements Comparator {

		boolean b;
		public SortByStealNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总抢断数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getStealNum() >= p2.getStealNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAveStealNum implements Comparator {

		boolean b;
		public SortByAveStealNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均抢断数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveStealNum() >= p2.getAveStealNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByBlockNum implements Comparator {

		boolean b;
		public SortByBlockNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总盖帽数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getBlockNum() >= p2.getBlockNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAveBlockNum implements Comparator {

		boolean b;
		public SortByAveBlockNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均盖帽数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveBlockNum() >= p2.getAveBlockNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByFoulNum implements Comparator {

		boolean b;
		public SortByFoulNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总失误数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTurnoverNum() >= p2.getTurnoverNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAveFoulNum implements Comparator {

		boolean b;
		public SortByAveFoulNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均失误数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveTurnoverNum() >= p2.getAveTurnoverNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByTurnoverNum implements Comparator {

		boolean b;
		public SortByTurnoverNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总犯规数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getFoulNum() >= p2.getFoulNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAveTurnoverNum implements Comparator {

		boolean b;
		public SortByAveTurnoverNum(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均犯规数排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAveFoulNum() >= p2.getAveFoulNum()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByPersonalPoints implements Comparator {

		boolean b;
		public SortByPersonalPoints(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 赛季总个人得分排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getPersonalPoints() >= p2.getPersonalPoints()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAvePersonalPoints implements Comparator {

		boolean b;
		public SortByAvePersonalPoints(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 场均个人得分排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAvePersonalPoints() >= p2.getAvePersonalPoints()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByEfficienty implements Comparator {

		boolean b;
		public SortByEfficienty(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 效率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getEfficiency() >= p2.getEfficiency()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByGmsc implements Comparator {

		boolean b;
		public SortByGmsc(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO GmSc排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getGmSc() >= p2.getGmSc()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByTrueShootingPercentage implements Comparator {

		boolean b;
		public SortByTrueShootingPercentage(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 真实命中率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTrueShootingPercentage() >= p2.getTrueShootingPercentage()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByShootingEfficiency implements Comparator {

		boolean b;
		public SortByShootingEfficiency(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 投篮效率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getShootingEfficiency() >= p2.getShootingEfficiency()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByTotalReboundRate implements Comparator {

		boolean b;
		public SortByTotalReboundRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 篮板率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getReboundRate() >= p2.getReboundRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByOffReboundRate implements Comparator {

		boolean b;
		public SortByOffReboundRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 进攻篮板率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getOffensiveReboundRate() >= p2.getOffensiveReboundRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByDefReboundRate implements Comparator {

		boolean b;
		public SortByDefReboundRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 防守篮板率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getDefensiveReboundRate() >= p2.getDefensiveReboundRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByAssistRate implements Comparator {

		boolean b;
		public SortByAssistRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 助攻率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getAssistRate() >= p2.getAssistRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByStealRate implements Comparator {

		boolean b;
		public SortByStealRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 抢断率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getStealRate() >= p2.getStealRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByBlockRate implements Comparator {

		boolean b;
		public SortByBlockRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 盖帽率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getBlockRate() >= p2.getBlockRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByTurnOverRate implements Comparator {

		boolean b;
		public SortByTurnOverRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 失误率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getTurnoverRate() >= p2.getTurnoverRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}
		
	}
	
	public class SortByUseRate implements Comparator {

		boolean b;
		public SortByUseRate(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 使用率排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			if(p1.getUseRate() >= p2.getUseRate()){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}

	}


	public class SortByPointReboundAssist implements Comparator {

		boolean b;
		public SortByPointReboundAssist(boolean isPositiveSequence) {
			b = isPositiveSequence;
		}
		
		public int compare(Object o1, Object o2) {
			// TODO 得分/篮板/助攻 排序
			int result = -1;
			PlayerVO p1 = (PlayerVO) o1;
			PlayerVO p2 = (PlayerVO) o2;
			double pra1 = 0;
			double pra2 = 0;
			if((p1.getTotalReboundsNum()) != 0 && (p1.getAssistNum() != 0)){
				pra1 = p1.getPersonalPoints() / p1.getTotalReboundsNum() / p1.getAssistNum();
			}
			if((p2.getTotalReboundsNum()) != 0 && (p2.getAssistNum() != 0)){
				pra2 = p2.getPersonalPoints() / p2.getTotalReboundsNum() / p2.getAssistNum();
			}
			
			if(pra1 >= pra2){
				result = 1;
			}
			if(!b){
				result = -result;
			}
			return result;
		}

	}
	
}
