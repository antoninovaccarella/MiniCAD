package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class UnGroupExpression implements NonTerminalExpression {

    private ObjIDExpression objID;

    public UnGroupExpression() {
    }

    public ObjIDExpression getObjID() {
        return objID;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol != TerminalExpression.NUMBER)
            throw new SyntaxException("Unexpected symbol: " + symbol);
        this.objID = (ObjIDExpression) new ObjIDExpression().interpret(analyzer);
        return this;
    }
}
