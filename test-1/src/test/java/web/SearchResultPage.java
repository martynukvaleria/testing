package web;

import core.DriverUtils;
import org.openqa.selenium.WebElement;
import java.util.List;


// page_url = https://www.google.com/search?q=testingchallenges.thetestingmap.org&sca_esv=dcfe5edb8f188ebf&sxsrf=ACQVn086jKcnbqyu8Oh2682Ow2h_p6RBpA%3A1708632191310&source=hp&ei=f6jXZZ7LELiCxc8Pltq1oAQ&iflsig=ANes7DEAAAAAZde2j3IWZKZmCiPugnJ27Yj6h-VlC8uG&udm=&ved=0ahUKEwjehsD23r-EAxU4QfEDHRZtDUQQ4dUDCBU&uact=5&oq=testingchallenges.thetestingmap.org&gs_lp=Egdnd3Mtd2l6IiN0ZXN0aW5nY2hhbGxlbmdlcy50aGV0ZXN0aW5nbWFwLm9yZzIEEAAYHjIEEAAYHjIEEAAYHkiuug5Qw7cOWMO3DnACeACQAQCYAcABoAHAAaoBAzAuMbgBA8gBAPgBAvgBAagCCsICBxAjGOoCGCc&sclient=gws-wiz#cobssid=s
public class SearchResultPage {
    public static List<WebElement> testPageLinks = DriverUtils.findElementsByXpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]");

    public SearchResultPage() {
    }

    public boolean isResultEmpty() {
        return testPageLinks.isEmpty();
    }

    public void waitForPageLoading() {

    }
}
