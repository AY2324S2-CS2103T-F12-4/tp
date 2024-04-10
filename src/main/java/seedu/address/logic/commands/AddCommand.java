package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GROUP;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.Optional;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.exceptions.UndoException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.Group;
import seedu.address.model.person.Sponsor;
import seedu.address.model.person.exceptions.GroupSponsorException;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command implements ReversibleCommand {

    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. \n"
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_CATEGORY + "CATEGORY "
            + "[" + PREFIX_GROUP + "GROUP]\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_CATEGORY + "participant "
            + PREFIX_GROUP + "3 ";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_SUCCESS_UNDO = "Person deleted: %1$s";
    public static final String MESSAGE_UNDO_NONEXISTENT_PERSON = "Undo failed:"
            + "Person does not exist in the address book";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";
    public static final String MESSAGE_GROUP_SPONSOR = "Sponsor doesn't have a group";

    private final Person toAdd;
    private final Optional<Group> group;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddCommand(Person person) {
        requireNonNull(person);
        toAdd = person;
        group = Optional.empty();
    }

    /**
     * Creates an AddCommand to add the specified {@code Person} with specified {@code group}
     */
    public AddCommand(Person person, Group group) {
        requireNonNull(person);
        toAdd = person;
        this.group = Optional.ofNullable(group);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        if (group.isPresent()) {
            try {
                toAdd.setGroup(group.get());
            } catch (GroupSponsorException e) {
                throw new CommandException(MESSAGE_GROUP_SPONSOR);
            }
        } else if (!(toAdd instanceof Sponsor)) {
            toAdd.setGroupNumber(0);
        }

        model.addPerson(toAdd);
        model.addCommand(this);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public CommandResult undo(Model model) throws UndoException {
        requireNonNull(model);

        if (!model.hasPerson(toAdd)) {
            throw new UndoException(MESSAGE_UNDO_NONEXISTENT_PERSON);
        }
        model.deletePerson(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS_UNDO, Messages.format(toAdd)));
    }

    @Override
    public CommandResult redo(Model model) throws UndoException, CommandException {
        model.addPerson(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddCommand)) {
            return false;
        }

        AddCommand otherAddCommand = (AddCommand) other;
        return toAdd.equals(otherAddCommand.toAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("toAdd", toAdd).toString();
    }
}
