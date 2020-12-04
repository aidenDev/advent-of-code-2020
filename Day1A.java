import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

class Day1A {

  public static void main(String[] args) throws IOException {
    Set<Integer> expenses = Files.lines(Paths.get(args[0]))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());

    expenses.stream()
        .filter(e -> expenses.contains(2020 - e))
        .findFirst()
        .ifPresent(e -> System.out.println(e * (2020 - e)));
  }
}
