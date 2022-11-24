package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;

public class GroupExpression implements NonTerminalExpression {

    private ListIDExpression listID;

    public GroupExpression() {
    }

    public ListIDExpression getListID() {
        return listID;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        this.listID = (ListIDExpression) new ListIDExpression().interpret(analyzer);
        return this;
    }
}
