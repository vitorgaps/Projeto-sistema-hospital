package Controle;

import java.io.Serializable;

public class Prontuario implements Serializable {
  String Sintomas;
  String Tratamento;
  String Exames;
  String Prontuario="";
  String Paciente;
  
    public Prontuario(String nome) {
        this.Sintomas = "";
        this.Tratamento = "";
        this.Exames = "";
        this.Paciente = nome;
    }   
    

   protected void AdicionarExames(String resExame)
   {
      
     Exames+= String.format("\n"+resExame);
   }    
   
   protected void AtualizarSintomas(String Sintomas){
     this.Sintomas = Sintomas;
   }
   
   protected void AtualizarTratamento(String Tratamento){
     this.Tratamento = Tratamento;
   }
   
   public String exibirProntuario(){
    if(this.Sintomas!=null)
    Prontuario=String.format("Sintomas: \n"+Sintomas+"\nExames: \n"+Exames+"\nTratamento: \n"+Tratamento+"\n");
     return Prontuario;
   }

    public String getNome() {
        return Paciente;
    }
   
   
   
   
   
}
