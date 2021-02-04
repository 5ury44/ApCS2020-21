import java.util.ArrayList;
import java.util.List;

public class LibraryTracker {
    private List<Book> borrowedBooks = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private String currDate = "00-00-0000";
    private final Integer[] months = new Integer[]{31,28,31,30,31,30,31,31,30,31,30,31};
    SearchSort searchSort= new SearchSort();
    private int returnSize(String current){
        String[] splitDate = current.split("-");
        int monthCount = 0; //100 400 year exception
        for(int j=0; j<Integer.parseInt(splitDate[2]);j++) {
            for (int i = 0; i < 12; i++) {
                if (i == 1 && j % 4 == 0 && (j % 100 != 0 || j % 400 == 0)) {
                    monthCount += 29; //get size of date
                    continue;
                }
                monthCount += months[i];
            }
        }
        for (int i = 0; i < Integer.parseInt(splitDate[0]); i++) {
            if (i == 1 && Integer.parseInt(splitDate[2]) % 4 == 0 && (Integer.parseInt(splitDate[2]) % 100 != 0 || Integer.parseInt(splitDate[2]) % 400 == 0)) {
                monthCount += 29;
                continue;
            }
            monthCount += months[i];
        }
        return monthCount;
    }
    private boolean isValid(String day, String year, String month){
        if((Integer.parseInt(day)<1||Integer.parseInt(day)>31)||(Integer.parseInt(month)<1||Integer.parseInt(month)>12)||(Integer.parseInt(year)<0)) return false;
        switch (Integer.parseInt(month)){ //check if date is valid based on leap years and month
            case 1,3,5,7,8,20,12: return true;
            case 4,6,9,11: return Integer.parseInt(day)<=30;
            case 2: if((Integer.parseInt(year)%4==0&&(Integer.parseInt(year)%100!=0||Integer.parseInt(year)%400==0)&&Integer.parseInt(day)<=29)||Integer.parseInt(day)<=28){return true;}
            default: return false;
        }
    }
    public void add(String Title, String Author){
        Book book = new Book(Title,Author,null,null);
        books.add(book); //add book
        searchSort.sort(books);
    }
    public void borrow(String date, String title, String name){
        if(returnSize(date)<returnSize(currDate)||!isValid(date.split("-")[1],date.split("-")[2],date.split("-")[0])){
            System.out.println("Invalid date or you went back in time.");
            return; //borrow book if valid
        }
        Book currBook;
        int ans = searchSort.binarySearch(books,title);
        if(ans!=-1){
            currBook = books.get(ans);
            books.remove(ans);
        }
        else{System.out.println("not found inside the library"); return;}
        currBook.date=date;
        currBook.name= name;//search book and name it currBook, set date and borrower if not borrowed
        currDate = date;
        borrowedBooks.add(currBook);
        searchSort.sort(borrowedBooks);//sort again
    }
    public void search(String title){
        //change to for loops so multiple detections possible -- email mr.geary
        int i= searchSort.binarySearch(books,title);
        int i1= searchSort.binarySearch(borrowedBooks,title); //find books in both borrowed and book list
        if(i==-1&&i1==-1) {System.out.println("not found inside the library");}
        else if(i1==-1){System.out.println("Book found available: "+books.get(i).title+", "+books.get(i).author);}
        else {System.out.println("Book found borrowed: "+borrowedBooks.get(i1).title+", "+borrowedBooks.get(i1).author);}
    }
    public void borrowedPrint(){for(Book book:borrowedBooks){System.out.println(book.title+", "+book.name+", "+book.date);}}
    public void searchAuthor(String Author){
        for(Book book:books){if(book.author.equals(Author)){System.out.println(book.title+" has been found.");}}
        System.out.println("End of search results."); //search based on author
    }
    public void late(String date){
        for(Book book: borrowedBooks){if(returnSize(date)+14<returnSize(book.date)){System.out.println(book.title+" from "+book.name+" is late over 2 weeks.");}}
        System.out.println("End of Overdue Search Results For Today's Date."); //search if late by adding 14 to entered date
    }
    public void total(){System.out.println(books.size()+" is the amount in library.");}
    public void returnBook(String title){
        int i = searchSort.binarySearch(borrowedBooks, title);
        if(i==-1){System.out.println("There was no book found borrowed with that title.");}
        else{
            Book book = borrowedBooks.get(i);
            borrowedBooks.remove(i);
            books.add(book); //add book back to book list
            searchSort.sort(books);//sort books
        }
    }
    public void delete(String title){
        int i = searchSort.binarySearch(books, title); //delete books
        if(i==-1){System.out.println("Book not currently in our library.");}
        else{books.remove(i);}
    }
}
