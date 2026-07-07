package guru.qa;

public class OperatorHomework {
    public static void cleaning(String... args) {
        // применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int
        int bottle = 3;
        int garbage = 2;
        System.out.println(bottle / garbage);
        System.out.println(bottle * garbage);
        System.out.println(bottle - garbage);
        System.out.println(bottle + garbage);
        // применить несколько арифметических операций над int и double в одном выражении
        double paper = 3.8;
        double take =  bottle + paper;
        System.out.println(take/garbage);
        System.out.println(++take*garbage);
        System.out.println((take+garbage)+(bottle+paper)/2);
        // применить несколько логических операций ( < , >, >=, <= )
        System.out.println(take > paper);
        System.out.println(bottle+garbage == take);
        System.out.println(10 / 2.5 <= take);
        //получить переполнение при арифметической операции
        int max = Integer.MAX_VALUE;
        System.out.println(max + 1);
        }

    public static void main(String[] args) {
        cleaning();
    }
}