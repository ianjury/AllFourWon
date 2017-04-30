package tests;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import model.Author;
import model.Conference;
import model.Paper;
import model.Reviewer;

public class ConferenceTests {
	
	/**
	 * A test for the conference constructor.
	 * @author Zachary Chandler
	 */
	@Test
	public void testConferenceConstrutor() {
		Conference emptyConference = new Conference();

		assertTrue(emptyConference.getDeadline() == null);
		assertTrue(emptyConference.getReviewers().size() == 0);
	}

	/**
	 * A test for submitting a paper with only one Author.
     * @author Zachary Chandler
	 */
	@Test
	public void testPaperSubmissionOneAuthor() {
		Conference simpleConference = new Conference();
		simpleConference.setDeadline(new Date(new Date().getTime() + 5000));
		simpleConference.addAuthor("zachac");

		Author zach = simpleConference.getAuthor("zachac");
		
		List<Author> authors = new LinkedList<Author>();
		authors.add(zach);
		
		Paper justZach1 = new Paper(null, authors, "Just Zach's Paper");
		assertTrue(simpleConference.submitPaper(justZach1));
		assertTrue(simpleConference.getPapers(zach).size() == 1);

		Paper justZach2 = new Paper(null, authors, "Just Zach's Paper");
		assertTrue(simpleConference.submitPaper(justZach2));
		assertTrue(simpleConference.getPapers(zach).size() == 2);

		Paper justZach3 = new Paper(null, authors, "Just Zach's Paper");
		assertTrue(simpleConference.submitPaper(justZach3));
		assertTrue(simpleConference.getPapers(zach).size() == 3);

		Paper justZach4 = new Paper(null, authors, "Just Zach's Paper");
		assertTrue(simpleConference.submitPaper(justZach4));
		assertTrue(simpleConference.getPapers(zach).size() == 4);

		Paper justZach5 = new Paper(null, authors, "Just Zach's Paper");
		assertTrue(simpleConference.submitPaper(justZach5));
		assertTrue(simpleConference.getPapers(zach).size() == 5);
		
		Paper justZach6 = new Paper(null, authors, "Just Zach's Paper");
		assertFalse(simpleConference.submitPaper(justZach6));
		assertTrue(simpleConference.getPapers(zach).size() == 5);
	}
	
