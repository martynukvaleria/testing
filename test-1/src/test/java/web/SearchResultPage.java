package web;

import org.openqa.selenium.WebElement;
import web.elements.Link;
import java.util.List;

// page_url = https://www.google.com/search?q=testingchallenges.thetestingmap.org&sca_esv=c796b4c45112019f&sxsrf=ACQVn09nbipZOCXEt-Lb-V-X70PfMM4hVQ%3A1709229055322&source=hp&ei=_8PgZYHXD6nZ7_UPl5KcqAE&iflsig=ANes7DEAAAAAZeDSDwBp_vjIUFFgSPHD7FiE1PMc8EBI&udm=&ved=0ahUKEwjB0ra1jtGEAxWp7LsIHRcJBxUQ4dUDCBY&uact=5&oq=testingchallenges.thetestingmap.org&gs_lp=Egdnd3Mtd2l6IiN0ZXN0aW5nY2hhbGxlbmdlcy50aGV0ZXN0aW5nbWFwLm9yZzIEECMYJzIEEAAYHjIEEAAYHkiAkwFQ7IsBWOyLAXABeACQAQCYAcQCoAHEAqoBAzMtMbgBA8gBAPgBAvgBAZgCAqAC2AKoAgrCAgcQIxjqAhgnmAMQkgcFMS4zLTE&sclient=gws-wiz

public class SearchResultPage {
    public Link mainLink = new Link("first link", "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/span/a/h3");
    public Link allLinks = new Link("all links", "//h3[@class=\"LC20lb MBeuO DKV0Md\"]");

    public boolean isResultEmpty() {
        return allLinks.getListOfLinks().isEmpty();
    }

    public boolean waitForPageLoading() {
        return mainLink.isDisplayed();
    }

    public void clickFirst() {
        mainLink.click();
    }
}
