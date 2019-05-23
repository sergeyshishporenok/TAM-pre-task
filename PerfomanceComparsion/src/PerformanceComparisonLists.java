import java.io.BufferedReader;
import java.util.*;

public class PerformanceComparisonLists {
    public static void main (String [] args) {
        //AddInEmptyCollectionSpeedComparison(getCapacityNumber());
        //SearchSpeedComparison(getCapacityNumber(), getListIndex());
        //AddElementInAlreadyCreatedCollection(getCapacityNumber(), getListIndex());
        //AddElementInAlreadyCreatedCollection(getCapacityNumber());
        //DeleteElementSpeedComparison(getCapacityNumber(), getListIndex());
    }

    public static void AddInEmptyCollectionSpeedComparison (int capacity) {

        // ArrayList add speed
        long startArrayListAdd = System.currentTimeMillis();
        List arraylist = createArrayList(capacity);
        long finishArrayListAdd = System.currentTimeMillis();
        long timeConsumedMillis = finishArrayListAdd - startArrayListAdd;
        System.out.println("ArrayList add speed in ms: " + timeConsumedMillis);

        // LinkedList add speed
        long startLinkedListAdd = System.currentTimeMillis();
        List linkedlist = createLinkedList(capacity);
        long finishLinkedListAdd = System.currentTimeMillis();
        long timeConsumedMillisLinkedList = finishLinkedListAdd - startLinkedListAdd;
        System.out.println("LinkedList add speed in ms: " + timeConsumedMillisLinkedList);

    }

    public static void AddElementInAlreadyCreatedCollection(int capacity, int elementIndex) {
        //Create lists for comparison
        List arrayList = createArrayList(capacity);
        List linkedList = createLinkedList(capacity);

        //addElement speed for ArrayList
        long startArrayListSearch = System.nanoTime();
        arrayList.add(elementIndex,(int)(Math.random()));
        long finishArrayListSearch = System.nanoTime();
        long timeConsumedMillisArrayList = finishArrayListSearch - startArrayListSearch;
        System.out.println("ArrayList add element in middle speed in ns: " + timeConsumedMillisArrayList);

        //addElement speed for LinkedList
        long startLinkedListSearch = System.nanoTime();
        linkedList.add(elementIndex, (int)(Math.random()));
        long finishLinkedListSearch = System.nanoTime();
        long timeConsumedMillisLinkedList = finishLinkedListSearch - startLinkedListSearch;
        System.out.println("LinkedList add element in middle speed in ns: " + timeConsumedMillisLinkedList);
    }

    public static void AddElementInAlreadyCreatedCollection(int capacity) {
        //Create lists for comparison
        List arrayList = createArrayList(capacity);
        List linkedList = createLinkedList(capacity);

        //addElement in the start of list speed for ArrayList
        long startArrayListSearch = System.nanoTime();
        arrayList.add((int)(Math.random()));
        long finishArrayListSearch = System.nanoTime();
        long timeConsumedMillisArrayList = finishArrayListSearch - startArrayListSearch;
        System.out.println("ArrayList add element in start in ns: " + timeConsumedMillisArrayList);


        //addElement in the start of list speed for LinkedList
        long startLinkedListSearch = System.nanoTime();
        linkedList.add((int)(Math.random()));
        long finishLinkedListSearch = System.nanoTime();
        long timeConsumedMillisLinkedList = finishLinkedListSearch - startLinkedListSearch;
        System.out.println("LinkedList add element in start speed in ns: " + timeConsumedMillisLinkedList);
    }

    public static void SearchSpeedComparison (int capacity, int elementIndex) {
        List arrayList = createArrayList(capacity);
        List linkedList = createLinkedList(capacity);

        long startArrayListSearch = System.nanoTime();
        arrayList.get(elementIndex);
        long finishArrayListSearch = System.nanoTime();
        long timeConsumedMillisArrayList = finishArrayListSearch - startArrayListSearch;
        System.out.println("ArrayList delete speed in ns: " + timeConsumedMillisArrayList);

        long startLinkedListSearch = System.nanoTime();
        linkedList.get(elementIndex);
        long finishLinkedListSearch = System.nanoTime();
        long timeConsumedMillisLinkedList = finishLinkedListSearch - startLinkedListSearch;
        System.out.println("LinkedList delete speed in ns: " + timeConsumedMillisLinkedList);

    }

    public static void  DeleteElementSpeedComparison(int capacity, int elementIndex) {
        List arrayList = createArrayList(capacity);
        List linkedList = createLinkedList(capacity);

        long startArrayListSearch = System.nanoTime();
        arrayList.remove(elementIndex);
        long finishArrayListSearch = System.nanoTime();
        long timeConsumedMillisArrayList = finishArrayListSearch - startArrayListSearch;
        System.out.println("ArrayList search speed in ns: " + timeConsumedMillisArrayList);

        long startLinkedListSearch = System.nanoTime();
        linkedList.remove(elementIndex);
        long finishLinkedListSearch = System.nanoTime();
        long timeConsumedMillisLinkedList = finishLinkedListSearch - startLinkedListSearch;
        System.out.println("LinkedList search speed in ns: " + timeConsumedMillisLinkedList);
    }


    public static List createArrayList(int capacity) {
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < capacity; i++) {
            list.add((int)(Math.random()));
        }
        return list;
    }

    public static List createLinkedList(int capacity) {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < capacity; i++) {
            list.add((int)(Math.random()));
        }
        return list;
    }

    public static int getCapacityNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input list capacity number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static int getListIndex() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input list index: ");
        int number = scanner.nextInt();
        return number;
    }

}
