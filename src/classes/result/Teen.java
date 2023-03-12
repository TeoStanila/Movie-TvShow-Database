package classes.result;

import classes.input.InputChild;
import classes.visitor.ChildVisitor;

public final class Teen extends ResultChild {
    @Override
    public Double accept(final ChildVisitor v) {
        return v.visit(this);
    }

    public Teen(final InputChild inputChild, final ChildVisitor v) {
        this.setId(inputChild.getId());
        this.setLastName(inputChild.getLastName());
        this.setFirstName(inputChild.getFirstName());
        this.setAge(inputChild.getAge());
        this.setCity(inputChild.getCity());
        this.getNiceScoreHistory().add(inputChild.getNiceScore());
        this.setAverageScore(v);
        this.setGiftsPreferences(inputChild.getGiftsPreferences());
    }

    public Teen(final ResultChild resultChild, final ChildVisitor v) {
        this.setId(resultChild.getId());
        this.setLastName(resultChild.getLastName());
        this.setFirstName(resultChild.getFirstName());
        this.setAge(resultChild.getAge());
        this.setCity(resultChild.getCity());
        this.setNiceScoreHistory(resultChild.getNiceScoreHistory());
        this.setAverageScore(v);
        this.setGiftsPreferences(resultChild.getGiftsPreferences());
    }
}
