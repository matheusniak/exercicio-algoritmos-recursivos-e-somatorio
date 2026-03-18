public class Somatorio {

    public static long funcaoIt(int n) {
        long soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += i;
        }
        return soma;
    }

    public static long funcaoRe(int n) {
        if (n <= 1) return n;
        return n + funcaoRe(n - 1);
    }

    public static void main(String[] args) {
        int[] entradas = {10, 20, 30, 40, 50, 100};
        int repeticoes = 100_000; // Número de vezes para tirar a média

        System.out.println("N\tIterativa (ns médios)\tRecursiva (ns médios)");
        System.out.println("----------------------------------------------------");

        for (int n : entradas) {
            
            // --- Medindo Iterativa ---
            // Aquecimento básico para o JIT
            for(int i = 0; i < 1000; i++) funcaoIt(n); 
            
            long startIt = System.nanoTime();
            for (int i = 0; i < repeticoes; i++) {
                funcaoIt(n);
            }
            long endIt = System.nanoTime();
            double mediaIt = (double) (endIt - startIt) / repeticoes;

            // --- Medindo Recursiva ---
            // Aquecimento básico para o JIT
            for(int i = 0; i < 1000; i++) funcaoRe(n);

            long startRe = System.nanoTime();
            for (int i = 0; i < repeticoes; i++) {
                funcaoRe(n);
            }
            long endRe = System.nanoTime();
            double mediaRe = (double) (endRe - startRe) / repeticoes;

            // Exibindo os resultados com 2 casas decimais
            System.out.printf("%d\t%.2f\t\t\t%.2f%n", n, mediaIt, mediaRe);
        }
    }
}