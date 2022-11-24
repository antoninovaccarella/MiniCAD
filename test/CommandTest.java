import core.CommandFactory;
import core.command.AreaCommand;
import core.interpreter.Parser;
import core.interpreter.SyntaxException;
import core.interpreter.nonterminalexpression.PosFloatExpression;
import mvc.controller.GraphicObjectPanel;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

class CommandTest {

    @Test
    void createCommand(){
        String command = "area all";
        Parser parser =  new Parser(new StringReader(command));
        Assert.assertEquals(AreaCommand.class, CommandFactory.getInstance().getCommand(parser.getRoot(),
                new GraphicObjectPanel()).getClass());
    }//createCommand


    @Test
    void createCommandWithException() {
        SyntaxException thrown = Assertions.assertThrows(SyntaxException.class, () -> {
           CommandFactory.getInstance().getCommand(new PosFloatExpression(), new GraphicObjectPanel());
        });
        Assert.assertEquals("Unknown command.", thrown.getMessage());
    }//createCommandWithException
}

