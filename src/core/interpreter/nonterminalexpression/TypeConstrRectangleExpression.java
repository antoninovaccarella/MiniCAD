package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class TypeConstrRectangleExpression extends TypeConstrExpression {

    private PosExpression pos;

    public TypeConstrRectangleExpression() {
    }

    public PosExpression getPos() {
        return pos;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        this.pos = (PosExpression) new PosExpression().interpret(analyzer);
        return this;
    }
}
