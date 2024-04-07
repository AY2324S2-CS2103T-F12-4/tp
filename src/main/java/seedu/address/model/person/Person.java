package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.exceptions.GroupSponsorException;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public abstract class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Category category;
    private final Comment comment;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Category category) {
        requireAllNonNull(name, phone, email, category);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.comment = new Comment();
    }
    /**
     * Constructs person with comment. Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Category category, Comment comment) {
        requireAllNonNull(name, phone, email, category);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.comment = comment;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Category getCategory() {
        return category;
    }

    public Comment getComment() {
        return comment;
    }

    public abstract Group getGroup();
    public abstract void setGroup(Group group) throws GroupSponsorException;
    public abstract int getGroupNumber();
    public abstract void setGroupNumber(int groupNumber) throws GroupSponsorException;


    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && category.equals(otherPerson.category);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("category", category)
                .add("comment", comment)
                .toString();
    }

    public String toCsvString() {
        return name + "," + phone + "," + email + "," + comment + "\n";
    }
    /**
     * Returns a string representation of the person's details for display.
     */
    public String getInformation() {
        return "Name: " + name + "\n"
                + "Phone: " + phone + "\n"
                + "Email: " + email + "\n"
                + "Category: " + category + "\n"
                + "Comment: " + comment + "\n";
    }
}
