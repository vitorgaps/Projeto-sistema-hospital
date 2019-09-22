package Controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteReadFile {

    public static void EscreverArquivos(Administracao adm) {
        try {
            File file = new File("Data.txt");
            file.delete();
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(adm);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encotrado");
        } catch (IOException e) {
            System.out.println("ERRO: " + e);
        }
    }
        public static void EscreverArquivos2(GerenciaLogin log) {
        try {
            File file = new File("Data2.txt");
            file.delete();
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(log);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encotrado");
        } catch (IOException e) {
            System.out.println("ERRO: " + e);
        }
    }

    public static Administracao LerArquivos() {
        Administracao adm = new Administracao();
        try {
            FileInputStream fis = new FileInputStream("Data.txt");
            if (0 < fis.available()) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                adm = (Administracao) ois.readObject();
                ois.close();
            }
        } catch (FileNotFoundException e) {
          //  System.out.println("Arquivo nao encotrado");
        } catch (IOException e) {
            System.out.println("ERRO: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: " + e);
        }
        return adm;
    }

    public static GerenciaLogin LerArquivos2() {
        GerenciaLogin log = new GerenciaLogin();
        try {
            FileInputStream fis = new FileInputStream("Data2.txt");
            if (0 < fis.available()) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                log = (GerenciaLogin) ois.readObject();
                ois.close();
            }
        } catch (FileNotFoundException e) {
           // System.out.println("Arquivo nao encotrado");
        } catch (IOException e) {
            System.out.println("ERRO: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: " + e);
        }
        return log;
    }
}
