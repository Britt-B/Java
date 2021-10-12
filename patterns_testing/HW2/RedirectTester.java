/**
*
@author Brittany Bergeron
@version 0.0.1
@since 2/12/19
*
*/


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;


public class RedirectTester{
	
	private static final int max = (Integer.MAX_VALUE);
	private static final int min = (Integer.MIN_VALUE);
	/**
	@param max holds maximum integer to test overflow
	@param min holds minimum integer to test overflow
	*/
	
	
	//pokemon to test
	private Pokemon pikaPika = new Pokemon("Pika", 15, 20);
	private Pokemon magiKarp = new Pokemon("Fishy Boi", -1, -1);
	private Pokemon charmander = new Pokemon("Spicy Boi", (max+1), (min-1));
	private Pokemon snorlax = new Pokemon("Sleepy Boi", (int)(-5.6), (int)(-8.5));
	private Pokemon diglett = new Pokemon(null, 0, 0);
	/**
	@param pikaPika tests observable with two positive integers
	@param magiKarp tests observable with two negative integers
	@param charmander tests observable with overflow
	@param snorlax tests observable with negative and positive decimals
	@param diglett tests observable with null and zero
	*/
	
	
	//trainers to test
	private PokemonTrainer ashKetchup = new PokemonTrainer("Kash Etchum");
	private PokemonTrainer drSumma = new PokemonTrainer("Apple Boi");
	private PokemonTrainer misty = new PokemonTrainer("Female Protagonist");
	private PokemonTrainer brockoli = new PokemonTrainer(null);
	
	/**
	@param ashKetchup tests observer "Kash Etchum"
	@param drSumma tests observer "Apple Boi"
	@param misty tests observer "Female Protagonist"
	@param brockoli tests observer with null args
	*/
	
	
	//new objects for output and error output
	private ByteArrayOutputStream output = new ByteArrayOutputStream();
	private ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
	/**
	@param output stores byte array output stream in a variable to be redirected and tested
	*/
	
	//line seperator
	private String lineSeparator = ("\n");
	private String lineTab = ("\t");
	/**
	@param lineSeparator holds new line to check equality
	@param lineTab holds tab to check equality
	*/
	
	
	/**
	*setup sets system output objects and assigns observers to observables
	*/
	@Before
	public void setup(){
		//set system output to output variable instead of console
		System.setOut(new PrintStream(output));
		System.setErr(new PrintStream(errorOutput));
		
		//add observers in various cases
		//pika has 2 observers
		pikaPika.addObserver(ashKetchup);
		pikaPika.addObserver(drSumma);
		//magiKarp has 1 observer	
		magiKarp.addObserver(misty);
		//charmander has 3 observers
		charmander.addObserver(ashKetchup);
		charmander.addObserver(misty);
		charmander.addObserver(drSumma);
		//snorlax has no observers
		//diglett has one observer (testing null with null)
		diglett.addObserver(brockoli);
	}
	
	/**
	*test if output is equal to Pokemon toString
	*/
	@Test
	public void testStdOutPokemon(){
		//error out
		System.err.print("Beep Boop. Error detected.");
		assertEquals("Beep Boop. Error detected.", errorOutput.toString());
		//clear output to test
		errorOutput.reset();
		
		//pikaPika
		System.out.print(pikaPika.toString());
		assertEquals(("Pokemon Pika:" + lineSeparator + lineTab + "health: 15" + lineSeparator + lineTab + "attack: 20"), output.toString());
		//clear output to test
		output.reset();
		
		//magikarp
		System.out.print(magiKarp.toString());
		assertEquals(("Pokemon Fishy Boi:" + lineSeparator + lineTab + "health: -1" + lineSeparator + lineTab + "attack: -1"), output.toString());
		//clear output to test
		output.reset();
		
		//charmander
		System.out.print(charmander.toString());
		assertEquals(("Pokemon Spicy Boi:" + lineSeparator + lineTab + "health: " + min + lineSeparator + lineTab + "attack: " + max), output.toString());
		//clear output to test
		output.reset();
		
		//snorlax
		System.out.print(snorlax.toString());
		assertEquals(("Pokemon Sleepy Boi:" + lineSeparator + lineTab + "health: -5" + lineSeparator + lineTab + "attack: -8"), output.toString());
		//clear output to test
		output.reset();
		
		//diglett
		System.out.print(diglett.toString());
		assertEquals(("Pokemon null:" + lineSeparator + lineTab + "health: 0" + lineSeparator + lineTab + "attack: 0"), output.toString());
		//clear output to test
		output.reset();
	}
	
	/**
	*test if output is equal to PokemonTrainer toString
	*/
	@Test
	public void testStdOutTrainer(){
		//Ash
		System.out.print(ashKetchup.toString());
		assertEquals(("PokemonTrainer Kash Etchum"), output.toString());
		//clear output to test
		output.reset();
		
		//Dr Summa
		System.out.print(drSumma.toString());
		assertEquals(("PokemonTrainer Apple Boi"), output.toString());
		//clear output to test
		output.reset();
		
		//Misty
		System.out.print(misty.toString());
		assertEquals(("PokemonTrainer Female Protagonist"), output.toString());
		//clear output to test
		output.reset();
		
		//Brock
		System.out.print(brockoli.toString());
		assertEquals(("PokemonTrainer null"), output.toString());
		//clear output to test
		output.reset();
	}
	
}//end class