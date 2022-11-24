package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class CreateExpression implements NonTerminalExpression {

    private TypeConstrExpression typeConstr;
    private PosExpression pos;

    public CreateExpression() {
    }

    public TypeConstrExpression getTypeConstr() {
        return typeConstr;
    }

    public PosExpression getPos() {
        return pos;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        switch (symbol) {
            case CIRCLE :
                this.typeConstr = (TypeConstrExpression) new TypeConstrCircleExpression().interpret(analyzer);
                break;
            case RECTANGLE:
                this.typeConstr = (TypeConstrExpression) new TypeConstrRectangleExpression().interpret(analyzer);
                break;
            case IMG:
                this.typeConstr = (TypeConstrExpression) new TypeConstrImageExpression().interpret(analyzer);
                break;
            default:
                throw new SyntaxException(symbol + " is not a valid type.");
        }
        this.pos = (PosExpression) new PosExpression().interpret(analyzer);
        return this;
    }
}
