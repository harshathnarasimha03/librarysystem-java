import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    @Test
    void newBookIsAvailable() {
        Library book = new Library("Clean Code");
        assertFalse(book.isBorrowed());
        assertEquals("Available", book.status());
    }

    @Test
    void memberCanBorrowBook() {
        Library book = new Library("Clean Code");
        assertTrue(book.borrow("Harsha"));
        assertTrue(book.isBorrowed());
        assertEquals("Harsha", book.getMember());
    }

    @Test
    void cannotBorrowAlreadyBorrowedBook() {
        Library book = new Library("Clean Code");
        book.borrow("Harsha");
        assertFalse(book.borrow("Ravi"));
    }

    @Test
    void returnBookMakesItAvailable() {
        Library book = new Library("Clean Code");
        book.borrow("Harsha");
        assertTrue(book.returnBook());
        assertFalse(book.isBorrowed());
        assertEquals("Available", book.status());
    }

    @Test
    void calculatesFine() {
        Library book = new Library("Clean Code");
        assertEquals(6.0, book.calculateFine(3));
        assertEquals(16.0, book.calculateFine(7));
        assertEquals(35.0, book.calculateFine(12));
    }
}
