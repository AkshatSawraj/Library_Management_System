package sait.bms.problemdomain;

import sait.bms.managers.Book;

public class Cookbook extends Book {

	public Cookbook(long _ISBN, String _number, int _available, int _total, String _title, String _publisher,
			char _diet) {
		super(_ISBN, _number, _available, _total, _title, _publisher, _diet);
		// TODO Auto-generated constructor stub
	}
public String getActualDiet(char diet) {
		
		if(diet == 'D') {
			return "Diabetic";
		}else if(diet == 'V') {
			return "Vegetarian";
		}else if(diet == 'G') {
			return "Gluten-free";
		}else if(diet =='I') {
			return "International";
		}else{
			return "None";
		}
	}
	
	@Override
	public String toString() {
		return "\nISBN:           " + getISBN() +
				"\nCall Number:    " + getNumber() +
				"\nAvailable:      "+getAvailable() +
				"\nTotal:          "+getTotal()+
				"\nTitle:          "+getTitle() +
				"\nPublisher:      "+getPublisher()+
				"\nDiet:           "+getActualDiet(getDiet())+"\n\n";
		
		}

}



