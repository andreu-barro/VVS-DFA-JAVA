package es.udc.vvs.dfa.graphwalker;

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

public class GraphWalkerTest extends ExecutionContext implements VVS{
	public final static Path MODEL_PATH = Paths.get("main/resources/testautomation/VVS.graphml");


	@Override
	public void Ready() {
		
		
	}
        
        @Override
	public void add_state() {
		
		
	}
	
	

	/*
	@Test
    public void runSmokeTest() {
        new TestBuilder()
            .addModel(MODEL_PATH,new AStarPath(new ReachedVertex("add_state")))
            .execute();
    }*/
	/*
	@Test
    public void runFunctionalTest() {
		AlternativeCondition condition = new AlternativeCondition();
		condition.addStopCondition(new EdgeCoverage(100));
		condition.addStopCondition(new TimeDuration(15, TimeUnit.SECONDS));
		new TestBuilder()
            .addModel(MODEL_PATH,new RandomPath(condition))
            .execute();
    }*/
	
	@Test
    public void runStabilityTest() {
        
        /*new TestBuilder()
            .addModel(MODEL_PATH,new RandomPath(new TimeDuration(15, TimeUnit.SECONDS)))
            .execute();*/
    }

}
