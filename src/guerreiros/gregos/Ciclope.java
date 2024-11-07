package guerreiros.gregos;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;
import manipularlista.ManipularLista;

public class Ciclope extends Grego {
    //private final int poderAtaque = 35;   
    
    public Ciclope(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
    
    @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo,int indiceAliado, int timeSorteado) {
        System.out.println(this.getNome()+" está atacando");
        
        //passar o índice do elemento
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
        
        //HABILIDADE EXCLUSIVA
        if((equipeAliada.getContadorAtaques() == 1 ) && (timeSorteado == equipeAliada.getIndicador())){//Vê se foi o primeiro a atacar
            guerreiroInimigo = filaInimiga.removeFirst();
            filaInimiga.addLast(guerreiroInimigo);
            System.out.println(this.getNome()+" jogou "+guerreiroInimigo.getNome() +" para o final da fila.\n");
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
    /*    
    @Override
    public void perderVida(int ataque) {
       this.setEnergia(getEnergia()-ataque);
       System.out.println(this.getNome()+" recebeu "+ ataque + " de dano."+"Sua energia agora é" + this.getEnergia());
       
       System.out.println("---------------------------");
       //COLOCAR NA CLASSE GUERREIRO, É IGUAL PARA TODOS
    }

    @Override
    public void verificaMorte(Equipe equipeAliada, Guerreiro guerreiro, int indice) {
        if(this.getEnergia()<=0){//COLOCAR NA CLASSE GUERREIRO, É IGUAL PARA TODOS
            this.setStatusVida(false);
            System.out.println(this.getNome()+"...E morreu ");
            //ManipularLista.enterro(ladoAliado, guerreiro, indice);
        }
    }*/

    
    
}      
