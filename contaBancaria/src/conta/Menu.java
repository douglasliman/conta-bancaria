package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.contaController.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner leia = new Scanner(System.in);

        int opcao, numero, agencia, tipo, numeroDestino;
        String titular;
        float saldo, limite, valor;

        ContaController contas = new ContaController();

        System.out.println("\nCriar Contas\n");

        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
        contas.cadastrar(cc1);

        ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
        contas.cadastrar(cc2);

        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f);
        contas.cadastrar(cp1);

        ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f);
        contas.cadastrar(cp2);

        contas.listarTodas();

        while (true) {
            System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
                    + "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                BANCO DO BUG                         ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Conta                            ");
            System.out.println("            2 - Listar todas as Contas                  ");
            System.out.println("            3 - Buscar Conta por Numero                ");
            System.out.println("            4 - Atualizar Dados da Conta             ");
            System.out.println("            5 - Apagar Conta                         ");
            System.out.println("            6 - Sacar                                ");
            System.out.println("            7 - Depositar                            ");
            System.out.println("            8 - Transferir valores entre Contas      ");
            System.out.println("            9 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     " + Cores.TEXT_RESET);

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                continue;
            }

            if (opcao == 9) {
                System.out.println(Cores.TEXT_GREEN + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println(Cores.TEXT_GREEN + "Criar Conta\n\n");

                    System.out.println("Digite o Numero da Agência: ");
                    agencia = leia.nextInt();
                    leia.nextLine(); // Limpar o buffer do scanner
                    System.out.println("Digite o Nome do Titular: ");
                    titular = leia.nextLine();

                    do {
                        System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
                        tipo = leia.nextInt();
                    } while (tipo < 1 || tipo > 2);

                    do {
                        System.out.println("Digite o Saldo da Conta (R$): ");
                        saldo = leia.nextFloat();
                    } while (saldo < 0);

                    switch (tipo) {
                        case 1:
                            System.out.println("Digite o Limite de Crédito (R$): ");
                            limite = leia.nextFloat();
                            contas.cadastrar(
                                    new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
                            break;
                        case 2:
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo));
                            break;
                    }

                    pressToContinue();
                    break;
                case 2:
                    System.out.println(Cores.TEXT_GREEN + "Listar todas as Contas\n\n");

                    contas.listarTodas();

                    pressToContinue();
                    break;
                case 3:
                    System.out.println(Cores.TEXT_GREEN + "Buscar Conta por número\n\n");

                    System.out.println("Digite o número da conta: ");
                    numero = leia.nextInt();

                    contas.procurarPorNumero(numero);

                    pressToContinue();
                    break;
                case 4:
                    // Atualizar Dados da Conta
                    break;
                case 5:
                    // Apagar Conta
                    break;
                case 6:
                    // Sacar
                    break;
                case 7:
                    // Depositar
                    break;
                case 8:
                    // Transferir valores entre Contas
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
                    pressToContinue();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: ");
        System.out.println("Generation Brasil - generation@generation.org");
        System.out.println("github.com/conteudoGeneration");
        System.out.println("*********************************************************");
    }

    public static void pressToContinue() {
        try {
            System.out.println(Cores.TEXT_GREEN + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
