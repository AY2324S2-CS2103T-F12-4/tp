package seedu.address.logic.parser.alias;

import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input with command aliases.
 */
public class AliasParser {

    /**
     * Parses user input into command for execution.
     *
     * @param commandWord command word
     * @param arguments   arguments
     * @return the command based on the user input, or null if the command word is
     *         not an alias
     * @throws ParseException if the arguments does not conform the expected format
     */
    public Command parseAlias(String commandWord, String arguments) throws ParseException {
        switch (commandWord) {

        case AddParticipantAlias.ALIAS_WORD:
            return new AddParticipantAlias().parse(arguments);

        case AddStaffAlias.ALIAS_WORD:
            return new AddStaffAlias().parse(arguments);

        case AddSponsorAlias.ALIAS_WORD:
            return new AddSponsorAlias().parse(arguments);

        case DeleteAlias.ALIAS_WORD:
            return new DeleteAlias().parse(arguments);

        case EditAlias.ALIAS_WORD:
            return new EditAlias().parse(arguments);

        case ExitAlias.ALIAS_WORD:
            return new ExitAlias().parse(arguments);

        case FindAlias.ALIAS_WORD:
            return new FindAlias().parse(arguments);

        case UndoAlias.ALIAS_WORD:
            return new UndoAlias().parse(arguments);

        case RedoAlias.ALIAS_WORD:
            return new RedoAlias().parse(arguments);

        default:
            return null;
        }
    }
}
