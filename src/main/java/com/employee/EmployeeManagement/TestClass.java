package com.employee.EmployeeManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestClass {

	public static void main(String[] args) {
		
		//1.reverse a string
		
		/*String str="Sneha";
		char[] revArr=str.toCharArray();
		StringBuilder revStr = new StringBuilder();
		for(int i=revArr.length-1;i>=0;i--)
		{
			revStr.append(revArr[i]);
		}
		System.out.println(revStr);*/
		
	  // -----------------------------------------------------------------------
		
		//2.check if string contains vowel
		
		/*String str="Snh";
		char[] strArr=str.toCharArray();
		boolean hasVowel = false;
		for(char a:strArr)
		{
			if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
				hasVowel = true;
			}
			
		}
		if(hasVowel == true)
		{
			System.out.print("String contains vowel");
		}
		else
			System.out.print("String doesnt contain vowel");*/
		
     // -----------------------------------------------------------------------

		
		//3.check if a list of integers contains only odd numbers
		
		/*List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		boolean oddOrNot=false;
		for(Integer i:numbers)
		{
			if(i%2 != 0)
			{
				oddOrNot=true;
			}
			else {
				oddOrNot=false;
			}
		}
		if(oddOrNot == true)
		{
			System.out.print("The list has only odd numbers");
		}
		else {
			System.out.print("The list doesnt have only odd numbers");
		}*/
		
		// -----------------------------------------------------------------------
		
		//4.check if a string is palindrome
		
		/*StringBuilder str= new StringBuilder("momm");
		if(str.toString().equalsIgnoreCase(str.reverse().toString()))
		{
			System.out.print("Its a palindrome");
		}
		else {
			System.out.print("Its not a palindrome");
		}*/
		
	// -----------------------------------------------------------------------
		
		/*Alternate method
		
		String str="moiom";
		//char[] strArr=str.toCharArray();
		boolean palOrNot=true;
		boolean flag=false;
		int length=str.length();
		for(int i=0;i<=length/2;i++) {
			if(str.charAt(i) == str.charAt(length-i-1)) {
				palOrNot=true;
			}
			else {
				palOrNot=false;
			}
		}
		if(palOrNot==true)
		{
			System.out.print("Its a palindrome");
		}
		else {
			System.out.print("Its not a palindrome");
		}*/
		
		// -----------------------------------------------------------------------
		
		//5.print fibonoccii series
		
		/*int count=10;
		int a=0,b=1;
		List<Integer> fib = new ArrayList<Integer>();
		fib.add(a);
		fib.add(b);
		for(int i=0;i<count-2;i++)
		{
			fib.add(fib.get(i)+fib.get(i+1));
		}
		System.out.print(fib);*/
		
		// -----------------------------------------------------------------------
		
		//6.factorial of number n
		
		/*int n=7,factorial=1;
		for(int i=1;i<=n;i++)
		{
			factorial = factorial * i;
		}
		System.out.print(factorial);*/
		
		// -----------------------------------------------------------------------
		
		//7.check if two arrays contain only same elements

		Integer[] firstArr = {1,2,3,4};	
		Integer[] secondArr = {1,2,3,4,5,6,8};	
		boolean simElem = true;
		Set<Integer> firstSet = new HashSet<Integer>(Arrays.asList(firstArr));
		Object[] objArr = firstSet.toArray();
		Set<Integer> secondSet = new HashSet<Integer>(Arrays.asList(secondArr));
		if(firstSet.size() != secondSet.size()) {
			System.out.print("Both arrays doesnt contain same elements");
		}
		else {
			for(int i=0;i<firstSet.size();i++) {
				if(!secondSet.contains(objArr[i])) {
					simElem=false;
					break;
				}
			}
			if(simElem == true)
			{
				System.out.print("Both arrays contain same elements");
			}
			else
			{
				System.out.print("Both arrays doesnt contain same elements");
			}
		}

	}

}
