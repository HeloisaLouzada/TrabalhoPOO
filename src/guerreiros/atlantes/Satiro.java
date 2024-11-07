package guerreiros.atlantes;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;
import manipularlista.ManipularLista;

public class Satiro extends Atlante{

    public Satiro(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }

     @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo,int indiceAliado, int timeSorteado) {
        System.out.println(this.getNome()+" está atacando");
        //passar o índice do elemento
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        
        //HABILIDADE EXCLUSIVA
        for(int i=0; i<filaInimiga.size();i++){
            Guerreiro guerreiroInimigo = filaInimiga.get(i);
            guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
        }
        
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
    /*@Override
    public void perderVida(int ataque) {
       this.setEnergia(getEnergia()-ataque);
       System.out.println(this.getNome()+" recebeu "+ ataque + " de dano."+"Sua energia agora é" + this.getEnergia());
       
       System.out.println("---------------------------");
    }

    @Override
    public void verificaMorte(Equipe equipeAliada, Guerreiro guerreiro, int indice) {
        if(this.getEnergia()<=0){
            this.setStatusVida(false);
            System.out.println(this.getNome()+"...E morreu \n\n\n");
           // ManipularLista.enterro(ladoAliado, guerreiro, indice);
        }
    }*/
    
     
    
}
