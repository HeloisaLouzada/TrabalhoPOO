package guerreiros.nordico;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;

public class LoboFenris extends Nordico{
    private int qtdeLobo = 0;

    public LoboFenris(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }

    public int getQtdeLobo() {
        return qtdeLobo;
    }

    public void setQtdeLobo(int qtdeLobo) {
        this.qtdeLobo = qtdeLobo;
    }
    
@Override
public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo, int indiceAliado, int timeSorteado) {
    System.out.println(this.getNome() + " está atacando");

    // HABILIDADE EXCLUSIVA
    LinkedList<Guerreiro> filaAliada = equipeAliada.getEquipe().get(indiceAliado);
    int totalLobos = -1; // Variável para somar lobos, começa com -1 pq ele se conta
    int cont = 1;
     
    while (cont < filaAliada.size()) {
        Guerreiro guerreiroAliado = filaAliada.get(cont);

        // Verifica se o guerreiro é um lobo e está vivo
        if (guerreiroAliado.getTipo() == 5 && guerreiroAliado.isStatusVida()) {
            totalLobos++;
        } else {
            break; // Sai do loop ao encontrar um guerreiro que não é lobo ou está morto
        }
        cont++;
    }
    
    System.out.println("Tinha " + totalLobos + " lobos atrás");
    
    // Ajuste de ataque
    //this.setAtaque(getAtaque() + (totalLobos * 8));
    System.out.println("Seu ataque agora é " + (getAtaque()+(totalLobos * 8)));

    // Ataque ao inimigo
    LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
    Guerreiro guerreiroInimigo = filaInimiga.getFirst();
    guerreiroInimigo.perderVida((this.getAtaque()+(totalLobos * 8)), equipeInimiga);
    
}
        
    @Override
    public void verificaMorte(Equipe equipeAliada) {
        super.verificaMorte(equipeAliada); 
    }

    @Override
    public void perderVida(int ataque, Equipe equipeAliada) {
        super.perderVida(ataque, equipeAliada); 
    }
    
    @Override
    public void envenenado() {
        super.envenenado(); 
    }
}
