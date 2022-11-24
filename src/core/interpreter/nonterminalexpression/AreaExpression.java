package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class AreaExpression extends AbstractAreaExpression { //Area all

    public AreaExpression() {
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        return this;
    }
}
