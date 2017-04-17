import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DesfaultSenderTest {
	ServiceMail SM;
	
	@Before
	public void setUp(){
		SM = new DefaultSender();
	}
	
	@Test
	public void testdefineContent() {
		assertEquals("Teste", SM.defineContent("Teste"));
	}
	
	@Test
	public void testdefineSubject(){
		assertEquals("Teste", SM.defineSubject("Teste"));
	}

	@Test
	public void testdefineSender(){
		assertEquals("Teste", SM.defineSender("Teste"));
	}
	
	@Test
	public void testdefinePassword(){
		assertEquals("Teste", SM.definePassword("Teste"));
	}
	
	/*
	@Test
	public void testSendMail(){
		assertEquals(True, SM.sendMail("Endereco"));
	}*/
}