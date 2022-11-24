package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class PosExpression implements NonTerminalExpression {

    PosFloatExpression posX, posY;

    public PosExpression() {
    }

    public PosFloatExpression getPosX() {
        return posX;
    }

    public PosFloatExpression getPosY() {
        return posY;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol!= TerminalExpression.OPEN_PARENTHESIS) {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.OPEN_PARENTHESIS);
        }
        this.posX = (PosFloatExpression) new PosFloatExpression().interpret(analyzer);
        symbol = analyzer.nextSymbol();
        if(symbol!= TerminalExpression.COMMA) {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.COMMA);
        }
        this.posY = (PosFloatExpression) new PosFloatExpression().interpret(analyzer);
        symbol = analyzer.nextSymbol();
        if(symbol!= TerminalExpression.CLOSED_PARENTHESIS) {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.CLOSED_PARENTHESIS);
        }
        return this;
    }
}
