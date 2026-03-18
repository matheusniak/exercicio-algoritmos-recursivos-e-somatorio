public class SomatorioPassos {

    static int operacoes = 0;

    // Função Iterativa com contagem de passos (Lógica Oficial)
    public static long funcaoIt(int n) {
        operacoes = 1; // soma = 0 (inicialização)
        for (int i = 1; i <= n; i++) {
            operacoes += 2; // soma += i E incremento do i
        }
        return 0; // O retorno não importa para a contagem
    }

    // Função Recursiva com contagem de passos (Lógica Oficial)
    public static long funcaoRe(int n) {
        operacoes++; // Verificação do if (n <= 1)
        if (n <= 1) {
            return 1;
        }
        operacoes++; // Operação de soma e n-1
        return n + funcaoRe(n - 1);
    }

    public static void main(String[] args) {
        int[] entradas = {10, 20, 30, 40, 50, 100};

        // Cabeçalho da tabela
        System.out.printf("%-12s | %-20s | %-20s%n", "Tamanho (N)", "Operações Iterativa", "Operações Recursiva");
        System.out.println("-----------------------------------------------------------------------");

        for (int n : entradas) {
            // Conta Iterativa
            funcaoIt(n);
            int passosIt = operacoes;

            // Reinicia e Conta Recursiva
            operacoes = 0;
            funcaoRe(n);
            int passosRe = operacoes;

            // Exibe os resultados alinhados
            System.out.printf("%-12d | %-20d | %-20d%n", n, passosIt, passosRe);
        }
    }
}