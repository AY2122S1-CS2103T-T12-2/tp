package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an attraction's Review in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidReview(String)} (String)}
 */
public class Review {

    public static final String MESSAGE_CONSTRAINTS = "Reviews can take any value, use '-' to indicate an empty review";

    public static final String EMPTY_REVIEW = "- No Review -";

    public final String value;


    /**
     * Constructs an {@code Review}.
     *
     * @param review A valid review.
     */
    public Review(String review) {
        requireNonNull(review);
        checkArgument(isValidReview(review), MESSAGE_CONSTRAINTS);
        value = review;
    }

    /**
     * Returns true if a given string is a valid review (all valid for now)
     */
    public static boolean isValidReview(String test) {
        return true;
    }

    public boolean isEmptyReview() {
        return value.equals(EMPTY_REVIEW);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Review // instanceof handles nulls
                && value.equals(((Review) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
