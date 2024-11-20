package ageOfMythologyRetoldArena;

import guerreiros.Guerreiro;
import manipularlista.ManipularLista;

public class FimDeJogoException extends Exception{
    private Guerreiro guerreiroMorto = null;
    private Guerreiro guerreiroAtacante = null;
    private Equipe equipeVencedora = null;
    private Equipe equipeDerrotada = null;

    public FimDeJogoException(Guerreiro guerreiroAtacante, Guerreiro guerreiroMorto, Equipe equipeVencedora, Equipe equipeDerrotada) {
        this.guerreiroAtacante = guerreiroAtacante;
        this.guerreiroMorto = guerreiroMorto;
        this.equipeVencedora = equipeVencedora;
        this.equipeDerrotada = equipeDerrotada;
    }

    // Getters para acessar os detalhes
    public Guerreiro getGuerreiroMorto() {
        return guerreiroMorto;
    }

    public Guerreiro getGuerreiroAtacante() {
        return guerreiroAtacante;
    }

    public Equipe getEquipeVencedora() {
        return equipeVencedora;
    }
    
    public Equipe getEquipeDerrotada() {
        return equipeVencedora;
    }
    
@Override
public String getMessage() {
    String indicadorVencedor = null;
    if(this.equipeVencedora.getIndicador() == 1){
     indicadorVencedor = "Gregos e Nórdicos";
     
    }else {
        indicadorVencedor = "Atlantes e egípcios";
    }
    
    System.out.println("\n\n =========================== Fim de Jogo! ===========================\n");
     
    System.out.println("Último guerreiro a atacar: ");
    ManipularLista.imprimir(guerreiroAtacante, this.equipeVencedora.getIndicador());

    System.out.println("\n\nÚltimo guerreiro a morrer: ");
    ManipularLista.imprimir(guerreiroMorto, this.equipeDerrotada.getIndicador());
    
    return  "\n\n"+ indicadorVencedor + " venceram.\n";
           
         
}
 
}

