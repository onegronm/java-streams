package IntermediateOperations;

import java.util.*;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        System.out.println("\nResults from runFlatMapLimit():");

        // Create several lists containing characters from Hamlet.
        List<String> l1 = List.of("Hamlet",
                "claudius",
                "Gertrude");

        List<String> l2 = List.of("Ophelia",
                "laertes",
                "Polonius");

        List<String> l3 = List.of("Reynaldo",
                "horatio",
                "Voltemand",
                "Cornelius",
                "Rosencrantz",
                "Gildenstern");

        List<String> l4 = List.of("Fortinbras");

        Stream.of(l1,l2,l3,l4)
        // Flatten the stream of lists of strings into a stream of
        // strings.
            .flatMap(strings -> {
            // Print strings to see how far we go in the stream!
            //System.out.println (strings);
            return strings.stream();
        })
        // Terminal operation that triggers aggregate operation
        // processing and prints the results in "encounter order".
        .forEachOrdered(System.out::println);
    }
}
