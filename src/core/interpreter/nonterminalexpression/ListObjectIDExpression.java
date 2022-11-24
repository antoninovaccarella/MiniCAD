package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class ListObjectIDExpression extends AbstractListExpression {

    private ObjIDExpression objID;

    public ListObjectIDExpression() {
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
