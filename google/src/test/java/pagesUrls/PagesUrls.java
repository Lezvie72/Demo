package pagesUrls;

public class PagesUrls {

    //public static String base = System.getenv("TESTING_HOST");
    public static String base = "www.google.ru";
    public static String mainPage = baseUrl();

    public static String baseUrl() {
        return "https://" + base;
    }

    public static String resultsPageUrl() {
        return mainPage + "/search";
    }
}
