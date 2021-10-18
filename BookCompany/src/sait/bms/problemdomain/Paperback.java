package sait.bms.problemdomain;

import sait.bms.managers.Book;

public class Paperback extends Book {

	public Paperback(long _ISBN, String _number, int _available, int _total, String _title, String _authors, int _year,
			char _genre) {
		super(_ISBN, _number, _available, _total, _title, _authors, _year, _genre);
		// TODO Auto-generated constructor stub
		}
	
	public String getActualGenre(char _genre) {
			
			if(_genre == 'A') {
				return "Adventure";
			}else if(_genre == 'D') {
				return "Drama";
			}else if(_genre == 'E') {
				return "Education";
			}else if(_genre =='C') {
				return "Classic";
			}else if(_genre =='F') {
				return "Fantasy";
			}else{
				return "Science Fiction";
			}
		}
	@Override
	public String toString() {
		return "\nISBN:           " + getISBN() +
				"\nCall Number:    " + getNumber() +
				"\nAvailable:      "+getAvailable() +
				"\nTotal:          "+getTotal()+
				"\nTitle:          "+getTitle() +
				"\nAuthors:        "+getAuthors()+
				"\nYear:           "+getYear()+
				"\nGenre:          "+getActualGenre(getGenre())+"\n\n";
		
		}
}
