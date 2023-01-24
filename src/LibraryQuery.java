import java.time.Period;

public class LibraryQuery {

    public String getMostIssuedBook(LibraryManagement libraryManagement) {

        Issue[][] issues = libraryManagement.getIssues();

        int max = 0;
        String mostIssuedBook = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 30; j++) {
                if (issues[i][j] == null) break;
                String tmp = issues[i][j].getBook();
                int count = 0;
                for (int k = 0; k < 30; k++) {
                    if (issues[i][k] == null) break;
                    if (tmp.equals(issues[i][k].getBook())) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    mostIssuedBook = issues[i][j].getBook();
                }
            }
        }
        return mostIssuedBook;
    }

    public String getMemberMostIssuedBook(LibraryManagement libraryManagement) {

        Issue[][] issues = libraryManagement.getIssues();

        int max = 0;
        String memberMostIssued = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 30; j++) {
                if (issues[i][j] == null) break;
                String tmp = issues[i][j].getMember();
                int count = 0;
                for (int k = 0; k < 30; k++) {
                    if (issues[i][k] == null) break;
                    if (tmp.equals(issues[i][k].getMember())) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    memberMostIssued = issues[i][j].getMember();
                }
            }
        }
        return memberMostIssued;
    }

    public double getHighestPenalty(LibraryManagement libraryManagement) {

        Issue[][] issues = libraryManagement.getIssues();

        double max = 0, highestPenalty = 0, days;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 30; j++) {
                if (issues[i][j] == null) break;
               Period period = Period.between(issues[i][j].getIssueDate(),issues[i][j].getReturningDate());
               days = period.getDays() + (period.getMonths() * 30) + (period.getYears() * 365);
                if (days > max) {
                    max = days;
                    highestPenalty = days * 0.5;
                }
            }
        }
        return highestPenalty;
    }

    public String getMostCopies(Library... libraries) {
        Book book = null;
        int max = 0;
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            for (Book value : books) {
                if (max < value.getQuantity()) {
                    max = value.getQuantity();
                    book = value;
                }
            }
        }
        return book != null ? book.getTitle() : "No value";
    }

    public String getFewestCopiesIssuedBefore(LibraryManagement libraryManagement, Library... libraries) {
        Issue[][] issues = libraryManagement.getIssues();

        Book book = null;
        int min = 999;

        for (Library library : libraries) {
            Book[] books = library.getBooks();
            for (Book value : books) {
                if (min > value.getQuantity()) {
                    min = value.getQuantity();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 30; j++) {
                            if (issues[i][j] == null) break;
                            if (value.getID().equals(issues[i][j].getBook())) {
                                book = value;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return book != null ? book.getTitle() : "No value";
    }

    public String getMemberIssuedLeastBookCS(LibraryManagement libraryManagement){
        Issue[][] issues = libraryManagement.getIssues();

        int min = 999;
        int count = 0;
        String member = null;
        for (int k = 0; k < issues[2].length; k++) {
            if (issues[2][k] == null) break;
            for(int i=0; i< issues[2].length; i++){
                if (issues[2][i] == null) break;
                if(issues[2][k].getMember().equals(issues[2][i].getMember())){
                    count++;
                }
            }if(min > count) {
                min = count;
                member = issues[2][k].getMember();
            }

        }
        return member;
    }
}