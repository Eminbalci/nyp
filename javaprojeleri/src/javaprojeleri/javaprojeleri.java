package javaprojeleri;

import java.util.*;

public class javaprojeleri {

	
	static class book
	{
		String name ;
		String author; 
		String price ;
		boolean childsafe; 
		public book(String bname, String bauthor, String bprice, boolean bchildsafe) {
		this.name = bname;
		this.author = bauthor;
		this.price = bprice;
		this.childsafe = bchildsafe;
		}
		public String toString() {
            return "Book [Name=" + name + ", Author=" + author + ", Price=" + price + ", Childsafe=" + childsafe + "]";
        }
	}
	static class classbook extends book
	{
		String lesson;
		String difficulity;
		public classbook(String bname, String bauthor, String bprice, boolean bchildsafe, String blesson, String bdifficulity) {
			super(bname, bauthor, bprice, bchildsafe);
		this.lesson = blesson;
		this.difficulity = bdifficulity;
		}
		public String toString() {
            return super.toString() + " [Lesson=" + lesson + ", Difficulity=" + difficulity + "]";
        }
	}
	static class recipiebook extends book
	{
		String type;
		public recipiebook(String bname, String bauthor, String bprice, boolean bchildsafe, String btype) {
			super(bname, bauthor, bprice, bchildsafe);
			this.type = btype;
		}
		public String toString() {
            return super.toString() + " [Type=" + type + "]";
        }
	}
	static class libr
	{
		ArrayList<book> lib = new ArrayList<book>(); 
		public void Add(book b) 
		{
			lib.add(b);
			System.out.println("'" + b.name + "' added to library.");
		}
		String away;
		public void list() {
			for (book i : lib) {
				System.out.println(i);
				System.out.println("-------------------------");
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		
		libr lib = new libr();
		Scanner input = new Scanner(System.in);
		while (true) {
		System.out.println("Select your process : List, Add");
		String process = input.nextLine();
		if (process.equalsIgnoreCase("List")) 
		{
			lib.list();
		}
		else if(process.equalsIgnoreCase("Add")) 
		{
			String splitter = "[,]";
			System.out.println("Write your book's name, author, price, childsafe(true/false),\n if classbook: lesson, difficulity if recipie book: type with ',' in between");
			String imported = input.nextLine();
		String[] array = imported.split(splitter);
		if(array.length == 4 ) {
			lib.Add(new book(array[0].trim(),array[1].trim(),array[2].trim(),Boolean.parseBoolean(array[3].trim())));
		}
		if(array.length == 6 ) {
			lib.Add(new classbook(array[0].trim(),array[1].trim(),array[2].trim(),Boolean.parseBoolean(array[3].trim()),array[4].trim(),array[5].trim()));
		}
		if(array.length == 5 ) {
			lib.Add(new recipiebook(array[0].trim(),array[1].trim(),array[2].trim(),Boolean.parseBoolean(array[3].trim()),array[4].trim()));
		}
		}
		}
	}

}
