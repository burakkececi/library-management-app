public class LibraryManagementApp {

    public static void main(String[] args){

        FileIO fileIO = new FileIO();

        Library L1 = new Library(fileIO.getBooks("L1"));
        Library L2 = new Library(fileIO.getBooks("L2"));
        Library L3 = new Library(fileIO.getBooks("L3"));

        LibraryManagement libraryManagement = new LibraryManagement(fileIO.getIssues());

        LibraryQuery libraryQuery = new LibraryQuery();

        System.out.println(libraryQuery.getMostIssuedBook(libraryManagement));
        System.out.println(libraryQuery.getMemberMostIssuedBook(libraryManagement));
        System.out.println(libraryQuery.getHighestPenalty(libraryManagement));
        System.out.println(libraryQuery.getMostCopies(L1,L2,L3));
        System.out.println(libraryQuery.getFewestCopiesIssuedBefore(libraryManagement, L1,L2,L3));
        System.out.println(libraryQuery.getMemberIssuedLeastBookCS(libraryManagement));

    }
}
