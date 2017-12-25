package impl.miw.business.bookmanager;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.BookManagerService;
import com.miw.model.Book;

public class BookManagerEJBService implements BookManagerService{

	@Autowired
	private BookManager bookManager;

	private Integer times=0;
	
	public void setTimes(Integer times) {
		System.out.println("setting times to "+times);
		this.times = times;
	}
	
	public void setBookManager(BookManager bm) {
		this.bookManager = bm;
	}

	@Override
	public Vector<Book> getBooks() throws Exception {
		for (int i = 0 ; i < times ; i++)
			System.out.println("Devolviendo la lista de libros desde el EJB Service");
		return bookManager.getBooks();
	}

	@Override
	public Book getSpecialOffer() throws Exception {
		for (int i = 0 ; i < times ; i++)
			System.out.println("Devolviendo la oferta de libros desde el EJB Service");
		return bookManager.getSpecialOffer();
	}
	
	public Book newBook(Book book ) throws Exception
	{
		return bookManager.newBook(book);
	}

	
}
