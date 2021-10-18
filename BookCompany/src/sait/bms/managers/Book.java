package sait.bms.managers;

public class Book {
	long ISBN=0;
	String number="";
	int available=0;
	int total=0;
	String title="";
	String authors="";
	char format='x';
	String publisher="";
	char diet='x';
	int year=0;
	char genre='x';
	char frequency='x';

	/** Book - create an book setting all the attributes
     */
	public Book(long _ISBN, String _number, int _available, int _total, String _title, char _format, String _authors){
		//ISBN;Call number;Available;Total;Title;Authors;Format
		this.ISBN=_ISBN;
        this.number=_number;
        this.available=_available;
        this.total=_total;
        this.title=_title;
        this.authors=_authors;
        this.format=_format;
	}
	public Book(long _ISBN, String _number, int _available, int _total, String _title, String _publisher, char _diet){
		//ISBN;Call number;Available;Total;Title;Publisher;Diet
		this.ISBN=_ISBN;
        this.number=_number;
        this.available=_available;
        this.total=_total;
        this.title=_title;
        this.publisher=_publisher;
        this.diet=_diet;
        
	}
	public Book(long _ISBN, String _number, int _available, int _total, String _title, String _authors, int _year, char _genre){
//		ISBN;Call number;Available;Total;Title;Authors;Year;Genre
		this.ISBN=_ISBN;
        this.number=_number;
        this.available=_available;
        this.total=_total;
        this.title=_title;
        this.authors=_authors;
        this.year=_year;
        this.genre=_genre;
        
	}
	public Book(long _ISBN, String _number, int _available, int _total, String _title, char _frequency){
//		ISBN;Call number;Available;Total;Title;Frequency
		this.ISBN=_ISBN;
        this.number=_number;
        this.available=_available;
        this.total=_total;
        this.title=_title;
        this.frequency=_frequency;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", number=" + number + ", available=" + available + ", total=" + total
				+ ", title=" + title + ", authors=" + authors + ", format=" + format + ", publisher=" + publisher
				+ ", diet=" + diet + ", year=" + year + ", genre=" + genre + ", frequency=" + frequency + "]";
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public char getFormat() {
		return format;
	}
	public void setFormat(char format) {
		this.format = format;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public char getDiet() {
		return diet;
	}
	public void setDiet(char diet) {
		this.diet = diet;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public char getGenre() {
		return genre;
	}
	public void setGenre(char genre) {
		this.genre = genre;
	}
	public char getFrequency() {
		return frequency;
	}
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}
	
}
