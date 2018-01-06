package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{

    public static int arBig [] = new int[20];
    public static int arSmallOne[] = new int [10];
    public static int arSmallTwo[] = new int [10];


    public static void main(String[] args) throws Exception
    {

        InputArray(arBig);

        arSmallOne = Arrays.copyOfRange(arBig, 0, 10);
        arSmallTwo = Arrays.copyOfRange(arBig, 10, 20);


        for (int i = 0; i < arSmallTwo.length; i++) {
            System.out.println(arSmallTwo[i]);
        }



    }

    public static void InputArray(int[] array) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < array.length; i++) {
            String st = reader.readLine();
            array[i] = Integer.parseInt(st);
        }
    }

}
