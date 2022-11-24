package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class PerimeterExpression extends AbstractPerimeterExpression {

    public PerimeterExpression() {
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        return this;
    }
}
