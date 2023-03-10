// create a class called Book
// single attribute - set and get method
// another class SearchBook which searches for a book using the search ID

class Book {
	String name;
	int id;
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
}
class SearchBook {
	Book books;
	void search_book(Book books) {
		this.books = books;
	}
	int searchID() {
		if(books.name == "ICUP") {
			return books.id;
		}
		return -1;
	}
}

class BookGood {
	public static void main(String args[]) {
		Book b1 = new Book();
		b1.setId(100);
		b1.setName("");
	}
}
