import java.util.*;

public class PerformanceComparisonMaps {

    public static void main (String [] args) {
        //mapsCreationAndInputSpeedComparison(getCapacityNumber());
        //mapsAddElementSpeedComparison(getCapacityNumber(), getIndexForMap());
        //mapsSearchElementSpeedComparison(getCapacityNumber(), getIndexForMap());
        //mapsDeleteElementSpeedComparison(getCapacityNumber(), getIndexForMap());
    }

    public static void mapsCreationAndInputSpeedComparison (int capacity){

        long startTimeForHashMap = System.currentTimeMillis();
        Map hashMap = createHashMap(capacity);
        long finishTimeForHashMap = System.currentTimeMillis();
        long timeConsumedMillisHashMap = finishTimeForHashMap - startTimeForHashMap;
        System.out.println("HashMap create and input speed in ms: " + timeConsumedMillisHashMap);
        //System.out.println(hashMap);

        long startTimeForTreeMap = System.currentTimeMillis();
        Map treeMap = createTreeMap(capacity);
        long finishTimeForTreeMap = System.currentTimeMillis();
        long timeConsumedMillisTreeMap = finishTimeForTreeMap - startTimeForTreeMap;
        System.out.println("TreeMap create and input speed in ms: " + timeConsumedMillisTreeMap);
        //System.out.println(treeMap);

    }

    public static void mapsAddElementSpeedComparison (int capacity, int index) {
        Map hashMap = createHashMap(capacity);
        Map treeMap = createTreeMap(capacity);

        long startTimeForHashSet = System.nanoTime();
        hashMap.put((double)index + 0.5, "testz");
        long finishTimeForHashSet = System.nanoTime();
        long timeConsumedMillisHashSet = finishTimeForHashSet - startTimeForHashSet;
        System.out.println("HashSet input element speed in ns: " + timeConsumedMillisHashSet);

        long startTimeForTreeSet = System.nanoTime();
        treeMap.put((double)index + 0.5, "testz");
        long finishTimeForTreeSet = System.nanoTime();
        long timeConsumedMillisTreeSet = finishTimeForTreeSet - startTimeForTreeSet;
        System.out.println("TreeSet input element speed in ns: " + timeConsumedMillisTreeSet);
    }

    public static void mapsSearchElementSpeedComparison (int capacity, int index) {
        Map hashMap = createHashMap(capacity);
        Map treeMap = createTreeMap(capacity);

        long startTimeForHashSet = System.nanoTime();
        //iteratorUsageForSearch(hashMap, getIndexForMap());
        hashMap.get((double)index);
        long finishTimeForHashSet = System.nanoTime();
        long timeConsumedMillisHashSet = finishTimeForHashSet - startTimeForHashSet;
        System.out.println("HashMap search element speed in ns: " + timeConsumedMillisHashSet);

        long startTimeForTreeSet = System.nanoTime();
        //iteratorUsageForSearch(treeMap, getIndexForMap());
        treeMap.get((double)index);
        long finishTimeForTreeSet = System.nanoTime();
        long timeConsumedMillisTreeSet = finishTimeForTreeSet - startTimeForTreeSet;
        System.out.println("TreeMap search element speed in ns: " + timeConsumedMillisTreeSet);
    }

    public static void mapsDeleteElementSpeedComparison (int capacity, int index) {
        Map hashMap = createHashMap(capacity);
        Map treeMap = createTreeMap(capacity);

        long startTimeForHashSet = System.nanoTime();
        hashMap.remove((double)index);
        long finishTimeForHashSet = System.nanoTime();
        long timeConsumedMillisHashSet = finishTimeForHashSet - startTimeForHashSet;
        System.out.println("HashMap delete element speed in ns: " + timeConsumedMillisHashSet);

        long startTimeForTreeSet = System.nanoTime();
        treeMap.remove((double)index);
        long finishTimeForTreeSet = System.nanoTime();
        long timeConsumedMillisTreeSet = finishTimeForTreeSet - startTimeForTreeSet;
        System.out.println("TreeMap delete element speed in ns: " + timeConsumedMillisTreeSet);
    }

    public static Map createHashMap (int capacity) {
        Map<Double, String> hashMap = new HashMap();

        for (int i = 0; i <capacity; i++) {
            hashMap.put((double)i, "test" + i);
        }

        return hashMap;
    }

    public static Map createTreeMap (int capacity) {
        Map<Double, String> treeMap = new TreeMap<>();

        for (int i = 0; i <capacity; i++) {
            treeMap.put((double)i, "test" + i);
        }

        return treeMap;
    }

    public static int getCapacityNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input list capacity number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static int getIndexForMap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input list index: ");
        int number = scanner.nextInt();
        return number;
    }
}
