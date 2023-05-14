package developer_tools;

import pro.sky.java.course2.examinerservice.domain.Question;


import java.util.Collection;
import java.util.List;

public class QuestionUtils {

    public static Collection<Question> initMathQuestions() {
        return List.of(
                new Question("2x2", "4"),
                new Question("Pi", "3.14"),
                new Question("e", "2.72"),
                new Question("1-1", "0"),
                new Question("5x5", "25"),
                new Question("Sin(pi)", "0"),
                new Question("Cos(pi)", "1"),
                new Question("7x7", "49"),
                new Question("3^6", "729"),
                new Question("5^5", "3125")
                );
    }
    public static Collection<Question> initJavaQuestions() {
        String stringQuestion;
        return List.of(
                new Question("How do you reverse a string in Java?",
                        "public class StringPrograms {\n" +
                                "\n" +
                                "\tpublic static void main(String[] args) {\n" +
                                "\t\tString str = \"123\";\n" +
                                "\n" +
                                "\t\tSystem.out.println(reverse(str));\n" +
                                "\t}\n" +
                                "\n" +
                                "\tpublic static String reverse(String in) {\n" +
                                "\t\tif (in == null)\n" +
                                "\t\t\tthrow new IllegalArgumentException(\"Null is not valid input\");\n" +
                                "\n" +
                                "\t\tStringBuilder out = new StringBuilder();\n" +
                                "\n" +
                                "\t\tchar[] chars = in.toCharArray();\n" +
                                "\n" +
                                "\t\tfor (int i = chars.length - 1; i >= 0; i--)\n" +
                                "\t\t\tout.append(chars[i]);\n" +
                                "\n" +
                                "\t\treturn out.toString();\n" +
                                "\t}\n" +
                                "\n" +
                                "}"),

                new Question("How do you swap two numbers without using a third variable in Java?",
                        "b = b + a; // now b is sum of both the numbers\n" +
                                "a = b - a; // b - a = (b + a) - a = b (a is swapped)\n" +
                                "b = b - a; // (b + a) - b = a (b is swapped)"),
                new Question("Write a Java program to check if a vowel is present in a string.",
                        "public class StringContainsVowels {\n" +
                                "\n" +
                                "\tpublic static void main(String[] args) {\n" +
                                "\t\tSystem.out.println(stringContainsVowels(\"Hello\")); // true\n" +
                                "\t\tSystem.out.println(stringContainsVowels(\"TV\")); // false\n" +
                                "\t}\n" +
                                "\n" +
                                "\tpublic static boolean stringContainsVowels(String input) {\n" +
                                "\t\treturn input.toLowerCase().matches(\".*[aeiou].*\");\n" +
                                "\t}\n" +
                                "\n" +
                                "}"),
                new Question("Write a Java program to check if the given number is a prime number.",
                        "public class PrimeNumberCheck {\n" +
                                "\n" +
                                "\tpublic static void main(String[] args) {\n" +
                                "\t\tSystem.out.println(isPrime(19)); // true\n" +
                                "\t\tSystem.out.println(isPrime(49)); // false\n" +
                                "\t}\n" +
                                "\n" +
                                "\tpublic static boolean isPrime(int n) {\n" +
                                "\t\tif (n == 0 || n == 1) {\n" +
                                "\t\t\treturn false;\n" +
                                "\t\t}\n" +
                                "\t\tif (n == 2) {\n" +
                                "\t\t\treturn true;\n" +
                                "\t\t}\n" +
                                "\t\tfor (int i = 2; i <= n / 2; i++) {\n" +
                                "\t\t\tif (n % i == 0) {\n" +
                                "\t\t\t\treturn false;\n" +
                                "\t\t\t}\n" +
                                "\t\t}\n" +
                                "\n" +
                                "\t\treturn true;\n" +
                                "\t}\n" +
                                "\n" +
                                "}"),
                new Question("Write a Java program to print a Fibonacci sequence using recursion.",
                        "public class PrintFibonacci {\n" +
                                "\n" +
                                "\tpublic static void printFibonacciSequence(int count) {\n" +
                                "\t\tint a = 0;\n" +
                                "\t\tint b = 1;\n" +
                                "\t\tint c = 1;\n" +
                                "\n" +
                                "\t\tfor (int i = 1; i <= count; i++) {\n" +
                                "\t\t\tSystem.out.print(a + \", \");\n" +
                                "\n" +
                                "            a = b;\n" +
                                "\t\t\tb = c;\n" +
                                "\t\t\tc = a + b;\n" +
                                "\t\t}\n" +
                                "\t}\n" +
                                "\n" +
                                "\tpublic static void main(String[] args) {\n" +
                                "    \tprintFibonacciSequence(10);\n" +
                                "\t}\n" +
                                "\n" +
                                "}"),
                new Question("How do you check if a list of integers contains only odd numbers in Java?",
                        "public static boolean onlyOddNumbers(List<Integer> list) {\n" +
                                "\tfor (int i : list) {\n" +
                                "\t\tif (i % 2 == 0)\n" +
                                "\t\t\treturn false;\n" +
                                "\t}\n" +
                                "\n" +
                                "\treturn true;\n" +
                                "}"),
                new Question("How do you check whether a string is a palindrome in Java?",
                        "boolean checkPalindromeString(String input) {\n" +
                                "\tboolean result = true;\n" +
                                "\tint length = input.length();\n" +
                                "\n" +
                                "\tfor (int i = 0; i < length/2; i++) {\n" +
                                "\t\tif (input.charAt(i) != input.charAt(length - i - 1)) {\n" +
                                "\t\t\tresult = false;\n" +
                                "\t\t\tbreak;\n" +
                                "\t\t}\n" +
                                "\t}\n" +
                                "\n" +
                                "\treturn result;\n" +
                                "}"),
                new Question("How do you remove spaces from a string in Java?",
                        "String removeWhiteSpaces(String input) {\n" +
                                "\tStringBuilder output = new StringBuilder();\n" +
                                "\t\n" +
                                "\tchar[] charArray = input.toCharArray();\n" +
                                "\t\n" +
                                "\tfor (char c : charArray) {\n" +
                                "\t\tif (!Character.isWhitespace(c))\n" +
                                "\t\t\toutput.append(c);\n" +
                                "\t}\n" +
                                "\t\n" +
                                "\treturn output.toString();\n" +
                                "}"),
                new Question("How do you remove leading and trailing spaces from a string in Java?",
                        "String s = \"  abc  def\\t\";\n" +
                                "\t\t\n" +
                                "s = s.strip();\n" +
                                "\t\t\n" +
                                "System.out.println(s);"),
                new Question("How do you sort an array in Java?",
                        "Arrays.sort(array);")
        );
    }
}
