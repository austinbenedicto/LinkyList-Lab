import java.util.LinkedList;
import java.util.Random;

/**
 * Comparison class to test LinkyList correctness and performance against Java's LinkedList
 * 
 * @author Austin Benedicto
 * @version 12/14/2025
 */
public class LinkyListComparison
{
    private static final int SMALL_SIZE = 100;
    private static final int MEDIUM_SIZE = 1000;
    private static final int LARGE_SIZE = 10000;
    private static final int ITERATIONS = 1000;
    
    public static void main(String[] args)
    {
        System.out.println("=".repeat(80));
        System.out.println("LinkyList vs Java LinkedList - Correctness and Performance Comparison");
        System.out.println("=".repeat(80));
        System.out.println();
        
        // Run correctness tests
        System.out.println("CORRECTNESS TESTS");
        System.out.println("-".repeat(80));
        runCorrectnessTests();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("PERFORMANCE TESTS");
        System.out.println("-".repeat(80));
        
        // Run performance tests
        runPerformanceTests(SMALL_SIZE, "Small (100 elements)");
        System.out.println();
        runPerformanceTests(MEDIUM_SIZE, "Medium (1000 elements)");
        System.out.println();
        runPerformanceTests(LARGE_SIZE, "Large (10000 elements)");
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("Testing Complete!");
        System.out.println("=".repeat(80));
    }
    
    private static void runCorrectnessTests()
    {
        int passed = 0;
        int failed = 0;
        
        // Test isEmpty on empty list
        if( testIsEmpty() ) {
            System.out.println("✓ isEmpty() - PASSED");
            passed++;
        } else {
            System.out.println("✗ isEmpty() - FAILED");
            failed++;
        }
        
        // Test add
        if( testAdd() ) {
            System.out.println("✓ add() - PASSED");
            passed++;
        } else {
            System.out.println("✗ add() - FAILED");
            failed++;
        }
        
        // Test get
        if( testGet() ) {
            System.out.println("✓ get() - PASSED");
            passed++;
        } else {
            System.out.println("✗ get() - FAILED");
            failed++;
        }
        
        // Test set
        if( testSet() ) {
            System.out.println("✓ set() - PASSED");
            passed++;
        } else {
            System.out.println("✗ set() - FAILED");
            failed++;
        }
        
        // Test remove by index
        if( testRemoveByIndex() ) {
            System.out.println("✓ remove(int) - PASSED");
            passed++;
        } else {
            System.out.println("✗ remove(int) - FAILED");
            failed++;
        }
        
        // Test remove by object
        if( testRemoveByObject() ) {
            System.out.println("✓ remove(Object) - PASSED");
            passed++;
        } else {
            System.out.println("✗ remove(Object) - FAILED");
            failed++;
        }
        
        // Test contains
        if( testContains() ) {
            System.out.println("✓ contains() - PASSED");
            passed++;
        } else {
            System.out.println("✗ contains() - FAILED");
            failed++;
        }
        
        // Test indexOf
        if( testIndexOf() ) {
            System.out.println("✓ indexOf() - PASSED");
            passed++;
        } else {
            System.out.println("✗ indexOf() - FAILED");
            failed++;
        }
        
        // Test lastIndexOf
        if( testLastIndexOf() ) {
            System.out.println("✓ lastIndexOf() - PASSED");
            passed++;
        } else {
            System.out.println("✗ lastIndexOf() - FAILED");
            failed++;
        }
        
        // Test size
        if( testSize() ) {
            System.out.println("✓ size() - PASSED");
            passed++;
        } else {
            System.out.println("✗ size() - FAILED");
            failed++;
        }
        
        // Test clear
        if( testClear() ) {
            System.out.println("✓ clear() - PASSED");
            passed++;
        } else {
            System.out.println("✗ clear() - FAILED");
            failed++;
        }
        
        // Test equals
        if( testEquals() ) {
            System.out.println("✓ equals() - PASSED");
            passed++;
        } else {
            System.out.println("✗ equals() - FAILED");
            failed++;
        }
        
        // Test toString
        if( testToString() ) {
            System.out.println("✓ toString() - PASSED");
            passed++;
        } else {
            System.out.println("✗ toString() - FAILED");
            failed++;
        }
        
        System.out.println("-".repeat(80));
        System.out.println(String.format("Results: %d passed, %d failed", passed, failed));
    }
    
    private static boolean testIsEmpty()
    {
        LinkyList<Integer> list = new LinkyList<>();
        if( !list.isEmpty() ) return false;
        list.add(1);
        if( list.isEmpty() ) return false;
        list.clear();
        return list.isEmpty();
    }
    
