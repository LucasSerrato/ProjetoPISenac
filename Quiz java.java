import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    static Scanner input = new Scanner(System.in);

    static int qtPontos = 0;

    // MÉTODO PARA APRESENTAR O MENU E AS OPÇÕES AO USUÁRIO E OBTER A ESCOLHA
    public static int menu() {
        int opcao;

        do {
            System.out.println();
            System.out.println("---------------- MENU -----------------");
            System.out.println("---------------------------------------");
            System.out.println("|                                     |");
            System.out.println("|           1- INTRUÇÕES              |");
            System.out.println("|           2- JOGAR                  |");
            System.out.println("|           3- CRÉDITOS               |");
            System.out.println("|           4- SAIR                   |");
            System.out.println("|                                     |");
            System.out.println("--------------------------------------");

            System.out.println();
            System.out.print("DIGITE A OPÇÃO DESEJADA: ");
            opcao = input.nextInt();

            limpaTerminal();

            if (opcao < 1 || opcao > 4) {
                System.out.println("OPÇÃO INVÁLIDA!");
            }
        } while (opcao < 1 || opcao > 4);

        return opcao;
    }

    public static void limpaTerminal() {
        System.out.print("\033[H\033[2J");// LIMPA O CONSOLE APÓS ESCOLHA
    }

    // MÉTODO CONTROLADOR PARA RETORNAR OS MÉTODOS DE ACORDO COM A ESCOLHA DO
    // USUÁRIO NO MENU
    public static void controlador(int opcao) { // AQUI ELE RECEBE O PARAMETRO OPCAO COMO VARIÁVEL INTEIRA PARA VALIDAR
                                                // OS CASES
        switch (opcao) {
            case 1:
                instrucoes();
                break;

            case 2:
                jogar();
                break;

            case 3:
                creditos();
                break;

            case 4:
                sair();
                break;
        }
    }

    // MÉTODO PARA RETORNAR AS INSTRUÇÕES AO USUÁRIO
    public static void instrucoes() {
        System.out.println();
        System.out.println("***************** SEJA BEM VINDO(A) AO QUIZ! **********************");
        System.out.println();
        System.out.println("O QUIZ SERÁ COMPOSTO DE 10 PERGUNTAS RELACIONADAS AS COPAS DO MUNDO.");
        System.out.println("PARA CADA PERGUNTA VOCÊ TERÁ 4 ALTERNATIVAS E 3 TENTATIVAS PARA ACERTÁ-LA.");
        System.out.println("A CADA ACERTO VOCÊ RECEBE 10 PONTOS.");
        System.out.println();
        System.out.println("*******************************************************************");
    }

    // MÉTODO PRINCIPAL PARA INICIAR O QUIZ
    public static void jogar() {
        pergunta1();
        pergunta2();
        pergunta3();
        pergunta4();
        pergunta5();
        pergunta6();
        pergunta7();
        pergunta8();
        pergunta9();
        pergunta10();
    }

    public static String getPerguntas(int indice) {
        // VETOR DE PERGUNTAS
        String perguntas[] = new String[10];
        perguntas[0] = "1- QUEM FOI O MAIOR ARTILHEIRO DAS COPAS DO MUNDO ATÉ O MOMENTO?";
        perguntas[1] = "2- QUEM SÃO OS MAIORES CAMPEÕES DA COPA DO MUNDO?";
        perguntas[2] = "3- QUANDO FOI REALIZADO A ÚLTIMA COPA DO MUNDO ATÉ O MOMENTO?";
        perguntas[3] = "4- QUEM FOI O JOGADOR MAIS CONVOCADO PARA AS COPAS DO MUNDO ATÉ O MOMENTO?";
        perguntas[4] = "5- QUAL É O ÚNICO JOGADOR QUE JÁ PARTICIPOU DE 3 FINAIS DA COPA DO MUNDO SEGUIDAS?";
        perguntas[5] = "6- QUAL PAÍS GANHOU A PRIMEIRA COPA DO MUNDO?";
        perguntas[6] = "7- QUAL O JOGADOR COM MAIS TÍTULOS DA COPA DO MUNDO?";
        perguntas[7] = "8- QUAL A SELEÇÃO QUE MARCOU O GOL MAIS RÁPIDO NUMA COPA DO MUNDO?";
        perguntas[8] = "9- QUANDO ACONTECEU A PRIMEIRA COPA DO MUNDO NO BRASIL?";
        perguntas[9] = "10- EM QUAL ESTÁDIO FOI A ABERTURA DA COPA DO MUNDO EM 2014?";
        String retorno = perguntas[indice];
        return retorno;
    }

    public static String getRespostaDescricao(int indice) {
        // VETOR DAS DESCRIÇÕES DAS PERGUNTAS
        String descricao[] = new String[10];
        descricao[0] = "Miroslav Josef Klose é o nome com mais gols marcados na história da Copa do Mundo, com 16 gols pela seleção da Alemanha.";
        descricao[1] = "Brasil possui 5 títulos da Copa do Mundo (1958, 1962, 1970, 1994 e 2002).";
        descricao[2] = "A última Copa foi em 2018, na Rússia, com o título da França em cima da Croácia.";
        descricao[3] = "Antonio Carbajal (México) 1950/1954/1958/1962/1966.";
        descricao[4] = "O jogador que mais vezes disputou jogos de finais da Copa do Mundo, em anos consecutivos, foi o Brasileiro Cafú.";
        descricao[5] = "O Uruguai enfrentou a Argentina na final e venceu por 4 a 2. A primeira Copa do Mundo ocorreu em 1930.";
        descricao[6] = "Pelé o atacante brasileiro é o maior campeão de Copas do Mundo na história da competição.";
        descricao[7] = "No duelo entre Turquia e Coreia do Sul, Hakan Shakur, atacante turco, brilhou ao marcar o gol mais rápido da história dos mundias, aos 11 segundos de jogo.";
        descricao[8] = "A Copa do Mundo FIFA de 1950 ou campeonato do Mundo da FIFA 1950, foi a quarta edição deste evento esportivo, um torneio internacional de futebol masculino organizado pela Federação Internacional de Futebol (FIFA), que ocorreu no Brasil, anfitrião da competição pela primeira vez.";
        descricao[9] = "Abertura da Copa do Mundo de 2014 no Brasil, realizada na Arena Corinthians, em São Paulo.";
        String retornaDesc = descricao[indice];
        return retornaDesc;
    }

    public static int addPontos(int pontos) {
        pontos++;
        return pontos;
    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 1
    public static void pergunta1() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("Miroslav Klose"); // RESPOSTA CORRETA
        alternativas.add("Ronaldo");
        alternativas.add("Gerd Müller");
        alternativas.add("Just Fontaine");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(0));
            System.out.println();
            System.out.println("a) " + alternativas.get(0)); // RESPOSTA CORRETA
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2));
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    System.out.println();
                    tentativas++;
                    if (alternativas.get(0) == "Miroslav Klose") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(0));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA

                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "Miroslav Klose") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println();
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(0));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA

                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "Miroslav Klose") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println();
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(0));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA

                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "Miroslav Klose") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println();
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(0));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA

                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 2
    public static void pergunta2() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("Brasil"); // RESPOSTA CORRETA
        alternativas.add("Alemanha");
        alternativas.add("Itália");
        alternativas.add("Argentina");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(1));
            System.out.println();
            System.out.println("a) " + alternativas.get(0)); // RESPOSTA CORRETA
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2));
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "Brasil") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(1));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA

                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "Brasil") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(1));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA

                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "Brasil") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(1));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA

                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "Brasil") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(1));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA

                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 3
    public static void pergunta3() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("2018"); // RESPOSTA CORRETA
        alternativas.add("2016");
        alternativas.add("2014");
        alternativas.add("2012");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(2));
            System.out.println();
            System.out.println("a) " + alternativas.get(0)); // RESPOSTA CORRETA
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2));
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "2018") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(2));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "2018") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(2));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "2018") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(2));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "2018") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(2));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 4
    public static void pergunta4() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("Antonio Carbajal (México)"); // RESPOSTA CORRETA
        alternativas.add("Lothar Matthäus (Alemanha)");
        alternativas.add("Gianluigi Buffon (Itália)");
        alternativas.add("Pelé (Brasil)");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(3));
            System.out.println();
            System.out.println("a) " + alternativas.get(0)); // RESPOSTA CORRETA
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2));
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "Antonio Carbajal (México)") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(3));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "Antonio Carbajal (México)") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(3));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "Antonio Carbajal (México)") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(3));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "Antonio Carbajal (México)") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(3));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 5
    public static void pergunta5() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("Pelé");
        alternativas.add("Cafú"); // RESPOSTA CORRETA
        alternativas.add("Messi");
        alternativas.add("Cristiano Ronaldo");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(4));
            System.out.println();
            System.out.println("a) " + alternativas.get(0)); // RESPOSTA CORRETA
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2));
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "Cafú") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(4));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "Cafú") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(4));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "Cafú") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(4));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "Cafú") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(4));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 6
    public static void pergunta6() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("Brasil");
        alternativas.add("Itália");
        alternativas.add("Uruguai"); // RESPOSTA CORRETA
        alternativas.add("Argentina");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(5));
            System.out.println();
            System.out.println("a) " + alternativas.get(0));
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2)); // RESPOSTA CORRETA
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "Uruguai") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(5));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "Uruguai") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(5));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "Uruguai") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(5));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "Uruguai") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(5));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 7
    public static void pergunta7() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("Cafú");
        alternativas.add("Maradona");
        alternativas.add("Puskas");
        alternativas.add("Pelé"); // RESPOSTA CORRETA

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(6));
            System.out.println();
            System.out.println("a) " + alternativas.get(0));
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2));
            System.out.println("d) " + alternativas.get(3)); // RESPOSTA CORRETA
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "Pelé") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(6));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "Pelé") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(6));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "Pelé") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(6));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "Pelé") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(6));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 8
    public static void pergunta8() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("Brasil");
        alternativas.add("Turquia"); // RESPOSTA CORRETA
        alternativas.add("Itália");
        alternativas.add("França");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(7));
            System.out.println();
            System.out.println("a) " + alternativas.get(0));
            System.out.println("b) " + alternativas.get(1));// RESPOSTA CORRETA
            System.out.println("c) " + alternativas.get(2));
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "Turquia") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "--------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(7));
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "Turquia") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "--------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(7));
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "Turquia") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "--------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(7));
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "Turquia") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(7));
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 9
    public static void pergunta9() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("1950");
        alternativas.add("1966"); // RESPOSTA CORRETA
        alternativas.add("2002");
        alternativas.add("2014");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(8));
            System.out.println();
            System.out.println("a) " + alternativas.get(0)); // RESPOSTA CORRETA
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2));
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "1950") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(8));
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "1950") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(8));
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "1950") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(8));
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "1950") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(8));
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
        }

    }

    // MÉTODO SEPARADO PARA PERGUNTA NÚMERO 9
    public static void pergunta10() {
        String resposta;
        boolean acerto = false;
        int tentativas = 0;
        List<String> alternativas = new ArrayList<String>();

        alternativas.add("Morumbi");
        alternativas.add("Beira Rio");
        alternativas.add("Arena Corinthians"); // RESPOSTA CORRETA
        alternativas.add("Castelão");

        do {
            Collections.shuffle(alternativas);
            System.out.println();
            System.out.println(getPerguntas(9));
            System.out.println();
            System.out.println("a) " + alternativas.get(0));
            System.out.println("b) " + alternativas.get(1));
            System.out.println("c) " + alternativas.get(2)); // RESPOSTA CORRETA
            System.out.println("d) " + alternativas.get(3));
            System.out.println();
            resposta = input.next();

            limpaTerminal();

            switch (resposta) {
                case "a":
                case "A":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(0) == "Arena Corinthians") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(9));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "b":
                case "B":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(1) == "Arena Corinthians") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(9));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "c":
                case "C":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(2) == "Arena Corinthians") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(9));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                case "d":
                case "D":
                    System.out.println();
                    System.out.println(
                            "!--------- VOCÊ SELECIONOU ALTERNATIVA " + resposta.toUpperCase() + " ---------!");
                    tentativas++;
                    if (alternativas.get(3) == "Arena Corinthians") {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA CORRETA ---------!");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(getRespostaDescricao(9));
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        acerto = true; // VARIÁVEL BOOLEANA PARA CONFERIR RESPOSTA CORRETA
                    } else {
                        System.out.println();
                        System.out.println("!--------- RESPOSTA INCORRETA ---------!");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }

            if (tentativas >= 3 && acerto == false) {
                System.out.println();
                System.out.println("!--------- VOCÊ ESGOTOU A QUANTIDADE DE TENTATIVAS ---------!");
                System.out.println();
                break;
            }

        } while (tentativas < 3 && !acerto);

        if (acerto) {
            qtPontos = addPontos(qtPontos);
            System.out
                    .println(
                            "VOCÊ ACERTOU: " + qtPontos + " perguntas e atingiu um score de " + qtPontos + "0 pontos.");
        }

    }

    // MÉTODO PARA RETORNAR OS CRÉDITOS
    public static void creditos() {
        System.out.println("\n****************************CRÉDITOS*****************************");
        System.out.println("\nEste Quiz foi desenvolvido pelos alunos:"
                + "\n*Lucas S"
                + "\n\nMatéria: Projeto Integrador I"
                + "\n\nCurso: Tecnologia em Análise e Desenvolvimento de Sistemas"
                + "\n\nTurma: C | Período: Noturno | Ano: 2022"
                + "\n\nInstituição de ensino: Centro Universitário Senac - Santo Amaro");
        System.out.println("\n*****************************************************************");
    }

    // MÉTODO PARA FINALIZAR O PROGRAMA
    public static void sair() {
        System.out.println("\n*****************");
        System.out.println("SESSÃO FINALIZADA");
        System.out.println("*****************");
        System.exit(0);
    }

    public static void main(String[] args) {
        int opcaoEscolhida;

        System.out.println();
        System.out.println("**************************");
        System.out.println("Seja Bem Vindo(a) ao Quiz Copa do Mundo!");
        System.out.println();

        do {
            opcaoEscolhida = menu();

            controlador(opcaoEscolhida);
        } while (opcaoEscolhida == 1 || opcaoEscolhida == 2 || opcaoEscolhida == 3 || opcaoEscolhida == 4);
    }

}
