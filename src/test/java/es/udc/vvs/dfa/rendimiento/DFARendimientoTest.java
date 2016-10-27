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
import es.udc.vvs.dfa.dfa.Alphabet;
import es.udc.vvs.dfa.dfa.DFA;
import es.udc.vvs.dfa.dfa.State;
import es.udc.vvs.dfa.dfa.Symbol;
import es.udc.vvs.dfa.dfa.Transition;
import es.udc.vvs.dfa.util.GenList;

public class DFARendimientoTest {

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
     * GetConnectedDFA test.
     */
    @Test
    public final void getConnectedDFARendimientoTest() {
        List<DFA> testElements = new ArrayList<DFA>();
        GenList<State> states = new GenList<State>();
        states.add(new State("a"));
        GenList<Transition> transitions = new GenList<Transition>();
        transitions.add(new Transition(new State("a"), new State("a"), new Symbol("a")));
        
        for (int i = 0; i < itNumber; i++) {
            testElements.add(new DFA(states, new Alphabet(), new State("a"), states, transitions));
        }

        EtmPoint point = etmMonitor
                .createPoint("DFARendimientoTest:getConnectedDFA");

        for (DFA a : testElements) {
            try {
                a.getConnectedDFA();
            }
            catch (Exception ex) {
                
            }
        }

        point.collect();
    }
}