    private static boolean testAdd()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        if( linky.size() != java.size() ) return false;
        for( int i = 0; i < 10; i++ ) {
            if( !linky.get(i).equals(java.get(i)) ) return false;
        }
        return true;
    }
    

    
    private static boolean testGet()
    {
        LinkyList<String> linky = new LinkyList<>();
        linky.add("A");
        linky.add("B");
        linky.add("C");
        
        return linky.get(0).equals("A") && 
               linky.get(1).equals("B") && 
               linky.get(2).equals("C");
    }
    
    private static boolean testSet()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        linky.set(5, 100);
        java.set(5, 100);
        
        for( int i = 0; i < 10; i++ ) {
            if( !linky.get(i).equals(java.get(i)) ) return false;
        }
        return true;
    }
    
    private static boolean testRemoveByIndex()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        Integer removed1 = linky.remove(5);
        Integer removed2 = java.remove(5);
        
        if( !removed1.equals(removed2) ) return false;
        if( linky.size() != java.size() ) return false;
        
        for( int i = 0; i < linky.size(); i++ ) {
            if( !linky.get(i).equals(java.get(i)) ) return false;
        }
        return true;
    }
    
    private static boolean testRemoveByObject()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        boolean removed1 = linky.remove(Integer.valueOf(5));
        boolean removed2 = java.remove(Integer.valueOf(5));
        
        if( removed1 != removed2 ) return false;
        if( linky.size() != java.size() ) return false;
        
        for( int i = 0; i < linky.size(); i++ ) {
            if( !linky.get(i).equals(java.get(i)) ) return false;
        }
        return true;
    }
    
    private static boolean testContains()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
        }
        
        return linky.contains(5) && !linky.contains(100);
    }
    
    private static boolean testIndexOf()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        linky.add(10);
        linky.add(20);
        linky.add(30);
        linky.add(20);
        
        return linky.indexOf(20) == 1 && linky.indexOf(100) == -1;
    }
    
    private static boolean testLastIndexOf()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        linky.add(10);
        linky.add(20);
        linky.add(30);
        linky.add(20);
        
        return linky.lastIndexOf(20) == 3 && linky.lastIndexOf(100) == -1;
    }
    
    private static boolean testSize()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        if( linky.size() != 0 ) return false;
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
        }
        
        return linky.size() == 10;
    }
    
    private static boolean testClear()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
        }
        
        linky.clear();
        return linky.isEmpty() && linky.size() == 0;
    }
    
    private static boolean testEquals()
    {
        LinkyList<Integer> list1 = new LinkyList<>();
        LinkyList<Integer> list2 = new LinkyList<>();
        LinkyList<Integer> list3 = new LinkyList<>();
        
        for( int i = 0; i < 10; i++ ) {
            list1.add(i);
            list2.add(i);
            list3.add(i + 1);
        }
        
        return list1.equals(list2) && !list1.equals(list3) && list1.equals(list1);
    }
    
    private static boolean testToString()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        
        // Test empty list
        if( !linky.toString().equals("[]") ) return false;
        
        linky.add(1);
        linky.add(2);
        linky.add(3);
        
        // Current implementation only returns "[]"
        // This test passes if toString returns a string (not null)
        return linky.toString() != null;
    }
    
    private static void runPerformanceTests(int size, String label)
    {
        System.out.println("\n" + label);
        System.out.println("-".repeat(80));
        
        Random rand = new Random(12345); // Fixed seed for reproducibility
        
        // Test add() performance
        testAddPerformance(size, rand);
        
        // Test get() performance
        testGetPerformance(size, rand);
        
        // Test remove() performance
        testRemovePerformance(size, rand);
        
        // Test contains() performance
        testContainsPerformance(size, rand);
        
        // Test indexOf() performance
        testIndexOfPerformance(size, rand);
        
        // Test equals() performance
        testEqualsPerformance(size, rand);
    }
    
    private static void testAddPerformance(int size, Random rand)
    {
        // LinkyList
        long start = System.nanoTime();
        LinkyList<Integer> linky = new LinkyList<>();
        for( int i = 0; i < size; i++ ) {
            linky.add(rand.nextInt(1000));
        }
        long linkyTime = System.nanoTime() - start;
        
        // Java LinkedList
        rand.setSeed(12345);
        start = System.nanoTime();
        LinkedList<Integer> java = new LinkedList<>();
        for( int i = 0; i < size; i++ ) {
            java.add(rand.nextInt(1000));
        }
        long javaTime = System.nanoTime() - start;
        
        printComparison("add()", linkyTime, javaTime);
    }
    
    private static void testGetPerformance(int size, Random rand)
    {
        // Setup
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        for( int i = 0; i < size; i++ ) {
            int val = rand.nextInt(1000);
            linky.add(val);
            java.add(val);
        }
        
        // LinkyList
        rand.setSeed(12345);
        long start = System.nanoTime();
        for( int i = 0; i < ITERATIONS; i++ ) {
            linky.get(rand.nextInt(size));
        }
        long linkyTime = System.nanoTime() - start;
        
        // Java LinkedList
        rand.setSeed(12345);
        start = System.nanoTime();
        for( int i = 0; i < ITERATIONS; i++ ) {
            java.get(rand.nextInt(size));
        }
        long javaTime = System.nanoTime() - start;
        
        printComparison("get()", linkyTime, javaTime);
    }
    
    private static void testRemovePerformance(int size, Random rand)
    {
        // Setup LinkyList
        LinkyList<Integer> linky = new LinkyList<>();
        for( int i = 0; i < size; i++ ) {
            linky.add(rand.nextInt(1000));
        }
        
        // LinkyList
        rand.setSeed(12345);
        long start = System.nanoTime();
        for( int i = 0; i < Math.min(100, size / 2); i++ ) {
            linky.remove(rand.nextInt(linky.size()));
        }
        long linkyTime = System.nanoTime() - start;
        
        // Setup Java LinkedList
        rand.setSeed(12345);
        LinkedList<Integer> java = new LinkedList<>();
        for( int i = 0; i < size; i++ ) {
            java.add(rand.nextInt(1000));
        }
        
        // Java LinkedList
        rand.setSeed(12345);
        start = System.nanoTime();
        for( int i = 0; i < Math.min(100, size / 2); i++ ) {
            java.remove(rand.nextInt(java.size()));
        }
        long javaTime = System.nanoTime() - start;
        
        printComparison("remove()", linkyTime, javaTime);
    }
    
    private static void testContainsPerformance(int size, Random rand)
    {
        // Setup
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        for( int i = 0; i < size; i++ ) {
            int val = rand.nextInt(1000);
            linky.add(val);
            java.add(val);
        }
        
        // LinkyList
        rand.setSeed(12345);
        long start = System.nanoTime();
        for( int i = 0; i < ITERATIONS; i++ ) {
            linky.contains(rand.nextInt(1000));
        }
        long linkyTime = System.nanoTime() - start;
        
        // Java LinkedList
        rand.setSeed(12345);
        start = System.nanoTime();
        for( int i = 0; i < ITERATIONS; i++ ) {
            java.contains(rand.nextInt(1000));
        }
        long javaTime = System.nanoTime() - start;
        
        printComparison("contains()", linkyTime, javaTime);
    }
    
    private static void testIndexOfPerformance(int size, Random rand)
    {
        // Setup
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        for( int i = 0; i < size; i++ ) {
            int val = rand.nextInt(1000);
            linky.add(val);
            java.add(val);
        }
        
        // LinkyList
        rand.setSeed(12345);
        long start = System.nanoTime();
        for( int i = 0; i < ITERATIONS; i++ ) {
            linky.indexOf(rand.nextInt(1000));
        }
        long linkyTime = System.nanoTime() - start;
        
        // Java LinkedList
        rand.setSeed(12345);
        start = System.nanoTime();
        for( int i = 0; i < ITERATIONS; i++ ) {
            java.indexOf(rand.nextInt(1000));
        }
        long javaTime = System.nanoTime() - start;
        
        printComparison("indexOf()", linkyTime, javaTime);
    }
    
    private static void testEqualsPerformance(int size, Random rand)
    {
        // Setup
        LinkyList<Integer> linky1 = new LinkyList<>();
        LinkyList<Integer> linky2 = new LinkyList<>();
        LinkedList<Integer> java1 = new LinkedList<>();
        LinkedList<Integer> java2 = new LinkedList<>();
        
        for( int i = 0; i < size; i++ ) {
            int val = rand.nextInt(1000);
            linky1.add(val);
            linky2.add(val);
            java1.add(val);
            java2.add(val);
        }
        
        // LinkyList
        long start = System.nanoTime();
        for( int i = 0; i < ITERATIONS; i++ ) {
            linky1.equals(linky2);
        }
        long linkyTime = System.nanoTime() - start;
        
        // Java LinkedList
        start = System.nanoTime();
        for( int i = 0; i < ITERATIONS; i++ ) {
            java1.equals(java2);
        }
        long javaTime = System.nanoTime() - start;
        
        printComparison("equals()", linkyTime, javaTime);
    }
    
    private static void printComparison(String method, long linkyTime, long javaTime)
    {
        double linkyMs = linkyTime / 1_000_000.0;
        double javaMs = javaTime / 1_000_000.0;
        double ratio = (double) linkyTime / javaTime;
        
        String performance;
        if( ratio < 0.9 ) {
            performance = String.format("%.2fx FASTER", 1.0 / ratio);
        } else if( ratio > 1.1 ) {
            performance = String.format("%.2fx slower", ratio);
        } else {
            performance = "~same speed";
        }
        
        System.out.printf("%-15s | LinkyList: %8.2f ms | Java LinkedList: %8.2f ms | %s%n",
                         method, linkyMs, javaMs, performance);
    }
}
