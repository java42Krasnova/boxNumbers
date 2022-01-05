package telran.util.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.BoxNumbers;
import telran.util.BoxNumbersArrayList;
import telran.util.BoxNumbersHashSet;
import telran.util.BoxNumbersLinkedList;
import telran.util.BoxNumbersTreeSet;

class BoxNumbersTest {
	BoxNumbers boxNumbersForArrayList = new BoxNumbersArrayList();
	BoxNumbers boxNumbersForLinkedList = new BoxNumbersLinkedList();
	BoxNumbers boxNumbersForHashSet = new BoxNumbersHashSet();
	BoxNumbers boxNumbersForTreeSet = new BoxNumbersTreeSet();

	int[] forList = { 13, 20, 44, 13, 29, 15, 20, 40, 44 };
	int[] forSet = { 13, 20, 44, 29, 15, 40 };

	@BeforeEach
	void setUp() throws Exception {
		fillBoxNumbers(boxNumbersForArrayList, forList);
		fillBoxNumbers(boxNumbersForLinkedList, forList);
		fillBoxNumbers(boxNumbersForHashSet, forSet);
		fillBoxNumbers(boxNumbersForTreeSet, forSet);
	}

	private void fillBoxNumbers(BoxNumbers box, int[] forList) {
		for (int i = 0; i < forList.length; i++) {
			box.addNumber(forList[i]);
		}
	}

	@Test
	void testAddNumber() {
		// ArrayList
		assertTrue(boxNumbersForArrayList.addNumber(5));
		// LinkedList
		assertTrue(boxNumbersForLinkedList.addNumber(4));
		// HashSet
		assertTrue(boxNumbersForHashSet.addNumber(4));
		// adding the same number
		assertFalse(boxNumbersForHashSet.addNumber(4));
		// TreSet
		assertTrue(boxNumbersForTreeSet.addNumber(4));
		// adding the same number
		assertFalse(boxNumbersForTreeSet.addNumber(4));
	}
	@Test
	void testRemoveNumber() {
		// ArrayList
		assertTrue(boxNumbersForArrayList.removeNumber(29));
		assertFalse(boxNumbersForArrayList.containsNumber(29));
		// LinkedList
		assertTrue(boxNumbersForLinkedList.removeNumber(29));
		assertFalse(boxNumbersForLinkedList.containsNumber(29));
		// HashSet
		assertTrue(boxNumbersForHashSet.removeNumber(20));
		// adding the same number
		assertTrue(boxNumbersForHashSet.addNumber(20));
		// TreeSet
		assertTrue(boxNumbersForTreeSet.removeNumber(20));
		// adding the same number
		assertTrue(boxNumbersForTreeSet.addNumber(20));
	}
	//	int forList[] = {13, 20, 44, 13, 29, 15, 20, 40, 44};
	//	int forSet[] = {13, 20, 44, 29, 15, 40, 44};
	@Test
	void testRemoveRepeated() {
		// ArrayList
		assertEquals(3, boxNumbersForArrayList.removeRepeated());
		assertEquals(0, boxNumbersForArrayList.removeRepeated());
		// LinkedList
		assertEquals(3, boxNumbersForLinkedList.removeRepeated());
		assertEquals(0, boxNumbersForLinkedList.removeRepeated());
		// HashSet
		assertEquals(0, boxNumbersForHashSet.removeRepeated());
		// TreeSet
		assertEquals(0, boxNumbersForTreeSet.removeRepeated());
	}

	@Test
	void testRemoveByPredicate() {
		// ArrayList
		assertEquals(5, boxNumbersForArrayList.removeByPredicate(p -> (p % 2 == 0)));
		assertEquals(1, boxNumbersForArrayList.removeByPredicate(p -> (p % 5 == 0)));
		// LinkedList
		assertEquals(5, boxNumbersForLinkedList.removeByPredicate(p -> (p % 2 == 0)));
		assertEquals(1, boxNumbersForLinkedList.removeByPredicate(p -> (p % 5 == 0)));
		// HashSet
		assertEquals(3, boxNumbersForHashSet.removeByPredicate(p -> (p % 5 == 0)));
		assertEquals(0, boxNumbersForHashSet.removeByPredicate(p -> (p % 14 == 0)));
		// TreeSet
		assertEquals(3, boxNumbersForTreeSet.removeByPredicate(p -> (p % 5 == 0)));
		assertEquals(0, boxNumbersForTreeSet.removeByPredicate(p -> (p % 14 == 0)));
	}
	//	int forList[] = {13, 20, 44, 13, 29, 15, 20, 40, 44};
		//	int forSet[] = {13, 20, 44, 29, 15, 40, 44};
	@Test
	void testRemoveInRange() {
		// ArrayList
		assertEquals(6, boxNumbersForArrayList.removeInRange(13, 40));
		assertEquals(1, boxNumbersForArrayList.removeInRange(40, 44));
		assertEquals(2, boxNumbersForArrayList.removeInRange(42, 50));
		assertEquals(0, boxNumbersForArrayList.removeInRange(42, 50));
		// LinkedList
		assertEquals(6, boxNumbersForLinkedList.removeInRange(13, 40));
		assertEquals(1, boxNumbersForLinkedList.removeInRange(40, 44));
		// HashSet
		assertEquals(2, boxNumbersForHashSet.removeInRange(20, 40));
		// TreeSet
		assertEquals(2, boxNumbersForTreeSet.removeInRange(20, 40));
		assertEquals(4, boxNumbersForTreeSet.removeInRange(13, 50));
		assertEquals(0, boxNumbersForTreeSet.removeInRange(13, 50));


	}

	@Test
	void testContainsNumber() {
		// ArrayList
		assertTrue(boxNumbersForArrayList.containsNumber(29));
		assertFalse(boxNumbersForArrayList.containsNumber(2));
		// LinkedList
		assertTrue(boxNumbersForLinkedList.containsNumber(29));
		assertFalse(boxNumbersForLinkedList.containsNumber(2));
		// HashSet
		assertTrue(boxNumbersForHashSet.containsNumber(20));
		assertFalse(boxNumbersForHashSet.containsNumber(2));
		// TreeSet
		assertTrue(boxNumbersForTreeSet.containsNumber(20));
		assertFalse(boxNumbersForTreeSet.containsNumber(2));

	}

}
