package developer_tools;

import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.domain.Question.Exam;


import java.util.Map;

public class QuestionUtils {

    public static Map<String, Question> initQuestions(Exam exam) {
        if (exam == Exam.JAVA) {
            return initJavaQuestions();
        }
        if (exam == Exam.MATH) {
            return initMathQuestions();
        }
        return Map.of();
    }

    public static Map<String, Question> initMathQuestions() {
        String stringQuestion;
        return Map.of(
                stringQuestion = "2x2",
                new Question(stringQuestion, "4"),

                stringQuestion = "Pi",
                new Question(stringQuestion, "3.14"),

                stringQuestion = "e",
                new Question(stringQuestion, "2.72"),

                stringQuestion = "1-1",
                new Question(stringQuestion, "0"),

                stringQuestion = "5x5",
                new Question(stringQuestion, "25"),

                stringQuestion = "Sin(pi)",
                new Question(stringQuestion, "0"),

                stringQuestion = "Cos(pi)",
                new Question(stringQuestion, "1"),

                stringQuestion = "7x7",
                new Question(stringQuestion, "49"),

                stringQuestion = "3^6",
                new Question(stringQuestion, "729"),

                stringQuestion = "5^5",
                new Question(stringQuestion, "3125")
                );
    }
    public static Map<String, Question> initJavaQuestions() {
        String stringQuestion;
        return Map.of(
                stringQuestion = "How do you reverse a string in Java?",
                new Question(stringQuestion,
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

                stringQuestion = "How do you swap two numbers without using a third variable in Java?",
                new Question(stringQuestion,
                        "b = b + a; // now b is sum of both the numbers\n" +
                                "a = b - a; // b - a = (b + a) - a = b (a is swapped)\n" +
                                "b = b - a; // (b + a) - b = a (b is swapped)"),
                stringQuestion = "Write a Java program to check if a vowel is present in a string.",
                new Question(stringQuestion,
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
                stringQuestion = "Write a Java program to check if the given number is a prime number.",
                new Question(stringQuestion,
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
                stringQuestion = "Write a Java program to print a Fibonacci sequence using recursion.",
                new Question(stringQuestion,
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
                stringQuestion = "How do you check if a list of integers contains only odd numbers in Java?",
                new Question(stringQuestion,
                        "public static boolean onlyOddNumbers(List<Integer> list) {\n" +
                                "\tfor (int i : list) {\n" +
                                "\t\tif (i % 2 == 0)\n" +
                                "\t\t\treturn false;\n" +
                                "\t}\n" +
                                "\n" +
                                "\treturn true;\n" +
                                "}"),
                stringQuestion = "How do you check whether a string is a palindrome in Java?",
                new Question(stringQuestion,
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
                stringQuestion = "How do you remove spaces from a string in Java?",
                new Question(stringQuestion,
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
                stringQuestion = "How do you remove leading and trailing spaces from a string in Java?",
                new Question(stringQuestion,
                        "String s = \"  abc  def\\t\";\n" +
                                "\t\t\n" +
                                "s = s.strip();\n" +
                                "\t\t\n" +
                                "System.out.println(s);"),
                stringQuestion = "How do you sort an array in Java?",
                new Question(stringQuestion,
                        "Arrays.sort(array);")


        );
    }
}
