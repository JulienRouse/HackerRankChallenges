package test.fr.julienrouse;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.julienrouse.FightMonster;

public class FightMonsterTest {

	@Test
	public void testNumberOfHitToKill() {
		assertEquals("my power is 2, monster hp is 2, 1hit ",1, FightMonster.numberOfHitToKill(2, 2));
		assertEquals("my power is 2, monster hp is 1, 1hit ",1, FightMonster.numberOfHitToKill(1, 2));
		assertEquals("my power is 1, monster hp is 2, 2hits",2, FightMonster.numberOfHitToKill(2, 1));
		assertEquals("my power is 2, monster hp is 3, 3hits",2, FightMonster.numberOfHitToKill(3, 2));
		}

	@Test
	public void testHowManyCanIFight(){
		List<Integer> monsters = new ArrayList<>();
		monsters.add(4);
		monsters.add(5);
		monsters.add(12);
		assertEquals("power 1, time 6, res 1", 1, FightMonster.howManyCanIfight(monsters, 1, 6));
		assertEquals("power 1, time 7, res 1", 1, FightMonster.howManyCanIfight(monsters, 1, 7));
		assertEquals("power 1, time 10, res 2", 2, FightMonster.howManyCanIfight(monsters, 1, 10));
		assertEquals("power 2, time 5, res 2", 2, FightMonster.howManyCanIfight(monsters, 2, 5));
		
	}
	
}
