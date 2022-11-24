package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class ListTypeExpression extends AbstractListExpression {

    private TypeExpression typeExpression;

    public ListTypeExpression() {
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
