package impl.miw.presentation.newBook;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.BookManagerService;
import com.miw.model.Book;

@Controller
@RequestMapping("private/newBook")
public class NewBookController {
	@Autowired 
	BookManagerService bookManagerService;
	
	
	public BookManagerService getBookManagerService() {
		return bookManagerService;
	}


	public void setBookManagerService(BookManagerService bookManagerService) {
		this.bookManagerService = bookManagerService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void get()
	{
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String newBook(@Valid @ModelAttribute Book book, BindingResult result )
	{
		if ( result.hasErrors())
		{
			return "private/newBook";
		}
		//forzamos la familia a 0
		book.setFamily(0);
		try {
			this.bookManagerService.newBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:seekBooks";
	}
	
	@ModelAttribute
	Book getBook()
	{
		return new Book();
	}
}
