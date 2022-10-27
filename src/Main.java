public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);

        //код в примере не работл, потому, что в b мы получаем 0,
        //и пытаемся в с получить результат от деления на 0.

        calc.println.accept(c);
    }
}