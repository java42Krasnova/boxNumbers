package telran.util;

import java.util.HashSet;
import java.util.Iterator;

public abstract class BoxNumbersList extends BoxNumbersCollection {

	@Override
	public int removeRepeated() {
		int sizeBeforeRemove = collection.size();
		HashSet<Integer> tmp = new HashSet<>();
		Iterator<Integer> iterator = iterator();
		while(iterator.hasNext()) {
			if(!tmp.add(iterator.next())) {
				iterator.remove();
			}
		}
	return sizeBeforeRemove-tmp.size();
	}
}
