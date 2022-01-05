package telran.util;

import java.util.HashSet;
import java.util.Iterator;

public abstract class BoxNumbersList extends BoxNumbersCollection {

	@Override
	public int removeRepeated() {
		int countOfremovedNumbers = 0;
		HashSet<Integer> tmp = new HashSet<>();
		Iterator<Integer> iterator = iterator();
		while(iterator.hasNext()) {
			if(!tmp.add(iterator.next())) {
				++countOfremovedNumbers;
				iterator.remove();
			}
		}
		return countOfremovedNumbers;

	}
}
