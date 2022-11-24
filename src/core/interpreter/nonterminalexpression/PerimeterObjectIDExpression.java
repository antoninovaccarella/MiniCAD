package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class PerimeterObjectIDExpression extends AbstractPerimeterExpression {

    private ObjIDExpression objID;

    public PerimeterObjectIDExpression() {
    }

    public ObjIDExpression getObjID() {
        return objID;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        this.objID = (ObjIDExpression) new ObjIDExpression().interpret(analyzer);
        return this;
    }
}
