package guerreiros.gregos;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;

public class Manticora extends Grego {

    public Manticora(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
      
    @Override
public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo, int indiceAliado, int timeSorteado) {
    System.out.println(this.getNome() + " está atacando");

    try {
       
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo - 1);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque() / 2, equipeInimiga);
    } catch (IndexOutOfBoundsException | NullPointerException e) {
        // Caso a fila esteja vazia, simplesmente ignora e continua a execução
    }

    try {
        
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
    } catch (IndexOutOfBoundsException | NullPointerException e) {
        
    }

    try {
        
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo + 1);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque() / 2, equipeInimiga);
    } catch (IndexOutOfBoundsException | NullPointerException e) {
       
    }

    // Envenenado
    this.envenenado();
    System.out.println("---------------------------");
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
