package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.action.ActionFailedException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.gamerunner.RunnableTurn;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.heroquest.action.UnfailableAttack;
import br.unicamp.mc322.projeto.heroquest.component.AttackableRangeArea;

public class Trap extends HeroQuestEntity implements Attacker, RunnableTurn, Interactable {
	
	private static final boolean IS_FRIENDLY = false;
	private static final int ATTACK_SCORE = 0;
	private UnfailableAttack base;
	private boolean turn;
	private boolean active;
	private static final float RANGE = 1;
	private static final int DAMAGE = 1;
	
	public Trap(Pose pose) {
		super(pose);
		turn = false;
		active = false;
		base = new UnfailableAttack(DAMAGE, RANGE);
	}

	@Override
	public int getAttackScore() {
		return ATTACK_SCORE;
	}

	@Override
	public boolean getIsFriendly() {
		return IS_FRIENDLY;
	}

	@Override
	public void run() {
		if (!turn)
			return;
		
		tryToActivate();
		
		if (active)
			try {
				attack();
			} catch (ActionFailedException e) {
				
				try {
					LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
					l.sendLog(LogType.OTHER, LogPriority.ERROR, "Trap", "A armadilha foi ativada, mas não conseguiu atacar");

				} catch (NotAvaibleServiceException | DisabledServiceException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
	}
	
	public void attack() throws ActionFailedException {
		base.run(this);
		detect();
	}

	@Override
	public void startTurn() {
		turn = true;
		
	}

	@Override
	public boolean isInTurn() {
		return turn;
	}
	
	private void tryToActivate() {
		Attackable[] neighbours = new AttackableRangeArea(getPose(), RANGE, Metric.MANHATTAN).getAttackablesInside(!IS_FRIENDLY);
		if (neighbours.length > 0)
			active = true;
	}
	
	public void detect() {
		disable();
	}

	@Override
	public void interact(Entity activator) {
		detect();
	}
	
	@Override
	public void draw() {
		if (active)
			super.draw();
	}
	
	
	
	
}
