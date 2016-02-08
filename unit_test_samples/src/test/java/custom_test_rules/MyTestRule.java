package custom_test_rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;


public class MyTestRule implements TestRule {

    Statement mStatement;
    Description mDescription;


    @Override
    public Statement apply(Statement statement, Description description) {

        mStatement = statement;
        mDescription = description;

        return new MyStatement(statement);
    }


    public class MyStatement extends Statement {

        final Statement base;

        public MyStatement(Statement statement) {
            base = statement;
        }


        @Override
        public void evaluate() throws Throwable {
            System.out.println("MyCustomRule  " + mDescription.getMethodName() + " started");
            try {
                base.evaluate();
            } finally {
                System.out.println("MyCustomRule  " + mDescription.getMethodName() + " started");
            }
        }
    }
}
