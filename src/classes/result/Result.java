package classes.result;

import java.util.ArrayList;

public final class Result {
    private ArrayList<ResultChildren> annualChildren = new ArrayList<>();

    public void setAnnualChildren(final ArrayList<ResultChildren> children) {
        this.annualChildren = children;
    }

    public ArrayList<ResultChildren> getAnnualChildren() {
        return annualChildren;
    }
}
