
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RepositorioProcessos implements IRespositorioProcessos{
    
    @Override
    public boolean addProcesso(Processo processo) {
        String filename = String.valueOf(processo.getId())+".txt";
        boolean success = true;
        
        try(FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw)){
            String content = 
                    processo.getNomeReclamante()+"\n"+
                    processo.getTelefone()+"\n"+
                    processo.getEmail()+"\n"+
                    processo.getContent()+"\n";
                    
            bw.write(content);
        }
        catch(IOException e){
            success = false;
        }
        return success;
    }

    @Override
    public Processo getProcesso(int id) {
        String filename = String.valueOf(id)+".txt";
        Processo processo;
        
        try(FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr)){
            processo = new Processo(id,br.readLine(),br.readLine(),
                    br.readLine(),br.readLine());
        }
        catch(IOException e){
            processo = null;
        }
        return processo;
    }
    
}
