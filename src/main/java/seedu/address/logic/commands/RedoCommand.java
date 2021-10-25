package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;

/**
 * Redoes the last change undone by the undo command.
 */
public class RedoCommand extends Command {
    public static final String COMMAND_WORD = "redo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Redoes the last change undid.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_REDO_SUCCESS = "Previous changes restored.";

    @Override
    public CommandResult execute(Model model) {
        if (model.isRedoable()) {
            model.redo();
            return new CommandResult(MESSAGE_REDO_SUCCESS);
        } else {
            return new CommandResult(Messages.MESSAGE_INVALID_REDO_STATE);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RedoCommand);
    }

}
