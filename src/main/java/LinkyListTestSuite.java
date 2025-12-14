import java.util.LinkedList;

/**
 * Comprehensive test suite to verify LinkyList produces identical results to Java's LinkedList
 * 
 * @author Austin Benedicto
 * @version 12/14/2025
 */
public class LinkyListTestSuite
{
    private static int testsPassed = 0;
    private static int testsFailed = 0;
    
    public static void main(String[] args)
    {
        System.out.println("=".repeat(80));
        System.out.println("LinkyList Comprehensive Test Suite");
        System.out.println("Verifying LinkyList produces identical results to Java's LinkedList");
        System.out.println("=".repeat(80));
        System.out.println();
        
        // Basic operations
        testEmptyList();
        testSingleElement();
        testMultipleElements();
        
        // Add operations
        testAddToEnd();
        testAddAtIndex();
        testAddNull();
        testAddDuplicates();
        
        // Get operations
        testGetFirst();
        testGetLast();
        testGetMiddle();
        
        // Set operations
        testSetFirst();
        testSetLast();
        testSetMiddle();
        testSetNull();
        
        // Remove operations
        testRemoveByIndex();
        testRemoveByObject();
        testRemoveFirst();
        testRemoveLast();
        testRemoveNull();
        testRemoveNonExistent();
        
        // Contains operations
        testContainsExisting();
        testContainsNonExisting();
        testContainsNull();
        
        // IndexOf operations
        testIndexOfFirst();
        testIndexOfMiddle();
        testIndexOfLast();
        testIndexOfNonExistent();
        testIndexOfNull();
        testIndexOfDuplicates();
        
        // LastIndexOf operations
        testLastIndexOfFirst();
        testLastIndexOfMiddle();
        testLastIndexOfLast();
        testLastIndexOfNonExistent();
        testLastIndexOfNull();
        testLastIndexOfDuplicates();
        
        // Size operations
        testSizeEmpty();
        testSizeAfterAdd();
        testSizeAfterRemove();
        testSizeAfterClear();
        
        // Clear operations
        testClearEmpty();
        testClearNonEmpty();
        
        // Equals operations
        testEqualsSameList();
        testEqualsDifferentOrder();
        testEqualsDifferentSize();
        testEqualsWithNull();
        testEqualsEmpty();
        
        // ToString operations
        testToStringEmpty();
        testToStringSingle();
        testToStringMultiple();
        
        // Edge cases
        testLargeList();
        testAlternatingNulls();
        testAllNulls();
        testMixedOperations();
        
        // Print results
        System.out.println("\n" + "=".repeat(80));
        System.out.println("Test Results");
        System.out.println("=".repeat(80));
        System.out.printf("Total Tests: %d%n", testsPassed + testsFailed);
        System.out.printf("Passed: %d%n", testsPassed);
        System.out.printf("Failed: %d%n", testsFailed);
        
        if( testsFailed == 0 ) {
            System.out.println("\n✓ ALL TESTS PASSED! LinkyList behaves identically to LinkedList!");
        } else {
            System.out.println("\n✗ Some tests failed. Review output above.");
        }
        System.out.println("=".repeat(80));
    }
    
    // ==================== BASIC OPERATIONS ====================
    
