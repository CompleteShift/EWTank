package ewTank;

import java.math.BigDecimal;

public class Event implements Comparable<Event> {

	private final String name;
	private BigDecimal time;
	private int potency = 0;
	private int healPotency = 0;
	private int mana = 0;
	private int shell = 0;
	private int beastGauge = 0;
	private int bloodGauge = 0;

	public Event(String name) {
		this.name = name;
	}

	public String toString() {
		String string = "";
		string += "Time: " + time;
		string += "\tName: " + name;
		if (potency != 0) {
			string += "\tPotency: " + potency;
		}
		if (healPotency != 0) {
			string += "\tHeal Potency: " + healPotency;
		}
		if (mana != 0) {
			string += "\tMana: " + mana;
		}
		if (shell != 0) {
			string += "\tShells: " + shell;
		}
		if (beastGauge != 0) {
			string += "\tBeast Gauge: " + beastGauge;
		}
		return string;
	}

	public String getName() {
		return name;
	}
	
	public void setTime(BigDecimal time)
	{
		this.time = time;
	}

	public BigDecimal getTime() {
		return time;
	}

	public int getPotency() {
		return potency;
	}

	public void setPotency(int potency) {
		this.potency = potency;
	}

	public int getHealPotency() {
		return healPotency;
	}

	public void setHealPotency(int healPotency) {
		this.healPotency = healPotency;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getShell() {
		return shell;
	}

	public void setShell(int shell) {
		this.shell = shell;
	}

	public int getBeastGauge() {
		return beastGauge;
	}

	public void setBeastGauge(int beastGauge) {
		this.beastGauge = beastGauge;
	}
	
	public int getBloodGauge() {
		return bloodGauge;
	}

	public void setBloodGauge(int bloodGauge) {
		this.bloodGauge = bloodGauge;
	}

	public int compareTo(Event o) {
		return this.time.compareTo(o.getTime());
	}
}
