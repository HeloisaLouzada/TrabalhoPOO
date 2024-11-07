package guerreiros.egipicio;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;

public class HomemEscorpiao extends Egipicio{

    public HomemEscorpiao(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
    
    @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo,int indiceAliado, int timeSorteado ) {
        System.out.println(this.getNome()+" está atacando");
        //passar o índice do elemento
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
        
        //HABILIDADE EXCLUSIVA É ENVENENAR
        if(!this.isStatusEnvenenado()){
            guerreiroInimigo.setStatusEnvenenado(true);
            System.out.println(guerreiroInimigo.getNome()+" foi ENVENENADO ");
        }
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
    
}
