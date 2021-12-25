import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScraperSeasonal {

    private Document html;

    public void connectLink() throws IOException {
        html = Jsoup.connect("https://myanimelist.net/anime/season").get();
    }

    public void currentSeason(int amount){
        Elements list = html.select("a.link-title");
        int count = 0;
        boolean getOut;
        for(Element e : list){
            if(count >= amount){
                break;
            } else {
                count++;
                System.out.println(e.text());
            }
        }
    }
}
