package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 > value2)
            return 1;
        else if (value1 < value2)
            return  -1;
        else return 0;
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        if (value1 > value2)
            return value1;
        else return value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int max = Integer.MIN_VALUE;
        for (int el: values) {
            if (el > max)
                max = el;
        }
        return max;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int el: values) {
            sum+=el;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        ArrayList evenDigits = new ArrayList();

        for (int el: values) {
            if (el % 2 == 0) {
                evenDigits.add(el);
            }
        }

        int[] res = new int[evenDigits.size()];
        for (int i = 0; i < evenDigits.size(); i++) {
            res[i] = (int)evenDigits.get(i);
        }
        return res;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        if (initialVal == 0) return 1;
        long res = 1;
        for (int i = 1; i <= initialVal; i++)
            res *= i;
        return res;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if (number == 0) return 0;
        long[] fibonacci = new long[number+1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < number + 1; i++)
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
        return fibonacci[number];
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        int[] sortedArray = new int[values.length];
        sortedArray = values;
        boolean stopFlag = false;
        while (!stopFlag) {
            stopFlag = true;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    int temporaryVariable = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temporaryVariable;
                    stopFlag = false;
                }
            }
        }
        return sortedArray;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        boolean isPrimary = true;
        if (number == 0 || number == 1) return false;
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                isPrimary = false;
                break;
            }
        }
        return isPrimary;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        if (values.length == 0) return values;
        int[] res = new int[values.length];
        for (int i = 0; i <= values.length/2; i++) {
            res[i] = values[values.length - i - 1];
            res[values.length - i - 1] = values[i];
        }
        return res;
    }
}
