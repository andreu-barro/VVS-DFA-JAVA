package es.udc.vvs.dfa.rendimiento;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

import com.google.code.jetm.reporting.BindingMeasurementRenderer;
import com.google.code.jetm.reporting.xml.XmlAggregateBinder;
import es.udc.vvs.dfa.dfa.State;
import es.udc.vvs.dfa.dfa.Symbol;
import es.udc.vvs.dfa.dfa.Transition;

public class TransitionRendimientoTest {

    private static EtmMonitor etmMonitor;

    /**
     * Configure JETM
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        BasicEtmConfigurator.configure();

        etmMonitor = EtmManager.getEtmMonitor();
        etmMonitor.start();
    }

    /**
     * Write out the results of all of the test runs. This writes out the
     * collected point data to an XML file located in target/jetm beneath the
     * working directory.
     *
     * @throws Exception If any errors occur during the write-out.
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (etmMonitor != null) {
            etmMonitor.stop();

            final File timingDirectory = new File("target/jetm");
            FileUtils.forceMkdir(timingDirectory);

            final File timingFile = new File(timingDirectory, "Timing" + ".xml");
            final FileWriter writer = new FileWriter(timingFile);
            try {
                etmMonitor.render(new BindingMeasurementRenderer(new XmlAggregateBinder(), writer));
            } finally {
                writer.close();
            }
        }
    }

		// Performance Variables
    /**
     * Number of iteratios to check performance.
     */
    private final Integer itNumber = 10000;

    /**
     * GetStartState test.
     */
    @Test
    public final void getStartStateRendimientoTest() {
        List<Transition> testElements = new ArrayList<Transition>();
        for (int i = 0; i < itNumber; i++) {
            testElements.add(new Transition(new State("a"), new State("a"), new Symbol("a")));
        }

        EtmPoint point = etmMonitor
                .createPoint("TransitionRendimientoTest:getStartState");

        for (Transition a : testElements) {
            a.getStartState();
        }

        point.collect();
    }

    /**
     * GetEndState test.
     */
    @Test
    public final void getEndStateRendimientoTest() {
        List<Transition> testElements = new ArrayList<Transition>();
        for (int i = 0; i < itNumber; i++) {
            testElements.add(new Transition(new State("a"), new State("a"), new Symbol("a")));
        }

        EtmPoint point = etmMonitor
                .createPoint("TransitionRendimientoTest:getEndState");

        for (Transition a : testElements) {
            a.getEndState();
        }

        point.collect();
    }
    
    /**
     * GetSymbol test.
     */
    @Test
    public final void getSymbolRendimientoTest() {
        List<Transition> testElements = new ArrayList<Transition>();
        for (int i = 0; i < itNumber; i++) {
            testElements.add(new Transition(new State("a"), new State("a"), new Symbol("a")));
        }

        EtmPoint point = etmMonitor
                .createPoint("TransitionRendimientoTest:getSymbol");

        for (Transition a : testElements) {
            a.getSymbol();
        }

        point.collect();
    }
}
