import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Robo> robos = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println("\n[1] Cadastrar robô");
            System.out.println("[2] Consultar robô");
            System.out.println("[3] Listar robôs");
            System.out.println("[4] Exibir classificação");
            System.out.println("[5] Emitir estatísticas");
            System.out.println("[6] Realizar um combate");
            System.out.println("[7] Realizar uma rodada geral");
            System.out.println("[8] Recuperar energia");
            System.out.println("[9] Excluir robô");
            System.out.println("[10] Encerrar programa");
            System.out.print("Escolha uma opção: ");

            opcao = s.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\n Nome: ");
                    String nome = s.next();
                    System.out.print("Código: ");
                    int codigo = s.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = s.nextInt();
                    System.out.print("Defesa: ");
                    int defesa = s.nextInt();

                    Robo robo = new Robo(
                            codigo,
                            nome,
                            defesa,
                            ataque);
                    robos.add(robo);

                    System.out.println("\nRobô cadastrado");
                    break;
                case 2:
                    System.out.print("\nDigite o código do robô: ");
                    int cod = s.nextInt();

                    for (Robo r : robos) {
                        if (r.codigo == cod) {
                            if (r.energia < 30) {
                                r.disponibilidade = "Em recuperação";
                            } else {
                                r.disponibilidade = "Disponível";
                            }
                            System.out.println(
                                    "\n Codigo: " + r.codigo +
                                            "\n Nome: " + r.nome +
                                            "\n Ataque: " + r.ataque +
                                            "\n Defesa: " + r.defesa +
                                            "\n Energia: " + r.energia +
                                            "\n Vitórias: " + r.vitorias +
                                            "\n Derrotas: " + r.derrotas +
                                            "\n Empates: " + r.empates +
                                            "\n Pontos: " + r.pontos +
                                            "\n Disponibilidade: " + r.disponibilidade);
                        }
                    }

                    break;
                case 3:
                    for (Robo r : robos) {
                        if (r.energia < 30) {
                            r.disponibilidade = "Em recuperação";
                        } else {
                            r.disponibilidade = "Disponível";
                        }
                        System.out.println(
                                "\n Codigo: " + r.codigo +
                                        "\n Nome: " + r.nome +
                                        "\n Ataque: " + r.ataque +
                                        "\n Defesa: " + r.defesa +
                                        "\n Energia: " + r.energia +
                                        "\n Vitórias: " + r.vitorias +
                                        "\n Derrotas: " + r.derrotas +
                                        "\n Empates: " + r.empates +
                                        "\n Pontos: " + r.pontos +
                                        "\n Disponibilidade: " + r.disponibilidade);
                    }

                    break;
                case 4:
                    ArrayList<Robo> placar = new ArrayList<>(robos);

                    for (int i = 0; i < placar.size() - 1; i++) {

                        for (int j = 0; j < placar.size() - 1; j++) {

                            if (placar.get(j).getPontos() < placar.get(j + 1).getPontos()) {

                                Robo temp = placar.get(j);
                                placar.set(j, placar.get(j + 1));
                                placar.set(j + 1, temp);

                            } else if (placar.get(j).getPontos() == placar.get(j + 1).getPontos()) {

                                if (placar.get(j).getVitorias() == placar.get(j + 1).getVitorias()) {

                                    Robo temp = placar.get(j);
                                    placar.set(j, placar.get(j + 1));
                                    placar.set(j + 1, temp);

                                } else if (placar.get(j).getEnergia() > placar.get(j + 1).getEnergia()) {

                                    Robo temp = placar.get(j);
                                    placar.set(j, placar.get(j + 1));
                                    placar.set(j + 1, temp);

                                } else if (placar.get(j).getCodigo() > placar.get(j + 1).getCodigo()) {

                                    Robo temp = placar.get(j);
                                    placar.set(j, placar.get(j + 1));
                                    placar.set(j + 1, temp);

                                }
                            }
                        }
                    }

                    break;
                case 5:
                    int mediaEnergia = 0;
                    int aproveitamento = 0;
                    int maior = 0;
                    nome = null;
                    HashMap<String, Integer> empateAprov = new HashMap<>();

                    for (Robo r : robos) {
                        if (r.getCombates() > 0) {
                            if(r.energia <= 30){
                                mediaEnergia += r.getEnergia();
                            }
                            aproveitamento = r.getAproveitamento();
                            if (aproveitamento > maior) {
                                maior = aproveitamento;
                                nome = r.getNome();
                            } else if (aproveitamento == maior) {
                                empateAprov.put(r.getNome(), aproveitamento);
                            }
                        }
                    }
                    mediaEnergia = mediaEnergia / robos.size();

                    System.out.println("\nRobôs cadastrados: " + robos.size());
                    System.out.println("Média de energia de robôs em recuperação: " + mediaEnergia);
                    if (empateAprov.isEmpty()) {
                        System.out.println("participante com maior aproveitamento: " + nome + " - " + aproveitamento);
                    } else {
                        for (int i = 0; i < empateAprov.size(); i++)
                            System.out.println("empates: " + empateAprov.toString());
                        System.out.println("participante com maior aproveitamento: " + nome + " - " + aproveitamento);
                    }
                    break;
                case 6: //NÃO TÁ FUNCIONANDO DIREITO. NÃO TÁ FUNCIONANDO DIREITO. NÃO TÁ FUNCIONANDO DIREITO.
                    Robo robo1 = null;
                    Robo robo2 = null;

                    System.out.print("\nDigite o código do 1° robô: ");
                    cod = s.nextInt();
                    System.out.print("Digite o código do 2° robô: ");
                    int cod2 = s.nextInt();

                    for (Robo r : robos) {
                        if (cod == r.getCodigo()) {
                            robo1 = r;
                        }
                        if (cod2 == r.getCodigo()) {
                            robo2 = r;
                        }
                    }

                    if (robo1.energia <= 30 || robo2.energia <= 30) {
                        System.out.println("Robos não tem energia suficente para batalhar");
                        break;
                    }

                    Robo roboPrimeiro = null;
                    Robo roboSegundo = null;
                    if (robo1.pontos == robo2.pontos) {
                        if (robo1.codigo > robo2.codigo) {
                            roboPrimeiro = robo2;
                            roboSegundo = robo1;
                        } else {
                            roboPrimeiro = robo1;
                            roboSegundo = robo2;
                        }
                    } else if (robo1.pontos < robo2.pontos) {
                        roboPrimeiro = robo2;
                        roboSegundo = robo1;
                    } else {
                        roboPrimeiro = robo1;
                        roboSegundo = robo2;
                    }

                    for (int rodada = 1; rodada <= 5; rodada++) {
                        System.out.println("\nRodada " + rodada);
                        int bonus = rodada % 2 == 0 ? 5 : 0;
                        int dano1 = roboSegundo.defesa - roboPrimeiro.ataque;
                        if (dano1 < 0) {
                            dano1 = 0;
                        } else if (dano1 < 5) {
                            dano1 = 5;
                        }
                        System.out.println("\nRobo " + roboPrimeiro.nome + " ataca. Dano: " + dano1);

                        roboSegundo.energia -= (dano1 + bonus);
                        if (roboSegundo.energia < 0) {
                            roboSegundo.energia = 0;
                        }
                        System.out.println("Robo " + roboSegundo.nome + " energia restante: " + roboSegundo.energia + "\n");
                        if (roboSegundo.energia <= 0) {
                            break;
                        }

                        int dano2 = roboPrimeiro.defesa - roboSegundo.ataque;
                        if (dano2 < 0) {
                            dano2 = 0;
                        } else if (dano2 < 5) {
                            dano2 = 5;
                        }
                        System.out.println("Robo " + roboSegundo.nome + " ataca. Dano: " + dano1);

                        roboPrimeiro.energia -= (dano2 + bonus);
                        if (roboPrimeiro.energia < 0) {
                            roboPrimeiro.energia = 0;
                        }
                        System.out.println("Robo " + roboPrimeiro.nome + " energia restante: " + roboPrimeiro.energia);
                        if (roboPrimeiro.energia <= 0) {
                            break;
                        }
                    }

                    if (roboPrimeiro.energia == roboSegundo.energia) {
                        System.out.println("\nEmpate");
                        roboPrimeiro.pontos++;
                        roboSegundo.pontos++;
                    } else if (roboPrimeiro.energia > roboSegundo.energia) {
                        System.out.println("\nVitória do robo " + roboPrimeiro.nome);
                        // venceu o primeiro
                        roboPrimeiro.pontos += 3;
                        roboPrimeiro.vitorias++;
                        roboSegundo.derrotas++;
                    } else {
                        System.out.println("\nVitória do robo " + roboSegundo.nome);
                        // venceu o segundo
                        roboSegundo.pontos += 3;
                        roboSegundo.vitorias++;
                        roboPrimeiro.derrotas++;
                    }
                    break;
                case 8:
                    int pnt = 0;

                    System.out.print("\nDigite o código do robô: ");
                    cod = s.nextInt();

                    System.out.print(
                            "\nDigite a quantidade de energia desejado a se recuperar (Deve ser múltiplo de 10 e cada 10 de energia custa 1 ponto): ");
                    int qtd = s.nextInt();

                    for (Robo r : robos) {
                        if (cod == r.getCodigo()) {
                            pnt = r.getPontos();
                            if (qtd > 0 && qtd % 10 == 0 && pnt >= qtd / 10 && qtd + r.energia <= 100) {
                                r.energia += qtd;
                                r.pontos -= qtd / 10;
                                System.out.println("\n" + r.nome + " recuperou " + qtd + " de energia.");
                            } else {
                                System.out.println("\nEssa quantidade de energia não é válida.");
                            }
                        }
                    }

                    break;
                case 9:
                    System.out.print("\nDigite o código do robô: ");
                    cod = s.nextInt();

                    for (int i = 0; i < robos.size(); i++) {
                        if (cod == robos.get(i).getCodigo() && robos.get(i).getCombates() == 0) {
                            robos.remove(i);
                            System.out.println("\nRobô excluído.");
                        }
                    }

                    break;
                case 10:
                    System.out.print("\nEncerrando programa.\n");
                    break;
                default:
                    System.out.print("Opção Inválida!");
                    break;
            }
        } while (opcao != 10);
        s.close();
    }
}