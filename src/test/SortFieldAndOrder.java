package test;

/**
 * 为了多条件优先级排序设置的类
 * @author HalaWKS
 * @date 2015年5月9日 下午3:05:35
 *
 */
public class SortFieldAndOrder {
	
	/**
	 * 排序依据
	 */
	private int field = 0;

	/**
	 * 是否正序排列
	 */
	private boolean isPositiveSequence = false;
	
	public SortFieldAndOrder(int field, boolean isPositiveSequence) {
		this.field = field;
		this.isPositiveSequence = isPositiveSequence;
	}

	public int getField() {
		return field;
	}

	public boolean isPositiveSequence() {
		return isPositiveSequence;
	}
	
	
}
