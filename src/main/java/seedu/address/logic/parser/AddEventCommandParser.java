package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENTCATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENTDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENTNAME;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventCategory;
import seedu.address.model.event.EventDate;
import seedu.address.model.event.EventFactory;
import seedu.address.model.event.EventName;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddEventCommandParser implements EventParser<AddEventCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddEventCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_EVENTNAME,
                        PREFIX_EVENTDATE, PREFIX_EVENTCATEGORY);

        if (!arePrefixesPresent(argMultimap, PREFIX_EVENTNAME, PREFIX_EVENTDATE, PREFIX_EVENTCATEGORY)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddEventCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_EVENTNAME, PREFIX_EVENTDATE, PREFIX_EVENTCATEGORY);
        EventName name = EventParserUtil.parseEventName(argMultimap.getValue(PREFIX_EVENTNAME).get());
        EventDate date = EventParserUtil.parseEventDate(argMultimap.getValue(PREFIX_EVENTDATE).get());
        EventCategory category = EventParserUtil.parseEventCategory(argMultimap.getValue(PREFIX_EVENTCATEGORY).get());

        Event event = EventFactory.createEvent(name, date, category);

        return new AddEventCommand(event);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
