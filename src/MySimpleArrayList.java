import java.util.*;

public class MySimpleArrayList<E> implements List<E> {

    private static final int capacity = 10;
    private int numOfFillCells;// Количество не пустых ячеек.
    private int indexOfData;
    private Object[] data;



    public MySimpleArrayList() {
       data = new Object[capacity];

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        data[indexOfData++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        if (checkIndex(index))
        {
            E item = (E) data[index];
            return item;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        Object[] newData = null;
        int length = data.length;
        if (data.length - indexOfData < 4)
        {
            length = length + 10;
        }
        if (checkIndex(index) || (index - indexOfData) == 1)
        {
            newData = new Object[length];
            int j = 0;
            for (int i = 0; i <= indexOfData + 1; i++)
            {
                if (i == index)
                {
                    newData[j] = element;
                    j++;
                }
                newData[j] = data[i];
                j++;
            }
            data = newData;
            indexOfData++;
        }


    }



    @Override
    public E remove(int index) {
        if (checkIndex(index)) {
            E item = (E) data[index];
            changeData(data, index);
            indexOfData--;
            return item;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i <= indexOfData; i++)
        {
            if (data[i].equals(o))
            {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void changeData(Object[] data, int index)
    {
        int j = 0;
        Object[] newData = new Object[data.length];
        copyArray(data, newData);
        for (int i = 0; i <= indexOfData; i++)
        {
            if (i == index)
                continue;
            data[j] = newData[i];
            j++;

        }
        clearData(data, indexOfData+1);
    }

    private void clearData(Object[] data, int startIndex)
    {
        for (int i = startIndex; i < data.length; i++)
        {
            data[i] = null;
        }
    }

    private void copyArray(Object[] src, Object[] dst)
    {
        for (int i = 0; i < data.length; i++)
        {
            dst[i] = src[i];
        }
    }

    private boolean checkIndex(int index)
    {
        if (index < 0 || index > indexOfData)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MySimpleArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
