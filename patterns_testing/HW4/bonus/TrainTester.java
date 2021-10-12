import static org.junit.Assert.*;
import org.junit.*;

public class TrainTester{

	private static Train soulTrain;
	private static Train thomasTheTrain;
	private static Train theLittleEngineThatCould;
	private static Train lilChooChoo;
	private static Train bigChooChoo;
	private static Train boat;
	
	
	@Before
	public void setup(){
		//normal train; engine, 9 cars, caboose
		soulTrain = new Train(10);
		//minimum train; engine, 1 car, caboose
		thomasTheTrain = new Train(2);
		//not train; engine, 1 car, no caboose
		theLittleEngineThatCould = new Train(1);
		//not train; engine only
		lilChooChoo = new Train(0);
		//big train; wow
		bigChooChoo = new Train(1000);
		//not train; negative number
		boat = new Train(-5);
	}
	
	@Test
	public void memberTest(){
		//normal train
		assertTrue(soulTrain.getEngine().isMemberOfValidTrain());
		//smallest s=train
		assertTrue(thomasTheTrain.getEngine().isMemberOfValidTrain());
		//not enough cars
		assertFalse(theLittleEngineThatCould.getEngine().isMemberOfValidTrain());
		//not enough cars
		assertFalse(lilChooChoo.getEngine().isMemberOfValidTrain());
		//big boi
		assertTrue(bigChooChoo.getEngine().isMemberOfValidTrain());
		//negative cars (so 0)
		assertFalse(boat.getEngine().isMemberOfValidTrain());
		
	}
	
	@Test
	public void distanceTest(){
		//no move
		assertEquals(0.0, soulTrain.getItsDistanceFromHome(), 0.0001);
		
		//one decimal move(positive)
		thomasTheTrain.getEngine().advance(15.2);
		assertEquals(15.2, thomasTheTrain.getItsDistanceFromHome(), 0.0001);
		
		//move twice
		lilChooChoo.getEngine().advance(1000.0);
		assertEquals(1000.0, lilChooChoo.getItsDistanceFromHome(), 0.0001);
		lilChooChoo.getEngine().advance(0.1);
		assertEquals(1000.1, lilChooChoo.getItsDistanceFromHome(), 0.0001);
		
		//overflow value goes to zero
		bigChooChoo.getEngine().advance(Integer.MAX_VALUE);
		bigChooChoo.getEngine().advance(1.0);
		assertEquals(1.0, bigChooChoo.getItsDistanceFromHome(), 0.0001);
		
		//boat went backwards. Silly train.
		boat.getEngine().advance(-15.2);
		assertEquals(-15.2, boat.getItsDistanceFromHome(), 0.0001);
		
	}
	
}//end class