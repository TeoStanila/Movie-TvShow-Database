package classes.visitor;

import classes.result.ResultChild;
import classes.result.Teen;
import classes.result.YoungAdult;
import classes.result.Kid;
import classes.result.Baby;

public interface Visitor {
    /**
     * Visits the baby
     * @param baby Baby
     * @return Baby's average score
     */
    double visit(Baby baby);
    /**
     * Visits the kid
     * @param kid Kid
     * @return Kid's average score
     */
    double visit(Kid kid);
    /**
     * Visits the teen
     * @param teen Teen
     * @return Teen's average score
     */
    double visit(Teen teen);
    /**
     * Visits the young adult
     * @param youngAdult Young adult
     * @return Young adult's average score
     */
    double visit(YoungAdult youngAdult);
    /**
     * Visits the result child
     * @param resultChild Result child
     * @return Result child's average score
     */
    double visit(ResultChild resultChild);
}
