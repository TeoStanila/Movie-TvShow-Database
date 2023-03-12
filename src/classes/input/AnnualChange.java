package classes.input;

import java.util.ArrayList;

public final class AnnualChange {
    private Double newSantaBudget;
    private ArrayList<Gift> newGifts;
    private ArrayList<InputChild> newInputChildren = new ArrayList<>();
    private ArrayList<Update> childrenUpdates = new ArrayList<>();

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final ArrayList<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    public ArrayList<InputChild> getNewChildren() {
        return newInputChildren;
    }

    public void setNewChildren(final ArrayList<InputChild> children) {
        this.newInputChildren = children;
    }

    public ArrayList<Update> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final ArrayList<Update> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
