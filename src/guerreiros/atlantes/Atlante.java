package guerreiros.atlantes;

import guerreiros.Guerreiro;

public abstract class Atlante extends Guerreiro{

    public Atlante(int tipo, String nome, int idade, double peso, int ataque) {
        super(tipo, nome, idade, peso, ataque);
    }
    
}
