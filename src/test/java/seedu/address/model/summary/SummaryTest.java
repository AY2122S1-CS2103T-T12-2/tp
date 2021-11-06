package seedu.address.model.summary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalContacts.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.UserPrefs;
import seedu.address.testutil.ContactBuilder;



public class SummaryTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private String totalContacts = "Total Number of Contacts: ";


    @Test
    public void execute_getNumberOfContactsGui_success() {
        ReadOnlyAddressBook addressBook = model.getAddressBook();
        int size = addressBook.getContactList().size();

        Summary summary = new Summary(getTypicalAddressBook());
        String summarySize = summary.getNumberOfContactsGui();

        assertEquals(totalContacts + size, summarySize);
    }


    @Test
    public void execute_getPercentageCategoryGui_successAfterUpdate() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        ReadOnlyAddressBook addressBook = model.getAddressBook();
        Summary summary = new Summary(addressBook);
        ObservableList<PieChart.Data> summaryCategory = summary.getPercentageCategoryGui();

        String category = ContactBuilder.DEFAULT_CATEGORY_CODE;
        model.addContact(new ContactBuilder().withName("Alice").build());


        ReadOnlyAddressBook addressBookAfterAdd = model.getAddressBook();
        Summary summaryAfterAdd = new Summary(addressBookAfterAdd);
        ObservableList<PieChart.Data> summaryCategoryAfterAdd = summaryAfterAdd.getPercentageCategoryGui();

        assertEquals(summaryCategory.size(), summaryCategoryAfterAdd.size());

        int count = 0;
        for (PieChart.Data i : summaryCategoryAfterAdd) {
            double afterAdd = summaryCategoryAfterAdd.get(count).getPieValue();
            double beforeAdd = summaryCategory.get(count).getPieValue();
            double afterAddAtt = afterAdd - 1;
            if (summaryCategoryAfterAdd.get(count).getName().equalsIgnoreCase(category)) {
                assertEquals(afterAddAtt, beforeAdd);
            } else {
                assertEquals(afterAdd, beforeAdd);
            }
            count++;
        }
    }

    @Test
    public void execute_getPercentageRatingGui_successAfterUpdate() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        ReadOnlyAddressBook addressBook = model.getAddressBook();
        Summary summary = new Summary(addressBook);
        ObservableList<PieChart.Data> summaryRating = summary.getPercentageRatingsGui();

        String category = ContactBuilder.DEFAULT_RATING;
        model.addContact(new ContactBuilder().withName("Alice").build());


        ReadOnlyAddressBook addressBookAfterAdd = model.getAddressBook();
        Summary summaryAfterAdd = new Summary(addressBookAfterAdd);
        ObservableList<PieChart.Data> summaryRatingAfterAdd = summaryAfterAdd.getPercentageRatingsGui();

        assertEquals(summaryRating.size(), summaryRatingAfterAdd.size());

        int count = 0;
        for (PieChart.Data i : summaryRatingAfterAdd) {
            double afterAdd = summaryRatingAfterAdd.get(count).getPieValue();
            double beforeAdd = summaryRating.get(count).getPieValue();
            double afterAddAtt = afterAdd - 1;
            if (summaryRatingAfterAdd.get(count).getName().substring(0, 1).equalsIgnoreCase(category)) {
                assertEquals(afterAddAtt, beforeAdd);
            } else {
                assertEquals(afterAdd, beforeAdd);
            }
            count++;
        }
    }

    @Test
    public void equals() {
        assertEquals(new Summary(model.getAddressBook()), model.getSummary());
    }


}
