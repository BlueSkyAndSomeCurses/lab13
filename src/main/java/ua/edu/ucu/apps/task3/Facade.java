package ua.edu.ucu.apps.task3;

import lombok.AllArgsConstructor;

public class Facade {
  public final ChatGPT chatGPT;
  public final WebScrapper scrapper;

  Facade(String URL, String APIkey) {
    chatGPT = new ChatGPT(APIkey);
    scrapper = new WebScrapper(URL);


  }

  public Company extractCompanyInfo(String company) {
    String scrapedData = scrapper.scrape(company);

    return chatGPT.extractCompanyDetails(scrapedData);

  }

}
