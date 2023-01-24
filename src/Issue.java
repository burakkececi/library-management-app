import java.time.LocalDate;
import java.util.Objects;
public class Issue {

    private String ID;
    private String memberId;
    private String bookId;
    private LocalDate issueDate;
    private LocalDate returningDate;

    public Issue(String ID, String member, String book, String issueDate, String returningDate) {
        this.ID = ID;
        this.memberId = member;
        this.bookId = book;

        String [] data1 = issueDate.split("-");
        String [] data2 = returningDate.split("-");
        int index1=1;
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (String month: months) {
            if (month.equals(data1[1])) break;
            index1++;
        }
        int index2=1;
        for (String month: months) {
            if (month.equals(data2[1])) break;
            index2++;
        }
        this.issueDate = LocalDate.of((2000 + Integer.parseInt(data1[2])), index1, Integer.parseInt(data1[0]) );
        this.returningDate = LocalDate.of((2000 + Integer.parseInt(data2[2])), index2, Integer.parseInt(data2[0]) );
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMember() {
        return memberId;
    }

    public void setMember(String member) {
        this.memberId = member;
    }

    public String getBook() {
        return bookId;
    }

    public void setBook(String book) {
        this.bookId = book;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(LocalDate returningDate) {
        this.returningDate = returningDate;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "ID='" + ID + '\'' +
                ", member=" + memberId +
                ", book=" + bookId +
                ", issueDate=" + issueDate +
                ", returningDate=" + returningDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return ID.equals(issue.ID) && memberId.equals(issue.memberId) && bookId.equals(issue.bookId) && issueDate.equals(issue.issueDate) && returningDate.equals(issue.returningDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, memberId, bookId, issueDate, returningDate);
    }
}