	/**
	 * A test for submitting a paper with more than one Author.
     * @author Zachary Chandler
	 */
	@Test
	public void testPaperSubmissionMoreThanOneAuthor() {
		Conference simpleConference = new Conference();
		simpleConference.setDeadline(new Date(new Date().getTime() + 5000));
		simpleConference.addAuthor("zachac");
		simpleConference.addAuthor("dimabliz");
		simpleConference.addAuthor("ianjury");
		simpleConference.addAuthor("briang5");
		simpleConference.addAuthor("kvn96");

		Author zach = simpleConference.getAuthor("zachac");
		Author dimtriy = simpleConference.getAuthor("dimabliz");
		Author ian = simpleConference.getAuthor("ianjury");
		Author brian = simpleConference.getAuthor("briang5");
		Author kevin = simpleConference.getAuthor("kvn96");
		
		List<Author> authors = new LinkedList<Author>();
		authors.add(zach);
		authors.add(dimtriy);
		authors.add(ian);
		authors.add(brian);
		authors.add(kevin);

		Paper fiveAuthors1 = new Paper(null, authors, "Just a Paper");
		assertTrue(simpleConference.submitPaper(fiveAuthors1));
		assertTrue(simpleConference.getPapers(zach).size() 		== 1);
		assertTrue(simpleConference.getPapers(dimtriy).size() 	== 1);
		assertTrue(simpleConference.getPapers(ian).size() 		== 1);
		assertTrue(simpleConference.getPapers(brian).size()		== 1);
		assertTrue(simpleConference.getPapers(kevin).size() 	== 1);

		Paper fiveAuthors2 = new Paper(null, authors, "Just a Paper");
		assertTrue(simpleConference.submitPaper(fiveAuthors2));
		assertTrue(simpleConference.getPapers(zach).size() 		== 2);
		assertTrue(simpleConference.getPapers(dimtriy).size() 	== 2);
		assertTrue(simpleConference.getPapers(ian).size() 		== 2);
		assertTrue(simpleConference.getPapers(brian).size()		== 2);
		assertTrue(simpleConference.getPapers(kevin).size() 	== 2);

		Paper fiveAuthors3 = new Paper(null, authors, "Just a Paper");
		assertTrue(simpleConference.submitPaper(fiveAuthors3));
		assertTrue(simpleConference.getPapers(zach).size() 		== 3);
		assertTrue(simpleConference.getPapers(dimtriy).size() 	== 3);
		assertTrue(simpleConference.getPapers(ian).size() 		== 3);
		assertTrue(simpleConference.getPapers(brian).size()		== 3);
		assertTrue(simpleConference.getPapers(kevin).size() 	== 3);

		Paper fiveAuthors4 = new Paper(null, authors, "Just a Paper");
		assertTrue(simpleConference.submitPaper(fiveAuthors4));
		assertTrue(simpleConference.getPapers(zach).size() 		== 4);
		assertTrue(simpleConference.getPapers(dimtriy).size() 	== 4);
		assertTrue(simpleConference.getPapers(ian).size() 		== 4);
		assertTrue(simpleConference.getPapers(brian).size()		== 4);
		assertTrue(simpleConference.getPapers(kevin).size() 	== 4);

		Paper fiveAuthors5 = new Paper(null, authors, "Just a Paper");
		assertTrue(simpleConference.submitPaper(fiveAuthors5));
		assertTrue(simpleConference.getPapers(zach).size() 		== 5);
		assertTrue(simpleConference.getPapers(dimtriy).size() 	== 5);
		assertTrue(simpleConference.getPapers(ian).size() 		== 5);
		assertTrue(simpleConference.getPapers(brian).size()		== 5);
		assertTrue(simpleConference.getPapers(kevin).size() 	== 5);
		
		Paper fiveAuthors6 = new Paper(null, authors, "Just a Paper");
		assertFalse(simpleConference.submitPaper(fiveAuthors6));
		assertTrue(simpleConference.getPapers(zach).size() 		== 5);
		assertTrue(simpleConference.getPapers(dimtriy).size() 	== 5);
		assertTrue(simpleConference.getPapers(ian).size() 		== 5);
		assertTrue(simpleConference.getPapers(brian).size()		== 5);
		assertTrue(simpleConference.getPapers(kevin).size() 	== 5);
	}
	
	/**
	 * Tests if paper removal method works properly.
	 * @author Ian Jury
	 */
	@Test
	public void testPaperRemoval() {
		//set up conference and paper
		Conference conferenceToTestPaperRemoval = new Conference();
		Author testAuthor = new Author("AuthorName");
		List<Author> authors = new LinkedList<Author>();
		authors.add(testAuthor);
		Path filePathOfPaper = Paths.get("temp/file/path");
		Paper paperToTestRemoval = new Paper(filePathOfPaper, authors, "Paper name");
		
		//submit and remove
		conferenceToTestPaperRemoval.submitPaper(paperToTestRemoval);
		conferenceToTestPaperRemoval.removePaper(paperToTestRemoval);
		
		//should be 0 if removed successfully 
		assertEquals(conferenceToTestPaperRemoval.getPapers(testAuthor).size(), 0);
	}
	
