package lab1_basic;

public class TestSort {

    public static void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        org.junit.Assert.assertArrayEquals(expected, input);

    }
     
    @org.junit.Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        String expected = "an";

        String actual = Sort.findSmallest(input);

        org.junit.Assert.assertEquals(expected, actual);
    }
}