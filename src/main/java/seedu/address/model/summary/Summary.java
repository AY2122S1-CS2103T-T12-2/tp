package seedu.address.model.summary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import seedu.address.model.AddressBook;
import seedu.address.model.person.CategoryCode;
import seedu.address.model.person.Person;


/**
 *  This class contains the logic of retrieving data from different components
 *  to display as a summary on application start up.
 */
public class Summary {
    private int numberOfContacts;
    private final HashMap<String, Integer> percentageRatings;
    private HashMap<String, Integer> percentageCategory;

    private List<Person> personList;

    /**
     * Constructor to create a summary of the addressBook.
     * @param addressBook addressBook to summarise.
     */
    public Summary(AddressBook addressBook) {
        this.personList = addressBook.getPersonList();
        numberOfContacts = setNumberOfContacts();
        percentageCategory = setNumberCategory();
        percentageRatings = setPercentageRatings();
    }

    /**
     * Sets the total number of contacts in the addressBook.
     * @return size of AddressBook.
     */
    private int setNumberOfContacts() {
        return personList.size();
    }

    /**
     * Sets the total number of Ratings in each category (0-5 stars).
     * @return HashMap of total number of contacts in each category.
     */
    private HashMap<String, Integer> setPercentageRatings() {
        HashMap<String, Integer> count = new HashMap<>();
        for (Person person : personList) {
            String rating = person.getRating().toString();
            if (count.containsKey(rating)) {
                int value = count.get(rating);
                int newValue = value + 1;
                count.replace(rating, newValue);
            } else {
                count.put(rating, 1);
            }
        }

        return count;
    }


    /**
     * Sets the total number of contacts in each category.
     * @return HashMap of total number of contacts in each category.
     */
    private HashMap<String, Integer> setNumberCategory() {
        List<String> categoryValues = CategoryCode.CATEGORY_VALUES;
        HashMap<String, Integer> count = new HashMap<>();
        

        for (String categoryValue : categoryValues) {
            count.put(categoryValue, 0);
        }

        for (Person person : personList) {
            String categoryString = person.getCategoryCode().toString().toLowerCase();
            int value = count.get(categoryString);
            int newValue = value + 1;
            count.replace(categoryString, newValue);
        }

        return count;
    }

    public int getNumberOfContacts() {
        return numberOfContacts;
    }

    public HashMap<String, Integer> getPercentageCategory() {
        return percentageCategory;
    }
    
    public HashMap<String, Integer> getPercentageRatings() {
        return percentageRatings;
    }

    //=========== GUI ==================================================================================

    public String getNumberOfContactsGUI() {
        String totalContacts = "Total Number of Contacts: ";
        return totalContacts + numberOfContacts;
    }

    public ObservableList<PieChart.Data> getPercentageCategoryGUI() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Map.Entry<String, Integer> entry : percentageCategory.entrySet()) {
            String key = entry.getKey().toUpperCase();
            Integer value = entry.getValue();
            pieChartData.add(new PieChart.Data(key, value));
        }
        return pieChartData;
    }

    public ObservableList<PieChart.Data> getPercentageRatingsGUI() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Map.Entry<String, Integer> entry : percentageRatings.entrySet()) {
            String key = entry.getKey() + "\u2B50";
            Integer value = entry.getValue();
            pieChartData.add(new PieChart.Data(key, value));
        }
        return pieChartData;
    }

}
