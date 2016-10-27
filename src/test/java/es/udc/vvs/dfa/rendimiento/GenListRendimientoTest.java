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
import es.udc.vvs.dfa.dfa.Symbol;
import es.udc.vvs.dfa.util.GenList;

public class GenListRendimientoTest {

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
     * add test.
     */
    @Test
    public final void addRendimientoTest() {
        List<GenList> testElements = new ArrayList<GenList>();
        for (int i = 0; i < itNumber; i++) {
            testElements.add(new GenList());
        }

        EtmPoint point = etmMonitor
                .createPoint("GenListRendimientoTest:add");

        for (GenList a : testElements) {
            a.add("a");
        }

        point.collect();
    }

    /**
     * remove test.
     */
    @Test
    public final void removeRendimientoTest() {
        List<GenList> testElements = new ArrayList<GenList>();
        for (int i = 0; i < itNumber; i++) {
            GenList gen = new GenList<String>();
            gen.add("a");
            testElements.add(gen);
        }

        EtmPoint point = etmMonitor
                .createPoint("GenListRendimientoTest:remove");

        for (GenList a : testElements) {
            a.remove(0);
        }

        point.collect();
    }
    
    /**
     * getBuffer test.
     */
    @Test
    public final void getBufferRendimientoTest() {
        List<GenList> testElements = new ArrayList<GenList>();
        for (int i = 0; i < itNumber; i++) {
            testElements.add(new GenList());
        }

        EtmPoint point = etmMonitor
                .createPoint("GenListRendimientoTest:getBuffer");

        for (GenList a : testElements) {
            a.getBuffer();
        }

        point.collect();
    }
    
    /**
     * get test.
     */
    @Test
    public final void getRendimientoTest() {
        List<GenList> testElements = new ArrayList<GenList>();
        for (int i = 0; i < itNumber; i++) {
            GenList gen = new GenList<String>();
            gen.add("a");
            testElements.add(gen);
        }

        EtmPoint point = etmMonitor
                .createPoint("GenListRendimientoTest:get");

        for (GenList a : testElements) {
            a.get(0);
        }

        point.collect();
    }
    
    /**
     * getArray test.
     */
    @Test
    public final void getArrayRendimientoTest() {
        List<GenList> testElements = new ArrayList<GenList>();
        for (int i = 0; i < itNumber; i++) {
            GenList gen = new GenList<String>();
            gen.add("a");
            testElements.add(gen);
        }

        EtmPoint point = etmMonitor
                .createPoint("GenListRendimientoTest:getArray");

        for (GenList a : testElements) {
            a.getArray();
        }

        point.collect();
    }
    
    /**
     * getSize test.
     */
    @Test
    public final void getSizeRendimientoTest() {
        List<GenList> testElements = new ArrayList<GenList>();
        for (int i = 0; i < itNumber; i++) {
            GenList gen = new GenList<String>();
            testElements.add(gen);
        }

        EtmPoint point = etmMonitor
                .createPoint("GenListRendimientoTest:getSize");

        for (GenList a : testElements) {
            a.getSize();
        }

        point.collect();
    }
    
    /**
     * getExistingObject test.
     */
    @Test
    public final void getExistingObjectRendimientoTest() {
        List<GenList> testElements = new ArrayList<GenList>();
        for (int i = 0; i < itNumber; i++) {
            GenList gen = new GenList<String>();
            gen.add("a");
            testElements.add(gen);
        }

        EtmPoint point = etmMonitor
                .createPoint("GenListRendimientoTest:getExistingObject");

        for (GenList a : testElements) {
            a.getExistingObject("a");
        }

        point.collect();
    }
}
