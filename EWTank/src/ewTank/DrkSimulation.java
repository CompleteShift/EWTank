package ewTank;

import java.math.BigDecimal;
import java.util.LinkedList;

public class DrkSimulation {

	private LinkedList<Event> timeline;
	private int mana = 10000;
	private BigDecimal time;

	public DrkSimulation() {
		timeline = new LinkedList<Event>();
		buildTimeline();
	}

	private void buildTimeline() {
		time = new BigDecimal(0);
		gcd(hardSlash());
		gcd(syphonStrike());
		gcd(souleater());
	}

	public void runSim() {
		for (Event event : timeline) {
			System.out.println(event);
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
		return event;
	}

	private void gcd() {
		time = time.add(new BigDecimal("2.4"));
	}
	
	private void gcd(Event gcdEvent) {
		gcdEvent.setTime(time);
		timeline.add(gcdEvent);
		gcd();
	}
	
	private void gcd(Event gcdEvent, Event ogcdEvent)
	{
		gcdEvent.setTime(time);
		ogcd();
		ogcdEvent.setTime(time);
		ogcd();
		ogcd();
		timeline.add(gcdEvent);
		timeline.add(ogcdEvent);
	}
	
	private void gcd(Event gcdEvent, Event ogcdEventOne, Event ogcdEventTwo)
	{
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

}
