/*
 *rules https://www.hackerrank.com/contests/w32/challenges/fight-the-monsters
 */

package fr.julienrouse;

import java.util.Collections;
import java.util.List;

public class FightMonster {

	
	/**
	 * 
	 * @param hitpoints monsters hp
	 * @param hitPower  power of each hit
	 * @return an integer being how many hit of power hitPower you need to kill a monster with hitpoints life
	 */
	public static int numberOfHitToKill(int hitpoints,int hitPower){
		return (int)Math.ceil((double)hitpoints/(double)hitPower);
	}
	
	/**
	 * 
	 * @param monsters list of monsters hp
	 * @param hitPower power for each hit
	 * @param t number of hit allowed
	 * @return the maximum number of monster killed
	 */
	public static int howManyCanIfight(List<Integer> monsters, int hitPower, int t){
		Collections.sort(monsters);
		int res = 0;
		int timeLeft = t;
		for(int hp:monsters){
			timeLeft -= numberOfHitToKill(hp, hitPower);
			if (timeLeft >= 0)
				res++;
			else if (timeLeft < 0)
				break;
		}
		
		return res;
		
		
	}
	
}
