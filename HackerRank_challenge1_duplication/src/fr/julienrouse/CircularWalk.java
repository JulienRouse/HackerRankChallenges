/*
 *  https://www.hackerrank.com/contests/w32/challenges/circular-walk
 *  reference for the challenge.
 */
package fr.julienrouse;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CircularWalk {

	/**
	 * You have a circle r, one starting point s and a target t.
	 * How many steps do you need to reach t from s, if you can move at most r[i]units 
	 * each steps in every direction(clockwise and counterclockwise).
	 * r[i] is defined by the recurrence r[i]= (r[i-1]*g+seed) % p 
	 * with 0 <=r_0, g, seed < p and 1 <= p <= n.
	 * 
	 * My strategy here is to build an array of distance called stepsFromT, where stepsFromT[s] = 0, 
	 * and then calculate every distance. The result is then stepsFromT[s] 
	 * 
	 * @param n  number of points of the circular walk
	 * @param s  starting index
	 * @param t  goal
	 * @param r_0 given value for number generator, and first value of the array R
	 * @param g given value for number generator
	 * @param seed given value for number generator
	 * @param p given value for number generator
	 * @return the number of steps you need to go from s to t
	 */
	public static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p){
		//case where starting position and goal position are the same.
		//We try it now to short circuit potentially costly allocations.
		if(s==t)
			return 0;
		//r will contains all the generated numbers, up to 10^7
		int[] r = populateR(n, r_0, g, seed, p);
		return minNumberCircularWalk(n, s, t, r);
    }

	
	//int minIndex = list.indexOf(Collections.min(list));
	/**
	 * find the minimum number of step to go from s to t in the circular walk r of size n
	 * 
	 * @param n size of the circular walk
	 * @param s starting position
	 * @param t goal position
	 * @param r the circular walk
	 * @return minimum number of steps from s to t.
	 */
	public static int minNumberCircularWalk(int n, int s, int t, int[] r) {
		if(s==t)
			return 0;
		int[] stepsFromT = new int[n];
		for(int i=0;i<n;i++)
			stepsFromT[i] = Integer.MAX_VALUE-1; //-1 because MAX_VALUE+1 is the
		                                         //minimum negative value and 
		                                         //bugs the research for a minimum
		stepsFromT[t] = 0;

		for(int i=1;i<n;i++){
			int indexRight = modulus((t+i),n);
			int valueRight = r[indexRight];
			int indexLeft = modulus((t-i),n);
			int valueLeft = r[indexLeft];
			if(valueRight>0)
				stepsFromT[indexRight] = 1 + getMinInterval(stepsFromT, indexRight-valueRight, indexRight+valueRight);

			if(valueLeft>0)
				stepsFromT[indexLeft] = 1 + getMinInterval(stepsFromT, indexLeft-valueLeft, indexLeft+valueLeft);
		}
		
		return stepsFromT[s]==(Integer.MAX_VALUE-1) ? -1 : stepsFromT[s];
	}

	
	/**
	 * Return the min value from the sub array array[start..end] and deal with wrap around.
	 * Example if array is of size 10, and start = -2, end = 5, take the min from the indexes [8,9]&&[0..5]
	 * @param array the array to search the min value in
	 * @param start the lower bound to the subarray. If negative, do a wrap around the array.
	 * @param end  the upper bound to the subarray. If end > array.length, wrap around
	 * @return the min value in array[start..end]
	 */
	public static int getMinInterval(int[] array, int start, int end){
		int min = Integer.MAX_VALUE;
		if(start<0&&end>=array.length)
			for(int i=0;i<array.length;i++)
				min = Math.min(min, array[i]);
		else if(start<0){
			for(int i=modulus(start,array.length);i<array.length;i++){
				min = Math.min(min, array[i]);
			}
			for(int i=0;i<=end;i++)
				min = Math.min(min, array[i]);
		}
		else if(end>=array.length){
			for(int i=start;i<array.length;i++)
				min = Math.min(min, array[i]);
			for(int i=0;i<=modulus(end,array.length);i++)
				min = Math.min(min, array[i]);
		}
		else
			for(int i=start;i<=end;i++)
				min = Math.min(min, array[i]);
		return min;
	}
	
	/**
	 * populate an array with a recurrence function defined as
	 * 
	 * r[i] = (r[i-1]*g-seed) mod p
	 * 
	 * @param n size of the array to populate
	 * @param r_0 first element of the array
	 * @param g given value for number generator
	 * @param seed given value for number generator
	 * @param p given value for number generator
	 * @return
	 */
	public static int[] populateR(int n, int r_0, int g, int seed, int p) {
		int[] r = new int[n];
		r[0] = r_0;
		for(int i=1;i<n;i++)
			r[i] = (r[i-1]*g+seed) % p;
		return r;
	}
	
	/**
	 * Reimplementation of the modulus operation because I want a positive value.
	 * Example: -1 % 2 == -1 in Java because it gives the remainder, modulus(-1,2) == 1
	 * @param a 
	 * @param b 
	 * @return the modulus of a/b
	 */
	public static int modulus(int a, int b){
		return (a % b + b) % b;
	}
	
	public static String arrayIntToString(int[] r){
		String s = "[";
		for(int tmp:r){
			s+=tmp;
			s+=",";
		}
		s+="]";
		return  s;
	}
	
}
