package classes.input;

import java.util.ArrayList;

public final class Data {
    private ArrayList<InputChild> inputChildren = new ArrayList<>();
    private ArrayList<Gift> santaGiftsList = new ArrayList<>();

    public ArrayList<InputChild> getChildren() {
        return inputChildren;
    }

    public void setChildren(final ArrayList<InputChild> children) {
        this.inputChildren = children;
    }

    public ArrayList<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final ArrayList<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
