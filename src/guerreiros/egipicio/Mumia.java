package guerreiros.egipicio;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;

public class Mumia extends Egipicio{

    public Mumia(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
    
    @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo, int indiceAliado, int timeSorteado) {
        System.out.println(this.getNome()+" está atacando");
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(),equipeInimiga);
        
        //HABILIDADE EXCLUSIVA
        if(!guerreiroInimigo.isStatusVida()){
            Guerreiro mortoVivo = new MortoVivo(7, guerreiroInimigo.getNome(),guerreiroInimigo.getIdade(),guerreiroInimigo.getPeso(), 5);
            LinkedList<Guerreiro> filaAliada = equipeAliada.getEquipe().get(indiceAliado);
            filaAliada.addLast(mortoVivo);
        }
    }
        
    @Override //sobrecarga
    public void verificaMorte(Equipe equipeAliada) {
        if(this.getEnergia()<=0){
            this.setStatusVida(false);
            System.out.println(this.getNome()+"...E morreu \n\n\n");
                       
            
                System.out.println(this.getNome()+"SERÁ VINGADOOO \n\n\n");
         
                Guerreiro anubitaVingadora = null;
                                
                for(int i=1; i<=4; i++){ //assim se precisar pode criar inúmeros filhos
                    anubitaVingadora = new Anubita(this.getTipo(), this.getNome().concat(String.valueOf(i)),this.getIdade(), this.getPeso(),5);
                    LinkedList<Guerreiro> filaAliada = equipeAliada.getEquipe().get(i);
                    filaAliada.addLast(anubitaVingadora);
                    System.out.println(anubitaVingadora.getNome()+" VINGADORES AVANTE \n\n\n");
                     
                }
            
        }
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
