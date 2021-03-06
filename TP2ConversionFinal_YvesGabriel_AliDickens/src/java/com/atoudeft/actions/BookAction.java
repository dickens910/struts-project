package com.atoudeft.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.atoudeft.dao.LivreDAO;
import com.atoudeft.entites.Book;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private List<Book> bookList ;//= LivreDAO.getBookList();
	private Book livre ;//= new Book();
	private List<String> commentaires;
	private String unCommentaire;
	  
	@Override
	public void setSession(Map<String, Object> s) {
		// TODO Auto-generated method stub
		session = s;
	}

	public String list()
	{
     //   if (!session.containsKey("connecte"))
     //   	return INPUT;

		bookList = LivreDAO.getBookList();
		return SUCCESS;
	}
	public String add()
	{
		if (livre!=null)
		{
			if (livre.getIsbn().trim().equals(""))
			{
				this.addFieldError("livre.isbn", "L'ISBN est obligatoire");
				return SUCCESS;
			}
			if (LivreDAO.addBook(livre))
			{
				this.addActionMessage("Livre ajoute avec succes.");
			}
			else
			{
				this.addActionMessage("L'ISBN existe deja.");
			}
		}
		return SUCCESS;
	}
	public String comment()
	{
		if (unCommentaire != null)
		{
			LivreDAO.addComment(livre.getIsbn(), unCommentaire);
		}
		livre = LivreDAO.getBook(livre.getIsbn());
		commentaires = LivreDAO.getComments(livre.getIsbn());
		return SUCCESS;
	}

    
    public void validate()
    {
        if (!session.containsKey("connecte"))
    		this.addActionError("Vous devez vous connecter pour accéder aux infos sur les livres");
    }

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Book getLivre() {
		return livre;
	}

	public void setLivre(Book livre) {
		this.livre = livre;
	}

	public List<String> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<String> commentaires) {
		this.commentaires = commentaires;
	}

	public String getUnCommentaire() {
		return unCommentaire;
	}

	public void setUnCommentaire(String unCommentaire) {
		this.unCommentaire = unCommentaire;
	}	
	
}
