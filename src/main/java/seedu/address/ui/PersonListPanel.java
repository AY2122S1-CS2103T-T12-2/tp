package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    private SelectedPersonCard selected = new SelectedPersonCard();

    @FXML
    private ListView<Person> personListView;

    @FXML
    private ScrollPane selectedPersonPanelPlaceholder;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML);
        setSelectedPersonPanel();
        selectedPersonPanelPlaceholder.setContent(selected.getRoot());
        updateDetailsIfChanged(personList);
        personListView.setItems(personList);
        personListView.setCellFactory(listView -> new PersonListViewCell());
        personListView.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Person selectedPerson = personListView.getSelectionModel().getSelectedItem();
                logger.info("selected " + selectedPerson);
                selectedPersonPanelPlaceholder.setVvalue(0.0);
                selected.updatePerson(selectedPerson);
                selected.setPersonDetails();
            }
        });
    }

    public void setSelectedPersonPanel() {
        selected.setPersonDetails();
    }

    private void updateDetailsIfChanged(ObservableList<Person> personList) {
        personList.addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        int indexToChange = change.getFrom();
                        Person updatedPerson = change.getList().get(indexToChange);
                        personListView.scrollTo(indexToChange);
                        personListView.getSelectionModel().select(indexToChange);
                        personListView.getFocusModel().focus(indexToChange);
                        selected.updatePerson(updatedPerson);
                    } else if (change.wasRemoved()) {
                        if (personList.size() > 0) {
                            personListView.scrollTo(0);
                            personListView.getSelectionModel().select(0);
                            personListView.getFocusModel().focus(0);
                        }
                        setSelectedPersonPanel();
                    }
                }
            }
        });
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {

        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(person, getIndex() + 1).getRoot());
            }
        }
    }

}
