import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Scraper scrape = new Scraper();
    scrape.setLink("https://nyaa.si/");
    scrape.scrapePageByTag("SubsPlease");
  }
}
