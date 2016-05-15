package net.trivialities;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
		ExecutorService executor = Executors.newFixedThreadPool(50);
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
	}

}
