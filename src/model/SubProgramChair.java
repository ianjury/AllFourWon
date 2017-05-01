/*
 * TCSS 360
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Subprogram chair class containing a list of papers assigned to instance of object.
 * @author Ian Jury
 * @version 1.0
 *
 */
public final class SubProgramChair extends AbstractRole implements Cloneable {
    
    /** Generated UID.*/
    private static final long serialVersionUID = 3678435490225778582L;
    
    /** List of assigned papers to subprogram chair.*/
    private List<Paper> assignedPapers;
    

    /**
     * Constructor for subprogram chair object
     * @param user the unique identifier of the user (AKA user name)
     */
    public SubProgramChair(String user) {
        super(user);
        assignedPapers = new ArrayList<>();
    }
    
    /**
     * Assigns a paper to the subprogram chair to manage.
     */
    public void addPaper(Paper thePaper) {
        if (!assignedPapers.contains(thePaper)) {
            assignedPapers.add(thePaper);            
        }
    }
    
    /**
     * Gets all of the papers that the subprogram chair has been assigned.
     * @return list of papers.
     * @throws CloneNotSupportedException 
     */
    public List<Paper> getPapers() {
        return new ArrayList<>(assignedPapers);
    }

}
