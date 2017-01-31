package com.nga.resourcelink;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class S {
	public static void main(String p[]){
		printReverse("malayalam");
		
	}
	
	public static void printReverse(String value){
		String [] splitValue = value.split("");
		Stream.of(splitValue)
		.collect(Collectors.toCollection(LinkedList::new))
		.descendingIterator()
		.forEachRemaining(System.out::print);
		
	}
}
