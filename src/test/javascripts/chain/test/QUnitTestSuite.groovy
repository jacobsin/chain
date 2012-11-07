package chain.test

import org.codehaus.jstestrunner.junit.JSTestSuiteRunner
import org.junit.runner.RunWith

@JSTestSuiteRunner.Include("**/*.html")
@JSTestSuiteRunner.ResourceBase(["src"])
@JSTestSuiteRunner.TestRunnerFilePath("src/test/javascripts/chain/test")
@TestResourceBase("test/javascripts/tests/")

@RunWith(QUnitTestSuiteRunner)
class QUnitTestSuite {
}
