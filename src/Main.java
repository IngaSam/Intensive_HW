
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();

        System.out.println("Текущий список: " + list);
        list.add(0, 10); // Добавляем элемент в начало
        list.add(1, 20); // Добавляем элемент в конец
        System.out.println("Текущий список после добавления двух элементов: " + list);

        System.out.println("Вывод первого элемента " + list.get(0)); // Должно вывести 10
        System.out.println("Вывод размера списка " + list.size()); // Должно вывести 2

        list.addAll(Arrays.asList(1, 2, 3)); // Добавляем коллекцию в список
        System.out.println("Размер листа после добавления коллекции из трех элементов = " + list.size()); // Должно вывести 5

        System.out.println("Текущий список: " + list);

        list.sort(Integer::compareTo); // Сортировка
        System.out.println("Отсортированный список: " + list);

        list.remove((Integer) 10); // Удаление элемента по значению
        System.out.println("\nПосле удаления элемента 10 размер стал =  " + list.size()); // Должно вывести 4

        list.clear(); // Очистка списка
        System.out.println("Текущий список после очистки: " + list);
        System.out.println("Список пуст? " + list.isEmpty()); // Должно вывести true

    }
}
