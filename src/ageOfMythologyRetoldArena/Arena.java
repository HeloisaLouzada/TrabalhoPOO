package ageOfMythologyRetoldArena;

import guerreiros.Guerreiro;
import java.util.LinkedList;
import manipularlista.ManipularLista;
import manipulararquivo.ManipularArquivo;
import java.util.Random;
import static manipularlista.ManipularLista.moverFinalFila;
import static manipularlista.ManipularLista.removerFila;

public class Arena {
    boolean ataqueGigantePedra = false;
    LinkedList<LinkedList<Guerreiro>> ladoGN;
    LinkedList<LinkedList<Guerreiro>> ladoAE;
    
    public static void main(String[] args) {
        final int quantidade = 4;
        //Cria os dois lados -> ManipularLista.CriaLista(quantidade);
        //LinkedList<LinkedList<Guerreiro>> ladoGN = Equipe.CriaLista(quantidade);
        //LinkedList<LinkedList<Guerreiro>> ladoAE = Equipe.CriaLista(quantidade);
        Arena areninha = new Arena();
        
        areninha.ladoGN=Equipe.CriaLista(quantidade);
        areninha.ladoAE = Equipe.CriaLista(quantidade);
        
        //Lê os arquivos e monta as filas
        areninha.ladoGN.add(ManipularArquivo.LerArquivo("arquivo1.txt", 1));
        areninha.ladoGN.add(ManipularArquivo.LerArquivo("arquivo2.txt", 1));
        areninha.ladoGN.add(ManipularArquivo.LerArquivo("arquivo3.txt", 1));
        areninha.ladoGN.add(ManipularArquivo.LerArquivo("arquivo4.txt", 1));

        areninha.ladoAE.add(ManipularArquivo.LerArquivo("arquivo5.txt", 2));
        areninha.ladoAE.add(ManipularArquivo.LerArquivo("arquivo6.txt", 2));
        areninha.ladoAE.add(ManipularArquivo.LerArquivo("arquivo7.txt", 2));
        areninha.ladoAE.add(ManipularArquivo.LerArquivo("arquivo8.txt", 2));

        Equipe equipeGN = new Equipe(1, areninha.ladoGN, 0);
        Equipe equipeAE = new Equipe(2, areninha.ladoAE, 0);
        
        
        
        areninha.rodada(areninha, equipeGN, equipeAE, quantidade);
        
    }//FIM DA MAIN ==============================================================
    
    //FUNÇÕES AUXILIARES 
    public void rodada(Arena parquinho, Equipe equipeGN, Equipe equipeAE, int quantidadeFilas){ 
        int time = 0;
        String equipeQueMorreu = "";
        
        //try {//O QUE DEU NISSO AQUI?????????
        while (!equipeGN.getEquipe().isEmpty() && !equipeAE.getEquipe().isEmpty()) {

            Random sorteador = new Random();
            time = (sorteador.nextInt(2) + 1);

            System.out.println("\nO TIME SORTEADO FOI:" + time);

            if (time == 1) { //ADICIONAR O MÉTODO ENTERRO DEPOIS DE CADA ATAQUE PARA LIMPAR A ARENA
                equipeQueMorreu = "Equipe GN";
                parquinho.combate(equipeGN, equipeAE, time, quantidadeFilas);
                ManipularLista.enterro(equipeAE);
                
                equipeQueMorreu = "Equipe AE";
                parquinho.combate(equipeAE, equipeGN, time, quantidadeFilas);
                ManipularLista.enterro(equipeGN);

            } else {
                equipeQueMorreu = "Equipe AE";
                parquinho.combate(equipeAE, equipeGN, time, quantidadeFilas);
                ManipularLista.enterro(equipeGN);
                
                equipeQueMorreu = "Equipe GN";
                parquinho.combate(equipeGN, equipeAE, time, quantidadeFilas);
                ManipularLista.enterro(equipeAE);
            }
            //REINICIAR RODADA
            //finalizou o combate, joga os guerreiros para trás
            moverFinalFila(equipeGN, quantidadeFilas);
            moverFinalFila(equipeAE, quantidadeFilas);
            equipeGN.setContadorAtaques(0);
            equipeAE.setContadorAtaques(0);

            System.out.println("\n\n FIM DA RODADA \n\n");
            if (equipeGN.getEquipe().isEmpty() || equipeAE.getEquipe().isEmpty()) {
                System.out.println("\n\n ACABOOOOU \n\n");
            }
        }
        /*} catch (Exception e) {
            System.out.println("A equipe que morreu por completo foi: " + equipeQueMorreu);
            //e.printStackTrace();
        }*/
    }

    public void combate(Equipe equipeAliada, Equipe equipeInimiga, int timeSorteado, int quantidade) {
        System.out.println("\n\n\n======================== INICIO DO COMBATEEEE! ========================\n\n\n");

        // Pega a fila que irá atacar, e repete por todas
        for (int i = 0; i < equipeAliada.getEquipe().size(); i++) { //anda para o próximo for
            LinkedList<Guerreiro> filaAliada = equipeAliada.getEquipe().get(i);

            // Verifica se a fila aliada não está vazia, se tiver ela passa para a próxima
            if (filaAliada.isEmpty()) {
                System.out.println("A fila" + i + "Está vazia...");
                continue;
            }

            //pega o guerreiro que irá atacar
            Guerreiro guerreiroAliado = filaAliada.getFirst();

            for (Guerreiro guerreiro : filaAliada) {
                if (guerreiroAliado.isStatusVida()) {
                    guerreiroAliado = guerreiro;
                    break;  // Encontra o primeiro vivo e sai do loop, obs deveria pegar o primeiro
                }
            }
                //ESCOLHER INIMIGO ========================================================================================
                Guerreiro guerreiroInimigo = null;
                int j = i; //pega o índice da equipe do lado

                while (j < equipeInimiga.getEquipe().size()) { //roda até encontrar 
                    LinkedList <Guerreiro> filaInimiga = equipeInimiga.getEquipe().get(j);
                    if (!filaInimiga.isEmpty()) {//se não estiver vazia
                        guerreiroInimigo = filaInimiga.getFirst();
                        break;
                    }
                    j++;
                }

                if ((guerreiroInimigo != null) && (guerreiroInimigo.isStatusVida())) {//se o gurreiro estiver vivo LUTEMMM
                    
                    System.out.println("Guerreiro aliado da fila " + i + " está atacando o inimigo da fila" + j);
                    equipeAliada.setContadorAtaques(equipeAliada.getContadorAtaques() + 1);
                    guerreiroAliado.ataque(equipeInimiga, equipeAliada, j, i, timeSorteado);
                    guerreiroInimigo.verificaMorte(equipeInimiga);// Tira o morto da arena
                    
                    
                } else {
                System.out.println("Nenhum inimigo disponível para o guerreiro aliado do índice " + i);
                //removerFila(equipeInimiga,j);//coloquei de volta

                }
        }
}

}//FIM DA CLASSE   

