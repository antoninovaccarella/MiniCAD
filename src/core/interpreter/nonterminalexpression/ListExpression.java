package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

import java.util.Locale;

public class ListExpression extends AbstractListExpression{

    private boolean groups;

    public ListExpression() {
    }

    public boolean isGroups() {
        return groups;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        if(analyzer.getString().equals(TerminalExpression.GROUPS.name().toLowerCase()))
            groups = true;
        if(analyzer.getString().equals(TerminalExpression.ALL.name().toLowerCase()))
            groups = false;
        if(!analyzer.getString().equals(TerminalExpression.GROUPS.name().toLowerCase()) &&
                !analyzer.getString().equals(TerminalExpression.ALL.name().toLowerCase()))
            throw new SyntaxException(analyzer.getString() + " not a valid parameter.");
        return this;
    }
}
