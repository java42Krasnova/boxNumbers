package telran.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public abstract class BoxNumbersCollection implements BoxNumbers {

	protected Collection<Integer> collection;
	@Override
	public Iterator<Integer> iterator() {
		
		return  collection.iterator();
	}

	@Override
	public boolean addNumber(int number) {
		return collection.add(number);
	}

	@Override
	public boolean removeNumber(int number) {
		return collection.remove(number);
	}

	@Override
	public int removeByPredicate(Predicate<Integer> predicate) {
		int countOfremovedNumbers = 0;
		Iterator<Integer> iterator = iterator();
		while(iterator.hasNext()) {
			if(predicate.test(iterator.next())) {
				++countOfremovedNumbers;
				iterator.remove();
			}
		}
		return countOfremovedNumbers;
	}
	
	@Override
	public int removeInRange(int minInclusive, int maxExclusive) {
		int sizeBeforeRemove = collection.size();
		removeByPredicate(i -> (i >= minInclusive && i < maxExclusive));
		return sizeBeforeRemove - collection.size();
	}

	@Override
	public boolean containsNumber(int number) {
		return collection.contains(number);
	}

}
