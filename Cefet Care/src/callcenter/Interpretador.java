package callcenter;
import java.util.HashSet;

public class Interpretador {     
    private HashSet<String> palavraChave;
    private String[] frase;

    public Interpretador() {        
        this.palavraChave = new HashSet <String>();
    }    

    public HashSet<String> getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(HashSet<String> palavraChave) {
        this.palavraChave = palavraChave;
    }      
    
    public void interpretar(String x){
        palavraChave.clear();
        String[] frase = x.split("[,.] *| +");    //[,.] * ==> Ponto ou vírgula seguido de zero ou mais espaços    
        for(int i=0;i<frase.length;i++)           //| + ==> ou um ou mais espaços. 
            palavraChave.add(frase[i]);                
    }       
}
