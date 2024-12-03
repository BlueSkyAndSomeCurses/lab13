package ua.edu.ucu.apps.task3;

import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatGPT {
  private final String apiKey;

  public ChatGPT(String apiKey) {
    this.apiKey = apiKey;
  }

  public Company extractCompanyDetails(String scrapedData) {
    try {
      // OpenAI API URL
      URL url = new URL("https://api.openai.com/v1/completions");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request properties
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("Authorization", "Bearer " + apiKey);
      connection.setDoOutput(true);

      // Create the prompt
      String prompt = "Extract the company name, description, and logo URL from the following data:\n" +
          scrapedData +
          "\nRespond in JSON format like {\"name\": \"...\", \"description\": \"...\", \"logo\": \"...\"}.";

      // Build the request payload
      JSONObject requestBody = new JSONObject();
      requestBody.put("model", "text-davinci-003");
      requestBody.put("prompt", prompt);
      requestBody.put("max_tokens", 200);
      requestBody.put("temperature", 0.7);

      // Send the request
      try (OutputStream os = connection.getOutputStream()) {
        os.write(requestBody.toString().getBytes(StandardCharsets.UTF_8));
      }

      // Read the response
      try (Scanner scanner = new Scanner(connection.getInputStream(), StandardCharsets.UTF_8)) {
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
          response.append(scanner.nextLine());
        }

        // Parse the response
        JSONObject jsonResponse = new JSONObject(response.toString());
        String responseText = jsonResponse.getJSONArray("choices").getJSONObject(0).getString("text").trim();
        JSONObject companyDetails = new JSONObject(responseText);

        // Create and return the Company object
        return new Company(
            companyDetails.optString("name", "N/A"),
            companyDetails.optString("description", "N/A"),
            companyDetails.optString("logo", "N/A")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new Company("Error", "Error occurred: " + e.getMessage(), "N/A");
    }
  }
}
