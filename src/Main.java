import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scraper scrape = new Scraper();
        Scanner scan = new Scanner(System.in);
        int alternative;
        boolean temp = true;
        String menu = """
                1. Scrape after searching for english subs.
                2. Scrape after searching for english subs with trusted uploader.
                3. Print menu again
                4. Exit program
                """;
        System.out.print(menu);
        while (temp) {
            System.out.print("New command input: ");
            alternative = scan.nextInt();
            scan.nextLine();
            switch (alternative) {
                case 1 -> {
                    System.out.println("Input search(can be left empty): ");
                    scrape.engSubSearch(scan.nextLine());
                    System.out.print("Filter by subtag(can be left empty): ");
                    scrape.scrapePageByTag(scan.nextLine());
                }
                case 2 -> {
                    System.out.println("Input search(can be left empty): ");
                    scrape.engTrustedSubSearch(scan.nextLine());
                    System.out.print("Filter by subtag(can be left empty): ");
                    scrape.scrapePageByTag(scan.nextLine());
                }
                case 3 -> System.out.print(menu);
                case 4 -> {
                    temp = false;
                    System.out.println("Thanks for using the program >^_^> :)");
                }
                default -> System.out.println("Input not an alternative" + System.lineSeparator() + menu);
            }
        }
    }
}
