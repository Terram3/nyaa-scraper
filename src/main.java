import java.io.IOException;

public class main {

  public static void main(String[] args) throws IOException {
    Scraper scrape = new Scraper();
    scrape.setLink("https://nyaa.si/");
    scrape.scrapePageByTag("SubsPlease");
  }
}
