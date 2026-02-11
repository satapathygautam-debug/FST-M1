// Abstract class Book
abstract class Book {
    // Instance variable
    String title;
    
    // Abstract method - must be implemented by subclasses
    abstract void setTitle(String s);
    
    // Concrete method - returns the title
    String getTitle() {
        return title;
    }
}
