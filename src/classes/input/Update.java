package classes.input;

import enums.Category;

import java.util.ArrayList;

public final class Update {
    private Integer id;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * Removes all duplicates from the gift preferences list
     */
    public void checkForDuplicates() {
        ArrayList<Category> duplicate = new ArrayList<>();
        for (Category preference : this.giftsPreferences) {
            if (!duplicate.contains(preference)) {
                duplicate.add(preference);
            }
        }
        this.setGiftsPreferences(duplicate);
    }

}
