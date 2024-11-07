package guerreiros.atlantes;

import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;

public class Prometeano extends Atlante{
    private int geracao;// por zero
    private int filhos=0;

    public Prometeano(int tipo, String nome, int idade, double peso, int ataque, int geracao) {
        super(tipo, nome, idade, peso, ataque);
        this.geracao = geracao;
    }

    public int getGeracao() {//tem que estar em guerreiro?????
        return geracao;
    }

    public void gerarFilhos(Equipe equipeAliada){
         int vidaFilhos = (int) (100/(Math.pow(2, this.geracao)));
           
            if((vidaFilhos >= 1)&&(this.filhos > 0)){//só pode gerar 2
                System.out.println(this.getNome()+"...VIROU PAPAI \n\n\n");
                Guerreiro filhotePrometeano = null;
               
                for(int i=1; i<=2; i++){ //assim se precisar pode criar inúmeros filhos
                    filhotePrometeano = new Prometeano(this.getTipo(), this.getNome()+i,this.getIdade(), this.getPeso(), this.getAtaque(), this.getGeracao()+1);
                    LinkedList<Guerreiro> filaAliada = equipeAliada.getEquipe().get(i);
                    filhotePrometeano.setEnergia(vidaFilhos);
                    filaAliada.addLast(filhotePrometeano);
                    System.out.println(filhotePrometeano.getNome()+" NASCEU \n\n\n");
                    this.filhos++;
                     
                }
            }
    }
            
    @Override
    public void ataque(Equipe equipeInimiga, Equipe equipeAliada, int indiceInimigo, int indiceAliado, int timeSorteado) {
        System.out.println(this.getNome()+" está atacando");
        
        LinkedList<Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(indiceInimigo);
        Guerreiro guerreiroInimigo = filaInimiga.getFirst();
        guerreiroInimigo.perderVida(this.getAtaque(), equipeInimiga);
    }
        
    @Override
    public void verificaMorte(Equipe equipeAliada) {
        super.verificaMorte(equipeAliada); 
    }

    @Override
    public void perderVida(int ataque, Equipe equipeAliada) {
        super.perderVida(ataque, equipeAliada);
        
        if(this.getEnergia() <= 0){
            this.gerarFilhos(equipeAliada);
        }
    }
    
    @Override
    public void envenenado() {
        super.envenenado(); 
    }
    
}
