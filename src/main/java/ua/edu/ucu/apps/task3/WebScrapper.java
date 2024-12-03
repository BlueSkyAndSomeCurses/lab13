package ua.edu.ucu.apps.task3;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScrapper {
  private String baseUrl;

  public WebScrapper(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String scrape(String company) {
    try {
      // Construct the search URL
      String searchUrl = baseUrl + "/search?q=" + company.replace(" ", "+");


      Connection connection = Jsoup.connect(searchUrl)
          .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
          .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
          .header("Accept-Language", "en-US,en;q=0.9")
          .header("Connection", "keep-alive")
          .followRedirects(true);

      Document doc = connection.get();

      // Select and process relevant elements (modify selectors based on the site's structure)
      Elements results = doc.select("div.search-result"); // Example selector

      // Collect the scraped data
      StringBuilder scrapedData = new StringBuilder();
      for (Element result : results) {
        String title = result.select("h2.title").text();
        String description = result.select("p.description").text();
        String link = result.select("a").attr("href");

        scrapedData.append("Title: ").append(title).append("\n");
        scrapedData.append("Description: ").append(description).append("\n");
        scrapedData.append("Link: ").append(link).append("\n\n");
      }

      return scrapedData.toString();
    } catch (IOException e) {
      e.printStackTrace();
      return "Error occurred while scraping: " + e.getMessage();
    }
  }
}
