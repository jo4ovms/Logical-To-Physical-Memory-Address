import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o tamanho da página (em bytes): ");
        int tamanhoPagina = scanner.nextInt();

        System.out.println("Informe o número de páginas");
        int numPaginas = scanner.nextInt();

        int[] tabelaPaginas = new int[numPaginas];
        System.out.println("Informe o quadro correspondente para cada página (-1 se não existir):");

        for (int i = 0; i < numPaginas; i++) {
            System.out.print("Pagina " + i + ": ");
            tabelaPaginas[i] = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.print("Informe os endereços lógicos a converter, separados por vírgula: ");
        String enderecosLogicosStr = scanner.nextLine();
        String[] enderecosLogicosArr = enderecosLogicosStr.split(",");

        for (String enderecoStr : enderecosLogicosArr) {
            int enderecoLogico = Integer.parseInt(enderecoStr.trim());


            int paginaLogica = enderecoLogico / tamanhoPagina;
            int deslocamento = enderecoLogico % tamanhoPagina;

            if (paginaLogica < numPaginas && tabelaPaginas[paginaLogica] != -1) {
                int quadroFisico = tabelaPaginas[paginaLogica];
                int enderecoFisico = (quadroFisico * tamanhoPagina) + deslocamento;
                System.out.println("Endereço Lógico: " + enderecoLogico +
                        " -> Página " + paginaLogica + ", Quadro " + quadroFisico +
                        ", Endereço Físico: " + enderecoFisico);
            } else {
                System.out.println("Endereço Lógico: " + enderecoLogico +
                        " -> Página " + paginaLogica + " não mapeada (Gera uma Interrupção).");
            }
        }
        scanner.close();
    }
}