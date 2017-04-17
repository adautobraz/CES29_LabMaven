
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersistenceRepoTest {
    
    private static Processo processo1;
    private static Processo processo2;
    private static IRespositorioProcessos rep;
    
    @BeforeClass
    public static void setUpClass() {
        rep = new RepositorioProcessos();
        processo1 = new Processo(0,"A","0129","A@gmail.com","ata0");
        processo2 = new Processo(1,"B","0129","B@gmail.com","ata1");
    }
    @Test
    public void AddGetProcesso1(){
        rep.addProcesso(processo1);
        Processo processo = rep.getProcesso(0);
        assertEquals(processo1.getNomeReclamante(), processo.getNomeReclamante());
        assertEquals(processo1.getTelefone(), processo.getTelefone());
        assertEquals(processo1.getEmail(), processo.getEmail());
        assertEquals(processo1.getContent(), processo.getContent());
    }
    
    @Test
    public void AddGetProcesso2(){
        rep.addProcesso(processo2);
        Processo processo = rep.getProcesso(1);
        assertEquals(processo2.getNomeReclamante(), processo.getNomeReclamante());
        assertEquals(processo2.getTelefone(), processo.getTelefone());
        assertEquals(processo2.getEmail(), processo.getEmail());
        assertEquals(processo2.getContent(), processo.getContent());
    }
}
