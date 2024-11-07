package guerreiros.egipicio;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;

public class Anubita extends Egipicio{

    public Anubita(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
    
     @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo,int indiceAliado, int timeSorteado ) {
        System.out.println(this.getNome()+" está atacando");
        //passar o índice do elemento
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
        
        //HABILIDADE EXCLUSIVA É ATACAR O PRIMEIRO E O ÚLTIMO DA FILA
        guerreiroInimigo = filaInimiga.getLast();
        guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
        
        //ENVENENADO
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
