package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class ObjIDExpression implements NonTerminalExpression {

    private Integer objectID;

    public ObjIDExpression() {
    }

    public Integer getObjectID() {
        return objectID;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        this.objectID = analyzer.getNumber().intValue();
        return this;
    }
}
