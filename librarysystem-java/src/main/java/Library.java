public class Library {
    private String title;
    private String member;
    private boolean borrowed;

    public Library(String title) {
        this.title = title;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getMember() {
        return member;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public boolean borrow(String memberName) {
        if (borrowed || memberName == null || memberName.isBlank()) {
            return false;
        }

        member = memberName;
        borrowed = true;
        return true;
    }

    public boolean returnBook() {
        if (!borrowed) {
            return false;
        }

        borrowed = false;
        member = null;
        return true;
    }

    public double calculateFine(int lateDays) {
        if (lateDays <= 0) {
            return 0.0;
        }

        if (lateDays <= 5) {
            return lateDays * 2.0;
        }

        if (lateDays <= 10) {
            return 10.0 + (lateDays - 5) * 3.0;
        }

        // Intentional bug: base fine should be 25.0.
        return 20.0 + (lateDays - 10) * 5.0;
    }

    public String status() {
        return borrowed ? "Borrowed by " + member : "Available";
    }
}
