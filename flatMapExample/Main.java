package flatMapExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        List<Integer> squaredNumbers = numbers.stream()
                // Change or Mutate to something else
                .map(n -> n * n)
                .collect(Collectors.toList());

        List<List<Integer>> matrix = new ArrayList<>();

        List<Integer> matrixElementsSquared = matrix.stream()
                // Map collection to stream of elements flat
                // from 2D change to 1D
                .flatMap(Collection::stream)
                .map(n -> n * n)
                .collect(Collectors.toList());

    }
}
