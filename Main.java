package projetofinalbes20262;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        int[] codigosProdutos = new int[15];
        int[] quantidadeProduto = new int[15];
        int produtosCadastrados = 0;

        boolean continuar = true;

        while(continuar){
            switch(exibirMenu()) {
                case 1:
                    produtosCadastrados = cadastrar(codigosProdutos, quantidadeProduto, produtosCadastrados);
                    break;
                case 2:
                    listar(codigosProdutos, quantidadeProduto, produtosCadastrados);
                    break;
                case 3:
                    System.out.println("Digite o código que deseja buscar: ");
                    int codigo = ler.nextInt();
                    int produtoLocalizacao = buscarPorCodigo(codigo, produtosCadastrados, codigosProdutos);
                    if(produtoLocalizacao == -1){
                        System.out.println("Produto não encontrado.");
                    } else {
                        System.out.println("Produto de código: " + codigo + " encontrado no índice " + produtoLocalizacao);
                    }
                    break;
                case 4:
                     int quantidadeProdutoMenor = calcularEstatistica(produtosCadastrados, quantidadeProduto);
                     if(quantidadeProdutoMenor == 0){
                         System.out.println("Erro, não há produtos cadastrados.");
                     } else {
                         System.out.println("A menor quantidade de produto é: "+ quantidadeProdutoMenor + " repor imediatamente!");
                     }
                    break;
                case 0:
                    System.out.println("Encerrando Sistema...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }

        }
    }
    // Módulo 1
    public static int exibirMenu(){
        Scanner ler = new Scanner(System.in);
            System.out.println("====ESCOLHA==== \n"
                    + "1- Cadastrar Produto \n"
                    + "2- Listar Estoque \n"
                    + "3- Buscar Produto por Código \n"
                    + "4- Verificar Menor Estoque (Alerta) \n"
                    + "0- Sair");
            int opcao = ler.nextInt();
            return(opcao);
        }
        // Módulo 2
        public static int cadastrar(int[] idProduto, int[] qntProduto, int contador){
            Scanner ler = new Scanner(System.in);
            for(int i = 0; i < idProduto.length; i++){
                if(idProduto[i] == 0){
                    contador = i;
                    break;
                } else if(idProduto[idProduto.length - 1] != 0){
                    System.out.println("Erro, número máximo de produtos cadastrados.");
                    return contador;
                }
            }
            int codigo, qnt;
            while(true){
                System.out.println("Digite o código do produto: ");
                codigo = ler.nextInt();
                if(codigo < 0 || codigo == 0){
                    System.out.println("Valor inválido, tente novamente.");
                    continue;
                }
                System.out.println("Digite a quantidade do produto em estoque: ");
                qnt = ler.nextInt();
                if(qnt < 0 || qnt == 0){
                    System.out.println("Valor inválido, tente novamente.");
                } else {
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                }
            }
            idProduto[contador] = codigo;
            qntProduto[contador] = qnt;
            return contador + 1;
        }
        // Módulo 3
        public static void listar(int[] idProduto, int[] qntProduto, int contador){
            if(contador == 0){
                System.out.println("Estoque vazio.");
            } else {
                System.out.println("Código | Quantidade:");
                for(int i = 0; i < idProduto.length; i++){
                    System.out.println(idProduto[i] + "   |   " + qntProduto[i]);
                }
            }
        }
        // Módulo 4
        public static int buscarPorCodigo(int codigo, int contador, int[] idProduto) {
            for (int i = 0; i <= contador - 1; i++) {
                if (idProduto[i] == codigo) {
                    return i;
                }

        }
            return -1;
    }
        // Módulo 5
        public static int calcularEstatistica(int contador, int[] qntProduto){
            int menorQnt = 0;
            if(contador == 0){
                System.out.println("Erro, não há produtos cadastrados.");
                return 0;
            }
            for(int i = 0; i <= contador - 1; i++){

                if(i == 0){
                    menorQnt = qntProduto[i];
                } else if(menorQnt > qntProduto[i]){
                    menorQnt = qntProduto[i];
                }

            }
            return menorQnt;
        }
}