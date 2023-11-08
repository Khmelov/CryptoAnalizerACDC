package com.javarush.kuzmina.resources;

import java.util.Scanner;
import static com.javarush.kuzmina.resources.MethodsCipher.cipher;
import static com.javarush.kuzmina.resources.MethodsCipher.textToArray;
import static com.javarush.kuzmina.resources.MethodsDecipher.decipher;

public class MethodsMain {
    public static final String GREETING = "Доброго времени суток! Что Вы желаете сделать сегодня? \n 1. Зашифровать текст \n 2. Расшифровать код";
    public static final String ASK_TEXT = "\nПожалуйста, введите свой текст для шифрования \n";
    public static final String ASK_DETEXT = "\nПожалуйста, введите свой текст для расшифровки \n";
    public static final String CHOOSE_NUMBER = "\nПожалуйста, введите число от 1 до 31 \n";
    public static final String MISUNDERSTANDING = "\nЯ Вас не понимаю. Пожалуйста, повторите свой ответ. \n";
    public static final String CONGRATULATION = "\nПоздравляем! Вы только что зашифровали свой текст. Хотите расшифровать его обратно?\n да\n нет \n";
    public static final String THANKYOU = "\nСпасибо, что воспользовались системой шифрования!";
    private static Object e;

    public static void ifAnswerCipher() {
        System.out.println(ASK_TEXT);
        Scanner scanText = new Scanner(System.in);
        String text = scanText.nextLine();
        char[] textArr = textToArray(text);
        System.out.println(CHOOSE_NUMBER);
        Scanner scanNumber = new Scanner(System.in);
        while (scanNumber.hasNext()) {
            try {
                int number = Integer.parseInt(scanNumber.next());
                if (number > 0 && number < 32) {
                    char[] textCipher = cipher(textArr, number);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (char value : textCipher) stringBuilder.append(value);
                    String joinedString = stringBuilder.toString();
                    System.out.println("\n" + joinedString);
                    System.out.println(CONGRATULATION);
                    String answer = "привет";
                    String yes = "да";
                    String no = "нет";
                    while (!answer.equals(yes) || !answer.equals(no)) {
                        Scanner scanner2 = new Scanner(System.in);
                        String answer2 = scanner2.nextLine();
                        answer = answer2.toLowerCase();
                        if (answer.equals("да")) {

                            char[] cipherArr = textToArray(joinedString);
                            char[] textDecipher = decipher(cipherArr, number);
                            StringBuilder stringBuilder2 = new StringBuilder();
                            for (char c : textDecipher) stringBuilder2.append(c);
                            String newString = stringBuilder2.toString();
                            System.out.println("\n" + newString);
                            System.out.println(THANKYOU);
                            break;
                        } else if (answer.equals("нет")) {
                            System.out.println(THANKYOU);
                            break;
                        } else {
                            System.out.println(MISUNDERSTANDING);
                        }
                    }
                    break;
                } else {
                    System.out.println(MISUNDERSTANDING);
                }
            } catch (NumberFormatException e) {
                System.out.println(MISUNDERSTANDING);
            }

        }
    }

    public static void ifAnswerDecipher() {
        System.out.println(ASK_DETEXT);
        Scanner scanDeText = new Scanner(System.in);
        String decText = scanDeText.nextLine();
        char[] cipherNewArr = textToArray(decText);
        System.out.println(CHOOSE_NUMBER);
        Scanner scanNewNumber = new Scanner(System.in);
        while (scanNewNumber.hasNext()) {
            try {
                int newNumber = Integer.parseInt(scanNewNumber.next());
                if (newNumber > 0 && newNumber < 32) {
                    char[] newTextDecipher = decipher(cipherNewArr, newNumber);
                    StringBuilder stringBuilder3 = new StringBuilder();
                    for (char c : newTextDecipher) stringBuilder3.append(c);
                    String newString = stringBuilder3.toString();
                    System.out.println("\n" + newString);
                    System.out.println(THANKYOU);
                    break;
                } else {
                    System.out.println(MISUNDERSTANDING);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(MISUNDERSTANDING);
            }
        }
    }
}


