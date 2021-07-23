package shop.data;

// TODO: complete the methods
/**
 * Immutable Data Class for video objects. Comprises a triple: title, year,
 * director.
 *
 * @objecttype Immutable Data Class
 * @objectinvariant Title is non-null, no leading or final spaces, not empty
 *                  string.
 * @objectinvariant Year is greater than 1800, less than 5000.
 * @objectinvariant Director is non-null, no leading or final spaces, not empty
 *                  string.
 */
final class VideoObj implements Comparable<VideoObj>, Video {
	/** @invariant non-null, no leading or final spaces, not empty string */
	private final String _title;
	/** @invariant greater than 1800, less than 5000 */
	private final int _year;
	/** @invariant non-null, no leading or final spaces, not empty string */
	private final String _director;

	/**
	 * Initialize all object attributes. Title and director are "trimmed" to remove
	 * leading and final space.
	 * 
	 * @throws IllegalArgumentExcept"ion if any object invariant is violated.
	 */
	VideoObj(String title, int year, String director) {
		// TODO
		if ((title == null) || (year <= 1800) || (year >= 5000) || (director == null) || (director == " ")
				|| (director == "  ") || (title == "") || (title == " ")) {

			throw new IllegalArgumentException();
		}
		this._title = title.trim();
		this._director = director.trim();
		this._year = year;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String director() {
		// TODO
		return _director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String title() {
		// TODO
		return _title;
	}

	/**
	 * Return the value of the attribute.
	 */
	public int year() {
		// TODO
		return _year;
	}

	/**
	 * Compare the attributes of this object with those of thatObject.
	 * 
	 * @param thatObject the Object to be compared.
	 * @return deep equality test between this and thatObject.
	 */
	public boolean equals(Object thatObject) {

		VideoObj ans = (VideoObj) thatObject;

		if (ans._director.equals(this._director) && ans._title.equals(this._title) && ans._year == this._year)
			return true;

		else
			return false;

	}

	/**
	 * Return a hash code value for this object using the algorithm from Bloch:
	 * fields are added in the following order: title, year, director.
	 */
	public int hashCode() {

		int result = 17;
		result = 37 * result + _title.hashCode();
		result = 37 * result + _year;
		result = 37 * result + _director.hashCode();
		return result;
		// TODO
	}

	/**
	 * Compares the attributes of this object with those of thatObject, in the
	 * following order: title, year, director.
	 * 
	 * @param that the VideoObj to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than that object.
	 */
	public int compareTo(VideoObj that) {

		int titlediff = this._title.compareTo(that.title());
		if (titlediff < 0) {
			return -1;
		}

		int yeardiff = Integer.compare(this._year, that.year());
		if (yeardiff != 0) {
			if (yeardiff < 0)
				return -1;
			else
				return 1;
		}
		int directordiff = this._director.compareTo(that.director());
		if (directordiff != 0) {
			if (directordiff < 0)
				return -1;
			else
				return 1;
		}

		return 0;

	}

	/**
	 * Return a string representation of the object in the following format:
	 * <code>"title (year) : director"</code>.
	 */
	public String toString() {

		StringBuilder ans = new StringBuilder();
		ans.append(this._title);
		ans.append(" (");
		ans.append(this._year);
		ans.append(") : ");
		ans.append(this._director);

		// TODO
		return ans.toString();
	}
}