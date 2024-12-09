package tech.reliab.course.galushenkoLab.bank.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    // Генерация случайного целого числа в диапазоне [min, max]
    public static int getRandomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    // Генерация случайного числа с плавающей точкой в диапазоне [min, max]
    public static double getRandomDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    // Генерация случайного денежного значения с плавающей точкой и округлением до 2 знаков после запятой
    public static BigDecimal getRandomBigDecimal(double min, double max) {
        double randomValue = getRandomDouble(min, max);
        return BigDecimal.valueOf(randomValue).setScale(2, RoundingMode.HALF_UP);
    }

    // Генерация случайной строки указанной длины (например, для паролей или уникальных идентификаторов)
    public static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    // Генерация случайного boolean значения
    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
