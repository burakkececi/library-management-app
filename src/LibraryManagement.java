public class LibraryManagement {

    private Issue[][] issues;

    public LibraryManagement() {
    }

    public LibraryManagement(Issue[][] issues) {
        this.issues = issues;
    }

    public Issue[][] getIssues() {
        return issues;
    }

    public void setIssues(Issue[][] issues) {
        this.issues = issues;
    }
}
