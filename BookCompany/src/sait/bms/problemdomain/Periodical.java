package sait.bms.problemdomain;

import sait.bms.managers.Book;

public class Periodical extends Book {

	public Periodical(long _ISBN, String _number, int _available, int _total, String _title, char _frequency) {
		super(_ISBN, _number, _available, _total, _title, _frequency);
		// TODO Auto-generated constructor stub
	}
	
	public String getActualFrequency(char _frequency) {
		
		if(_frequency== 'D') {
			return "Daily";
		}else if(_frequency == 'W') {
			return "Weekly";
		}else if(_frequency == 'M') {
			return "Monthly";
		}else if(_frequency =='B') {
			return "Bimonthly";
		}else {
			return "Quarterly";
		}
	} 
	
	@Override
	public String toString() {
		return "\nISBN:           " + getISBN() +
				"\nCall Number:    " + getNumber() +
				"\nAvailable:      "+getAvailable() +
				"\nTotal:          "+getTotal()+
				"\nTitle:          "+getTitle() +
				"\nFrequency:      "+getActualFrequency(getFrequency())+"\n\n";
		
		}
}
