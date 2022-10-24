import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;

public class FiltersRtPage {

    public String noFilterIconArchiveJournal() {
        String s = $(shadowCss("#Acked", "#\\39 0506")).toString();
        System.err.println(s);

        return s;

    }
}
