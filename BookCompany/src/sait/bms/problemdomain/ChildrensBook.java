package sait.bms.problemdomain;

import sait.bms.managers.Book;

public class ChildrensBook extends Book{
	
	public ChildrensBook(long _ISBN, String _number, int _available, int _total, String _title,
			char _format, String _authors) {
		super(_ISBN, _number, _available, _total, _title, _format,_authors );
		// TODO Auto-generated constructor stub
	}

	public String getActualFormat(char _format) {
		
		if(_format== 'P') {
			return "Picture Book";
		}else if(_format== 'E') {
			return "Early Readers";
		}else {
			return "Chapter Book";
		}
	}
	@Override
	public String toString() {
		return 	"\nISBN:           " + getISBN() +"\n"+
				"Call Number:    " + getNumber() +"\n"+ 
				"Available:      "+getAvailable() +"\n"+ 
				"Total:          "+getTotal()+"\n"+
				"Title:          "+getTitle() +"\n"+ 
				"Authors:        "+getAuthors()+"\n"+ 
				"Format:         "+getActualFormat(getFormat())+"\n\n";
		
		}
}

