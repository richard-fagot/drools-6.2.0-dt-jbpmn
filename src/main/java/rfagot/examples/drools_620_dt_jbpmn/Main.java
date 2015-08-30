package rfagot.examples.drools_620_dt_jbpmn;

import java.util.LinkedList;
import java.util.List;

import org.kie.api.builder.ReleaseId;

import rfagot.examples.drools_620_dt_jbpmn.model.Boxer;
import rfagot.examples.drools_620_dt_jbpmn.ruleutils.RuleException;
import rfagot.examples.drools_620_dt_jbpmn.ruleutils.RuleSession;

public class Main {

	public static void main(String[] args) {
		(new Main()).run();
	}

	public void run() {
		ReleaseId id = null;
		RuleSession session;
		try {
			session = new RuleSession(id, "drools-dt-jbpmnKS", 0);

			List<Boxer> boxers = getBoxers();
			// insert objects into working memory
			for (Boxer b : boxers) {
				session.insertIntoWm(b);
			}

			session.fireAll("MainRuleFlow");
			session.retractAll();
			session.closeKsession();
			
			for(Boxer b : boxers) {
				System.out.println(b.getNom() + "("+b.getAge()+" ans, "+b.getPoids()+" kg) est " + b.getAgeCat());
			}
		} catch (RuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Boxer> getBoxers() {
		List<Boxer> list = new LinkedList<Boxer>();
		
		Boxer b = new Boxer();
		b.setNom("Pierre");
		b.setAge(12);
		b.setPoids(40);
		list.add(b);
		
		Boxer c = new Boxer();
		c.setNom("Jacques");
		c.setAge(36);
		c.setPoids(73);
		list.add(c);
		
		return list;
	}

}
