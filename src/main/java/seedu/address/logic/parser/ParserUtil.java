package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.GroupCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.EventCategory;
import seedu.address.model.event.EventDate;
import seedu.address.model.event.EventName;
import seedu.address.model.person.Category;
import seedu.address.model.person.Email;
import seedu.address.model.person.Group;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String category} into a {@code Category}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code category} is invalid.
     */
    public static Category parseCategory(String category) throws ParseException {
        requireNonNull(category);
        String trimmedCategory = category.trim().toUpperCase();
        if (!Category.isValidCategory(trimmedCategory)) {
            throw new ParseException(Category.MESSAGE_CONSTRAINTS);
        }
        return new Category(trimmedCategory);
    }


    /**
     * Parses a string representation of an event name into an EventName object.
     *
     * @param eventname A string representing the name to be parsed.
     * @return The parsed EventName object.
     * @throws ParseException If the given name string is invalid or cannot be parsed.
     *                        The error message will contain details about the parsing constraints.
     * @throws NullPointerException If the input name string is null.
     */
    public static EventName parseEventName(String eventname) throws ParseException {
        requireNonNull(eventname);
        String trimmedName = eventname.trim();
        if (!EventName.isValidName(trimmedName)) {
            throw new ParseException(EventName.MESSAGE_CONSTRAINTS);
        }
        return new EventName(trimmedName);
    }


    /**
     * Parses a string representation of an event date into an EventDate object.
     *
     * @param date A string representing the date to be parsed.
     * @return The parsed EventDate object.
     * @throws ParseException If the given date string is invalid or cannot be parsed.
     *                        The error message will contain details about the parsing constraints.
     * @throws NullPointerException If the input date string is null.
     */
    public static EventDate parseEventDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDate = date.trim();
        if (!EventDate.isValidDate(trimmedDate)) {
            throw new ParseException(EventDate.MESSAGE_CONSTRAINTS);
        }
        return new EventDate((trimmedDate));
    }

    /**
     * Parses a string representation of an event category into an EventCategory object.
     *
     * @param eventcategory A string representing the category to be parsed.
     * @return The parsed EventCategory object.
     * @throws ParseException If the given category string is invalid or cannot be parsed.
     *                        The error message will contain details about the parsing constraints.
     * @throws NullPointerException If the input category string is null.
     */
    public static EventCategory parseEventCategory(String eventcategory) throws ParseException {
        requireNonNull(eventcategory);
        String trimmedCategory = eventcategory.trim().toUpperCase();
        if (!Category.isValidCategory(trimmedCategory)) {
            throw new ParseException(Category.MESSAGE_CONSTRAINTS);
        }
        return new EventCategory(trimmedCategory);
    }
    /**
     * Parses a {@code String group} into a {@code Group}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code group} is invalid.
     */
    public static Group parseGroup(String group) throws ParseException {
        if (group == null) {
            return null;
        }

        String trimmedGroup = group.trim();
        int groupNumber;

        try {
            groupNumber = Integer.parseInt(trimmedGroup);
        } catch (NumberFormatException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, GroupCommand.MESSAGE_USAGE));
        }

        if (!Group.isValidGroup(groupNumber)) {
            throw new ParseException(Group.MESSAGE_CONSTRAINTS);
        }

        return new Group(groupNumber);

    }

}
