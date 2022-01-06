package telran.util;

import java.util.Collection;
import java.util.Iterator;

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
		int countOfremovedNumbers = collection.size();
		collection.removeIf(predicate);
		return countOfremovedNumbers-collection.size();
	}
	
	@Override
	public int removeInRange(int minInclusive, int maxExclusive) {
		int sizeBeforeRemove = collection.size();

		collection.removeIf(el -> (el >= minInclusive && el < maxExclusive));
		return sizeBeforeRemove - collection.size();
	}

	@Override
	public boolean containsNumber(int number) {
		return collection.contains(number);
	}

}
