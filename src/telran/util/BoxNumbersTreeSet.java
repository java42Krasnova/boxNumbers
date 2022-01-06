package telran.util;

import java.util.TreeSet;

public class BoxNumbersTreeSet extends BoxNumbersSet{

	public BoxNumbersTreeSet() {
		collection = new TreeSet<Integer>();
	}
	
	@Override
	public int removeInRange(int minInclusive, int maxExclusive) {
		int sizeBeforeRemove = collection.size();
		 ((TreeSet<Integer>)collection).subSet(minInclusive, maxExclusive).clear();
		return sizeBeforeRemove - collection.size();
	}

}
