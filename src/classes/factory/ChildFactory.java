package classes.factory;

import classes.result.Kid;
import classes.result.YoungAdult;
import classes.result.Teen;
import classes.result.Baby;
import classes.result.ResultChild;
import classes.input.InputChild;
import classes.visitor.ChildVisitor;
import common.Constants;

public final class ChildFactory {
    /**
     * Creates a result child based on his age
     *
     * @param inputChild input child
     * @return created child
     */
    public ResultChild createChild(final InputChild inputChild) {
        ChildVisitor v = new ChildVisitor();
        if (inputChild.getAge() <= Constants.BABY_AGE) {
            return new Baby(inputChild, v);
        } else if (inputChild.getAge() <= Constants.KID_AGE) {
            return new Kid(inputChild, v);
        } else if (inputChild.getAge() <= Constants.TEEN_AGE) {
            return new Teen(inputChild, v);
        } else {
            return new YoungAdult(inputChild, v);
        }
    }
    //Functie care creeaza copii de tip rezultat din tipul input

    /**
     * Updates a result child's averagescore by creating another
     * @param resultChild result child that needs to be updated
     * @return New result child
     */
    public ResultChild createChild(final ResultChild resultChild) {
        ChildVisitor v = new ChildVisitor();
        if (resultChild.getAge() <= Constants.BABY_AGE) {
            return new Baby(resultChild, v);
        } else if (resultChild.getAge() <= Constants.KID_AGE) {
            return new Kid(resultChild, v);
        } else if (resultChild.getAge() <= Constants.TEEN_AGE) {
            return new Teen(resultChild, v);
        } else  {
            return new YoungAdult(resultChild, v);
        }
    }
    //Functie care updateaza copiii de tip rezultat
}
