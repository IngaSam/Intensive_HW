
/*import java.until.Iterator;*/
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;


public class CustomArrayList <E>
{
    private Object[] elements;
    private int size;

    public CustomArrayList(){
        elements = (E[]) new Object[10];
        size = 0;
    }

    public void add(int index, E element){
         if (index < 0 || index > size){
             throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size); // вывод ошибки если index не попадает по размерам
         }
         ensureCapacity(size + 1); // метод на проверку размерности и увелечение его
         System.arraycopy(elements, index, elements, index + 1, size - index);
         elements[index] = element;
         size++;
     }

    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Collection cannot be null");
        }

        Object[] array = c.toArray(); //toArray - из списка делает массив
        int arraySize = array.length;
        if (arraySize == 0) {
            return false;
        }
        ensureCapacity(size + arraySize);
        System.arraycopy(array, 0, elements, size, arraySize);
        size += arraySize;
        return true;
    }
    public void clear() {
        Arrays.fill(elements, 0, size, null); // Заполняем элементы null
        size = 0; // Сбрасываем размер
    }


    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index]; // Возвращаем элемент по индексу
    }

/*    public int size() {
        return size; // Возвращаем текущий размер списка
    }*/

    public boolean isEmpty() {
        return size == 0; // Возвращаем true, если список пуст
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) elements[index]; // Сохраняем удаляемое значение
        int numMoved = size - index - 1; // Количество элементов, которые нужно переместить
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // уменьшаем размер массива и забываем про последний элемент
        return oldValue; // Возвращаем удаляемое значение
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                remove(i); // Удаляем элемент, если он найден
                return true; // Возвращаем true после успешного удаления
            }
        }
        return false; // Возвращаем false, если элемент не найден
    }


    // метод на проверку размерности и увелечение его
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {

            int newCapacity = (elements.length * 3) / 2 + 1;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

        /*private void ensureCapacity(int minCapacity) {
            int oldCapacity = elements.length;
            if (minCapacity > oldCapacity) {
                int newCapacity = oldCapacity + (oldCapacity >> 1); // Увеличение емкости на 50%
                if (newCapacity < minCapacity) {
                    newCapacity = minCapacity;
                }
                elements = Arrays.copyOf(elements, newCapacity);
            }
        }*/

        public void sort(Comparator<? super E> c){
            if (c == null) {
                throw new NullPointerException("Comparator cannot be null");
            }

            quickSort(0, size - 1, c);
        }


        public int size() {
            return size;
        }
    public void quickSort(int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int pivotIndex = partition(low, high, c);
            quickSort(low, pivotIndex - 1, c);
            quickSort(pivotIndex + 1, high, c);
        }
    }

    private int partition(int low, int high, Comparator<? super E> c) {
        E pivot = (E) elements[high];  // Опорный элемент
        int i = low - 1;  // Индекс меньшего элемента
        for (int j = low; j < high; j++) {
            if (c.compare((E) elements[j], pivot) < 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
