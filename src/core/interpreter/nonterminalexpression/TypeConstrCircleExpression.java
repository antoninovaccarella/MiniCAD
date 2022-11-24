package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class TypeConstrCircleExpression extends TypeConstrExpression {

    private PosFloatExpression posFloat;

    public TypeConstrCircleExpression() {
    }

    public PosFloatExpression getPosFloat() {
        return posFloat;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol!= TerminalExpression.OPEN_PARENTHESIS) {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.OPEN_PARENTHESIS);
        }
        this.posFloat = (PosFloatExpression) new PosFloatExpression().interpret(analyzer);
        symbol = analyzer.nextSymbol();
        if(symbol!= TerminalExpression.CLOSED_PARENTHESIS) {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.CLOSED_PARENTHESIS);
        }
        return this;
    }
}
