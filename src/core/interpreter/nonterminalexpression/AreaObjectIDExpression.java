package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class AreaObjectIDExpression extends AbstractAreaExpression {

    private ObjIDExpression objID;

    public AreaObjectIDExpression() {
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
