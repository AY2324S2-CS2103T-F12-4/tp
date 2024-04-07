package seedu.address.model.person;

import seedu.address.commons.util.ToStringBuilder;

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
     * Sets the group of the staff.
     */
    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Returns the group of the staff.
     */
    @Override
    public Group getGroup() {
        return group;
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

    @Override
    public String toString() {
        return new ToStringBuilder(super.toString())
                .add("group", group)
                .toString();
    }

    @Override
    public String getInformation() {
        return super.getInformation()
                + "Group: " + group + "\n";
    }
}
