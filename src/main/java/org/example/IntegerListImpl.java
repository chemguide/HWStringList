package org.example;

import Exceptions.ArrayIsEmptyException;
import Exceptions.ElementNotFoundException;
import Exceptions.NullParameterException;
import Exceptions.PositionNotExistException;

public class IntegerListImpl implements IntegerList {

    private int arraySize;

    public IntegerListImpl(int arraySize) {
        this.arraySize = arraySize;
    }

    private Integer[] array = new Integer[arraySize];

    public void extendArray() {
        if (array.length == size()) {
            arraySize = array.length + 5;
            Integer[] newArray = new Integer[arraySize];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void correctPositionCheck(int index) {
        if (index >= size()) {
            throw new PositionNotExistException();
        }
    }

    public void nullCheck(Integer number) {
        if (number == null) {
            throw new NullParameterException();
        }
    }

    public Integer add(Integer item) {
        nullCheck(item);
        extendArray();
        array[size()] = item;
        return item;
    }


    public Integer add(int index, Integer item) {
        nullCheck(item);
        correctPositionCheck(index);
        extendArray();
        for (int i = size() - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = item;
        return item;
    }


    public Integer set(int index, Integer item) {
        nullCheck(item);
        correctPositionCheck(index);
        array[index] = item;
        return item;
    }


    public Integer remove(Integer item) {
        nullCheck(item);
        int position = indexOf(item);
        if (!contains(item)) {
            throw new ElementNotFoundException();
        }
        remove(position);
        return item;
    }


    public Integer remove(int index) {
        correctPositionCheck(index);
        Integer item = array[index];
        for (int i = index; i < (size() - 1); i++) {
            array[i] = array[i + 1];
        }
        array[size() - 1] = null;
        return item;
    }

    public int indexOf(Integer item) {
        nullCheck(item);
        int position = -1;
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(item)) {
                position = i;
                break;
            }
        }
        return position;
    }

    @Override
    public int lastIndexOf(Integer item) {
        nullCheck(item);
        int position = -1;
        for (int i = size() - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                position = i;
                break;
            }
        }
        return position;
    }


    public Integer get(int index) {
        correctPositionCheck(index);
        return array[index];
    }


    public boolean equals(IntegerList otherList) {
        if ((otherList == null) && (array != null)) {
            return false;
        } else if ((otherList == null) && (array == null)) {
            return true;
        }
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }


    public int size() {
        int actualSize = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                break;
            }
            actualSize++;
        }
        return actualSize;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public void clear() {
        array = new Integer[arraySize];
    }


    public Integer[] toArray() {
        if (isEmpty()) {
            throw new ArrayIsEmptyException();
        }
        Integer[] newArray = new Integer[size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = get(i);
        }
        return newArray;
    }

    public void swapElements(int pos1, int pos2) {
        if (isEmpty()) {
            throw new ArrayIsEmptyException();
        }
        correctPositionCheck(pos1);
        correctPositionCheck(pos2);
        Integer buffer = get(pos1);
        set(pos1, get(pos2));
        set(pos2, buffer);
    }

    public void bubbleSort() {
        if (isEmpty()) {
            throw new ArrayIsEmptyException();
        }
        for (int i = 0; i < size(); i++) {
            for (int i1 = 0; i1 < (size() - 1 - i); i1++) {
                if (get(i1) > get(i1 + 1)) {
                    swapElements(i1, (i1 + 1));
                }
            }
        }
    }

    // Самый быстрый метод сортировки
    public void chooseSort() {
        if (isEmpty()) {
            throw new ArrayIsEmptyException();
        }
        Integer max = Integer.MIN_VALUE;
        int posOfMax = 0;
        for (int i = 0; i < size(); i++) {
            for (int i1 = 0; i1 < (size() - i); i1++) {
                if (get(i1) > max) {
                    max = get(i1);
                    posOfMax = i1;
                }
            }
            swapElements(posOfMax, size() - 1 - i);
            max = Integer.MIN_VALUE;
        }
    }

    public void insertSort() {
        if (isEmpty()) {
            throw new ArrayIsEmptyException();
        }
        for (int i = 1; i < size(); i++) {
            int temp = get(i);
            int j = i;
            while (j > 0 && get(j - 1) >= temp) {
                set(j, get(j - 1));
                j--;
            }
            set(j, temp);
        }
    }

    public boolean contains(Integer item) {
        int min = 0;
        int max = size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(get(mid))) {
                return true;
            }

            if (item < get(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
