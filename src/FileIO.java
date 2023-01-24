import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {

    private final Book[] books = new Book[20];
    private final Issue[][] issues = new Issue[3][30];
    private final Member[] members = new Member[5];

    public Book[] getBooks(String library){
        String name = "data/"+library+"_Books.csv";
        getData(name, 'B');

        Book[] booksCopy = new Book[books.length];
        int index = 0;
        for (Book book: books) {
            booksCopy[index] = book;
            index++;
        }
        return booksCopy;
    }

    public Issue[][] getIssues(){
        String name;

        name = "data/L1_Issues.csv";
        getData(name, '1');

        name = "data/L2_Issues.csv";
        getData(name, '2');

        name = "data/L3_Issues.csv";
        getData(name, '3');

        return issues;
    }

    public Member[] getMembers(){
        getData("data/Members.csv", 'M');
        return members;
    }

    private void getData(String fileName, char type){

        try {
            Scanner file = new Scanner(new File(fileName));
            String[] data;
            int index = 0;
            while(file.hasNextLine()){
                String line = file.nextLine();
                data = line.split(",");
                if(type == 'B'){
                    Book book = new Book(data[0], data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]));
                    books[index] = book;
                }else if(type == '1'){
                    Issue issue = new Issue(data[0], data[1], data[2], data[3], data[4]);
                    issues[0][index] = issue;
                }else if(type == '2'){
                    Issue issue = new Issue(data[0], data[1], data[2], data[3], data[4]);
                    issues[1][index] = issue;
                }else if(type == '3'){
                    Issue issue = new Issue(data[0], data[1], data[2], data[3], data[4]);
                    issues[2][index] = issue;
                }else if(type == 'M'){
                    Member member = new Member(data[0], data[1], data[2]);
                    members[index] = member;
                }
                index++;
            }
            file.close();
        }catch (FileNotFoundException e){
            System.out.println("File Not Found!");
            System.exit(0);
        }catch (NumberFormatException e){
            System.out.println("Given number is not valid!");
            System.exit(0);
        }
    }

    public static void main(String[] args){
       /* Book[] book = getBooks("L1");
        for (Book mbr: books) {
            System.out.println(mbr.getAuthor());
        }*/
    }
}
