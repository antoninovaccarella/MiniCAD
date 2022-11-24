package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class PerimeterTypeExpression extends AbstractPerimeterExpression {

    private TypeExpression typeExpression;


    public PerimeterTypeExpression() {
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
