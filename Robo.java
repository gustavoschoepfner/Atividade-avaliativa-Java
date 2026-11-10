public class Robo {
    public int codigo;
    public String nome;
    public int defesa;
    public int ataque;
    public int energia;
    public int vitorias;
    public int derrotas;
    public int empates;
    public int pontos;
    public String disponibilidade;

    Robo(int codigo, String nome, int defesa, int ataque){
        this.codigo = codigo;
        this.nome = nome;
        this.defesa = defesa;
        this.ataque = ataque;
        this.energia = 100;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.pontos = 0;
        this.disponibilidade = "disponível";
    }

    public int getPontos(){
        return pontos;
    }
    public int getCodigo(){
        return codigo;
    }
    public int getVitorias(){
        return vitorias;
    }
    public int getEnergia(){
        return energia;
    }
    public int getAproveitamento(){
        return 100*vitorias/(vitorias+derrotas+empates);
    }
    public String getNome(){
        return nome;
    }

    public int getCombates(){
        return vitorias+derrotas+empates;
    }
}