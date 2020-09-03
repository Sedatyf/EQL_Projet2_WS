package eql;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.tools.SoapUITestCaseRunner;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class RunnerSoapUITest {
	
	//@Test
	public void testRunner() throws Exception {
		SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
		runner.setProjectFile("src/test/resources/NOAA2-soapui-project.xml");
		runner.run();
	}

	@Test
	public void testTestCaseRunnerTest() throws Exception {
		WsdlProject project = new WsdlProject("src/test/resources/NOAA2-soapui-project.xml");
		List<TestSuite> testSuites = project.getTestSuiteList();
		for (TestSuite suite : testSuites) {
			List<TestCase> testCases = suite.getTestCaseList();
			for (TestCase testCase : testCases) {
				System.out.println("Running SoapUI test [" + testCase.getName() + "]");
				TestRunner runner2 = testCase.run(new PropertiesMap(), false);
				assertEquals(Status.FINISHED, runner2.getStatus());
			}
		}
	}
	
	

}
