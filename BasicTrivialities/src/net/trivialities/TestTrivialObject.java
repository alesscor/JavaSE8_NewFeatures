package net.trivialities;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import net.trivialities.TrivialObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTrivialObject {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TrivialObject firstObject=new TrivialObject(0, "Alessandroski", LocalDate.now());
		assertTrue(TrivialObject.getExistenceAmount()==1);
		TrivialObject secondObject=new TrivialObject(0, "Michelinski", LocalDate.now());
		TrivialObject thirdObject=new TrivialObject(firstObject);
		assertTrue(firstObject.getID()==1);
		assertTrue(secondObject.getID()==2);
		assertTrue(TrivialObject.getExistenceAmount()==3);
		System.out.println(firstObject);
		assertTrue(firstObject!=secondObject);
		assertTrue(!firstObject.equals(secondObject));
		assertTrue(!firstObject.equals(thirdObject));
		System.out.println(thirdObject);
	}
	@Test
	public void testConcurrency(){
		ExecutorService executor = Executors.newFixedThreadPool(500);
		int totalInhabitants=100000;
		List<TrivialObject> aList=Collections.synchronizedList(new ArrayList<TrivialObject>(totalInhabitants)); // spends ~0.26s
		// List<TrivialObject> aList=new CopyOnWriteArrayList<TrivialObject>(); // spends ~4.47s
		
		assertTrue(aList.size()==0);
		for(int i=0;i<totalInhabitants;i++){
			final int theI=i;
			executor.submit(new Runnable() {
				@Override
				public void run() {
					TrivialObject objectI=new TrivialObject(theI, "Object."+theI, LocalDate.now());
					aList.add(objectI);
				}
			});
		}
		try {
			executor.shutdown();
			executor.awaitTermination(totalInhabitants/50,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		assertTrue(aList.size()==totalInhabitants);
		System.out.println("Number of inhabitants: "+aList.size());
		System.out.println("The inhabitant at 714th position: "+aList.get(714));
		System.out.println("The inhabitant at "+totalInhabitants+"th position: "+aList.get(totalInhabitants-1));
		System.out.println("The ID counter "+TrivialObject.getExistenceAmount());
	}
	@Test
	public void testStreaming(){
		TrivialObject anObject=
				new TrivialObject(0, "To transfer", LocalDate.of(1975, 5, 24));
		TrivialObject anotherObject=null;
		boolean everythingRight=false;
		System.out.println("testStreaming: "+anObject);
		try {
			FileOutputStream fout = new FileOutputStream("trivialobject.storage");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(anObject);
			oos.close();
			everythingRight=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(everythingRight){
			try {
				FileInputStream fin = new FileInputStream("trivialobject.storage");
				ObjectInputStream ois = new ObjectInputStream(fin);
				anotherObject=(TrivialObject)ois.readObject();
				ois.close();
				System.out.println("testStreaming: "+anotherObject);
				everythingRight=true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		assertTrue(everythingRight);
		assertTrue(anotherObject.equals(anObject));
		assertFalse(anotherObject==anObject);
		System.out.println("anObject: "+anObject.hashCode());
		System.out.println("anotherObject: "+anotherObject.hashCode());
	}
	@Test
	public void testFeatures() {
		TrivialObject anObject=new TrivialObject(0, "Alesso", LocalDate.of(1975, 5, 24));
		anObject.addFeature("Análisis alto");
		anObject.addFeature("Dopamina alta");
		anObject.addMetric("Altura", 1.68);
		anObject.addMetric("Peso", 75.9);
		Set<String> features=anObject.getFeatures();
		System.out.println(anObject);
		features.add("Cosas muy locas");
		System.out.println(anObject);
		features.forEach(e->{System.out.println("i:" +e);});
	}
}
