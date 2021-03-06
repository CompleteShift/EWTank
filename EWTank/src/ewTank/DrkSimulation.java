package ewTank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class DrkSimulation {

	private LinkedList<Event> timeline;
	private BigDecimal time;

	public DrkSimulation() {
		timeline = new LinkedList<Event>();
		buildTimeline();
	}

	private void buildTimeline() {
		time = new BigDecimal("-1.6");
		
		ogcd(theBlackestNight());
		ogcd(bloodWeapon());
		gcd(hardSlash(), edgeOfShadow());
		gcd(syphonStrike());
		gcd(souleater(), livingShadow());
		gcd(hardSlash(), saltedEarth(), delirium());
		gcd(bloodspiller(true), edgeOfShadow(true), shadowbringer());
		gcd(bloodspiller(true), edgeOfShadow(), shadowbringer());
		gcd(bloodspiller(true), edgeOfShadow(), saltAndDarkness());
		gcd(syphonStrike(), edgeOfShadow(), carveAndSpit());
		gcd(souleater(), plunge(), abyssalDrain());
		gcd(hardSlash(), plunge());
		gcd(syphonStrike());
		gcd(souleater());
		gcd(bloodspiller());
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater());
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater());
		gcd(bloodspiller());
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater());
		gcd(hardSlash());
		gcd(syphonStrike(), theBlackestNight(), bloodWeapon());
		gcd(souleater());
		gcd(bloodspiller());
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater(), edgeOfShadow(true), delirium());
		gcd(bloodspiller(true), edgeOfShadow());
		gcd(bloodspiller(true), edgeOfShadow());
		gcd(bloodspiller(true), edgeOfShadow());
		gcd(bloodspiller(), carveAndSpit());
		gcd(hardSlash(), abyssalDrain());
		gcd(syphonStrike());
		gcd(souleater());
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater());
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater());
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater());
		gcd(bloodspiller());
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater());
		
		addManaTicks();
	}

	public void runSim() {
		int totalPotency = 0;
		int totalMana = 10000;
		int totalBlood = 0;
		
		timeline.sort(null);;

		for (Event event : timeline) {
			// System.out.println(event);
			totalPotency += event.getPotency();
			totalMana += event.getMana();
			totalBlood += event.getBloodGauge();

			String output = "";
			output += "Time: " + event.getTime();
			output += "\tName: " + event.getName();
			if (event.getTime().compareTo(new BigDecimal(0)) > 0) {
				output += "\tPPS: " + new BigDecimal(totalPotency).divide(event.getTime(), RoundingMode.HALF_UP);
			}
			output += "\tMana: " + totalMana;
			output += "\tBlood: " + totalBlood;
			System.out.println(output);
		}
	}

	private Event hardSlash() {
		Event event = new Event("Hard Slash");
		event.setPotency(210);
		return event;
	}

	private Event syphonStrike() {
		Event event = new Event("Syphon Strike");
		event.setPotency(270);
		event.setMana(600);
		return event;
	}

	private Event souleater() {
		Event event = new Event("Souleater");
		event.setPotency(330);
		event.setHealPotency(300);
		event.setBloodGauge(20);
		return event;
	}

	private Event bloodspiller() {
		Event event = new Event("Bloodspiller");
		event.setPotency(500);
		event.setBloodGauge(-50);
		return event;
	}
	
	private Event bloodspiller(boolean free)
	{
		Event event = bloodspiller();
		if (free)
			event.setBloodGauge(0);
		return event;
	}

	private Event edgeOfShadow() {
		Event event = new Event("Edge of Shadow");
		event.setPotency(400);
		event.setMana(-3000);
		return event;
	}

	private Event edgeOfShadow(boolean free) {
		Event event = edgeOfShadow();
		if (free)
			event.setMana(0);
		return event;
	}

	private Event carveAndSpit() {
		Event event = new Event("Carve and Spit");
		event.setPotency(360);
		event.setMana(600);
		return event;
	}

	private Event abyssalDrain() {
		Event event = new Event("Abyssal Drain");
		event.setPotency(150);
		event.setHealPotency(200);
		return event;
	}

	private Event saltedEarth() {
		Event event = new Event("Salted Earth");
		event.setPotency(250);
		return event;
	}

	private Event saltAndDarkness() {
		Event event = new Event("Salt and Darkness");
		event.setPotency(500);
		return event;
	}

	private Event shadowbringer() {
		Event event = new Event("Shadowbringer");
		event.setPotency(600);
		return event;
	}

	private Event livingShadow() {
		Event event = new Event("Living Shadow");
		event.setPotency(1470);
		event.setBloodGauge(-50);
		return event;
	}

	private Event plunge() {
		Event event = new Event("Plunge");
		event.setPotency(150);
		return event;
	}

	private Event theBlackestNight() {
		Event event = new Event("The Blackest Night");
		event.setMana(-3000);
		return event;
	}

	private Event bloodWeapon() {
		Event event = new Event("Blood Weapon");
		BigDecimal bwTime = this.time.add(new BigDecimal("0.8"));
		for (int i = 1; i < 6; i++)
		{
			Event bwEvent = new Event("Blood GCD Mana " + i);
			bwEvent.setTime(bwTime);
			bwEvent.setMana(600);
			bwEvent.setBloodGauge(10);;
			timeline.add(bwEvent);
			bwTime = bwTime.add(new BigDecimal("2.4"));
		}
		// TODO: Blood weapon gcds mana ticks
		return event;
	}

	private Event delirium() {
		Event event = new Event("Delirium");
		BigDecimal dTime = this.time.add(new BigDecimal("1.6"));
		for (int i = 1; i < 4; i++)
		{
			Event dEvent = new Event("Delirium GCD Mana " + i);
			dEvent.setTime(dTime);
			dEvent.setMana(200);
			timeline.add(dEvent);
			dTime = dTime.add(new BigDecimal("2.4"));
		}		return event;
	}
	
	private void addManaTicks() {
		for (int i = 0; i < 120; i += 3)
		{
			Event mEvent = new Event("Mana tick " + i);
			mEvent.setTime(new BigDecimal(i));
			mEvent.setMana(200);
			timeline.add(mEvent);
		}
	}

	private void gcd() {
		time = time.add(new BigDecimal("2.4"));
	}

	private void gcd(Event gcdEvent) {
		gcdEvent.setTime(time);
		timeline.add(gcdEvent);
		gcd();
	}

	private void gcd(Event gcdEvent, Event ogcdEvent) {
		gcdEvent.setTime(time);
		ogcd();
		ogcdEvent.setTime(time);
		ogcd();
		ogcd();
		timeline.add(gcdEvent);
		timeline.add(ogcdEvent);
	}

	private void gcd(Event gcdEvent, Event ogcdEventOne, Event ogcdEventTwo) {
		gcdEvent.setTime(time);
		ogcd();
		ogcdEventOne.setTime(time);
		ogcd();
		ogcdEventTwo.setTime(time);
		ogcd();
		timeline.add(gcdEvent);
		timeline.add(ogcdEventOne);
		timeline.add(ogcdEventTwo);
	}

	private void ogcd() {
		time = time.add(new BigDecimal("0.8"));
	}

	private void ogcd(Event ogcdEvent) {
		ogcdEvent.setTime(time);
		ogcd();
		timeline.add(ogcdEvent);
	}

}
