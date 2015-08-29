package rfagot.examples.drools_6._dt_jbpmn.ruleutils;


import org.drools.core.event.DefaultAgendaEventListener;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.kie.api.runtime.rule.RuleFlowGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RuleLogger extends DefaultAgendaEventListener {

	static private Logger logger = LoggerFactory.getLogger(RuleLogger.class);
	
	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		final Rule rule = event.getMatch().getRule();
		logger.debug(rule.getPackageName() + "." + rule.getName() + " -> just fired ");

	}


	@Override
	public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		final  RuleFlowGroup group = event.getRuleFlowGroup();
		logger.debug(group.getName() + " -> just passed ");
	}

}
