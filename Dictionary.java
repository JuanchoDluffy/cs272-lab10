import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {

  public static void main(String[] args) {
    String csvFile = "example_words.txt";
    String line;
    String[] fields;
    HashMap<String, String> dictionary = new HashMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      br.readLine();
      while ((line = br.readLine()) != null) {
        fields = line.split("\t");
        dictionary.put(fields[0], fields[1]);
        // System.out.println(fields[0]);
        // System.out.println(fields[1]);

        // add newly created employee to employeeSet.

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Scanner scan = new Scanner(System.in);
    System.out.println(" Please enter the word you are looking for or DONE to end:");
    String userSearch = scan.nextLine();

    while (!userSearch.equals("DONE")) {
      System.out.println(" The definiotin of " + userSearch + " " + "is: \n" + dictionary.get(userSearch));
      System.out.println("Please enter the word you are looking for or DONE to end: ");
      userSearch = scan.nextLine();
    }
    System.out.println(" Bye, have a good day!!");
  }

}
