package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.modifier.model.Point;
import edu.kis.powp.jobs2d.command.visitor.VisitorCommand;
import edu.kis.powp.jobs2d.command.modifier.IVisitorModifier;

/**
 * Implementation of Job2dDriverCommand for operateTo command functionality.
 */
public class OperateToCommand implements DriverCommand {

	private int posX;
	private int posY;

	public OperateToCommand(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public Point getPoint(IVisitorModifier visitor) {
		return visitor.getPoint(this);
	}

	@Override
	public void setPoint(IVisitorModifier visitor, Point point) {
		visitor.setPoint(this, point);
	}

	@Override
	public void execute(Job2dDriver driver) {
		driver.operateTo(posX, posY);
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return new OperateToCommand(this.posX, this.posY);
		}
	}

	@Override
	public void accept(VisitorCommand visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "OperateToCommand: posX=" + posX + ", posY=" + posY;
	}

}
