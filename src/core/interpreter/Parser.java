package core.interpreter;

import core.command.Command;
import core.interpreter.nonterminalexpression.CmdExpression;
import core.interpreter.nonterminalexpression.NonTerminalExpression;

import java.io.Reader;

public class Parser {
    private LexicalAnalyzer analyzer;
    private TerminalExpression simbolo;
    private NonTerminalExpression root;

    public Parser(Reader in) {
        analyzer = new LexicalAnalyzer(in);
        root = new CmdExpression().interpret(analyzer);
        //expected(TerminalExpression.EOF);
    }

    public NonTerminalExpression getRoot() {
        return root;
    }

    private void expected(TerminalExpression s) {
        if (simbolo != s) {
            String msg = " trovato " + simbolo + " mentre si attendeva " + s;
            throw new SyntaxException(msg);
        }
        simbolo = analyzer.nextSymbol();
    }// atteso





}

