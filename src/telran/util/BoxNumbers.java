package telran.util;

import java.util.function.Predicate;

public interface BoxNumbers extends Iterable<Integer> {

	boolean addNumber(int number);
	boolean removeNumber(int number);
	int removeRepeated();// count of removed numbers
	int removeByPredicate(Predicate<Integer> predicate);// count of removed numbers
	int removeInRange(int minInclusive, int maxExclusive);// count of removed numbers
	boolean containsNumber(int number);
}
