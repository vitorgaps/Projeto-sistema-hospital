package callcenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.security.SecureRandom;

public class SuporteTecnico {
    private HashMap <String,String> bancoSolucao;
    private ArrayList <String> respostaPadrao;
    private Interpretador inter;
    
    public SuporteTecnico(){
        this.bancoSolucao = new HashMap<>();
        this.respostaPadrao = new ArrayList<>();
        this.inter = new Interpretador();        
        preencher();
    }
    
    private void preencher(){
        bancoSolucao.put("estomago", "Para termos mais confiança no diagnóstico solicite uma endoscopia.");
        bancoSolucao.put("cabeca", "Para termos mais confiança no diagnóstico solicite uma tomografia da cabeça.");
        bancoSolucao.put("barriga", "Para termos mais confiança no diagnóstico solicite uma ultrassonografia da barriga.");
        bancoSolucao.put("pulmao", "Para termos mais confiança no diagnóstico solicite uma radiografia dos pulmões.");
        bancoSolucao.put("coracao", "Para termos mais confiança no diagnóstico solicite um ecocardiograma.");
        bancoSolucao.put("febre", "Febre pode dizer muitas coisas, procure melhorar o histórico do paciente.");
        bancoSolucao.put("rins", "Para termos mais confiança no diagnóstico solicite uma ultrassonografia dos rins.");
        bancoSolucao.put("figado", "Para termos mais confiança no diagnóstico solicite uma ultrassonografia do figado.");
        bancoSolucao.put("check", "Peça exame de sangue completo, urina e fezes.");        
        respostaPadrao.add("Isto pode ser uma virose. Vou te receitar um remédio");
        
    }

    public HashMap<String, String> getBancoSolucao() {
        return bancoSolucao;
    }

    public void setBancoSolucao(HashMap<String, String> bancoSolucao) {
        this.bancoSolucao = bancoSolucao;
    }

    public ArrayList<String> getRespostaPadrao() {
        return respostaPadrao;
    }

    public void setRespostaPadrao(ArrayList<String> respostaPadrao) {
        this.respostaPadrao = respostaPadrao;
    }
    
    public String solucao(String problema){        
        inter.interpretar(problema);        
        for(String s: inter.getPalavraChave()){
            for(String key : bancoSolucao.keySet()){
                if(key.equals(s)){
                    return (bancoSolucao.get(key));
                }
            }       
        }        
        return null;
    }
    
    public String solucaoAleatoria(){
        SecureRandom random = new SecureRandom();
        int i = random.nextInt(respostaPadrao.size());
        return (respostaPadrao.get(i));
    
    }
    
    
}
