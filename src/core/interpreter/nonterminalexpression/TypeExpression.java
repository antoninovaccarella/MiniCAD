package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class TypeExpression implements NonTerminalExpression {

    private String type;

    public TypeExpression() {
    }

    public String getType() {
        return type;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        this.type = analyzer.getString();
        return this;
    }
}
