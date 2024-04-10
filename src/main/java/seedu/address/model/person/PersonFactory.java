package seedu.address.model.person;


/**
 * Factory class for creating Person objects.
 */
public class PersonFactory {
    /**
     * Creates a Person based on the category.
     */
    public static Person createPerson(Name name, Phone phone, Email email, Category category) {
        switch (category.value) {
        case "PARTICIPANT":
            return new Participant(name, phone, email, category);
        case "STAFF":
            return new Staff(name, phone, email, category);
        case "SPONSOR":
            return new Sponsor(name, phone, email, category);
        default: // cannot happen due to category validation
            throw new IllegalArgumentException("Invalid category");
        }
    }
    /**
     * Creates a Person based on the category and comment.
     */
    public static Person createPerson(Name name, Phone phone, Email email, Category category, Comment comment) {
        switch (category.value) {
        case "PARTICIPANT":
            return new Participant(name, phone, email, category, comment);
        case "STAFF":
            return new Staff(name, phone, email, category, comment);
        case "SPONSOR":
            return new Sponsor(name, phone, email, category, comment);
        default: // cannot happen due to category validation
            throw new IllegalArgumentException("Invalid category");
        }
    }
    /**
     * Creates a Person based on the category, group, and comment.
     */
    public static Person createPerson(Name name, Phone phone, Email email, Category category, Group group,
                                      Comment comment) {
        if (group == null) {
            return createPerson(name, phone, email,category,comment);
        }

        if (category.value.equals("SPONSOR")) {
            throw new IllegalArgumentException("Sponsor doesn't have a group");
        }

        Person person = createPerson(name, phone, email,category,comment);
        person.setGroup(group);
        return person;
    }
}
