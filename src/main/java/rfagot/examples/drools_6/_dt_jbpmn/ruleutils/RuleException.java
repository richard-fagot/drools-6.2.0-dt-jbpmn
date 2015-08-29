package rfagot.examples.drools_6._dt_jbpmn.ruleutils;


@SuppressWarnings("serial")
public class RuleException extends Exception {

	public RuleException(String message){
		super(message);
	}

	public RuleException(Throwable cause){
		super(cause);
	}

	public RuleException(String message,Throwable cause){
		super(message, cause);
	}

}