	/**
	 * Tests if getter for papers in conference works properly.
	 * @author Ian Jury
	 */
	@Test
	public void testGetPapers() {
		Conference conferenceToTestGetPapers = new Conference();
		Author testAuthor = new Author("AuthorName");
		List<Author> authors = new LinkedList<Author>();
		authors.add(testAuthor);
		Path filePathOfPaper = Paths.get("temp/file/path");
		Paper paperToTestGetPapers = new Paper(filePathOfPaper, authors, "Paper name");
		
		conferenceToTestGetPapers.submitPaper(paperToTestGetPapers);
		
		assertEquals(conferenceToTestGetPapers.getPapers(testAuthor), paperToTestGetPapers);
		
	}
	/**
	 * Tests if boolean variable for the submission limit is working.
	 * @author Kevin Nguyen
	 */
	@Test
	public void testAuthorPaperLimit() {
		Conference conferencePaperLimit = new Conference();
		Author testAuthor = new Author("Sam");
		//Should the add author method take in the Author class?
		/* I think the parameter for addAuthor should be Author rather than strings
		 * Since (atleast for this test) I can't call the author paper limit 
		 * method. It kinda makes it long 
		 */
		conferencePaperLimit.addAuthor("Sam"); 
		List<Author> authors = new LinkedList<Author>();
		authors.add(testAuthor);
		Author sam = conferencePaperLimit.getAuthor("sam");

		Path filePathOfPaper = Paths.get("temp/file/path");
		Paper mockPaperTest = new Paper(filePathOfPaper, authors, "AwesomePaper");
		//I don't know the author add paper method yet since it was empty
		//assuming it will be like this -> testAuthor.addPaper(mockPaperTest);
		assertTrue(conferencePaperLimit.isAuthorAtPaperLimit(testAuthor));
		//Do I need to make unique parameters for the Papers?
		Paper fiveAuthors1 = new Paper(null, authors, "Just a Paper");
		Paper fiveAuthors2 = new Paper(null, authors, "Just a Paper");
		Paper fiveAuthors3 = new Paper(null, authors, "Just a Paper");
		Paper fiveAuthors4 = new Paper(null, authors, "Just a Paper");
		Paper fiveAuthors5 = new Paper(null, authors, "Just a Paper");
		Paper fiveAuthors6 = new Paper(null, authors, "Just a Paper");
		//This should return false
		assertFalse(conferencePaperLimit.isAuthorAtPaperLimit(testAuthor));
	}
	/**
	 * Tests if roles are correctly identified in the conference.
	 * Not sure if testing right since its a tree map I presume.
	 * @author Kevin Nguyen
	 */
	@Test
	public void testGetRoles() {
		Conference conRole = new Conference();
		conRole.addAuthor("Ian"); 
		Author ian = new Author("Ian");
		conRole.addAuthor("Jury");
		Author jury = conRole.getAuthor("Jury");
		conRole.addReviewer("Zach");
		conRole.addReviewer("Chandler");
		conRole.addSubprogramChair("Dimitry");
		conRole.addSubprogramChair("Bliznyuk");
		//I think this failed because returned memory address.
		assertEquals(conRole.getRoles("Ian"), "Author");
		assertEquals(conRole.getAuthor("Jury"), "Author");
		assertEquals(conRole.getRoles("Zach"), "Reviewer");
		List<Author> authors = new LinkedList<Author>();
		authors.add(jury);
		assertEquals(conRole.getRoles(authors.get(0).toString()), "Author");
		assertEquals(conRole.getRoles("Bliznyuk"), "SubProgramChair");
		assertEquals(conRole.getRoles("Zach"), "Reviewer");

		
		
	}
	
	/**
	 * Testing the addReviewer method and the getReviewer method in Conference class.
	 * @author Dmitriy Bliznyuk
	 */
	@Test
	public void testAddGetReviewer() {
		Conference testConference = new Conference();
		testConference.addReviewer("johndoe");
		testConference.addReviewer("janedoe");
		testConference.addReviewer("johnnyMcJohnnyface");
		
		List<Reviewer> reviewerList = testConference.getReviewers();
		assertEquals(reviewerList.get(0).getUser(), "johndoe");
		assertEquals(reviewerList.get(1).getUser(), "janedoe");
		assertEquals(reviewerList.get(2).getUser(), "johnnyMcJohnnyface");
	}
}
