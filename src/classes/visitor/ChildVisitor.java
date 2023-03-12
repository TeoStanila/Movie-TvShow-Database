package classes.visitor;

import classes.result.Kid;
import classes.result.Baby;
import classes.result.Teen;
import classes.result.YoungAdult;
import classes.result.ResultChild;
import common.Constants;

public final class ChildVisitor implements Visitor {

    @Override
    public double visit(final Baby baby) {
        return Constants.BABY_SCORE;
    }

    @Override
    public double visit(final Kid kid) {
        double sum = Constants.ZERO;
        double number = Constants.ZERO;
        for (Double score : kid.getNiceScoreHistory()) {
            sum += score;
            number++;
        }
        return sum / number;
    }

    @Override
    public double visit(final Teen teen) {
        double sum = Constants.ZERO;
        double weight = Constants.ONE;
        for (Double score : teen.getNiceScoreHistory()) {
            sum += score * weight;
            weight++;
        }
        int weightSum = teen.getNiceScoreHistory().size()
                * (teen.getNiceScoreHistory().size() + 1) / 2;
        return sum / weightSum;
    }

    @Override
    public double visit(final YoungAdult youngAdult) {
        return Constants.ZERO;
    }

    @Override
    public double visit(final ResultChild resultChild) {
        return resultChild.getAverageScore();
    }

}