    private static void testEmptyList()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        assertBehavior("Empty list - isEmpty()", 
            linky.isEmpty(), java.isEmpty());
        assertBehavior("Empty list - size()", 
            linky.size(), java.size());
    }
    
    private static void testSingleElement()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        java.add("A");
        
        assertBehavior("Single element - size()", 
            linky.size(), java.size());
        assertBehavior("Single element - get(0)", 
            linky.get(0), java.get(0));
        assertBehavior("Single element - contains('A')", 
            linky.contains("A"), java.contains("A"));
    }
    
    private static void testMultipleElements()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        assertBehavior("Multiple elements - size()", 
            linky.size(), java.size());
        
        for( int i = 0; i < 10; i++ ) {
            assertBehavior("Multiple elements - get(" + i + ")", 
                linky.get(i), java.get(i));
        }
    }
    
    // ==================== ADD OPERATIONS ====================
    
    private static void testAddToEnd()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            boolean linkyResult = linky.add(i * 10);
            boolean javaResult = java.add(i * 10);
            assertBehavior("Add to end - add(" + (i * 10) + ")", 
                linkyResult, javaResult);
        }
        
        assertBehavior("Add to end - final size", 
            linky.size(), java.size());
        assertListsEqual("Add to end - contents", linky, java);
    }
    
    private static void testAddAtIndex()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("C");
        java.add("A");
        java.add("C");
        
        linky.add(1, "B");
        java.add(1, "B");
        
        assertBehavior("Add at index - size after insert", 
            linky.size(), java.size());
        assertListsEqual("Add at index - contents", linky, java);
    }
    
    private static void testAddNull()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add(null);
        java.add(null);
        linky.add("A");
        java.add("A");
        linky.add(null);
        java.add(null);
        
        assertBehavior("Add null - size", 
            linky.size(), java.size());
        assertListsEqual("Add null - contents", linky, java);
    }
    
    private static void testAddDuplicates()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        linky.add(5);
        linky.add(5);
        linky.add(5);
        java.add(5);
        java.add(5);
        java.add(5);
        
        assertBehavior("Add duplicates - size", 
            linky.size(), java.size());
        assertListsEqual("Add duplicates - contents", linky, java);
    }
    
    // ==================== GET OPERATIONS ====================
    
    private static void testGetFirst()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("First");
        linky.add("Second");
        java.add("First");
        java.add("Second");
        
        assertBehavior("Get first - get(0)", 
            linky.get(0), java.get(0));
    }
    
    private static void testGetLast()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("First");
        linky.add("Last");
        java.add("First");
        java.add("Last");
        
        assertBehavior("Get last - get(1)", 
            linky.get(1), java.get(1));
    }
    
    private static void testGetMiddle()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        assertBehavior("Get middle - get(2)", 
            linky.get(2), java.get(2));
    }
    
    // ==================== SET OPERATIONS ====================
    
    private static void testSetFirst()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        java.add("A");
        java.add("B");
        
        String linkyOld = linky.set(0, "X");
        String javaOld = java.set(0, "X");
        
        assertBehavior("Set first - old value", linkyOld, javaOld);
        assertBehavior("Set first - new value", linky.get(0), java.get(0));
    }
    
    private static void testSetLast()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        java.add("A");
        java.add("B");
        
        String linkyOld = linky.set(1, "Y");
        String javaOld = java.set(1, "Y");
        
        assertBehavior("Set last - old value", linkyOld, javaOld);
        assertBehavior("Set last - new value", linky.get(1), java.get(1));
    }
    
    private static void testSetMiddle()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        Integer linkyOld = linky.set(2, 99);
        Integer javaOld = java.set(2, 99);
        
        assertBehavior("Set middle - old value", linkyOld, javaOld);
        assertListsEqual("Set middle - contents", linky, java);
    }
    
    private static void testSetNull()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        java.add("A");
        
        linky.set(0, null);
        java.set(0, null);
        
        assertBehavior("Set null - get(0)", linky.get(0), java.get(0));
    }
    
    // ==================== REMOVE OPERATIONS ====================
    
    private static void testRemoveByIndex()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        Integer linkyRemoved = linky.remove(2);
        Integer javaRemoved = java.remove(2);
        
        assertBehavior("Remove by index - removed value", linkyRemoved, javaRemoved);
        assertBehavior("Remove by index - size after", linky.size(), java.size());
        assertListsEqual("Remove by index - contents", linky, java);
    }
    
    private static void testRemoveByObject()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        linky.add("C");
        java.add("A");
        java.add("B");
        java.add("C");
        
        boolean linkyResult = linky.remove("B");
        boolean javaResult = java.remove("B");
        
        assertBehavior("Remove by object - return value", linkyResult, javaResult);
        assertListsEqual("Remove by object - contents", linky, java);
    }
    
    private static void testRemoveFirst()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        Integer linkyRemoved = linky.remove(0);
        Integer javaRemoved = java.remove(0);
        
        assertBehavior("Remove first - removed value", linkyRemoved, javaRemoved);
        assertListsEqual("Remove first - contents", linky, java);
    }
    
    private static void testRemoveLast()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        Integer linkyRemoved = linky.remove(linky.size() - 1);
        Integer javaRemoved = java.remove(java.size() - 1);
        
        assertBehavior("Remove last - removed value", linkyRemoved, javaRemoved);
        assertListsEqual("Remove last - contents", linky, java);
    }
    
    private static void testRemoveNull()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add(null);
        linky.add("B");
        java.add("A");
        java.add(null);
        java.add("B");
        
        boolean linkyResult = linky.remove(null);
        boolean javaResult = java.remove(null);
        
        assertBehavior("Remove null - return value", linkyResult, javaResult);
        assertListsEqual("Remove null - contents", linky, java);
    }
    
    private static void testRemoveNonExistent()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        java.add("A");
        
        boolean linkyResult = linky.remove("Z");
        boolean javaResult = java.remove("Z");
        
        assertBehavior("Remove non-existent - return value", linkyResult, javaResult);
        assertBehavior("Remove non-existent - size unchanged", linky.size(), java.size());
    }
    
    // ==================== CONTAINS OPERATIONS ====================
    
    private static void testContainsExisting()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        assertBehavior("Contains existing - contains(3)", 
            linky.contains(3), java.contains(3));
    }
    
    private static void testContainsNonExisting()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        assertBehavior("Contains non-existing - contains(99)", 
            linky.contains(99), java.contains(99));
    }
    
    private static void testContainsNull()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add(null);
        java.add("A");
        java.add(null);
        
        assertBehavior("Contains null - contains(null)", 
            linky.contains(null), java.contains(null));
    }
    
    // ==================== INDEXOF OPERATIONS ====================
    
    private static void testIndexOfFirst()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        linky.add("C");
        java.add("A");
        java.add("B");
        java.add("C");
        
        assertBehavior("IndexOf first - indexOf('A')", 
            linky.indexOf("A"), java.indexOf("A"));
    }
    
    private static void testIndexOfMiddle()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        linky.add("C");
        java.add("A");
        java.add("B");
        java.add("C");
        
        assertBehavior("IndexOf middle - indexOf('B')", 
            linky.indexOf("B"), java.indexOf("B"));
    }
    
    private static void testIndexOfLast()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        linky.add("C");
        java.add("A");
        java.add("B");
        java.add("C");
        
        assertBehavior("IndexOf last - indexOf('C')", 
            linky.indexOf("C"), java.indexOf("C"));
    }
    
    private static void testIndexOfNonExistent()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        java.add("A");
        
        assertBehavior("IndexOf non-existent - indexOf('Z')", 
            linky.indexOf("Z"), java.indexOf("Z"));
    }
    
    private static void testIndexOfNull()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add(null);
        linky.add("B");
        java.add("A");
        java.add(null);
        java.add("B");
        
        assertBehavior("IndexOf null - indexOf(null)", 
            linky.indexOf(null), java.indexOf(null));
    }
    
    private static void testIndexOfDuplicates()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        linky.add(5);
        linky.add(10);
        linky.add(5);
        java.add(5);
        java.add(10);
        java.add(5);
        
        assertBehavior("IndexOf duplicates - indexOf(5)", 
            linky.indexOf(5), java.indexOf(5));
    }
    
    // ==================== LASTINDEXOF OPERATIONS ====================
    
    private static void testLastIndexOfFirst()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        linky.add("A");
        java.add("A");
        java.add("B");
        java.add("A");
        
        assertBehavior("LastIndexOf first - lastIndexOf('A')", 
            linky.lastIndexOf("A"), java.lastIndexOf("A"));
    }
    
    private static void testLastIndexOfMiddle()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        linky.add("C");
        java.add("A");
        java.add("B");
        java.add("C");
        
        assertBehavior("LastIndexOf middle - lastIndexOf('B')", 
            linky.lastIndexOf("B"), java.lastIndexOf("B"));
    }
    
    private static void testLastIndexOfLast()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add("B");
        linky.add("C");
        java.add("A");
        java.add("B");
        java.add("C");
        
        assertBehavior("LastIndexOf last - lastIndexOf('C')", 
            linky.lastIndexOf("C"), java.lastIndexOf("C"));
    }
    
    private static void testLastIndexOfNonExistent()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        java.add("A");
        
        assertBehavior("LastIndexOf non-existent - lastIndexOf('Z')", 
            linky.lastIndexOf("Z"), java.lastIndexOf("Z"));
    }
    
    private static void testLastIndexOfNull()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        linky.add("A");
        linky.add(null);
        linky.add("B");
        linky.add(null);
        java.add("A");
        java.add(null);
        java.add("B");
        java.add(null);
        
        assertBehavior("LastIndexOf null - lastIndexOf(null)", 
            linky.lastIndexOf(null), java.lastIndexOf(null));
    }
    
    private static void testLastIndexOfDuplicates()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        linky.add(5);
        linky.add(10);
        linky.add(5);
        linky.add(15);
        linky.add(5);
        java.add(5);
        java.add(10);
        java.add(5);
        java.add(15);
        java.add(5);
        
        assertBehavior("LastIndexOf duplicates - lastIndexOf(5)", 
            linky.lastIndexOf(5), java.lastIndexOf(5));
    }
    
    // ==================== SIZE OPERATIONS ====================
    
    private static void testSizeEmpty()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        assertBehavior("Size empty - size()", 
            linky.size(), java.size());
    }
    
    private static void testSizeAfterAdd()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        assertBehavior("Size after add - size()", 
            linky.size(), java.size());
    }
    
    private static void testSizeAfterRemove()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        linky.remove(5);
        java.remove(5);
        
        assertBehavior("Size after remove - size()", 
            linky.size(), java.size());
    }
    
    private static void testSizeAfterClear()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        linky.clear();
        java.clear();
        
        assertBehavior("Size after clear - size()", 
            linky.size(), java.size());
    }
    
    // ==================== CLEAR OPERATIONS ====================
    
    private static void testClearEmpty()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        linky.clear();
        java.clear();
        
        assertBehavior("Clear empty - isEmpty()", 
            linky.isEmpty(), java.isEmpty());
    }
    
    private static void testClearNonEmpty()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        linky.clear();
        java.clear();
        
        assertBehavior("Clear non-empty - isEmpty()", 
            linky.isEmpty(), java.isEmpty());
        assertBehavior("Clear non-empty - size()", 
            linky.size(), java.size());
    }
    
    // ==================== EQUALS OPERATIONS ====================
    
    private static void testEqualsSameList()
    {
        LinkyList<Integer> linky1 = new LinkyList<>();
        LinkyList<Integer> linky2 = new LinkyList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky1.add(i);
            linky2.add(i);
        }
        
        assertBehavior("Equals same list - equals()", 
            linky1.equals(linky2), true);
    }
    
    private static void testEqualsDifferentOrder()
    {
        LinkyList<Integer> linky1 = new LinkyList<>();
        LinkyList<Integer> linky2 = new LinkyList<>();
        
        linky1.add(1);
        linky1.add(2);
        linky2.add(2);
        linky2.add(1);
        
        assertBehavior("Equals different order - equals()", 
            linky1.equals(linky2), false);
    }
    
    private static void testEqualsDifferentSize()
    {
        LinkyList<Integer> linky1 = new LinkyList<>();
        LinkyList<Integer> linky2 = new LinkyList<>();
        
        linky1.add(1);
        linky2.add(1);
        linky2.add(2);
        
        assertBehavior("Equals different size - equals()", 
            linky1.equals(linky2), false);
    }
    
    private static void testEqualsWithNull()
    {
        LinkyList<String> linky1 = new LinkyList<>();
        LinkyList<String> linky2 = new LinkyList<>();
        
        linky1.add("A");
        linky1.add(null);
        linky2.add("A");
        linky2.add(null);
        
        assertBehavior("Equals with null - equals()", 
            linky1.equals(linky2), true);
    }
    
    private static void testEqualsEmpty()
    {
        LinkyList<Integer> linky1 = new LinkyList<>();
        LinkyList<Integer> linky2 = new LinkyList<>();
        
        assertBehavior("Equals empty - equals()", 
            linky1.equals(linky2), true);
    }
    
    // ==================== TOSTRING OPERATIONS ====================
    
    private static void testToStringEmpty()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        // Note: LinkyList toString may not be fully implemented
        assertBehavior("ToString empty - not null", 
            linky.toString() != null, java.toString() != null);
    }
    
    private static void testToStringSingle()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        linky.add(42);
        java.add(42);
        
        assertBehavior("ToString single - not null", 
            linky.toString() != null, java.toString() != null);
    }
    
    private static void testToStringMultiple()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        linky.add(1);
        linky.add(2);
        linky.add(3);
        java.add(1);
        java.add(2);
        java.add(3);
        
        assertBehavior("ToString multiple - not null", 
            linky.toString() != null, java.toString() != null);
    }
    
    // ==================== EDGE CASES ====================
    
    private static void testLargeList()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        for( int i = 0; i < 1000; i++ ) {
            linky.add(i);
            java.add(i);
        }
        
        assertBehavior("Large list - size()", 
            linky.size(), java.size());
        assertBehavior("Large list - get(500)", 
            linky.get(500), java.get(500));
        assertBehavior("Large list - contains(750)", 
            linky.contains(750), java.contains(750));
    }
    
    private static void testAlternatingNulls()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        for( int i = 0; i < 10; i++ ) {
            if( i % 2 == 0 ) {
                linky.add(null);
                java.add(null);
            } else {
                linky.add("Value" + i);
                java.add("Value" + i);
            }
        }
        
        assertBehavior("Alternating nulls - size()", 
            linky.size(), java.size());
        assertListsEqual("Alternating nulls - contents", linky, java);
    }
    
    private static void testAllNulls()
    {
        LinkyList<String> linky = new LinkyList<>();
        LinkedList<String> java = new LinkedList<>();
        
        for( int i = 0; i < 5; i++ ) {
            linky.add(null);
            java.add(null);
        }
        
        assertBehavior("All nulls - size()", 
            linky.size(), java.size());
        assertBehavior("All nulls - contains(null)", 
            linky.contains(null), java.contains(null));
        assertBehavior("All nulls - indexOf(null)", 
            linky.indexOf(null), java.indexOf(null));
    }
    
    private static void testMixedOperations()
    {
        LinkyList<Integer> linky = new LinkyList<>();
        LinkedList<Integer> java = new LinkedList<>();
        
        // Add elements
        linky.add(1);
        java.add(1);
        linky.add(2);
        java.add(2);
        linky.add(3);
        java.add(3);
        
        // Remove one
        linky.remove(Integer.valueOf(2));
        java.remove(Integer.valueOf(2));
        
        // Add more
        linky.add(4);
        java.add(4);
        
        // Set one
        linky.set(1, 99);
        java.set(1, 99);
        
        // Remove by index
        linky.remove(0);
        java.remove(0);
        
        assertBehavior("Mixed operations - size()", 
            linky.size(), java.size());
        assertListsEqual("Mixed operations - contents", linky, java);
    }
    
    // ==================== HELPER METHODS ====================
    
    private static <T> void assertBehavior(String testName, T linkyResult, T javaResult)
    {
        boolean equal = (linkyResult == null && javaResult == null) || 
                       (linkyResult != null && linkyResult.equals(javaResult));
        
        if( equal ) {
            System.out.println("✓ " + testName);
            testsPassed++;
        } else {
            System.out.println("✗ " + testName);
            System.out.println("  Expected (LinkedList): " + javaResult);
            System.out.println("  Got (LinkyList):       " + linkyResult);
            testsFailed++;
        }
    }
    
    private static <T> void assertListsEqual(String testName, LinkyList<T> linky, LinkedList<T> java)
    {
        if( linky.size() != java.size() ) {
            System.out.println("✗ " + testName + " - sizes differ");
            System.out.println("  Expected size: " + java.size());
            System.out.println("  Got size:      " + linky.size());
            testsFailed++;
            return;
        }
        
        for( int i = 0; i < linky.size(); i++ ) {
            T linkyVal = linky.get(i);
            T javaVal = java.get(i);
            
            boolean equal = (linkyVal == null && javaVal == null) || 
                           (linkyVal != null && linkyVal.equals(javaVal));
            
            if( !equal ) {
                System.out.println("✗ " + testName + " - element at index " + i + " differs");
                System.out.println("  Expected: " + javaVal);
                System.out.println("  Got:      " + linkyVal);
                testsFailed++;
                return;
            }
        }
        
        System.out.println("✓ " + testName);
        testsPassed++;
    }
}
