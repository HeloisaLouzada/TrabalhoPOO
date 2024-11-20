package ageOfMythologyRetoldArena.questoes;

import ageOfMythologyRetoldArena.Arena;
import ageOfMythologyRetoldArena.Equipe;
import guerreiros.Guerreiro;
import java.util.LinkedList;

public class Questoes {

    /*private double pesoTotal;

    public double getPesoTotal() {
        return pesoTotal;
    }
     */
    public static void somaPeso(Equipe equipe) {
        double pesoTotal = 0;

        for (int i = 0; i < equipe.getEquipe().size(); i++) {
            LinkedList<Guerreiro> fila = equipe.getEquipe().get(i);
            for (int j = 0; j < fila.size(); j++) {
                for (Guerreiro guerreiro : fila) {
                    pesoTotal = pesoTotal + guerreiro.getPeso();
                }
            }
        }

        System.out.println("O peso total da equipe " + equipe.getIndicador() + " é:" + pesoTotal);
        
    }

    public static void guerreiroMaisVelho(Arena areninha, int qtdEquipe) {
        int idadeMax = 0;
        Guerreiro guerreiroMaisVelho = null;

        LinkedList<LinkedList<Guerreiro>> equipe = areninha.getLadoAE(); //Pega o lado
        
        for(qtdEquipe = 2; qtdEquipe > 0; qtdEquipe -- ){
            for (LinkedList<Guerreiro> fila : equipe) {
                for (Guerreiro guerreiro : fila) {
                    if (guerreiro.getIdade() > idadeMax) {
                        idadeMax = guerreiro.getIdade();
                        guerreiroMaisVelho = guerreiro;

                    }
                }
            }
            equipe = areninha.getLadoGN();
        }
         System.out.println("O guerreiro mais velho é" + guerreiroMaisVelho.getNome() + " com "+guerreiroMaisVelho.getIdade()+" anos de idade.");
    }
}
