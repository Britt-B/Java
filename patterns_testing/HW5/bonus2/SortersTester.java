import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SortersTester {
  private ArrayList<Dog> pack;
  private ArrayList<Dog> emptyList;
  private Comparator<Dog> comp;
  
  /*
  *setup creates both an empty ArrayList and a filled ArrayList to be tested and compared
  **/
  @Before
  public void setup() {
    emptyList = new ArrayList<Dog>();
    pack = new ArrayList<Dog>();
    pack.add(new Dog("Josie", 74));
    pack.add(new Dog("Beatrice", 118));
    pack.add(new Dog("Watson", 39));
    pack.add(new Dog("Brutus", 102));
    pack.add(new Dog("Phineas", 57));
    pack.add(new Dog("Hamlet", 76));
    pack.add(new Dog("Amadeus", 125));
    pack.add(new Dog("Sansa", 48));
    pack.add(new Dog("Nutmeg", 68));
    pack.add(new Dog("Copernicus", 87));
	
	//comparator object
	comp = new Comparator<Dog>(){
		public int compare(Dog dog1, Dog dog2){
			int intVal = 0;
			if(dog1.getWeight()-dog2.getWeight() < 0){
				intVal = -1;
			}
			else if(dog1.getWeight()-dog2.getWeight() > 0){
				intVal = 1;
			}
			return intVal;
		}
	};
  }

  /*
  @return inOrder stores the proper order of the pack in an array, which will be used to compare with the lists returned
  *in the future tests.
  **/
  private boolean isInOrder(List<Dog> pack) {
    boolean inOrder = true;
    String[] names = {"Watson", "Sansa",      "Phineas", "Nutmeg",   "Josie",
                      "Hamlet", "Copernicus", "Brutus",  "Beatrice", "Amadeus"};
    for(int i = 0; i < pack.size(); i++) {
      inOrder = inOrder && (pack.get(i).getName()).equals(names[i]);
    }
    return inOrder;
  }
 
  /*
  *testBubbleSort will ensure the bubble sorting algorithm can handle an empty, regular, and in order list
  **/
  @Test
  public void testBubbleSort() {
    // Test sort can handle emptyList
    Sorters2120.bubbleSort(emptyList);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.bubbleSort(pack);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.bubbleSort(pack);
    assertTrue(isInOrder(pack));
  }
  //USING COMPARATOR:
  @Test
  public void testBubbleSort2(){
	// Test sort can handle emptyList
    Sorters2120.bubbleSort(emptyList,comp);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.bubbleSort(pack,comp);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.bubbleSort(pack,comp);
    assertTrue(isInOrder(pack));
  }

  /*
  *testSelectionSort will ensure the selection sorting algorithm can handle an empty, regular, and in order list
  **/
  @Test
  public void testSelectionSort() {
    // Test sort can handle emptyList
    Sorters2120.selectionSort(emptyList);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.selectionSort(pack);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.selectionSort(pack);
    assertTrue(isInOrder(pack));
  }
   //USING COMPARATOR:
  @Test
    public void testSelectionSort2() {
    // Test sort can handle emptyList
    Sorters2120.selectionSort(emptyList,comp);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.selectionSort(pack,comp);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.selectionSort(pack,comp);
    assertTrue(isInOrder(pack));
  }
  
  /*
  *testMergeSort will ensure the merge sorting algorithm can handle an empty, regular, and in order list
  **/
  @Test
  public void testMergeSort() {
    // Test sort can handle emptyList
    Sorters2120.mergeSort(emptyList);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.mergeSort(pack);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.mergeSort(pack);
    assertTrue(isInOrder(pack));
  }
  //USING COMPARATOR:
  @Test
  public void testMergeSort2() {
    // Test sort can handle emptyList
    Sorters2120.mergeSort(emptyList,comp);
    assertTrue(emptyList.size() == 0);

    // Test normal case sorting
    assertFalse(isInOrder(pack));
    Sorters2120.mergeSort(pack,comp);
    assertTrue(isInOrder(pack));

    // Test Sorting on a sortedList
    Sorters2120.mergeSort(pack,comp);
    assertTrue(isInOrder(pack));
  }

  /*
  *testIndexOf will ensure the binary search algorithm can find highest, lowest, normal, and nonexistent elements
  **/
  @Test
  public void testIndexOf() {
    // Sort the pack using an independent sorter so that binary search can work
    Collections.sort(pack);
    Dog amadeus = new Dog("Amadeus", 125);
    Dog brutus = new Dog("Brutus", 102);
    Dog watson = new Dog("Watson", 39);

    Dog albert = new Dog("Albert", 130);
    Dog zeke = new Dog("Zeke", 12);

    assertEquals(9, Sorters2120.indexOf(amadeus, pack));
    assertEquals(7, Sorters2120.indexOf(brutus, pack));
    assertEquals(0, Sorters2120.indexOf(watson, pack));

    assertEquals(-1, Sorters2120.indexOf(albert, pack));
    assertEquals(-1, Sorters2120.indexOf(zeke, pack));
  }
  //USING COMPARATOR:
  @Test
  public void testIndexOf2() {
    // Sort the pack using an independent sorter so that binary search can work
    Collections.sort(pack);
    Dog amadeus = new Dog("Amadeus", 125);
    Dog brutus = new Dog("Brutus", 102);
    Dog watson = new Dog("Watson", 39);

    Dog albert = new Dog("Albert", 130);
    Dog zeke = new Dog("Zeke", 12);

    assertEquals(9, Sorters2120.indexOf(amadeus, pack, comp));
    assertEquals(7, Sorters2120.indexOf(brutus, pack, comp));
    assertEquals(0, Sorters2120.indexOf(watson, pack, comp));

    assertEquals(-1, Sorters2120.indexOf(albert, pack, comp));
    assertEquals(-1, Sorters2120.indexOf(zeke, pack, comp));
  }
}
