//package web;
//
//import org.openqa.selenium.WebElement;
//import web.elements.PageElement;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SearchResultPage {
//    public static List<WebElement> testPageLinks = new ArrayList<>();
//
//    public void lookForResult(){
//        testPageLinks = PageElement.addToList("//h3[@class=\"LC20lb MBeuO DKV0Md\"]");
//    }
//
//    public boolean isResultEmpty() {
//        return testPageLinks.isEmpty();
//    }
//
//    public boolean waitForPageLoading() {
//        return testPageLinks.getFirst().isDisplayed();
//    }
//}
