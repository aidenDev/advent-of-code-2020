import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2A {

  static class Password {
    char letter;
    int lowerBound;
    int upperBound;
    String password;

    Password(String line) {
      String[] elements = line.split("-|\\s|:\\s");
      this.lowerBound = Integer.parseInt(elements[0]);
      this.upperBound = Integer.parseInt(elements[1]);
      this.letter = elements[2].charAt(0);
      this.password = elements[3];
    }

    boolean isValid() {
      long charCount = password.chars()
          .filter(c -> c == letter)
          .count();

      return (charCount >= lowerBound && charCount <= upperBound)
          ? true
          : false;
    }
  }

  public static void main(String[] args) throws IOException {
    long validPasswords = Files.lines(Paths.get(args[0]))
        .map(Password::new)
        .filter(Password::isValid)
        .count();

    System.out.println(validPasswords);
  }
}
