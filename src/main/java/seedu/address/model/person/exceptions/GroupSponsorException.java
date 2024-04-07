package seedu.address.model.person.exceptions;

/**
 * Signals that the operation is unable to find Group of a Sponsor.
 */
public class GroupSponsorException extends RuntimeException {
    public GroupSponsorException() {
        super("Sponsor doesn't have a group");
    }
}
