import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
        // Declaração de Variáveis
        // variaveis da formula
        double Sa = 0.0, SOa = 0.0, Va = 0.0, Sb = 0.0, SOb = 0.0, Vb = 0.0, t = 0.0;

        // variavel de opção de escolha para rodas o programa
        int opcao = 0;
        int hora = 17;

        // variaveis de saida
        double posicao = 0.0, tempo = 0.0, horas = 0.0, minuto = 0, segundo = 0;
        String horario = "";
        // Sa & Sb = o local
        // tempo = o instante que colidiu em segundos
        // hora = horario de partida
        // horario = hora de colisão formatada

        // Criação do Objeto Scanner
        Scanner ler = new Scanner(System.in);


        // Estrutura de Repetição (para o usuário realiar o calculo quantas vezes desejar)
        while (true){
            try {
                // Seleção da ação que o usuário deseja realizar
                System.out.println("\nEste programa informa o momento e local em que os trens colidem." +
                        "Insira o nuúmero referente a opção desejada:" +
                        "\n1. Obter instante e local da colisão" +
                        "\n2. Sair do programa");
                opcao = ler.nextInt();

                // Estrutura de Decisão (Executa conforme o comando do usuário)
                switch (opcao) {
                    // Opção 1 : Calcula a colisão dos trens
                    case 1 -> {
                        try {
                            // Entrada de Dados

                            // Estrutura de epetição (executa em looping até o usuário insirir os valores conforme o modulo especificado)
                            do {
                                System.out.println("\nInsira o posição incial do Trem A em KM (de 0 á 10000 km): ");
                                SOa = ler.nextDouble();

                                if (SOa < 0 || SOa > 10000) {
                                    System.out.println("\nA posição do trem A deve ser maior que 0 e menor que 10000. " +
                                            "\nPor favor, digite novamente. ");
                                }
                            } while (SOa < 0 || SOa > 10000);


                            do {
                                System.out.println("\nInsira o posição incial do trem B em KM (de 0 á 10000 km): ");
                                SOb = ler.nextDouble();
                                if (SOb < 0 || SOb > 10000) {
                                    System.out.println("\nA posição do trem B deve ser maior que 0 e menor que 10000." +
                                            "\nPor favor, digite novamente. ");
                                }
                            } while (SOb < 0 || SOb > 10000);


                            do {
                                System.out.println("\nInsira a velocidade do trem A em km/h (de 0 á 300 km/h): ");
                                Va = ler.nextDouble();

                                if (Va < 0 || Va > 300) {
                                    System.out.println("\nA velocidade do trem A deve ser maior que 0 e menor que 300." +
                                            "\nPor favor, digite novamente: ");
                                }
                            } while (Va < 0 || Va > 300);


                            do {
                                System.out.println("\nInsira a velocidade do trem B em km/h (de -300 á 0 km/h): ");
                                Vb = ler.nextDouble();

                                if (Vb > 0 || Vb < -300) {
                                    System.out.println("\nA velocidade do trem B deve ser menor que 0 e maior que -300." +
                                            "\nPor favor, digite novamente. ");
                                }
                            } while (Vb > 0 || Vb < -300);

                            // Verificação para situações que os trens não colide,
                            // (quando as velocidades são 0 e a posição de A é maior que B)
                            if ((Va == 0 && Vb == 0) || SOa > SOb) {
                                System.out.println("\nDe acordo com os dados inseridos, os trens não irão colidir.");
                            }

                            // Calculo do tempo (em horas)
                            t = (SOa - SOb) / (Vb - Va);


                            // Calculo da posição (em km)
                            posicao = SOa + (Va * t);

                            // Conversão do Tempo de Horas para Segundos
                            tempo = t * 3600;

                            // Horario de colisão
                            horas = t + hora;
                            minuto = (tempo/60) %60;
                            segundo = tempo % 60;

                            // Fortamção do Horário
                            horario = String.format("%02.0f:%02.0f:%02.0f", horas, minuto, segundo);


                            // Calculo Posição do Trem A
                            // Sa = SOa + (Va * t);
                            // System.out.println("equação Trem A " + Sa);


                            // Calculo Posição do Trem B
                            // Sb = SOb - (Vb * t);
                            // System.out.println("equação Trem B " + Sb);


                            // Apresentação sobre as Informações da Colisão
                            System.out.printf("\nA colisão de trens acontecerá no KM %2.0f e ocorrerá após %2.0f segundos " +
                                    "no horario de %s \n", posicao, tempo, horario);

                            // Tratamento de erro (para inserção de valores que não seja númericos)
                        } catch (InputMismatchException e) {
                            System.out.println("\nVocê digitou um caractere inválido." +
                                    "\nPor favor, digite novamente:");
                            ler.next();
                        }
                    }

                    // Opção 2 : Encrerra o programa
                    case 2 -> {
                        System.out.println("\nFIM DO PROGRAMA");
                        System.exit(0);
                    }

                    // Tratamento de Erro para Ação selecionada não existente
                    default -> {
                        System.out.println("Opção inválida." +
                                "\nTente novamente:");
                    }
                }

                // Tratamento de Erro para ação inicial do programa
            } catch (InputMismatchException e) {
                System.out.println("\nVocê digitou um caractere inválido." +
                        "\nPor favor, tente novamente:");
                ler.next();
            }
        }
    }
}