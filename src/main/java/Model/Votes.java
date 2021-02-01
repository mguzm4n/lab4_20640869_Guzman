package Model;

/**
 * Clase votes que engloba votos positivos y negativos que puede tener un Usuario - User
 * @author Marcelo Guzmán
 */
public class Votes {
    private int votesUp, votesDown;
    
    /** 
     * Constructor de Votes
     * Se setean en 0 los atributos votesUp y votesDown
     */
    public Votes(){
        this.votesUp = 0;
        this.votesDown = 0;
    }
    
    /**
     * Realizar el voto
     * @param type boolean que determina si se incrementa votesUp o votesDown
     */
    public void makeVote(boolean type){
        if(type){
            this.votesUp++;
        }
        else{
            this.votesDown++;
        }
    }
    
    /** 
     * Obtencion de los votos positivos de una pregunta/respuesta
     * @return int positivo o cero
     */
    public int getVotesUp(){
        return this.votesUp;
    }
    
    /** 
     * Obtencion de los votos negativos de una pregunta/respuesta
     * @return int que acumula los votos negativos
     */
    public int getVotesDown(){
        return this.votesDown;
    }
    
    
    /**
     * Representacion de la informacion respectiva a los votos de una 
     * Pregunta/Respuesta
     * @return String equivalente a una instancia de Votes
     */
    @Override
    public String toString(){
        return "Votos Positivos: "+this.votesUp+" || "+"Votos Negativos: "+this.votesDown;
    }
}
