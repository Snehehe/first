public class Library {
    private String name;
    private String address;
    private Book[] books;

    /**
     * Represents a library with a name, address, and a collection of books.
     *
     * @param name    The name of the library, which must be between 9 and 20 characters.
     * @param address The address of the library, which must be between 10 and 25 characters.
     */
    public Library(String name, String address) {
        setName(name);
        setAddress(address);
        this.books = new Book[0];
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        if (name != null) {
            if (name.length() >= 9 && name.length() <= 20) {
                this.name = name;
            }
        }

    }

    public void setAddress(String address) {
        if (address != null) {
            if (address.length() >= 10 && address.length() <= 25) {
                this.address = address;
            }
        }

    }

    public Book[] getAvailableBooks() {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getStatus().equals("Available")) {
                count++;
            }
        }
        if (count != 0) {
            Book[] availableBooks = new Book[count];
            int index = 0;
            for (int i = 0; i < books.length; i++) {
                Book book = books[i];
                if (book.getStatus().equals("Available")) {
                    availableBooks[index++] = book;
                }
            }
            return availableBooks;
        } else {
            return null;
        }
    }

    public boolean addBook(Book book) {
        if (book != null && book.getStatus().equals("Available")) {
            if (!containsBook(book)) {
                int length = books.length;
                Book[] newBooks = new Book[length + 1];
                System.arraycopy(books, 0, newBooks, 0, length);
                newBooks[length] = book;
                books = newBooks;
                return true;
            }
        }
        return false;
    }

    private boolean containsBook(Book book) {
        for (int i = 0, booksLength = books.length; i < booksLength; i++) {
            Book b = books[i];
            if (b != null && b.equals(book)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeBook(Book book) {
        if (book != null && book.getStatus().equals("Archived")) {
            int indexToRemove = -1;
            for (int i = 0; i < books.length; i++) {
                if (books[i] != null && books[i].equals(book)) {
                    indexToRemove = i;
                    break;
                }
            }
            if (indexToRemove != -1) {
                int length = books.length;
                Book[] newBooks = new Book[length - 1];
                System.arraycopy(books, 0, newBooks, 0, indexToRemove);
                System.arraycopy(books, indexToRemove + 1, newBooks, indexToRemove, length - indexToRemove - 1);
                books = newBooks;
                return true;
            }
        }
        return false;
    }

    public boolean rentBook(int i, Reader reader) {
        if (i >= 0 && i < books.length && reader != null) {
            Book book = books[i];
            if (book.getStatus().equals("Available")) {
                if (book.rent(reader)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean returnBook(Book book, int rating) {
        if (book != null && book.getStatus().equals("Rented") && rating >= 0 && rating <= 5) {
            if (book.addRating(book.getLastReader(), rating)) {
                book.setStatus("Available");
                return true;
            }
        }
        return false;
    }

    public String toString() {
        int availableCount = 0;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getStatus().equals("Available")) {
                availableCount++;
            }
        }
        return name + " has " + availableCount + " books available";
    }

    public String displayBooks() {
        StringBuilder bookList = new StringBuilder("List of books:\n");
        for (int i = 0, booksLength = books.length; i < booksLength; i++) {
            Book book = books[i];
            bookList.append(book.toString()).append("\n");
        }
        return bookList.toString();
    }
}
