//>===========================================================<
// RUM                                                                                                      >====<
// Freelance Job Marketplace                                                                      //////////
// Sunday, Feb 29th, 2020                                                                          >====<
//>===========================================================<


public class Project {

    private String projectId;
    private String company;
    private String title;
    private String description;
    private String category;
    private int minPrice;
    private int maxPrice;
    private String status;
    private String feedback;
    private Project next;

    public Project(String projectId, String company, String title, String description, String category, int minPrice, int maxPrice, String status, String feedback, Project next) {
        this.projectId = projectId;
        this.company = company;
        this.title = title;
        this.description = description;
        this.category = category;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.status = status;
        this.feedback = feedback;
        this.next = next;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Project getNext() {
        return next;
    }

    public void setNext(Project next) {
        this.next = next;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        if (feedback == null) {
            return String.format("| %-11s%-14s%-29s%-38s%-15s%-10s%-11s%-8s%-8s", projectId, company, title, description, category, minPrice, maxPrice, status, "");
        } else {
            return String.format("| %-11s%-14s%-29s%-38s%-15s%-10s%-11s%-8s%-8s", projectId, company, title, description, category, minPrice, maxPrice, status, feedback);
        }

    }

}
