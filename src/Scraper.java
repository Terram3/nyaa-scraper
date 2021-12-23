import java.io.IOException;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {

  private Document html;
  private String link = "https://nyaa.si/";

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
    link = "https://nyaa.si/";
    search = search.replace(" ", "+");
    connectLink(link + "?f=0&c=1_2&q=" + search);
  }

  public void engTrustedSubSearch(String search) throws IOException {
    link = "https://nyaa.si/";
    search = search.replace(" ", "+");
    connectLink(link + "?f=2&c=1_2&q=" + search);
  }

  public void scrapePageByTag(String tag) {
    Elements fuck = html.select("a[href]");
    searchList(tag, fuck);
  }

//TODO: Fix several word search, special signs and smarter search ;)
  private void searchList(String tag, Elements fuck) {
    boolean temp = false;
    for (Element e : fuck) {
      String titleName = e.attr("title");
      String subLink = e.attr("href");
      if (filterNonTorrentLinks(tag, titleName, subLink)) {
        System.out.println(titleName + System.lineSeparator() + link.substring(0, 15) + subLink);
        temp = true;
      /* will use this eventually, for finding next pages.
        } else if(subLink.contains("p=")){
        System.out.println(link.substring(0, link.length() - 1) + subLink);*/
      } else if(subLink.contains("magnet") && temp){
        System.out.println(e.attr("href") + System.lineSeparator());
        temp = false;
      }
    }
  }

  private boolean filterNonTorrentLinks(String tag, String titleName, String subLink) {
    return titleName.toLowerCase(Locale.ROOT).contains(tag.toLowerCase(Locale.ROOT))
            && !titleName.equals("") && subLink.contains("view") && !subLink.contains("comment");
  }
}
