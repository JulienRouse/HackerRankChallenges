/*
 * https://www.hackerrank.com/contests/w32/challenges/geometric-trick
 */
package fr.julienrouse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeometricTrick {

	/**
	 * Consider a string s of length n with alphabet {a,b,c}.
	 * We look for the number of different triplet (i,j,k) where 0<=i,j,k<n, satisfying!
	 * - s[i] = "a", s[j] = "b", s[k] = "c"
	 * - (j + 1)² = (i + 1)(k + 1) 
	 * @param s A string we look the triplet in
	 * @return Number of different triplets such as enonced above. 
	 */
	public static int geometricTrick(String s){
		
		//extract index for a,b and c in lists
		List<Integer> indexA = new ArrayList<>(s.length());
		List<Integer> indexB = new ArrayList<>(s.length());
		List<Integer> indexC = new ArrayList<>(s.length());
		
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='a')
				indexA.add(i);
			if(s.charAt(i)=='b')
				indexB.add(i);
			if(s.charAt(i)=='c')
				indexC.add(i);
		}
	
		
		int res = 0;
		for(int tmpA:indexA)
			for(int tmpB:indexB)
				for(int tmpC:indexC)
					if(((tmpB+1)*(tmpB+1))==((tmpA+1)*(tmpC+1)))
						res++;
		
        return res;
    }
	
	public static int geometricTrickv2(String s){
		
		//extract index for a,b and c in lists
		Set<Integer> indexA = new HashSet<>(s.length());
		List<Integer> indexB = new ArrayList<>();
		Set<Integer> indexC = new HashSet<>(s.length());
		
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='a')
				indexA.add(i);
			if(s.charAt(i)=='b')
				indexB.add(i);
			if(s.charAt(i)=='c')
				indexC.add(i);
		}
	
		
		int res = 0;
		for(int tmpB:indexB){
			int powB = (int)Math.pow((double)(tmpB+1),2);
			//Set<Integer> factors = new HashSet<>();
			for(int i=2;i<=Math.sqrt((double)powB);i++){
				if(powB%i==0){
					if(i != powB/i)
						if(indexA.contains(i-1)&&indexC.contains(powB/i-1))
							res++;
						if(indexC.contains(i-1)&&indexA.contains(powB/i-1))
							res++;
					else
						if(indexA.contains(i-1)&&indexC.contains(i-1))
							res++;
				}
			}
			
		}
		
        return res;
    }
	
	/**
	 * Return all the factors of n
	 * @param n 
	 * @return
	 */
	public static Set<Integer> factor(int n){
		Set<Integer> factors = new HashSet<>();
		for(int i=1;i<=Math.sqrt((double)n);i++){
			if(n%i==0){
				factors.add(i);
				if(i != n/i)
					factors.add(n/i);
			}
		}
		return factors;
	}
	
	
	
	
	
}
