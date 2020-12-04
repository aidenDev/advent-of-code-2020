import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Day1B {
    
  public static void main(String[] args) throws IOException {
    Integer[] expenses = Files.lines(Paths.get(args[0]))
        .map(Integer::parseInt)
        .toArray(Integer[]::new);

    for (int i = 0; i < expenses.length - 2; i++) {
      int sum = 2020 - expenses[i];
      Set<Integer> expensesSeen = new HashSet<>();

      for (int j = i+1; j < expenses.length; j++) {
        if (expensesSeen.contains(sum - expenses[j])) {
          System.out.println(expenses[i] * expenses[j] * (sum - expenses[j]));
          return;
        }
        expensesSeen.add(expenses[j]);
      }
    }
  }
}
