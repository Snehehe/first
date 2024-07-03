public class Reader {
    private String fullName;
    private int yearOfBirth;
    private int zipCode;



    /**
     * Constructs a new `Reader` object with the specified full name, year of birth,
     * and zip code.
     *
     * @param fullName     The full name of the reader (between 3 and 20 characters).
     * @param yearOfBirth  The year of birth of the reader (between 1923 and 2013).
     * @param zipCode      The zip code of the reader (a 5-digit integer).
     */

    public Reader(String fullName, int yearOfBirth, int zipCode) {
        setFullName(fullName);
        setYearOfBirth(yearOfBirth);
        setZipCode(zipCode);
    }

    public String getFullName() {
        return fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setFullName(String fullName) {
        if (fullName != null){
            if( fullName.length() >= 3 ){
                if( fullName.length() <= 20) {
                    this.fullName = fullName;
                }
            }
        }
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth >= 1923 && yearOfBirth <= 2013) {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public void setZipCode(int zipCode) {
        if (String.valueOf(zipCode).length() == 5) {
            this.zipCode = zipCode;
        }
    }
}
