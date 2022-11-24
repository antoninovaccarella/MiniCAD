package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class TypeConstrImageExpression extends TypeConstrExpression {

    private String path;

    public TypeConstrImageExpression() {
    }

    public String getPath() {
        return path;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        // <QUOTES><WORD><DOT><WORD><QUOTES>
        // <QUOTES><WORD></><WORD><DOT><WORD><QUOTES>

        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol!= TerminalExpression.OPEN_PARENTHESIS) {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.OPEN_PARENTHESIS);
        }
        symbol = analyzer.nextSymbol();
        if(symbol!= TerminalExpression.QUOTES) {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.QUOTES);
        }
        this.path = analyzer.getString();
        symbol = analyzer.nextSymbol();
        if(symbol!= TerminalExpression.CLOSED_PARENTHESIS) {
            throw new SyntaxException("Found " + symbol + " while waiting " + TerminalExpression.CLOSED_PARENTHESIS);
        }
        return this;
    }
}

