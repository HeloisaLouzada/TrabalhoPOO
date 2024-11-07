package guerreiros.nordico;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;


public class Valquiria extends Nordico{

    public Valquiria(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
    
    @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo,int indiceAliado, int timeSorteado ) {
        System.out.println(this.getNome()+" está atacando");
        //passar o índice do elemento
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
        
        //HABILIDADE EXCLUSIVA É CURAR
        LinkedList<Guerreiro> filaAliada = equipeAliada.getEquipe().get(indiceAliado);
        Guerreiro guerreiroAliado = filaAliada.get(1);
        guerreiroAliado.setEnergia(getEnergia()+20);
        
        if(guerreiroAliado.getTipo()<=4){//se for grego
            guerreiroAliado.setEnergia(100);
        }
        
        System.out.println(guerreiroAliado.getNome()+" ganhou 20 de energia, agora está com: "+ guerreiroAliado.getEnergia());
        System.out.println("---------------------------");
        
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
            //ManipularLista.enterro(ladoAliado, guerreiro, indice);
        }
    }*/
    
     
}
