import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scraper scrape = new Scraper();
        ScraperSeasonal season = new ScraperSeasonal();
        Scanner scan = new Scanner(System.in);
        int alternative;
        boolean temp = true;
        String menu = """
                1. Scrape after searching for english subs.
                2. Scrape after searching for english subs with trusted uploader.
                3. Scrape front page
                4. Scrape trusted eng subs front page
                5. Show current season anime
                7. Print menu again
                8. Exit program
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
                case 3 -> {
                    scrape.resetLink();
                    System.out.print("Filter by subtag(can be left empty): ");
                    scrape.scrapePageByTag(scan.nextLine());
                }
                case 4 -> {
                    scrape.engTrustedSubSearch("");
                    System.out.print("Filter by subtag(can be left empty): ");
                    scrape.scrapePageByTag(scan.nextLine());
                }
                case 5 -> season.getTitleList();

                case 7 -> System.out.print(menu);
                case 8 -> {
                    temp = false;
                    System.out.println("Thanks for using the program >^_^> :)");
                }
                default -> System.out.println("Input not an alternative" + System.lineSeparator() + menu);
            }
        }
    }
}
