import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScraperSeasonal {
    //TODO: Setup scrap for seasonal top 20 anime, eventual filters for info might be c00l
    public void getTitleList() throws IOException {
        Document html = Jsoup.connect("https://myanimelist.net/anime/season").get();
        Elements list = html.select("a.link-title");
        for(Element e : list){
            System.out.println(e.text());
        }
    }
}
