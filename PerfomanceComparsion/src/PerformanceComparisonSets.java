import java.util.*;

public class PerformanceComparisonSets {
    public static void main (String [] args) {
        //setsCreationAndInputSpeedComparison(getCapacityNumber());
        //setsAddElementSpeedComparison(getCapacityNumber(), getListIndex());
        //setsSearchElementSpeedComparison(getCapacityNumber(), getListIndex());
        setsDeleteElementSpeedComparison(getCapacityNumber(),getListIndex());
    }

    public static void setsCreationAndInputSpeedComparison (int capacity){

        long startTimeForHashSet = System.currentTimeMillis();
        Set hashSet = createHashSet(capacity);
        long finishTimeForHashSet = System.currentTimeMillis();
        long timeConsumedMillisHashSet = finishTimeForHashSet - startTimeForHashSet;
        System.out.println("HashSet create and input speed in ms: " + timeConsumedMillisHashSet);

        long startTimeForTreeSet = System.currentTimeMillis();
        Set treeSet = createTreeSet(capacity);
        long finishTimeForTreeSet = System.currentTimeMillis();
        long timeConsumedMillisTreeSet = finishTimeForTreeSet - startTimeForTreeSet;
        System.out.println("TreeSet create and input speed in ms: " + timeConsumedMillisTreeSet);

    }

    public static void setsAddElementSpeedComparison (int capacity, int index) {
        Set hashSet = createHashSet(capacity);
        Set treeSet = createTreeSet(capacity);

        long startTimeForHashSet = System.nanoTime();
        hashSet.add((double) index + 0.5);
        long finishTimeForHashSet = System.nanoTime();
        long timeConsumedMillisHashSet = finishTimeForHashSet - startTimeForHashSet;
        System.out.println("HashSet input element speed in ns: " + timeConsumedMillisHashSet);
        //System.out.println(hashSet);

        long startTimeForTreeSet = System.nanoTime();
        treeSet.add((double) index + 0.5);
        long finishTimeForTreeSet = System.nanoTime();
        long timeConsumedMillisTreeSet = finishTimeForTreeSet - startTimeForTreeSet;
        System.out.println("TreeSet input element speed in ns: " + timeConsumedMillisTreeSet);
        //System.out.println(treeSet);
    }

    public static void setsSearchElementSpeedComparison (int capacity, int element) {
        Set hashSet = createHashSet(capacity);
        Set treeSet = createTreeSet(capacity);

        System.out.println("Search by Iterator"); //search required element by Iterator
        long startTimeForHashSet = System.nanoTime();
        iteratorUsageForSearch(hashSet, element);
        long finishTimeForHashSet = System.nanoTime();
        long timeConsumedMillisHashSet = finishTimeForHashSet - startTimeForHashSet;
        System.out.println("HashSet search element speed in ns: " + timeConsumedMillisHashSet);

        long startTimeForTreeSet = System.nanoTime();
        iteratorUsageForSearch(treeSet, element);
        long finishTimeForTreeSet = System.nanoTime();
        long timeConsumedMillisTreeSet = finishTimeForTreeSet - startTimeForTreeSet;
        System.out.println("TreeSet search element speed in ns: " + timeConsumedMillisTreeSet);


        System.out.println("Search by contains"); //Search by contains
        long startTimeForHashSetByContains = System.nanoTime();
        hashSet.contains((double)element);
        long finishTimeForHashSetByContains = System.nanoTime();
        long timeConsumedMillisHashSetByContains = finishTimeForHashSetByContains - startTimeForHashSetByContains;
        System.out.println("HashSet search element speed in ns: " + timeConsumedMillisHashSetByContains);

        long startTimeForTreeSetByContains = System.nanoTime();
        treeSet.contains((double)element);
        long finishTimeForTreeSetByContains = System.nanoTime();
        long timeConsumedMillisTreeSetByContains = finishTimeForTreeSetByContains - startTimeForTreeSetByContains;
        System.out.println("TreeSet search element speed in ns: " + timeConsumedMillisTreeSetByContains);

    }

    public static void setsDeleteElementSpeedComparison (int capacity, int element) {
        Set hashSet = createHashSet(capacity);
        Set treeSet = createTreeSet(capacity);

        long startTimeForHashSet = System.nanoTime();
        hashSet.remove((double)element);
        long finishTimeForHashSet = System.nanoTime();
        long timeConsumedMillisHashSet = finishTimeForHashSet - startTimeForHashSet;
        System.out.println("HashSet remove element speed in ns: " + timeConsumedMillisHashSet);
        //iteratorUsageForSearch(hashSet, 1);

        long startTimeForTreeSet = System.nanoTime();
        treeSet.remove((double)element);
        long finishTimeForTreeSet = System.nanoTime();
        long timeConsumedMillisTreeSet = finishTimeForTreeSet - startTimeForTreeSet;
        System.out.println("TreeSet remove element speed in ns: " + timeConsumedMillisTreeSet);
        //iteratorUsageForSearch(treeSet, 1);

    }

    public static void iteratorUsageForSearch (Set set,int element) {
        Iterator<Double> iterator = set.iterator();

        while (iterator.hasNext()) {
            Double number = iterator.next();
            //System.out.println(text);

            if (number.equals((double)element)) {
                //System.out.println(text);
                break;
            }

        }
    }

    public static Set createHashSet(int capacity) {
        Set<Double> hashSet = new HashSet<Double>();

        for (int i = 0; i < capacity; i++) {
            hashSet.add((double)i);
        }
        return hashSet;
    }

    public static Set createTreeSet(int capacity) {
        Set<Double> treeSet = new TreeSet<Double>();

        for (int i = 0; i < capacity; i++) {
            treeSet.add((double)i);
        }
        return treeSet;

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
