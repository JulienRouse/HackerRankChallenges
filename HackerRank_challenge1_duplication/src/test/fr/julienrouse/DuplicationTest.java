package test.fr.julienrouse;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.julienrouse.Duplication;

public class DuplicationTest {

	@Test
	public void testGenerateS() {
		Duplication d = new Duplication();
		
		List<Character> res = d.generateS();
		
		//System.out.println(res);
		assertEquals('0',(char) res.get(0));
		assertEquals('1',(char) res.get(1));
		assertEquals('1',(char) res.get(2));
		assertEquals('0',(char) res.get(3));
		assertEquals('1',(char) res.get(4));
		assertEquals('0',(char) res.get(5));
		assertEquals('0',(char) res.get(6));
		assertEquals('1',(char) res.get(7));
	}

}
