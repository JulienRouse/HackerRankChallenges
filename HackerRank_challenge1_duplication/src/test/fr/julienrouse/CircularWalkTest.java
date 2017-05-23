package test.fr.julienrouse;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.julienrouse.CircularWalk;

public class CircularWalkTest {

	//minCircularWalk
	@Test
	public void testMinCircularWalkChallengeExample() {
		int[] r = {1,0,2,1,1,1,1,2,4};
		int res = CircularWalk.minNumberCircularWalk(9, 0, 2, r);
		assertEquals("example was given by the challenge, should be 2", 2, res);
	}

	@Test
	public void testMinCircularWalkWithoutZeroValue() {
		int[] r = {1,1,2,1,1,1,1,2,4};
		int res = CircularWalk.minNumberCircularWalk(9, 0, 2, r);
		assertEquals("example given by the challenge but wihout the zero at index 1, should be 2", 2, res);
	}
	
	@Test
	public void testMinCircularWalkAllOne() {
		int[] r = {1,1,1,1,1,1,1,1,1};
		int res = CircularWalk.minNumberCircularWalk(9, 0, 2, r);
		assertEquals("example was given by the challenge, should be 2", 2, res);
	}
	
	@Test
	public void testMinCircularWalkAllZero() {
		int[] r = {0,0,0,0,0,0,0,0,0};
		int res = CircularWalk.minNumberCircularWalk(9, 0, 2, r);
		assertEquals("all zero, should be -1", -1, res);
	}
	
	@Test
	public void testMinCircularWalkSAndTSame() {
		int[] r = {0,0,0,0,0,0,0,0,0};
		int res = CircularWalk.minNumberCircularWalk(9, 0, 0, r);
		assertEquals("s and t are equal, should be 0", 0, res);
	}
	
	//populateR
	
	@Test
	public void testPopulateR() {
		int[] r = CircularWalk.populateR(3, 5, 1, 7, 3);
		
		assertEquals("size of r is 3", 3, r.length);
		assertEquals("r[0] is 5", 5 , r[0]);
		assertEquals("r[1] is 0", 0, r[1]);
		assertEquals("r[2] is 1", 1, r[2]);
	}
	
	//getMinInterval
	@Test
	public void testGetMinIntervalBothIndexInsideRange(){
		int[] arr = {0,1,2,3,4,5,6};
		
		assertEquals("start=2, end=4, rep should be 2", 2, CircularWalk.getMinInterval(arr, 2, 4));
	}
	
	@Test
	public void testGetMinIntervalStartOutsideRange(){
		int[] arr = {0,1,2,3,4,5,6};
		assertEquals("start=-2, end=4, rep should be 0", 0, CircularWalk.getMinInterval(arr, -2, 4));
	}
	
	@Test
	public void testGetMinIntervalEndOutsideRange(){
		int[] arr = {0,1,2,3,4,5,6};
		assertEquals("start=4, end=8, rep should be 6", 0, CircularWalk.getMinInterval(arr, 4, 8));
	}
	
	@Test
	public void testGetMinIntervalBothOutsideRange(){
		int[] arr = {0,1,2,3,4,5,6};
		assertEquals("start=-2, end=8, rep should be 0", 0, CircularWalk.getMinInterval(arr, -2, 8));
	}
	
	//modulus
	@Test
	public void testModulus(){
		assertEquals("when a and b positives, modulus == %", true, 1%2 == CircularWalk.modulus(1, 2));
		assertEquals("when a is negative, modulus != %", false, -1%2 == CircularWalk.modulus(-1, 2));
		assertEquals("-1 modulus 2 should be 1", 1, CircularWalk.modulus(-1, 2));
	}

}
