package seedu.address.testutil;

import seedu.address.model.person.Category;
import seedu.address.model.person.Comment;
import seedu.address.model.person.Email;
import seedu.address.model.person.Group;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonFactory;
import seedu.address.model.person.Phone;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_CATEGORY = "PARTICIPANT";
    public static final String DEFAULT_COMMENT = "No comment provided.";
    public static final int DEFAULT_GROUP = 2;

    private Name name;
    private Phone phone;
    private Email email;
    private Category category;
    private Comment comment;
    private Group group;


    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        category = new Category(DEFAULT_CATEGORY);
        comment = new Comment(DEFAULT_COMMENT);
        group = new Group(DEFAULT_GROUP);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        category = personToCopy.getCategory();
        comment = personToCopy.getComment();
        group = personToCopy.getGroup();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }


    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Category} of the {@code Category} that we are building.
     */
    public PersonBuilder withCategory(String category) {
        this.category = new Category(category);
        return this;
    }

    /**
     * Sets the {@code Comment} of the {@code Person} that we are building.
     */
    public PersonBuilder withComment(String comment) {
        this.comment = new Comment(comment);
        return this;
    }

    /**
     * Sets the {@code Group} of the {@code Person} that we are building.
     */
    public PersonBuilder withGroup(int groupNumber) {
        this.group = new Group(groupNumber);
        return this;
    }

    public Person build() {
        return PersonFactory.createPerson(name, phone, email, category, group, comment);
    }
}
