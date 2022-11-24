package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class PosFloatExpression implements NonTerminalExpression {

    Float posFloat;

    public PosFloatExpression() {
    }

    public Float getPosFloat() {
        return posFloat;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol==TerminalExpression.NUMBER) {
            this.posFloat = analyzer.getNumber().floatValue();
        }
        else {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.NUMBER);
        }
        return this;
    }
}

