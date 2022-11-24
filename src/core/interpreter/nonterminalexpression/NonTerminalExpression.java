package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public interface NonTerminalExpression {

    public NonTerminalExpression interpret(LexicalAnalyzer analyzer);

}
