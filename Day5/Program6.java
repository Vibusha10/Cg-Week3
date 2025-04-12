import java.util.*;

public class Program6 {

    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size - 1;

        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            hashSet.add(i);
            treeSet.add(i);
        }

        long startArray = System.nanoTime();
        boolean foundInArray = arrayList.contains(target);
        long endArray = System.nanoTime();
        System.out.println("Array search time: " + (endArray - startArray) / 1_000_000 + " ms");

        long startHashSet = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long endHashSet = System.nanoTime();
        System.out.println("HashSet search time: " + (endHashSet - startHashSet) / 1_000_000 + " ms");

        long startTreeSet = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long endTreeSet = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTreeSet - startTreeSet) / 1_000_000 + " ms");
    }
}
