package seedu.address.model.person;

import seedu.address.model.person.exceptions.GroupSponsorException;

/**
 * Represents a sponsor in the hackathon.
 */
public class Sponsor extends Person {
    /**
     * Constructs a sponsor. Every field must be present and not null.
     */
    public Sponsor(Name name, Phone phone, Email email, Category category) {
        super(name, phone, email, category);
    }

    /**
     * Constructs a sponsor with comment. Every field must be present and not null.
     */
    public Sponsor(Name name, Phone phone, Email email, Category category, Comment comment) {
        super(name, phone, email, category, comment);
    }

    /**
     * Throws GroupSponsorException.
     */
    @Override
    public void setGroup(Group group) {
        throw new GroupSponsorException();
    }

    /**
     * Returns null.
     */
    @Override
    public Group getGroup() {
        return null;
    }

    /**
     * Throws GroupSponsorException.
     */
    public void setGroupNumber(int groupNumber) {
        throw new GroupSponsorException();
    }

    /**
     * Returns -1.
     */
    public int getGroupNumber() {
        return -1;
    }

    @Override
    public boolean isSamePerson(Person other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Sponsor)) {
            return false;
        }
        return super.isSamePerson(other);
    }
}
