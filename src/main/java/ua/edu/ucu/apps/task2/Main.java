package ua.edu.ucu.apps.task2;

public class Main {
  public static void main(String[] args) {
    DBAdabter db = new DBAdabter(new БазаДаних());
    AuthorizationAdapter auth = new AuthorizationAdapter(new Авторизація());

    if (auth.auth(db)) {
      ReportBuilder br = new ReportBuilder(db);
      System.out.println("Glory");
    }

  }
}
