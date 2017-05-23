/**
 * rules are here https://www.hackerrank.com/contests/w32/challenges/duplication
 * 
 */
package fr.julienrouse;

import java.util.ArrayList;
import java.util.List;

public class Duplication {

		
		public List<Character> generateS() {
			List<Character> s = new ArrayList<>();
			s.add('0');
			List<Character> t = new ArrayList<>();
			

			while(s.size()<1000){
				for(int i=0; i<s.size();i++){
					t.add(Character.forDigit(1-Character.getNumericValue((char)s.get(i)), 10));
				}
				s.addAll(t);
				t = new ArrayList<>();
			}
			return s;
		}
		
	
		
		
}
