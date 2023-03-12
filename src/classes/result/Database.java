package classes.result;

import classes.factory.ChildFactory;
import classes.input.Data;
import classes.input.AnnualChange;
import classes.input.Gift;
import classes.input.Update;
import classes.input.InputChild;
import common.Constants;
import enums.Category;

import java.util.ArrayList;
import java.util.Objects;

public final class Database {
    private Integer numberOfYears;
    private Double santaBudget;
    private Data initialData;
    private ArrayList<AnnualChange> annualChanges = new ArrayList<>();
    private ArrayList<ResultChild> resultChildren = new ArrayList<>();
    private Double budgetUnit;

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public Data getInitialData() {
        return initialData;
    }

    public void setInitialData(final Data initialData) {
        this.initialData = initialData;
    }

    public ArrayList<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(final ArrayList<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }

    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public ArrayList<ResultChild> getResultChildren() {
        return resultChildren;
    }

    public void setResultChildren(final ArrayList<ResultChild> resultChildren) {
        this.resultChildren = resultChildren;
    }

    public Double getBudgetUnit() {
        return budgetUnit;
    }

    /**
     * Sets the budget unit for the round
     */
    public void setBudgetUnit() {
        Double sum = 0.0;
        for (ResultChild child : this.getResultChildren()) {
            sum += child.getAverageScore();
        }
        this.budgetUnit = this.santaBudget / sum;
    }

    /**
     * Gives the right gifts to the child
     * @param child child that receives gifts
     */
    public void findRightGifts(final ResultChild child) {
        double assignedBudget = child.getAssignedBudget();
        for (Category giftCategory : child.getGiftsPreferences()) {
            double minPrice = Constants.MAX_PRICE;
            Gift rightGift = null;
            for (Gift gift : this.getInitialData().getSantaGiftsList()) {
                if (gift.getCategory().equals(giftCategory)
                        && gift.getPrice() < minPrice) {
                    minPrice = gift.getPrice();
                    rightGift = gift;
                }
            }
            // Cautam cadoul din categoria potrivita

            if (minPrice < assignedBudget) {
                assignedBudget -= minPrice;
                child.getReceivedGifts().add(rightGift);
            }
            // Daca am gasit ceva potrivit, il adaugam in lista
            // si scadem pretul lui din buget
        }
    }

    /**
     * Finds a child by their id
     * @param id Id of the child
     * @return The child
     */
    public ResultChild findResultChildById(final int id) {
        for (ResultChild resultChild : this.getResultChildren()) {
            if (resultChild.getId().equals(id)) {
                return resultChild;
            }
        }
        return null;
    }

    /**
     * Applies the change for the round
     * @param change Change to pe applied
     */
    public void applyChange(final AnnualChange change) {
        ChildFactory factory = new ChildFactory();
        ArrayList<ResultChild> newResultChildren = new ArrayList<>();

        this.setSantaBudget(change.getNewSantaBudget());
        // Am updatat bugetul Mosului

        this.getInitialData().getSantaGiftsList().addAll(change.getNewGifts());
        // Am updatat cadourile Mosului


        for (Update update : change.getChildrenUpdates()) {
            ResultChild resultChild = this.findResultChildById(update.getId());
            if (resultChild != null && !Objects.equals(resultChild.getAge(), Constants.TEEN_AGE)) {
                if (update.getNiceScore() != null) {
                    resultChild.getNiceScoreHistory().add(update.getNiceScore());
                }
                // Am updatat lista de scoruri a copilului

                if (update.getGiftsPreferences() != null) {
                    for (Category giftPreference : update.getGiftsPreferences()) {
                        resultChild.getGiftsPreferences().remove(giftPreference);
                    }
                    // Am sters preferintele care se repeta din lista copilului

                    update.checkForDuplicates();
                    // Verificam lista are elemente duble
                    update.getGiftsPreferences().addAll(resultChild.getGiftsPreferences());
                    resultChild.setGiftsPreferences(update.getGiftsPreferences());
                    // Am updatat lista de preferinte ale copilului
                }
            }
        }
        // Am updatat copiii existenti, mai putin pe cei
        // care urmeaza sa devina tineri adulti

        for (ResultChild child : this.getResultChildren()) {
            child.setAge(child.getAge() + 1);
            ResultChild resultChild = factory.createChild(child);
            if (resultChild.getAge() <= Constants.TEEN_AGE) {
                newResultChildren.add(resultChild);
            }
        }
        this.setResultChildren(newResultChildren);
        // Am updatat varsta copiilor tip rezultat, stergand tinerii adulti

        for (InputChild child : change.getNewChildren()) {
            ResultChild resultChild = factory.createChild(child);
            if (resultChild.getAge() <= Constants.TEEN_AGE) {
                this.getResultChildren().add(resultChild);
            }
        }
        // Am adaugat copiii noi

        this.setBudgetUnit();
        // Am updatat unitatea de buget a Mosului

        for (ResultChild child : this.getResultChildren()) {
            child.setAssignedBudget(this.getBudgetUnit() * child.getAverageScore());
        }
        // Am updatat bugetul pentru fiecare copil
    }
}
