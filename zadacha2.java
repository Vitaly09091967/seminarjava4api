/**Задача №2. Даны два Deque, представляющие два целых числа. Цифры хранятся 
в обратном порядке и каждый из их узлов содержит одну цифру.
2) Сложите два числа и верните сумму в виде связанного списка.
Одно или два числа могут быть отрицательными.

Даны два Deque, цифры в обратном порядке.
[3,2,1] - пример Deque
[5,4,3]- пример второго Deque
Ответ всегда - связный список, в обычном порядке*/


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class zadacha2 {
    public static LinkedList<Integer> addNumbers(Deque<Integer> deque1, Deque<Integer> deque2) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        int position = 0;

        while (!deque1.isEmpty() || !deque2.isEmpty() || carry != 0) {
            int digit1 = deque1.isEmpty() ? 0 : deque1.removeFirst();
            int digit2 = deque2.isEmpty() ? 0 : deque2.removeFirst();
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.addLast(sum % 10);
            position++;
        }

        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        deque1.add(3);
        deque1.add(2);
        deque1.add(1);

        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.add(5);
        deque2.add(4);
        deque2.add(3);

        LinkedList<Integer> sum = addNumbers(deque1, deque2);
        System.out.println("Sum: " + sum);
    }
}
