public class Somatorio {

    // Versão Iterativa
    public static long funcaoIt(int n) {
        long soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += i;
        }
        return soma;
    }

    // Versão Recursiva
    public static long funcaoRe(int n) {
        if (n <= 1) return n;
        return n + funcaoRe(n - 1);
    }

    public static void main(String[] args) {
        int[] entradas = {10, 20, 30, 40, 50, 100};
        
        System.out.println("N\tIterativa (ns)\tRecursiva (ns)");
        
        for (int n : entradas) {
            // Iterativa
            long startIt = System.nanoTime();
            funcaoIt(n);
            long endIt = System.nanoTime();
            
            // Recursiva
            long startRe = System.nanoTime();
            funcaoRe(n);
            long endRe = System.nanoTime();
            
            System.out.println(n + "\t" + (endIt - startIt) + "\t\t" + (endRe - startRe));
        }
    }
}