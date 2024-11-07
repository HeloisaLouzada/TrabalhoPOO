package ageOfMythologyRetoldArena;

import guerreiros.Guerreiro;
import java.util.LinkedList;

public class Equipe {
    private int indicador;
    private LinkedList <LinkedList <Guerreiro>> equipe;
    private int contadorAtaques;

    public Equipe(int indicador, LinkedList<LinkedList<Guerreiro>> equipe, int contadorAtaques) {
        this.indicador = indicador;
        this.equipe = equipe;
        this.contadorAtaques = contadorAtaques;
    }

    public LinkedList<LinkedList<Guerreiro>> getEquipe() {
        return equipe;
    }

    public void setEquipe(LinkedList<LinkedList<Guerreiro>> equipe) {
        this.equipe = equipe;
    }
    
    public int getIndicador() {
        return indicador;
    }

    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }

    public int getContadorAtaques() {
        return contadorAtaques;
    }

    public void setContadorAtaques(int contadorAtaques) {
        this.contadorAtaques = contadorAtaques;
    }
    
    
    //METODOS EXTRAS
     public static LinkedList CriaLista(int tamanhoLista){
     int i;
       
      LinkedList <LinkedList <Guerreiro>> lado = new LinkedList();
       /*for(i =0; i<tamanhoLista; i++){
           LinkedList <Guerreiro> lista = new LinkedList();//<>
           lado.add(lista);
       }*/
      
       return lado;
   }
   
}
