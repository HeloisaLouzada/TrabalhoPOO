package guerreiros.egipicio;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;

public class MortoVivo extends Guerreiro {

    public MortoVivo(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
    
    @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo, int indiceAliado, int timeSorteado) {
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
    }
            
    @Override
    public void envenenado() {
        super.envenenado(); 
    }

    @Override
    public void perderVida(int ataque, Equipe equipeAliada) {
        super.perderVida(ataque, equipeAliada); 
    }

    @Override
    public void verificaMorte(Equipe equipeAliada) {
        super.verificaMorte(equipeAliada); 
    }
    
}
