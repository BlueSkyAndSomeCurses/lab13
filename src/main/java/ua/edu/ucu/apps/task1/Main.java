package ua.edu.ucu.apps.task1;

public class Main {
  public static void main(String[] args) {
    TwitterAdapter user1 = new TwitterAdapter(new TwitterUser("meow@meow.meow", "777", 593498));
    FacebookAdapter user2 = new FacebookAdapter(new FacebookUser("xyz@zxc.ghoul", "993", 2281337));

    MessageSender sender = new MessageSender();
    sender.send("Hi", user1, "777");
    sender.send("Bye", user2, "993");

  }
}