package core.interpreter.nonterminalexpression;

import core.interpreter.LexicalAnalyzer;
import core.interpreter.SyntaxException;
import core.interpreter.TerminalExpression;

public class CmdExpression implements NonTerminalExpression {

    private NonTerminalExpression nonTerminalExpression;

    public CmdExpression() {
    }

    public NonTerminalExpression getNonTerminalExpression() {
        return nonTerminalExpression;
    }

    @Override
    public NonTerminalExpression interpret(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        switch (symbol) {
            case NEW:
                this.nonTerminalExpression = new CreateExpression().interpret(analyzer);
                break;
            case DEL:
                this.nonTerminalExpression = new RemoveExpression().interpret(analyzer);
                break;
            case MV:
                this.nonTerminalExpression = new MoveExpression(false).interpret(analyzer);
                break;
            case MVOFF:
                this.nonTerminalExpression = new MoveExpression(true).interpret(analyzer);
                break;
            case SCALE:
                this.nonTerminalExpression = new ScaleExpression().interpret(analyzer);
                break;
            case LS:
                this.nonTerminalExpression = listExpression(analyzer);
                break;
            case GRP:
                this.nonTerminalExpression = new GroupExpression().interpret(analyzer);
                break;
            case UNGRP:
                this.nonTerminalExpression = new UnGroupExpression().interpret(analyzer);
                break;
            case AREA:
                this.nonTerminalExpression = areaExpression(analyzer);
                break;
            case PERIMETER:
                this.nonTerminalExpression = perimeterExpression(analyzer);
                break;
            default:
                throw new SyntaxException("Error! "+ symbol + " is not a command.");
        }
        return this;
    }


    private NonTerminalExpression listExpression(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol.equals(TerminalExpression.GROUPS) || symbol.equals(TerminalExpression.ALL) )
            return new ListExpression().interpret(analyzer);
        if(symbol.equals(TerminalExpression.CIRCLE) ||  symbol.equals(TerminalExpression.IMG) ||
                symbol.equals(TerminalExpression.RECTANGLE))
            return new ListTypeExpression().interpret(analyzer);
        if(symbol.equals(TerminalExpression.NUMBER))
            return new ListObjectIDExpression().interpret(analyzer);
        throw new SyntaxException("Unexpected symbol: " + symbol);
    }//listExpression

    private NonTerminalExpression areaExpression(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol.equals(TerminalExpression.ALL) )
            return new AreaExpression().interpret(analyzer);
        if(symbol.equals(TerminalExpression.CIRCLE) ||  symbol.equals(TerminalExpression.IMG) ||
                symbol.equals(TerminalExpression.RECTANGLE))
            return new AreaTypeExpression().interpret(analyzer);
        if(symbol.equals(TerminalExpression.NUMBER))
            return new AreaObjectIDExpression().interpret(analyzer);
        throw new SyntaxException("Unexpected symbol: " + symbol);
    }//areaExpression

    private NonTerminalExpression perimeterExpression(LexicalAnalyzer analyzer) {
        TerminalExpression symbol = analyzer.nextSymbol();
        if(symbol.equals(TerminalExpression.ALL) )
            return new PerimeterExpression().interpret(analyzer);
        if(symbol.equals(TerminalExpression.CIRCLE) ||  symbol.equals(TerminalExpression.IMG) ||
                symbol.equals(TerminalExpression.RECTANGLE))
            return new PerimeterTypeExpression().interpret(analyzer);
        if(symbol.equals(TerminalExpression.NUMBER))
            return new PerimeterObjectIDExpression().interpret(analyzer);
        throw new SyntaxException("Unexpected symbol: " + symbol);
    }//perimeterExpression
}
