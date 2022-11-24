package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class ScaleExpression implements NonTerminalExpression {

    private ObjIDExpression objID;
    private PosFloatExpression posFloat;

    public ScaleExpression() {
    }

    public ObjIDExpression getObjID() {
        return objID;
    }

    public PosFloatExpression getPosFloat() {
        return posFloat;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol != TerminalExpression.NUMBER)
            throw new SyntaxException("Unexpected symbol: " + symbol);
        this.objID = (ObjIDExpression) new ObjIDExpression().interpret(analyzer);
        this.posFloat = (PosFloatExpression) new PosFloatExpression().interpret(analyzer);
        return this;
    }
}
