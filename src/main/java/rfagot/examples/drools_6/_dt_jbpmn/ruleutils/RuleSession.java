package rfagot.examples.drools_6._dt_jbpmn.ruleutils;

import java.util.Iterator;
import java.util.Vector;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class RuleSession {
	
	static private Logger logger = LoggerFactory.getLogger(RuleSession.class);

	private KieSession         ksession;
	private Vector<FactHandle>       facts = new Vector<FactHandle>();

	public RuleSession(ReleaseId id, String name, int seconds) throws RuleException
	{
		
		
		KieServices services = KieServices.Factory.get();
		
		// if id == null we use the classpath container
		KieContainer container = null;
		if (id == null)
		{
			container = services.newKieClasspathContainer();
		}
		else 
		{
			container = services.newKieContainer(id);
		}
		
		ksession = container.newKieSession(name);

		if (ksession == null)
		{
			String error = "Base " + id + " ,Drools session " + name + " is null";
			logger.error(error);
			throw new RuleException(error);
		}
		
		
		if (seconds > 0)
		{
			KieScanner kScanner = services.newKieScanner(container);
			kScanner.start(seconds);			
		}	
	}
	
		
	public void insertIntoWm(Object object) throws RuleException
	{
		if (ksession == null) 
		{
			String error="rule session should not be null when inserting objects";
			logger.error(error);
			throw new RuleException(error);
		}

		FactHandle handle = ksession. insert(object);
		facts.add(handle);
	}

	public void fireAll(String process) throws RuleException
	{
		if (process !=null)
		{
			if (ksession.getKieBase().getProcess(process) != null)
			{
				ksession.startProcess(process);
			}
			else
			{
				String error="Process " + process + "  cannot be found";
				logger.error(error);
				throw new RuleException(error);
			}
			
		}
		ksession.fireAllRules();
	}
	
	public void retractAll()
	{
		for (Iterator<FactHandle> iterator = facts.iterator(); iterator.hasNext();) 
		{
			FactHandle fact = iterator.next();
			ksession.delete(fact);			
		}
	}

	public void closeKsession() throws RuleException {
		
		if (ksession == null) 
		{
			String error="rule session should not be null before being closed";
			logger.error(error);
			throw new RuleException(error);
		}
		try {

			// load up the knowledge base
			ksession.dispose();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	
}
