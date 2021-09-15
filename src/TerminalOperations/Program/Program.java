package TerminalOperations.Program;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.Character.toLowerCase;
import static java.util.stream.Collectors.summingLong;

/*
    Source: https://github.com/douglascraigschmidt/LiveLessons/blob/master/Java8/ex12/src/ex12.java
 */

public class Program {
    public static void main(String[] args) {

    }

    /**
     * Capitalize {@code s} by making the first letter uppercase and
     * the rest lowercase.  This "pure" function's return value is
     * only determined by its input.
     */
    private String capitalize(String s) {
        if (s.length() == 0)
            return s;
        return s
                // Uppercase the first character of the string.
                .substring(0, 1)
                .toUpperCase()
                // Lowercase the remainder of the string.
                + s.substring(1)
                .toLowerCase();
    }

    private void runForEach() {
        System.out.println("\nResults from runForEach():");

        Stream
                // Create a stream of characters from William
                // Shakespeare's Hamlet.
                .of("horatio",
                        "claudius",
                        "Gertrude",
                        "Hamlet",
                        "laertes",
                        "Ophelia")
                // Remove any strings that don't start with 'h' or 'H'
                .filter(s -> toLowerCase(s.charAt(0)) == 'h')
                // Capitalize the first letter in the string
                .map(this::capitalize)
                // Sort the results in ascending order
                .sorted()
                // processing and prints the results
                .forEach(System.out::println);
    }

    /**
     * Run an example using the collect() terminal operation to put
     * the results into a ArrayList using the toList() collector.
     */
    private void runCollectToList() {
        System.out.println("\nResults from runCollectToList():");

        // Create a list of key characters in Hamlet.
        List<String> characters = List
                .of("horatio",
                        "claudius",
                        "Gertrude",
                        "Hamlet",
                        "Hamlet", // Hamlet appears twice.
                        "laertes",
                        "Ophelia");

        // Create sorted list of characters starting with 'h' or 'H'.
        List<String> results = characters

        // Create a stream of characters from William
        // Shakespeare's Hamlet.
        .stream()

        // Remove any strings that don't start with 'h' or 'H'.
        .filter(s -> toLowerCase(s.charAt(0)) == 'h')

        // Capitalize the first letter in the string.
        .map(this::capitalize)

        // Sort the results in ascending order.
        .sorted()

        // This terminal operation triggers aggregate operation
        // processing and collects the results into a list, which
        // contains duplicates
        .collect(Collectors.toList());

        // Print the results.
        System.out.println(results);
    }

    /**
     * Run an example using the collect() terminal operation to put
     * the results into a HashMap using the toMap() collector.
     */
    private void runCollectToMap() {
        System.out.println("\nResults from runCollectToMap():");

        // Create a list of key characters in Hamlet.
        List<String> characters = List
                .of("horatio",
                        "claudius",
                        "Gertrude",
                        "Hamlet",
                        "Hamlet", // Hamlet appears twice.
                        "laertes",
                        "Ophelia");

        // Create sorted set of characters starting with 'h' or 'H'.
        Map<String, Integer> results = characters
                // Create a stream of characters from William
                // Shakespeare's Hamlet.
                .stream()

                // Remove any strings that don't start with 'h' or 'H'.
                .filter(s -> toLowerCase(s.charAt(0)) == 'h')

                // Capitalize the first letter in the string.
                .map(this::capitalize)

                // Terminal operation that triggers aggregate operation
                // processing and collects the results into a map.
                // (key strategy, value strategy, merge function)
                .collect(Collectors.toMap(Function.identity(), String::length, Integer::sum));

        // Print the results.
        System.out.println("Hamlet characters' names + name lengths "
                // Get the list of character names.
                + results);
    }

    /**
     * Run an example using the collect() terminal operation to put
     * the results into a TreeMap using the groupingBy() collector.
     */
    private void runCollectGroupingBy() {
        System.out.println("\nResults from runCollectGroupingBy():");

        // Create a list of key characters in Hamlet.
        List<String> characters = List
                .of("horatio",
                        "claudius",
                        "Gertrude",
                        "Hamlet",
                        "Hamlet", // Hamlet appears twice.
                        "laertes",
                        "Ophelia");

        // Create sorted set of characters starting with 'h' or 'H'.
        Map<String, Long> results = characters
                // Create a stream of characters from William
                // Shakespeare's Hamlet.
                .stream()

                // Remove any strings that don't start with 'h' or 'H'.
                .filter(s -> toLowerCase(s.charAt(0)) == 'h')

                // Capitalize the first letter in the string.
                .map(this::capitalize)

                // Terminal operation that triggers aggregate operation
                // processing and collects the results into a map.
                // Terminal operation that triggers aggregate operation
                // processing and groups the results into a map whose keys
                // are strings of matching Hamlet characters and whose
                // values are the length of each string.
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, summingLong(String::length)));

        // Print the results.
        System.out.println("Hamlet characters' names + name lengths "
                // Get the list of character names.
                + results);
    }
}
