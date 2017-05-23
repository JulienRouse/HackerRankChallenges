package test.fr.julienrouse;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import fr.julienrouse.GeometricTrick;

public class GeometricTrickTest {

	@Test
	public void testGeometricTrickChallengeExample() {
		String s = "ccaccbbbaccccca";
		
		assertEquals("challenge example, string: ccaccbbbaccccca and result should be 2", 2, GeometricTrick.geometricTrick(s));
	}
	
	
	//factor
	@Test
	public void testFactorPrime(){
		int n = 17;
		Set<Integer> factors = GeometricTrick.factor(n);
		
		assertEquals("factors of a prime number n are 1 and n", true, factors.contains(1));
		assertEquals("factors of a prime number n are 1 and n", true, factors.contains(n));
		assertEquals("number of factors for a prime is 2", 2, factors.size());
	}
	
	@Test
	public void testFactorNotPrime(){
		int n = 25;
		Set<Integer> factors = GeometricTrick.factor(n);
		
		assertEquals("factors of 25 are 1, 5, 25", true, factors.contains(1));
		assertEquals("factors of 25 are 1, 5, 25", true, factors.contains(5));
		assertEquals("factors of 25 are 1, 5, 25", true, factors.contains(n));
		assertEquals("number of factors for 25 is 3", 3, factors.size());
	}
	
	//v2
	@Test
	public void testGeometricTrickv2ChallengeExample() {
		String s = "ccaccbbbaccccca";
		
		assertEquals("challenge example, string: ccaccbbbaccccca and result should be 2", 2, GeometricTrick.geometricTrickv2(s));
	}
	

}
