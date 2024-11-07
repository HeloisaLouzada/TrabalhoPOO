package guerreiros.gregos;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;


public class Hidra extends Grego{
    private int cabeca=1;
    public Hidra(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }

    public int getCabeca() {
        return cabeca;
    }

    public void setCabeca(int cabeca) {
        this.cabeca = cabeca;
    }
       
    @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo, int indiceAliado, int timeSorteado) {
        System.out.println(this.getNome()+" está atacando");
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(),equipeInimiga);
        
        //HABILIDADE EXCLUSIVA
        if(!guerreiroInimigo.isStatusVida()){
            this.setCabeca(this.getCabeca()+1);
            this.setAtaque(this.getAtaque()+5);
            this.setEnergia(this.getEnergia()+20);
        }
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
