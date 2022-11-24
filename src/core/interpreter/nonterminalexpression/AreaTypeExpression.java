package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class AreaTypeExpression extends AbstractAreaExpression {

    private TypeExpression typeExpression;


    public AreaTypeExpression() {
    }

    public TypeExpression getTypeExpression() {
        return typeExpression;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        this.typeExpression = (TypeExpression) new TypeExpression().interpret(analyzer);
        return this;
    }
}
