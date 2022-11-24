import core.interpreter.Parser;
import core.interpreter.SyntaxException;
import core.interpreter.nonterminalexpression.CmdExpression;
import core.interpreter.nonterminalexpression.CreateExpression;
import core.interpreter.nonterminalexpression.TypeConstrCircleExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.io.StringReader;

class InterpreterTest {

    @Test
    void testCreateExpression() {
        String command = "new circle (20.0) (200.0,200.0)";
        Parser parser =  new Parser(new StringReader(command));
        assertEquals(CmdExpression.class, parser.getRoot().getClass());
        CmdExpression cmd = (CmdExpression) parser.getRoot();
        assertEquals(CreateExpression.class, cmd.getNonTerminalExpression().getClass());
        CreateExpression create = (CreateExpression) cmd.getNonTerminalExpression();
        assertEquals(TypeConstrCircleExpression.class, create.getTypeConstr().getClass());
    }//testCreateExpression

    @Test
    void testCreateWithWrongExpression() {
        String command = "new circle 20.0 (200.0,200.0)";
        SyntaxException thrown = Assertions.assertThrows(SyntaxException.class, () -> {
            new Parser(new StringReader(command));
        });
    }//testCreateWithWrongExpression
}
