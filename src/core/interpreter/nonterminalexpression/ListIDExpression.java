package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

import java.util.LinkedList;
import java.util.List;

public class ListIDExpression implements NonTerminalExpression {

    List<ObjIDExpression> objectList;

    public ListIDExpression() {
        this.objectList = new LinkedList<>();
    }

    public List<ObjIDExpression> getObjectList() {
        return objectList;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol != TerminalExpression.NUMBER)
            throw new SyntaxException("Unexpected symbol: " + symbol);
        this.objectList.add((ObjIDExpression) new ObjIDExpression().interpret(analyzer)); //perché il primo c'è sicuro
        symbol = analyzer.nextSymbol();
        while(symbol==TerminalExpression.COMMA) {
            symbol = analyzer.nextSymbol();
            if(symbol != TerminalExpression.NUMBER)
                throw new SyntaxException("Unexpected symbol: " + symbol);
            this.objectList.add((ObjIDExpression) new ObjIDExpression().interpret(analyzer));
            symbol = analyzer.nextSymbol();
        }
        return this;
    }
}
