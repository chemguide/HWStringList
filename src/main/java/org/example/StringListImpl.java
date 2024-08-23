package org.example;

import Exceptions.ArrayIsEmptyException;
import Exceptions.ElementNotFoundException;
import Exceptions.NullParameterException;
import Exceptions.PositionNotExistException;

public class StringListImpl implements StringList {

    private int arraySize;

    public StringListImpl(int arraySize) {
        this.arraySize = arraySize;
    }

    private String[] array = new String[arraySize];

    public void extendArray() {
        if (array.length == size()) {
            arraySize = array.length + 5;
            String[] newArray = new String[arraySize];
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

    public void nullCheck(String string) {
        if (string == null) {
            throw new NullParameterException();
        }
    }

    public String add(String item) {
        nullCheck(item);
        extendArray();
        array[size()] = item;
        return item;
    }


    public String add(int index, String item) {
        nullCheck(item);
        correctPositionCheck(index);
        extendArray();
        for (int i = size() - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = item;
        return item;
    }


    public String set(int index, String item) {
        nullCheck(item);
        correctPositionCheck(index);
        array[index] = item;
        return item;
    }


    public String remove(String item) {
        nullCheck(item);
        int position = indexOf(item);
        if (!contains(item)) {
            throw new ElementNotFoundException();
        }
        remove(position);
        return item;
    }


    public String remove(int index) {
        correctPositionCheck(index);
        String item = array[index];
        for (int i = index; i < (size()-1); i++) {
            array[i] = array[i + 1];
        }
        array[size()-1] = null;
        return item;
    }


    public boolean contains(String item) {
        nullCheck(item);
        return indexOf(item) != -1;
    }


    public int indexOf(String item) {
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
    public int lastIndexOf(String item) {
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


    public String get(int index) {
        correctPositionCheck(index);
        return array[index];
    }


    public boolean equals(StringList otherList) {
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
        array = new String[arraySize];
    }


    public String[] toArray() {
        if (isEmpty()) {
            throw new ArrayIsEmptyException();
        }
        String[] newArray = new String[size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = get(i);
        }
        return newArray;
    }
}
