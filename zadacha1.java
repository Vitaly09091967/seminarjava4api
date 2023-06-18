/**Задача 1. Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
Одно или два числа могут быть отрицательными.

Даны два Deque, цифры в обратном порядке.
[3,2,1] - пример Deque
[5,4,3]- пример второго Deque
1) 123 * 345 = 42 435
Ответ всегда - связный список, в обычном порядке
[4,2,4,3,5] - пример ответа*/


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class zadacha1 {
    public static LinkedList<Integer> multiplyNumbers(Deque<Integer> deque1, Deque<Integer> deque2) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        int position = 0;
        int[] intermediateResults = new int[deque1.size() + deque2.size() + 1];

        while (!deque1.isEmpty() || carry != 0) {
            int digit1 = deque1.isEmpty() ? 0 : deque1.removeFirst();
            carry = 0;
            int tempPosition = position;

            for (int digit2 : deque2) {
                int product = digit1 * digit2 + intermediateResults[tempPosition] + carry;
                intermediateResults[tempPosition] = product % 10;
                carry = product / 10;
                tempPosition++;
            }

            if (carry != 0) {
                intermediateResults[tempPosition] = carry;
            }

            position++;
        }

        for (int i = 0; i < intermediateResults.length; i++) {
            result.addLast(intermediateResults[i]);
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

        LinkedList<Integer> product = multiplyNumbers(deque1, deque2);
        System.out.println("Product: " + product);
    }
}
