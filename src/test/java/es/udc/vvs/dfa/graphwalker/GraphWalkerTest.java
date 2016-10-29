package es.udc.vvs.dfa.graphwalker;

import es.udc.vvs.dfa.dfa.State;
import es.udc.vvs.dfa.dfa.Symbol;
import static org.junit.Assert.assertEquals;

import org.graphwalker.core.condition.AlternativeCondition;
import org.graphwalker.core.condition.CombinedCondition;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;

import es.udc.vvs.dfa.dfa.Transition;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class GraphWalkerTest extends ExecutionContext implements VVS{
	public final static Path MODEL_PATH = Paths.get("src/main/resources/testautomation/VVS.graphml");

	@Override
	public void Ready() {
            System.out.println("ready");
	}
        
        /*@Override
	public void Simbolo() {
            System.out.println("simbolo");
	}*/
        
        @Override
	public void add_state() {
            State state = new State("1");
            State state2 = new State("1");
            assertTrue(state.equals(state2));
            System.out.println("add_state");
	}
        
        /*@Override
	public void add_symbol() {
            Symbol symbol = new Symbol("1");
            Symbol symbol2 = new Symbol("1");
            assertTrue(symbol.equals(symbol2));
            System.out.println("add_symbol");
	}*/
	
    @Test
    public void Test1() {
	AlternativeCondition condition = new AlternativeCondition();
	condition.addStopCondition(new EdgeCoverage(100));
	condition.addStopCondition(new TimeDuration(5, TimeUnit.SECONDS));
	new TestBuilder()
            .addModel(MODEL_PATH,new RandomPath(condition))
            .execute();
    }
	
    @Test
    public void Test2() {
        new TestBuilder()
            .addModel(MODEL_PATH,new RandomPath(new TimeDuration(5, TimeUnit.SECONDS)))
            .execute();
    }

}
