package flyweight;

final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  VideoObj(String title, int year, String director) {
     _title = title;
     _year = year;
     _director = director;
  }

  public String director() {
    // TODO
    return _director;
  }

  public String title() {
    // TODO
    return _title;
  }

  public int year() {
    // TODO
    return  _year;
  }

  public boolean equals(Object thatObject) {
    // TODO
	  VideoObj ans = (VideoObj) thatObject;

		if (ans._director.equals(this._director) && ans._title.equals(this._title) && ans._year == this._year)
			return true;

		else
			return false;
  }

  public int hashCode() {
    // TODO
	  int result = 17;
		result = 37 * result + _title.hashCode();
		result = 37 * result + _year;
		result = 37 * result + _director.hashCode();
		return result;
  }

  public int compareTo(Video that) {
    // TODO
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

  public String toString() {
    // TODO
	  StringBuilder ans = new StringBuilder();
		ans.append(this._title);
		ans.append(" (");
		ans.append(this._year);
		ans.append(") : ");
		ans.append(this._director);
		return ans.toString();
  }
}
