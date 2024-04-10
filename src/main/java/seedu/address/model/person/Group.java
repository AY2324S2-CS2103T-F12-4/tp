package seedu.address.model.person;

import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's group in the hackathon.
 */
public class Group {
    public static final String MESSAGE_CONSTRAINTS =
            "Group should be a positive integer.";
    private static int totalGroupNumber = 0;

    public final String value;
    private final int groupNumber;

    /**
     * Constructs a {@code Group} with group number 0.
     */
    public Group() {
        this.groupNumber = 0;
        this.value = String.valueOf(groupNumber);
    }

    /**
     * Constructs a {@code Group}.
     *
     * @param groupNumber a positive integer.
     */
    public Group(int groupNumber) {
        checkArgument(isValidGroup(groupNumber), MESSAGE_CONSTRAINTS);
        this.groupNumber = groupNumber;
        this.value = String.valueOf(groupNumber);
    }

    /**
     * Returns true if a given integer is a valid Group.
     */
    public static boolean isValidGroup(int test) {
        return test >= 0;
    }

    /**
     * Returns true if a given string is a valid Group.
     */
    public static boolean isValidGroup(String test) {
        if (test == null) {
            return false;
        }
        try {
            return Integer.parseInt(test) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Sets the last group number.
     */
    public static void setTotalGroupNumber(int lastNumber) {
        totalGroupNumber = lastNumber;
    }

    /**
     * Returns the last group number.
     */
    public static int getTotalGroupNumber() {
        return totalGroupNumber;
    }

    /**
     * Returns the group number.
     */
    public int getGroupNumber() {
        return groupNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(groupNumber);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Group)) {
            return false;
        }

        Group otherCategory = (Group) other;
        return groupNumber == otherCategory.groupNumber;
    }
}
