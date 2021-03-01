package Model;

/**
 * Clase votes que engloba votos positivos y negativos que puede tener una instancia de la clase User
 */
public class Votes {
    private int votesUp, votesDown, totalVotes;
    
    /** 
     * Constructor de Votes
     * Se setean en 0 los atributos votesUp y votesDown
     */
    public Votes(){
        this.votesUp = 0;
        this.votesDown = 0;
        this.totalVotes = 0;
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
     * Obtencion de los votos negativos de una pregunta/respuesta
     * @return int que acumula los votos negativos
     */
    public int getTotalVotes(){
        return this.totalVotes;
    }
    
    public void setVotesUp(boolean type){
        if(type){
            this.votesUp++;
            this.totalVotes++;
        }else{
            this.votesUp--;
            this.totalVotes--;
        }
    }
    
    public void setVotesDown(boolean type){
        if(type){
            this.votesDown++;
            this.totalVotes--;
        }else{
            this.votesDown--;
            this.totalVotes++;
        }
    }
    /**
     * Representacion de la informacion respectiva a los votos de una 
     * Pregunta/Respuesta
     * @return String equivalente a una instancia de Votes
     */
    @Override
    public String toString(){
        return "Votos Positivos: "+this.votesUp+" || "+"Votos Negativos: "+this.votesDown +"- Total: "+this.totalVotes;
    }
}
