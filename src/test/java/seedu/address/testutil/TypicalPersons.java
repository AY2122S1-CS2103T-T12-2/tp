package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_CODE_ATT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_CODE_OTH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REVIEW_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REVIEW_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withCategoryCode("att").withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253").withReview("great")
            .withTags("friends").withRating("3").build();
    public static final Person BENSON = new PersonBuilder().withCategoryCode("oth").withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends").withReview("amazing").withRating("4").build();
    public static final Person CARL = new PersonBuilder().withCategoryCode("acc").withName("Carl Kurz")
            .withPhone("95352563").withEmail("heinz@example.com").withAddress("wall street")
            .withReview("bad").withRating("2").build();
    public static final Person DANIEL = new PersonBuilder().withCategoryCode("tpt").withName("Daniel Meier")
            .withPhone("87652533").withEmail("cornelia@example.com").withAddress("10th street")
            .withReview("great").withTags("friends").withRating("5").build();
    public static final Person ELLE = new PersonBuilder().withCategoryCode("att").withName("Elle Meyer")
            .withReview("great").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").withRating("4").build();
    public static final Person FIONA = new PersonBuilder().withCategoryCode("com").withName("Fiona Kunz")
            .withReview("great").withPhone("9482427").withEmail("lydia@example.com")
            .withAddress("little tokyo").withRating("3")
            .build();
    public static final Person GEORGE = new PersonBuilder().withCategoryCode("fnb").withName("George Best")
            .withPhone("9482442").withEmail("anna@example.com").withAddress("4th street").withReview("great")
            .withRating("2").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withCategoryCode("att").withName("Hoon Meier")
            .withPhone("8482424").withEmail("stefan@example.com").withAddress("little india").withReview("great")
            .withRating("4").build();
    public static final Person IDA = new PersonBuilder().withCategoryCode("oth").withName("Ida Mueller")
            .withPhone("8482131").withEmail("hans@example.com").withAddress("chicago ave").withReview("bad")
            .withRating("2").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withCategoryCode(VALID_CATEGORY_CODE_ATT)
            .withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY)
            .withAddress(VALID_ADDRESS_AMY).withReview(VALID_REVIEW_AMY).withTags(VALID_TAG_FRIEND).withRating("5")
            .build();
    public static final Person BOB = new PersonBuilder().withCategoryCode(VALID_CATEGORY_CODE_OTH)
            .withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
            .withAddress(VALID_ADDRESS_BOB).withReview(VALID_REVIEW_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .withRating("5")
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static AddressBook getRandomTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getRandomTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    public static List<Person> getRandomTypicalPersons() {
        return new ArrayList<>(Arrays.asList(CARL, DANIEL, GEORGE, BENSON, ELLE, ALICE, FIONA));
    }
}
