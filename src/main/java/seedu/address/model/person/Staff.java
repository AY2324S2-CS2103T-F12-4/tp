package seedu.address.model.person;

/**
 * Represents a staff in the hackathon.
 */
public class Staff extends Person {
    private Group group;
    /**
     * Constructs staff. Every field must be present and not null.
     */
    public Staff(Name name, Phone phone, Email email, Category category) {
        super(name, phone, email, category);
        this.group = new Group();
    }

    /**
     * Constructs staff with comment. Every field must be present and not null.
     */
    public Staff(Name name, Phone phone, Email email, Category category, Comment comment) {
        super(name, phone, email, category, comment);
        this.group = new Group();
    }

    /**
     * Sets the group number of the staff.
     */
    public void setGroupNumber(int groupNumber) {
        this.group = new Group(groupNumber);
    }

    /**
     * Returns the group number of the staff.
     */
    public int getGroupNumber() {
        return group.getGroupNumber();
    }
    @Override
    public boolean isSamePerson(Person other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Staff)) {
            return false;
        }

        return super.isSamePerson(other);
    }
}
