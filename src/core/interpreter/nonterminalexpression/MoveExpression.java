package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class MoveExpression implements NonTerminalExpression {

    private boolean moveOff;
    private ObjIDExpression objID;
    private PosExpression pos;

    public MoveExpression(boolean moveOff) {
        this.moveOff = moveOff;
    }

    public boolean isMoveOff() {
        return moveOff;
    }

    public ObjIDExpression getObjectID() {
        return objID;
    }

    public PosExpression getPos() {
        return pos;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol != TerminalExpression.NUMBER)
            throw new SyntaxException("Unexpected symbol: " + symbol);
        this.objID = (ObjIDExpression) new ObjIDExpression().interpret(analyzer);
        this.pos = (PosExpression) new PosExpression().interpret(analyzer);
        return this;
    }
}
