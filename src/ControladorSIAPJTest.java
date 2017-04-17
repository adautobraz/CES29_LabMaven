import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ControladorSIAPJTest {
	ControladorSIAPJ control;
	Processo proc;
	
	@Before
	public void setUp(){
		control = new ControladorSIAPJ();
		proc = new Processo();
		proc.setId(1244);
		proc.setEmail("fulano@provedor.com");
		proc.setTelefone("(12)12345-6789");
		proc.setNomeReclamante("abcsd asdw toerwi adasdi");
		proc.setContent("A conta de luz ta um absurrrdo!");
	}
	@Test
	public void testValidProc() {
		Database db = mock(Database.class);
		when(db.persist(proc)).thenReturn(true);
		control.setDatabaseConnection(db);
		assertTrue(control.initProcesso(proc));
	}
	
	@Test
	public void testInvalidId() {
		proc.setId(-345);
		assertFalse(control.initProcesso(proc));
	}
	
	@Test
	public void testInvalidName(){
		proc.setNomeReclamante("A23N34z asdw fas");
		assertFalse(control.initProcesso(proc));
	}
	
	@Test
	public void testInvalidTelephone(){
		proc.setTelefone("1223-76384");
		assertFalse(control.initProcesso(proc));
	}
	@Test
	public void testEmail(){
		proc.setEmail("fulano_432@mil.eb.br");
		Database db = mock(Database.class);
		when(db.persist(proc)).thenReturn(true);
		control.setDatabaseConnection(db);
		assertTrue(control.initProcesso(proc));
		proc.setEmail("fulano@provedor@xcd.com");
		assertFalse(control.initProcesso(proc));
	}

}
