import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2B {

  static class Password {
    char letter;
    int lowerPosition;
    int upperPosition;
    String password;

    Password(String line) {
      String[] elements = line.split("-|\\s|:\\s");
      this.lowerPosition = Integer.parseInt(elements[0]);
      this.upperPosition = Integer.parseInt(elements[1]);
      this.letter = elements[2].charAt(0);
      this.password = elements[3];
    }

    boolean isValid() {
      return password.charAt(lowerPosition-1) == letter 
      ^ password.charAt(upperPosition-1) == letter;
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
