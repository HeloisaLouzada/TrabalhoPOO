package guerreiros.gregos;

import guerreiros.Guerreiro;

public abstract class Grego extends Guerreiro{

    public Grego(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
   
    public void limiteVida(){//this não funcioa?
        if(this.getEnergia() >100){
            this.setEnergia(100);
        }
    }
    
       
}
