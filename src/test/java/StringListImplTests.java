import org.example.StringList;
import org.example.StringListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringListImplTests {

    private final int listSize = 5;

    String[] testStrings = new String[]{"test1", "test2", "test3", "test4", "test5", "test6", "test7"};


    public StringList stringList = new StringListImpl(listSize);
    public StringList stringList1 = new StringListImpl(listSize);

    @Test
    public void shouldGetActualSizeIfNoAdded() {
        Assertions.assertEquals(0, stringList.size());
    }

    @Test
    public void shouldGetActualSizeIfOneAdded() {
        stringList.add(testStrings[0]);
        Assertions.assertEquals(1, stringList.size());
    }

    @Test
    public void shouldGetActualSizeIfTwoAdded() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[1]);
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    public void shouldAddElement_byItem() {
        Assertions.assertEquals(testStrings[0], stringList.add(testStrings[0]));
    }

    @Test
    public void shouldThrowException_whenTryToAddNullItem() {
        Assertions.assertThrows(Exceptions.NullParameterException.class,
                () -> stringList.add(null));
    }

    @Test
    public void shouldExtendArray_whenNoSpace() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[1]);
        stringList.add(testStrings[2]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[4]);
        stringList.add(testStrings[5]);
        Assertions.assertEquals(6, stringList.size());
    }

    @Test
    public void shouldAddElement_byItemAndPosition() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[2]);
        stringList.add(1, testStrings[1]);
        String[] expected = new String[]{testStrings[0], testStrings[1], testStrings[2]};
        Assertions.assertArrayEquals(expected, stringList.toArray());
    }

    @Test
    public void shouldThrowException_whenAdd_ifIndexOutOfBounds() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[2]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> stringList.add(2, testStrings[0]));
    }

    @Test
    public void shouldSetItem() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[2]);
        String[] expected = new String[]{testStrings[0], testStrings[1]};
        stringList.set(1, testStrings[1]);
        String[] actuals = stringList.toArray();
        Assertions.assertArrayEquals(expected, actuals);
    }

    @Test
    public void shouldThrowException_whenSet_ifIndexOutOfBounds() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[2]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> stringList.set(2, testStrings[0]));
    }

    @Test
    public void shouldRemoveItemByIndex() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[1]);
        stringList.add(testStrings[2]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[4]);
        String[] expected = new String[]{testStrings[0], testStrings[2], testStrings[3], testStrings[4]};
        stringList.remove(1);
        String[] actuals = stringList.toArray();
        Assertions.assertArrayEquals(expected, actuals);
    }

    @Test
    public void shouldThrowException_whenRemoveByIndex_ifIndexOutOfBounds() {
        stringList.add(testStrings[0]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> stringList.remove(1));
    }

    @Test
    public void shouldRemoveItemByItem() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[1]);
        stringList.add(testStrings[2]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[4]);
        String[] expected = new String[]{testStrings[0], testStrings[1], testStrings[3], testStrings[4]};
        stringList.remove(testStrings[2]);
        String[] actuals = stringList.toArray();
        Assertions.assertArrayEquals(expected, actuals);
    }

    @Test
    public void shouldThrowException_whenRemoveByItem_ifItemNotExist() {
        stringList.add(testStrings[0]);
        Assertions.assertThrows(Exceptions.ElementNotFoundException.class,
                () -> stringList.remove(testStrings[1]));
    }

    @Test
    public void shouldReturnCorrectIndexOfItem() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[2]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[4]);
        Assertions.assertEquals(1, stringList.indexOf(testStrings[3]));
    }

    @Test
    public void shouldReturnMinusOne_whenFindIndex_whenItemNotExist() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[1]);
        Assertions.assertEquals(-1, stringList.indexOf(testStrings[2]));
    }

    @Test
    public void shouldReturnCorrectLastIndexOfItem() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[2]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[4]);
        Assertions.assertEquals(3, stringList.lastIndexOf(testStrings[3]));
    }

    @Test
    public void shouldReturnMinusOne_whenFindLastIndex_whenItemNotExist() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[1]);
        Assertions.assertEquals(-1, stringList.lastIndexOf(testStrings[2]));
    }

    @Test
    public void shouldGetCorrectItem() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[2]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[4]);
        Assertions.assertEquals(testStrings[3], stringList.get(1));
    }

    @Test
    public void shouldThrowException_whenGetItem_ifIndexOutOfBounds() {
        stringList.add(testStrings[0]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> stringList.get(1));
    }

    @Test
    public void shouldReturnTrueResults_whenCompareIdenticalObjects() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        stringList1.add(testStrings[0]);
        stringList1.add(testStrings[3]);
        Assertions.assertTrue(stringList.equals(stringList1));
    }

    @Test
    public void shouldReturnFalseResults_whenCompareDifferentObjectsByContent() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        stringList1.add(testStrings[1]);
        stringList1.add(testStrings[3]);
        Assertions.assertFalse(stringList.equals(stringList1));
    }

    @Test
    public void shouldReturnFalseResults_whenCompareDifferentObjectsBySize() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        stringList1.add(testStrings[1]);
        stringList1.add(testStrings[3]);
        stringList1.add(testStrings[3]);
        Assertions.assertFalse(stringList.equals(stringList1));
    }

    @Test
    public void shouldReturnFalseResults_whenCompareDifferentObjects_whenFirstNull() {
        stringList1.add(testStrings[0]);
        stringList1.add(testStrings[3]);
        Assertions.assertFalse(stringList.equals(stringList1));
    }

    @Test
    public void shouldReturnFalseResults_whenCompareDifferentObjects_whenSecondNull() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        Assertions.assertFalse(stringList.equals(stringList1));
    }

    @Test
    public void shouldReturnTrueResults_whenCompareObjects_whenBothNull() {
        Assertions.assertTrue(stringList.equals(stringList1));
    }

    @Test
    public void shouldReturnCorrectSize() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    public void shouldReturnTrueResults_whenListIsEmpty() {
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void shouldReturnFalseResults_whenListIsNotEmpty() {
        stringList.add(testStrings[3]);
        Assertions.assertFalse(stringList.isEmpty());
    }

    @Test
    public void shouldClearArray() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[3]);
        stringList.clear();
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> stringList.get(0));
    }

    @Test
    public void shouldConvertToArrayCorrectly() {
        stringList.add(testStrings[0]);
        stringList.add(testStrings[1]);
        stringList.add(testStrings[3]);
        stringList.add(testStrings[4]);
        String[] expected = new String[]{testStrings[0], testStrings[1], testStrings[3], testStrings[4]};
        Assertions.assertArrayEquals(expected, stringList.toArray());
    }

    @Test
    public void shouldThrowException_whenTryConvertToArray_whenIsEmpty() {
        Assertions.assertThrows(Exceptions.ArrayIsEmptyException.class,
                () -> stringList.toArray());
    }
}
