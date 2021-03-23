//>===========================================================<
// RUM                                                                                                      >====<
// Freelance Job Marketplace                                                                      //////////
// Sunday, Feb 29th, 2020                                                                          >====<
//>===========================================================<

public class FreelanceJobMarketplace {

    private Freelancer headFL;
    private Project headPL;

    public void removeProject(String s_id) {
        headPL = removeProject(headPL, s_id);

    }

    private Project removeProject(Project head, String s_id) {

        if (!ProjectIsEmpty()) {
            if (head.getProjectId().equalsIgnoreCase(s_id)) {
                head = head.getNext(); //Head will now point to the next node in the list
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and 
            //look for it
            else {
                Project helpPtr = head; //reference variable helpPtr will be used to traverse and 
                while (helpPtr.getNext() != null) {

                    if (helpPtr.getNext().getProjectId().equalsIgnoreCase(s_id)) {//Comparing the data of next node 
                        //(successor of current node) with the 
                        //data to be deleted
                        helpPtr.setNext(helpPtr.getNext().getNext()); //Skipping the deleted node
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                } //End of while
            } //End of else part
            // return the possibly updated head of the list
            return head; //Returns reference of the first node
        } //End of outer most if 
        return head; //If list becomes empty, it returns null as the value of reference variable ‘head’
    }

    public String searchProject(String skill, int min) {
        String result = "";
        Project hptr = headPL;
        while (hptr != null) {
            if ((hptr.getCategory().equalsIgnoreCase(skill) && hptr.getMinPrice() <= min) && hptr.getStatus().equalsIgnoreCase("not started")) {
                result += hptr.toString() + "\n";
            }
            hptr = hptr.getNext();
        }

        return result;
    }

    public boolean searchpreProject(String projectId) {
        Freelancer hptr = headFL;
        while (hptr != null) {
            for (int i = 0; i < hptr.getPrevProject().length; i++) {
                if (Integer.toString((hptr.getPrevProject()[i])).equals(projectId)) {
                    return true;
                }
            }
            hptr = hptr.getNext();
        }
        return false;
    }

    ///==============================DONE======================
    public String printBestFreelancer() {
        Freelancer hptr = headFL;
        String print = "";
        print += "\n\t\t\t\t\tBest Freelnacer.\n\n";
        print += "|----------------------------------------------------------------------------------------------------------------------------------------------------|\n";
        print += String.format("%s%-15s%s%-9s%s%-30s%s%-10s%s%-23s%s%-10s%s%-6s%s%-12s%s%-12s%s%-12s%s\n", "|", "PseudoName", "|", "Name", "|", "Email", "|", "Phone", "|", "Skills",
                "|", "Experience", "|", "Rating", "|", "Project-ID-1", "|", "Project-ID-2", "|", "Project-ID-3", "|");
        print += "|---------------+---------+------------------------------+----------+-----------------------+----------+------+------------+------------+------------|\n";
        int counter = 0;
        while (hptr != null) {
            if (counter != 10 && (!hptr.getEmail().isEmpty() || !hptr.getPhone().isEmpty())) {

                print += hptr.toString() + "\n";
                counter++;
            }

            hptr = hptr.getNext();

        }
        print += "|---------------+---------+------------------------------+----------+-----------------------+----------+------+------------+------------+------------|\n";
        return print;
    }

    public String printValidFreelancerList() {
        Freelancer hptr = headFL;
        String print = "";
        print += "\n\t\t\t\t\tFreelancer list with a valid account.\n\n";
        print += "|----------------------------------------------------------------------------------------------------------------------------------------------------|\n";
        print += String.format("%s%-15s%s%-9s%s%-30s%s%-10s%s%-23s%s%-10s%s%-6s%s%-12s%s%-12s%s%-12s%s\n", "|", "PseudoName", "|", "Name", "|", "Email", "|", "Phone", "|", "Skills",
                "|", "Experience", "|", "Rating", "|", "Project-ID-1", "|", "Project-ID-2", "|", "Project-ID-3", "|");
        print += "|---------------+---------+------------------------------+----------+-----------------------+----------+------+------------+------------+------------|\n";
        while (hptr != null) {
            if (!hptr.getEmail().isEmpty() || !hptr.getPhone().isEmpty()) {
                print += hptr.toString() + "\n";
            }
            hptr = hptr.getNext();
        }
        print += "|---------------+---------+------------------------------+----------+-----------------------+----------+------+------------+------------+------------|\n";
        return print;
    }

    public String printNotStartedProject() {
        Project hptr = headPL;
        String print = "";
        print += "\n\t\t\t\t\tPrint ‘not started’ project list\n\n";
        print += "|------------------------------------------------------------------------------------------------------------------------------------------------|\n";
        print += String.format("%s%-10s%s%-14s%s%-28s%s%-37s%s%-14s%s%-6s%s%-10s%s%-15s%s\n", "|", "Project Id", "|", "company", "|", "title", "|", "description",
                "|", "category", "|", "min-price", "|", "max-price", "|", "status", "|");
        print += "|------------------------------------------------------------------------------------------------------------------------------------------------|\n";
        while (hptr != null) {
            if (hptr.getStatus().equalsIgnoreCase("not started")) {
                print += hptr.toString() + "\n";
            }
            hptr = hptr.getNext();
        }
        print += "|------------------------------------------------------------------------------------------------------------------------------------------------|\n";
        return print;
    }

    public boolean ProjectIsEmpty() {
        return headPL == null;
    }

    public boolean freelancerIsEmpty() {
        return headFL == null;
    }

    public void addFreelancer(String pseudoName, String name, String email, String phone, String skills, int experience, float rating, int[] prevProject) { //Takes only data to be inserted
        headFL = addFreelancer(headFL, pseudoName, name, email, phone, skills, experience, rating, prevProject);
    }

    private Freelancer addFreelancer(Freelancer head, String pseudoName, String name, String email, String phone, String skills, int experience, float rating, int[] prevProject) { //Receives reference variable and data

        if (freelancerIsEmpty() || head.getRating() < rating) {//If head is null i.e. there is no node or if there

            head = new Freelancer(pseudoName, name, email, phone, skills, experience, rating, prevProject, head); //Creates new node with data and reference variable

            return head;
        } else {

            Freelancer helpPtr = headFL;

            while (helpPtr.getNext() != null) { //Traversing the entire link list
                if (helpPtr.getNext().getRating() < rating) { //if data of next (i.e. successor) node is 

                    break; // we found our spot and should break out of the while loop
                }
                helpPtr = helpPtr.getNext();
            }
            Freelancer newNode = new Freelancer(pseudoName, name, email, phone, skills, experience, rating, prevProject, helpPtr.getNext()); //Creates a newNode and 
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }

    public void addproject(String projectId, String company, String title, String description, String category, int minPrice, int maxPrice, String status, String feedback) {
        headPL = addproject(headPL, projectId, company, title, description, category, minPrice, maxPrice, status, feedback);
    }

    public Project addproject(Project head, String projectId, String company, String title, String description, String category, int minPrice, int maxPrice, String status, String feedback) {
        if (ProjectIsEmpty()) {
            head = new Project(projectId, company, title, description, category, minPrice, maxPrice, status, feedback, head);
            return head;
        } else {
            Project helpPtr = headPL;
            while (helpPtr.getNext() != null) {
                helpPtr = helpPtr.getNext();
            }
            Project newNode = new Project(projectId, company, title, description, category, minPrice, maxPrice, status, feedback, helpPtr.getNext());
            helpPtr.setNext(newNode);

        }
        return head;
    }

    public boolean checkProjectId(String id) {
        Project hptr = headPL;
        while (!ProjectIsEmpty()) {
            if (hptr.getProjectId().equals(id)) {
                return true;
            }
            hptr = hptr.getNext();
        }
        return false;
    }

    public boolean checkPseudoName(String pseudoName) {
        Freelancer hptr = headFL;
        while (hptr != null) {
            if (hptr.getPseudoName().equalsIgnoreCase(pseudoName)) {
                return true;
            }
            hptr = hptr.getNext();
        }
        return false;
    }
}
