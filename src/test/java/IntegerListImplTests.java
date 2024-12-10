import org.example.IntegerList;
import org.example.IntegerListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerListImplTests {

    private final int listSize = 5;

    Integer[] testNumbers = new Integer[]{1, 2, 3, 4, 5, 6, 7};


    public IntegerList integerList = new IntegerListImpl(listSize);
    public IntegerList integerList1 = new IntegerListImpl(listSize);

    @Test
    public void shouldGetActualSizeIfNoAdded() {
        Assertions.assertEquals(0, integerList.size());
    }

    @Test
    public void shouldGetActualSizeIfOneAdded() {
        integerList.add(testNumbers[0]);
        Assertions.assertEquals(1, integerList.size());
    }

    @Test
    public void shouldGetActualSizeIfTwoAdded() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        Assertions.assertEquals(2, integerList.size());
    }

    @Test
    public void shouldAddElement_byItem() {
        Assertions.assertEquals(testNumbers[0], integerList.add(testNumbers[0]));
    }

    @Test
    public void shouldThrowException_whenTryToAddNullItem() {
        Assertions.assertThrows(Exceptions.NullParameterException.class,
                () -> integerList.add(null));
    }

    @Test
    public void shouldExtendArray_whenNoSpace() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        integerList.add(testNumbers[2]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        integerList.add(testNumbers[5]);
        Assertions.assertEquals(6, integerList.size());
    }

    @Test
    public void shouldAddElement_byItemAndPosition() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[2]);
        integerList.add(1, testNumbers[1]);
        Integer[] expected = new Integer[]{testNumbers[0], testNumbers[1], testNumbers[2]};
        Assertions.assertArrayEquals(expected, integerList.toArray());
    }

    @Test
    public void shouldThrowException_whenAdd_ifIndexOutOfBounds() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[2]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> integerList.add(2, testNumbers[0]));
    }

    @Test
    public void shouldSetItem() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[2]);
        Integer[] expected = new Integer[]{testNumbers[0], testNumbers[1]};
        integerList.set(1, testNumbers[1]);
        Integer[] actuals = integerList.toArray();
        Assertions.assertArrayEquals(expected, actuals);
    }

    @Test
    public void shouldThrowException_whenSet_ifIndexOutOfBounds() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[2]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> integerList.set(2, testNumbers[0]));
    }

    @Test
    public void shouldRemoveItemByIndex() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        integerList.add(testNumbers[2]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        Integer[] expected = new Integer[]{testNumbers[0], testNumbers[2], testNumbers[3], testNumbers[4]};
        integerList.remove(1);
        Integer[] actuals = integerList.toArray();
        Assertions.assertArrayEquals(expected, actuals);
    }

    @Test
    public void shouldThrowException_whenRemoveByIndex_ifIndexOutOfBounds() {
        integerList.add(testNumbers[0]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> integerList.remove(1));
    }

    @Test
    public void shouldRemoveItemByItem() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        integerList.add(testNumbers[2]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        Integer[] expected = new Integer[]{testNumbers[0], testNumbers[1], testNumbers[3], testNumbers[4]};
        integerList.remove(testNumbers[2]);
        Integer[] actuals = integerList.toArray();
        Assertions.assertArrayEquals(expected, actuals);
    }

    @Test
    public void shouldThrowException_whenRemoveByItem_ifItemNotExist() {
        integerList.add(testNumbers[0]);
        Assertions.assertThrows(Exceptions.ElementNotFoundException.class,
                () -> integerList.remove(testNumbers[1]));
    }

    @Test
    public void shouldReturnCorrectIndexOfItem() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[2]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        Assertions.assertEquals(1, integerList.indexOf(testNumbers[3]));
    }

    @Test
    public void shouldReturnMinusOne_whenFindIndex_whenItemNotExist() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        Assertions.assertEquals(-1, integerList.indexOf(testNumbers[2]));
    }

    @Test
    public void shouldReturnCorrectLastIndexOfItem() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[2]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        Assertions.assertEquals(3, integerList.lastIndexOf(testNumbers[3]));
    }

    @Test
    public void shouldReturnMinusOne_whenFindLastIndex_whenItemNotExist() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        Assertions.assertEquals(-1, integerList.lastIndexOf(testNumbers[2]));
    }

    @Test
    public void shouldGetCorrectItem() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[2]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        Assertions.assertEquals(testNumbers[3], integerList.get(1));
    }

    @Test
    public void shouldThrowException_whenGetItem_ifIndexOutOfBounds() {
        integerList.add(testNumbers[0]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> integerList.get(1));
    }

    @Test
    public void shouldReturnTrueResults_whenCompareIdenticalObjects() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        integerList1.add(testNumbers[0]);
        integerList1.add(testNumbers[3]);
        Assertions.assertTrue(integerList.equals(integerList1));
    }

    @Test
    public void shouldReturnFalseResults_whenCompareDifferentObjectsByContent() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        integerList1.add(testNumbers[1]);
        integerList1.add(testNumbers[3]);
        Assertions.assertFalse(integerList.equals(integerList1));
    }

    @Test
    public void shouldReturnFalseResults_whenCompareDifferentObjectsBySize() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        integerList1.add(testNumbers[1]);
        integerList1.add(testNumbers[3]);
        integerList1.add(testNumbers[3]);
        Assertions.assertFalse(integerList.equals(integerList1));
    }

    @Test
    public void shouldReturnFalseResults_whenCompareDifferentObjects_whenFirstNull() {
        integerList1.add(testNumbers[0]);
        integerList1.add(testNumbers[3]);
        Assertions.assertFalse(integerList.equals(integerList1));
    }

    @Test
    public void shouldReturnFalseResults_whenCompareDifferentObjects_whenSecondNull() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        Assertions.assertFalse(integerList.equals(integerList1));
    }

    @Test
    public void shouldReturnTrueResults_whenCompareObjects_whenBothNull() {
        Assertions.assertTrue(integerList.equals(integerList1));
    }

    @Test
    public void shouldReturnCorrectSize() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        Assertions.assertEquals(2, integerList.size());
    }

    @Test
    public void shouldReturnTrueResults_whenListIsEmpty() {
        Assertions.assertTrue(integerList.isEmpty());
    }

    @Test
    public void shouldReturnFalseResults_whenListIsNotEmpty() {
        integerList.add(testNumbers[3]);
        Assertions.assertFalse(integerList.isEmpty());
    }

    @Test
    public void shouldClearArray() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[3]);
        integerList.clear();
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> integerList.get(0));
    }

    @Test
    public void shouldConvertToArrayCorrectly() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        Integer[] expected = new Integer[]{testNumbers[0], testNumbers[1], testNumbers[3], testNumbers[4]};
        Assertions.assertArrayEquals(expected, integerList.toArray());
    }

    @Test
    public void shouldThrowException_whenTryConvertToArray_whenIsEmpty() {
        Assertions.assertThrows(Exceptions.ArrayIsEmptyException.class,
                () -> integerList.toArray());
    }

    @Test
    public void shouldSwapElementsCorrectly() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        integerList1.add(testNumbers[3]);
        integerList1.add(testNumbers[1]);
        integerList1.add(testNumbers[0]);
        integerList1.add(testNumbers[4]);
        integerList.swapElements(0, 2);
        Assertions.assertArrayEquals(integerList.toArray(), integerList1.toArray());
    }

    @Test
    public void shouldThrowException_whenSwap_ifArrayIsNull() {
        Assertions.assertThrows(Exceptions.ArrayIsEmptyException.class,
                () -> integerList.swapElements(0, 1));
    }

    @Test
    public void shouldThrowException_whenSwap_ifIndexesIncorrect() {
        integerList.add(testNumbers[0]);
        Assertions.assertThrows(Exceptions.PositionNotExistException.class,
                () -> integerList.swapElements(0, 1));
    }

    @Test
    public void shouldSortCorrectly_whenBubbleSort() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        integerList1.add(testNumbers[3]);
        integerList1.add(testNumbers[1]);
        integerList1.add(testNumbers[0]);
        integerList1.add(testNumbers[4]);
        integerList1.bubbleSort();
        Assertions.assertArrayEquals(integerList.toArray(), integerList1.toArray());
    }

    @Test
    public void shouldThrowException_whenBubbleSort_ifArrayIsEmpty() {
        Assertions.assertThrows(Exceptions.ArrayIsEmptyException.class,
                () -> integerList.bubbleSort());
    }

    @Test
    public void shouldSortCorrectly_whenChooseSort() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        integerList1.add(testNumbers[3]);
        integerList1.add(testNumbers[1]);
        integerList1.add(testNumbers[0]);
        integerList1.add(testNumbers[4]);
        integerList1.bubbleSort();
        Assertions.assertArrayEquals(integerList.toArray(), integerList1.toArray());
    }

    @Test
    public void shouldThrowException_whenChooseSort_ifArrayIsEmpty() {
        Assertions.assertThrows(Exceptions.ArrayIsEmptyException.class,
                () -> integerList.chooseSort());
    }

    @Test
    public void shouldSortCorrectly_whenInsertSort() {
        integerList.add(testNumbers[0]);
        integerList.add(testNumbers[1]);
        integerList.add(testNumbers[3]);
        integerList.add(testNumbers[4]);
        integerList1.add(testNumbers[3]);
        integerList1.add(testNumbers[1]);
        integerList1.add(testNumbers[0]);
        integerList1.add(testNumbers[4]);
        integerList1.bubbleSort();
        Assertions.assertArrayEquals(integerList.toArray(), integerList1.toArray());
    }

    @Test
    public void shouldThrowException_whenInsertSort_ifArrayIsEmpty() {
        Assertions.assertThrows(Exceptions.ArrayIsEmptyException.class,
                () -> integerList.insertSort());
    }
}
