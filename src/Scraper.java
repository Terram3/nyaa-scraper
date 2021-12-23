import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {

  Document html;
  String link = "https://nyaa.si/";

  public Scraper() {
    /* TODO: search before filter */
  }

  public void resetLink() throws IOException {
    connectLink(link.substring(0, 16));
  }

  public void connectLink(String link) throws IOException {
    if (link == null) {
      throw new IllegalArgumentException();
    }
    this.link = link;
    html = Jsoup.connect(link).get();
  }

  public void engSubSearch(String search) throws IOException {
    connectLink(link + "?f=0&c=1_2&q=" + search);
  }

  public void scrapePageByTag(String tag) {
    Elements fuck = html.select("a[href]");
    searchList(tag, fuck);
  }

  private void searchList(String tag, Elements fuck) {
    boolean temp = false;
    for (Element e : fuck) {
      String titleName = e.attr("title");
      String subLink = e.attr("href");
      if (titleName.contains(tag)) {
        System.out.println(titleName + System.lineSeparator() + link.substring(0, link.length() - 1) + subLink);
        temp = true;
      } else if(subLink.contains("p=")){
        System.out.println(link.substring(0, link.length() - 1) + subLink);
      } else if(subLink.contains("magnet") && temp){
        System.out.println(e.attr("href"));
        temp = false;
      }
    }
  }
}
