package manipularlista;

import ageOfMythologyRetoldArena.Equipe;
import java.util.LinkedList;
import guerreiros.Guerreiro;
 import java.util.Iterator;
public class ManipularLista {
        
    public static void moverFinalFila(Equipe equipe, int tamanhoLado){//rever se precisa passar o tamanho da fila
                
        for (int i = 0; i < equipe.getEquipe().size(); i++) {
            LinkedList<Guerreiro> subFila = equipe.getEquipe().get(i); //pega a fila de índice i, e vai até passar por todas as listas
    
            // Verifica se a fila aliada não está vazia, se tiver ela passa para a próxima
            if (subFila.isEmpty()) {
                removerFila(equipe, i);
                continue;
            }
            
            //pega o guerreiro do início e coloca no final
            Guerreiro primeiroGuerreiro = subFila.removeFirst();
            subFila.addLast(primeiroGuerreiro);
            
            /*if(!primeiroGuerreiro.isStatusVida()){//se o status de vida for falso, morreu e tira da fila
                ManipularLista.enterro(equipe, primeiroGuerreiro, i);
            }*/
            
        }
         
    }
    
    public static void imprimir(Guerreiro guerreiro, int time) {
        String especie = null; 
        
        if (time == 1) {
            switch (guerreiro.getTipo()) {
                case 1 -> especie = "Ciclope";
                case 2 -> especie = "Mantícora";
                case 3 -> especie = "Hidra";
                case 4 -> especie = "Valquíria";
                case 5 -> especie = "Lobo de Fenris";
                case 6 -> especie = "Gigante de Pedra";
                default -> {
                    break;
                }
            }
        } else {
            switch (guerreiro.getTipo()){ 
                case 1 -> especie = "Prometeano";
                case 2 -> especie = "Sátiro";
                case 3 -> especie = "Argus";
                case 4 -> especie = "Anubita";
                case 5 -> especie = "Homem escorpião";
                case 6 -> especie = "Múmia";
                default -> {
                    break;
                }
            }
        }
        
        System.out.println("Espécie:"+ especie);
        System.out.println("Nome:"+ guerreiro.getNome());
        System.out.println("Idade:"+ guerreiro.getIdade());
        System.out.println("Peso:"+guerreiro.getPeso());
        System.out.println("Energia:"+guerreiro.getEnergia());
                               
    }

public static void enterro(Equipe equipe) {
    for (int i = 0; i < equipe.getEquipe().size(); i++) { 
        LinkedList<Guerreiro> fila = equipe.getEquipe().get(i);
        Iterator<Guerreiro> iterator = fila.iterator();

        while (iterator.hasNext()) {
            Guerreiro falecido = iterator.next();
            if (!falecido.isStatusVida()) {
                iterator.remove(); // Remove de forma segura durante a iteração
                System.out.print("Um minuto de silêncio para: " + falecido.getNome() + "\n\n\n");
            }
        }
    }
}
    
    public static void removerFila(Equipe equipeAliada, int fila){
        equipeAliada.getEquipe().remove(fila);
        System.out.print("TODA A FILA:" + fila+"MORREU \n");
     
    }
}
