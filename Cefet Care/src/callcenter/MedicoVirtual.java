package callcenter;

import java.util.Scanner;

public class MedicoVirtual {
    private String problema ;
    private String solucao ;
    private SuporteTecnico suporte;
    private boolean continuar = true;
    
    public MedicoVirtual(){
        this.suporte = new SuporteTecnico();        
    }   
    
    public void diagnostiscar(){  
        Scanner scanner = new Scanner(System.in);
        //problema = scanner.nextLine();
        if("SAIR".equals(problema)){
            continuar = false;
            return;
        }
        if(suporte.solucao(problema) == null)
            solucao=suporte.solucaoAleatoria();
        else
            solucao = suporte.solucao(problema);    
    }

    public boolean getContinuar() {
        return continuar;
    }

    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }
    
    
    
    
}
