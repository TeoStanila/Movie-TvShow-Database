package classes.result;

import java.util.ArrayList;

public final class ResultChildren {
    private ArrayList<ResultChild> children = new ArrayList<>();

    public ArrayList<ResultChild> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<ResultChild> children) {
        this.children = children;
    }

    public ResultChildren(final ArrayList<ResultChild> children) {
        this.children = children;
    }

    public ResultChildren() {
    }
}
