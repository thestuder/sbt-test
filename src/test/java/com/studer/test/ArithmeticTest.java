package com.studer.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ArithmeticTest {

    private List<String> testparams;

    public ArithmeticTest(List<String> testparams) {
        this.testparams = testparams;
    }

    @Parameterized.Parameters
    /**
     * Считываем данные из файла test-cases.txt (имя захардкожено, лежит в корне проекта)
     * Считываем построчно, разбиваем по точке с запятой, превращаем в List и формируем
     * из этого коллекцию. Пытался собрать коллекцию из массивов- не заработало.
     *
     * Дан файл вида: 
     * data file
     *
     * operand1;operand2;operation;result
     * operand1;operand2;operation;result
     *
     * каждая строка описывает арифметическое действие. 
     * operand1 и operand2 - операнды, целые числа
     * operation - арифметическое действие + - / *
     * result - результат операции operation над operand1 и operand2
     *
     * В файле могут содержаться любые значения полей
     */
    public static Collection<List<String>> getTestData() throws IOException {
        List<List<String>> lines = new ArrayList<List<String>>();
        BufferedReader reader = new BufferedReader(new FileReader("test-cases.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(";");
            lines.add(Arrays.asList(split));

        }
        return lines;
    }

    /**
     * Проверяем равенство реального результата арифметических действий ожидаемому результату.
     */
    @org.junit.Test
    public void testArithmeticOperation() throws Exception {

        //порядок параметров:
        //operand1;operand2;operation;result
        List<String> testparams = this.testparams;

        //параметров должно быть 4
        if(testparams.size()!=4) throw new Exception("Неправильное количество параметров");

        //проверяем числовые параметры на "числовость" и если это не так, то выбрасываем эксепшн
        int operator1;
        try {
            operator1 = Integer.parseInt(testparams.get(0));
        } catch (NumberFormatException e) {
            throw new Exception("Первый параметр не является числом");
        }
        int operator2;
        try {
            operator2 = Integer.parseInt(testparams.get(1));
        } catch (NumberFormatException e) {
            throw new Exception("Второй параметр не является числом");
        }
        double expectedResult;
        try {
            expectedResult = Double.parseDouble(testparams.get(3));
        } catch (NumberFormatException e) {
            throw new Exception("Результат не является числом");
        }

        String operation = testparams.get(2);
        double result = getActualResult(operator1, operator2, operation);

        //собственно сама проверка
        assertTrue("" + operator1 + " " + operation + " " + operator2 + " = " + expectedResult, expectedResult == result);
    }

//    выполняем требуемую операцию над операндами и если операция указана неверно
//    то выбрасываем эксепшн
    private double getActualResult(int operator1, int operator2, String operation) throws Exception {
        if ("+".equals(operation)) return operator1 + operator2;
        if ("-".equals(operation)) return operator1 - operator2;
        if ("*".equals(operation)) return operator1 * operator2;
        if ("/".equals(operation)) return (double) operator1 / (double) operator2;
        throw new Exception("Неправильно указана операция");
    }


}
