package core.interpreter;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

public class LexicalAnalyzer {

    private StreamTokenizer input;
    private TerminalExpression symbol;

    public LexicalAnalyzer(Reader in) {

        input = new StreamTokenizer(in);
        input.resetSyntax();
        input.eolIsSignificant(false);
        input.wordChars('a', 'z');
        input.wordChars('A', 'Z');
        input.parseNumbers();
        input.whitespaceChars('\u0000', ' ');
        input.ordinaryChar('(');
        input.ordinaryChar(')');
        input.quoteChar('"');
        input.ordinaryChar(',');
    }

    public String getString() {
        return input.sval;
    }

    public Double getNumber() {
        return input.nval;
    }

    public TerminalExpression nextSymbol() {
        try {
            switch (input.nextToken()) {
                case StreamTokenizer.TT_EOF:
                    symbol = TerminalExpression.EOF;
                    break;
                case StreamTokenizer.TT_WORD:
                    // verifica prima se la parola è riservata
                    if (input.sval.equalsIgnoreCase("new"))
                        symbol = TerminalExpression.NEW;
                    else if (input.sval.equalsIgnoreCase("del"))
                        symbol = TerminalExpression.DEL;
                    else if (input.sval.equalsIgnoreCase("mv"))
                        symbol = TerminalExpression.MV;
                    else if (input.sval.equalsIgnoreCase("mvoff"))
                        symbol = TerminalExpression.MVOFF;
                    else if (input.sval.equalsIgnoreCase("scale"))
                        symbol = TerminalExpression.SCALE;
                    else if (input.sval.equalsIgnoreCase("ls"))
                        symbol = TerminalExpression.LS;
                    else if (input.sval.equalsIgnoreCase("all"))
                        symbol = TerminalExpression.ALL;
                    else if (input.sval.equalsIgnoreCase("groups"))
                        symbol = TerminalExpression.GROUPS;
                    else if (input.sval.equalsIgnoreCase("grp"))
                        symbol = TerminalExpression.GRP;
                    else if (input.sval.equalsIgnoreCase("ungrp"))
                        symbol = TerminalExpression.UNGRP;
                    else if (input.sval.equalsIgnoreCase("area"))
                        symbol = TerminalExpression.AREA;
                    else if (input.sval.equalsIgnoreCase("perimeter"))
                        symbol = TerminalExpression.PERIMETER;
                    else if (input.sval.equalsIgnoreCase("circle"))
                        symbol = TerminalExpression.CIRCLE;
                    else if (input.sval.equalsIgnoreCase("rectangle"))
                        symbol = TerminalExpression.RECTANGLE;
                    else if (input.sval.equalsIgnoreCase("img"))
                        symbol = TerminalExpression.IMG;
                    else
                        // parola normale - nome
                        symbol = TerminalExpression.WORD;
                    break;
                case StreamTokenizer.TT_NUMBER:
                       symbol = TerminalExpression.NUMBER;
                       break;
                case '"':
                        symbol = TerminalExpression.QUOTES;
                        break;
                case '(':
                    symbol = TerminalExpression.OPEN_PARENTHESIS;
                    break;
                case ')':
                    symbol = TerminalExpression.CLOSED_PARENTHESIS;
                    break;
                case ',':
                    symbol = TerminalExpression.COMMA;
                    break;
                default:
                    symbol = TerminalExpression.INVALID_CHAR;
            }
        } catch (IOException e) {
            symbol = TerminalExpression.EOF;
        }
        return symbol;
    }// prossimoSimbolo

} //AnalizzatoreLessicale
