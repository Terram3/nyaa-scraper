import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Scraper scrape = new Scraper();
    scrape.engSubSearch("sekai");
    scrape.scrapePageByTag("SubsPlease");
    scrape.resetLink();
    scrape.scrapePageByTag("SubsPlease");
  }
}
