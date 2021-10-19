package seedu.address.ui;


import java.util.Comparator;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class SelectedPersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";
    private final Logger logger = LogsCenter.getLogger(SelectedPersonCard.class);

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    private Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label category;
    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label review;
    @FXML
    private FlowPane tags;
    @FXML
    private Label rating;

    /**
     * Creates an empty {@code PersonCode}.
     */
    public SelectedPersonCard() {
        super(FXML);
        this.person = null;
    }

    /**
     * Sets the person of Selected Person with the given {@code Person}.
     */
    public void updatePerson(Person person) {
        this.person = person;
        logger.info("Updated SelectedPersonCard");
        //setPersonDetails();
    }


    /**
     * Sets the details of Selected Person with the given {@code Person}.
     */
    public void setPersonDetails() {
        if (person == null) {
            setEmptyPersonDetails();
        } else {
            category.setText(person.getCategoryCode().toString());
            name.setText(person.getName().fullName);
            phone.setText(person.getPhone().value);
            address.setText(person.getAddress().value);
            review.setText(person.getReview().value);
            email.setText(person.getEmail().value);
            tags.getChildren().clear();
            person.getTags().stream()
                    .sorted(Comparator.comparing(tag -> tag.tagName))
                    .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
            rating.setText(person.getRating().value + "\u2B50");
            logger.info("Person details set " + person);
        }
    }

    /**
     * Sets the empty Selected Person details.
     */
    public void setEmptyPersonDetails() {
        category.setText("NIL");
        name.setText("NIL");
        phone.setText("NIL");
        address.setText("NIL");
        review.setText("NIL");
        email.setText("NIL");
        tags.getChildren().clear();
        rating.setText("NIL" + "\u2B50");
        logger.info("Empty person set");
    }

    /**
     * Returns the selected person.
     */
    public Person getPerson() {
        return person;
    }
}
