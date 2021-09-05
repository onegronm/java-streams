package FactoryMethods;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Program {
    public static void main(String[] args) {

        // Obtaining a stream from a java collection
        List<String> wordsToFind = Arrays.asList("do", "re", "mi", "fa", "so");
        Stream<String> wtfSequentialStream = wordsToFind.stream();
        Stream<String> wtfParallelStream = wordsToFind.parallelStream();
        Stream<String> wtfSeqToParallelStream = wordsToFind.stream().parallel();

        // Obtaining a stream from an array
        String[] a = { "a", "b", "c", "d", "e" };
        Stream<String> streamFromArray = Arrays.stream(a);
        // Print all elements from the stream
        streamFromArray.forEach(System.out::println);
        // streamFromArray.forEach(s -> System.out.println(s));

        // Obtaining a stream from a static factory method
        Stream<String> streamFromStaticFactoryMethod = Stream.of(a);

        // Use the Stream.iterate() static factory method to generate an infinite stream of objects
        // This example generates and prints the first 100 Fibonacci numbers
        var seed = new BigInteger[] { BigInteger.ONE, BigInteger.ONE }; // defines the initial element in the stream
        Stream.iterate(seed,
                f -> new BigInteger[] { f[1], f[0].add(f[1]) }) // A lambda function applied to the previous element to produce a new element. For each element in the stream, create a new array containing the second element as the first value and the addition of the first and second elements as the second value
                .map(f -> f[0]) // convert the array to its first element
                .limit(100) // limit the stream to 100 elements
                .forEach(System.out::println);

        // Generate an unbounded stream of random numbers ranging between 0 and 100
        new Random()
            .ints(0,100)
            .limit(50)
            .forEach(System.out::println);

        // Generate an "infinite" stream of TreeMaps
        List<TreeMap<Long, String>>
                listOfTreeMap =
                    Stream.generate(TreeMap<Long, String>::new)
                    .limit(100) // limit the stream to 100 elements
                    .collect(toList());
    }
}
