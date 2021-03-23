//>===========================================================<
// RUM                                                                                                      >====<
// Freelance Job Marketplace                                                                      //////////
// Sunday, Feb 29th, 2020                                                                          >====<
//>===========================================================<

public class Freelancer {

    private String pseudoName;
    private String name;
    private String email;
    private String phone;
    private String skills;
    private int experience;
    private float rating;
    private int[] prevProject;
    private Freelancer next;

    public Freelancer(String pseudoName, String name, String email, String phone, String skills, int experience, float rating, int[] prevProject, Freelancer next) {
        this.pseudoName = pseudoName;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.experience = experience;
        this.rating = rating;
        this.prevProject = prevProject;
        this.next = next;
    }

    public String getPseudoName() {
        return pseudoName;
    }

    public void setPseudoName(String pseudoName) {
        this.pseudoName = pseudoName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int[] getPrevProject() {
        return prevProject;
    }

    public void setPrevProject(int[] prevProject) {
        this.prevProject = prevProject;
    }

    public Freelancer getNext() {
        return next;
    }

    public void setNext(Freelancer next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String prev = "";
        for (int i = 0; i < prevProject.length; i++) {
            prev += String.format("%-13s", prevProject[i]);
        }
        return String.format("|%-16s%-10s%-31s%-11s%-28s%-9s%-6s%s", pseudoName, name, email, phone, skills, experience, rating, prev);
    }

}
