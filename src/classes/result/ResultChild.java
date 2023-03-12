package classes.result;

import classes.Child;
import classes.input.Gift;
import classes.visitor.ChildVisitor;
import classes.visitor.Visitable;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;

public class ResultChild extends Child implements Visitable {

    private Double averageScore;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts = new ArrayList<>();

    /**
     * Used for updating a result child's average score
     * @param v Child Visitor
     * @return Child's average score
     */
    public Double accept(final ChildVisitor v) {
        return v.visit(this);
    }

    /**
     * Returns average score
     * @return Average score
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     * Sets the average score
     * @param v visitor
     */
    public void setAverageScore(final ChildVisitor v) {
        this.averageScore = accept(v);
    }

    /**
     * Returns nice score history
     * @return NIce score history
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * Sets nice score history
     * @param scoreHistory Nice score History
     */
    public void setNiceScoreHistory(final ArrayList<Double> scoreHistory) {
        this.niceScoreHistory = scoreHistory;
    }

    /**
     * Returns assigned budget
     * @return Assigned budget
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * Sets assigned budget
     * @param assignedBudget Assigned Budget
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * Returns received gifts
     * @return received gifts
     */
    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * Sets received gifts
     * @param gifts Received gifts
     */
    public void setReceivedGifts(final ArrayList<Gift> gifts) {
        this.receivedGifts = gifts;
    }

    /**
     * Constructor for ResultChild
     * @param averageScore Average score
     * @param niceScoreHistory Nice score history
     * @param assignedBudget Assigned budget
     * @param receivedGifts Received gifts
     * @param id Id
     * @param lastName Last name
     * @param firstName First name
     * @param city City
     * @param age Age
     * @param giftsPreferences Gift preferences
     */
    public ResultChild(final Double averageScore, final ArrayList<Double> niceScoreHistory,
                       final Double assignedBudget, final ArrayList<Gift> receivedGifts,
                       final Integer id, final String lastName, final String firstName,
                       final Cities city, final Integer age,
                       final ArrayList<Category> giftsPreferences) {
        this.averageScore = averageScore;
        this.niceScoreHistory = niceScoreHistory;
        this.assignedBudget = assignedBudget;
        this.receivedGifts = receivedGifts;
        this.setId(id);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setCity(city);
        this.setAge(age);
        this.setGiftsPreferences(giftsPreferences);
    }

    /**
     * Default constructor
     */
    public ResultChild() {
    }

    /**
     * Function that deep copies the result child
     * @return Deep copied result child
     */
    public ResultChild deepCopy() {
        ArrayList<Category> giftsPreferences = new ArrayList<>(super.getGiftsPreferences());
        ArrayList<Double> scoreHistory = new ArrayList<>(this.niceScoreHistory);
        ArrayList<Gift> gifts = new ArrayList<>(this.receivedGifts);
        return new ResultChild(this.averageScore, scoreHistory, this.assignedBudget,
                gifts, this.getId(), this.getLastName(), this.getFirstName(),
                this.getCity(), this.getAge(), giftsPreferences);
    }
}
