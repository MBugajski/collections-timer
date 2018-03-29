package com.MBugajski.timingCollections;


public class Book /*implements Comparable<Book>*/ {
	private String author;
	private String title;

	public Book(String author, String title) {
		super();
		this.author = author;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

//	@Override
//	public int compareTo(Book b) {
//		return Comparator.comparing(Book::getAuthor).compare(this, b);
//		return Comparator.comparing(Book::getTitle).compare(this, b);
//		return Comparator.comparing(Book::getTitle).thenComparing(Book::getAuthor).compare(this, b);
//		return Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle).compare(this, b);
//	}
	
	

}
