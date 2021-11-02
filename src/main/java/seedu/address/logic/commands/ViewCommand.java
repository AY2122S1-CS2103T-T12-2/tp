package seedu.address.logic.commands;

/**
 * Displays details of a person identified using it's displayed index or name on the side panel.
 */
public abstract class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Views details of the contact identified by the index number or name "
            + "used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer)\n or NAME (must be full name)"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_VIEW_PERSON_SUCCESS = "Displayed contact: %1$s";

    public ViewCommand() {
    }

    @Override
    public boolean equals(Object other) {
        return other == this; // short circuit if same object
    }
}
