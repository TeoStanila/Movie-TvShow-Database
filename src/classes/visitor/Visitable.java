package classes.visitor;

public interface Visitable {
    /**
     * Function that is used by children to calculate their score
     * @param v Visitor
     * @return Average score
     */
    Double accept(ChildVisitor v);
}
