package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jfree.data.DataUtilities; 
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.*;

public class DataUtilitiesTest {
	private Values2D values2D;
	private Values2D validValues;
	private Values2D emptyValues;
	
	private KeyedValues validKeyedValues;
	private KeyedValues negativeKeyedValues;
	private KeyedValues invalidKeyedValues;
	private KeyedValues emptyKeyedValues;
	
	@Before
	public void setUp() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		values2D = testValues;
		
		DefaultKeyedValues2D validTestValues = new DefaultKeyedValues2D(); 
		validTestValues.addValue(1, 0, 0);
		validTestValues.addValue(4, 1, 0);
		validTestValues.addValue(7, 2, 0);
		validTestValues.addValue(2, 0, 1);
		validTestValues.addValue(5, 1, 1);
		validTestValues.addValue(8, 2, 1);
		validTestValues.addValue(3, 0, 2);
		validTestValues.addValue(6, 1, 2);
		validTestValues.addValue(9, 2, 2);
		validValues = validTestValues;
		
		DefaultKeyedValues validTestKeyedValues = new DefaultKeyedValues();
		validTestKeyedValues.addValue((Comparable<?>)0, 3);
		validTestKeyedValues.addValue((Comparable<?>)1, 4);
		validTestKeyedValues.addValue((Comparable<?>)2, 5);
		validKeyedValues = validTestKeyedValues;
		
		DefaultKeyedValues negativeTestKeyedValues = new DefaultKeyedValues();
		negativeTestKeyedValues.addValue((Comparable<?>)0, -2);
		negativeTestKeyedValues.addValue((Comparable<?>)1, -3);
		negativeKeyedValues = negativeTestKeyedValues;
		
		DefaultKeyedValues invalidTestKeyedValues = new DefaultKeyedValues();
		invalidTestKeyedValues.addValue((Comparable<?>)0, 8);
		invalidTestKeyedValues.addValue((Comparable<?>)1, 9);
		invalidKeyedValues = invalidTestKeyedValues;
	}

	@After
	public void tearDown() {
		values2D = null;
	}
	
	@Test
	public void testValidDataAndColumnColumnTotal() {
		assertEquals(5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testNullDataColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
	} 
	
	@Test
	public void testCalculateColumnTotalWithValidDataAndFinalColumn() {
		assertEquals(18.0, DataUtilities.calculateColumnTotal(validValues, 2), 0.0000001d);
	} 
	
	@Test
	public void testCalculateColumnTotalWithNullColumn() {
		try {
			DataUtilities.calculateColumnTotal(emptyValues, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotalWithValidDataAndColumnNotInRange() {
		try {
			assertEquals(0, DataUtilities.calculateColumnTotal(validValues, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Test failed and Exception thrown: " + e);
		}
	} 
	
	@Test
	public void testCalculateColumnTotalWithValidDataAndNegativeColumnNotInRange() {
		try {
			assertEquals(0, DataUtilities.calculateColumnTotal(validValues, 3), 0.0000001d);
		} catch (Exception e) {
			fail("Test failed and Exception thrown: " + e);
		}
	}
	
	
	@Test
	public void testCalculateRowTotalWithValidDataAndRow() {
		assertEquals(6.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalWithValidDataAndFinalRow() {
		assertEquals(24.0, DataUtilities.calculateRowTotal(validValues, 2), 0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalWithValidDataAndRowNotInRange() {
		try {
			assertEquals(0, DataUtilities.calculateRowTotal(validValues, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Test failed and Exception thrown: " + e);
		}
	} 
	
	@Test
	public void testCalculateRowTotalWithValidDataAndNegativeRowNotInRange() {
		try {
			assertEquals(0, DataUtilities.calculateRowTotal(validValues, 3), 0.0000001d);
		} catch (Exception e) {
			fail("Test failed and Exception thrown: " + e);
		}
	}
	
	@Test
	public void testCalculateRowTotalWithNullDataAndValidRow() {
		try {
			DataUtilities.calculateRowTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalWithEmptyDataAndValidRow() {
		try {
			DataUtilities.calculateRowTotal(emptyValues, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
	} 
	

	@Test
	public void testCreateNumberArrayWithValidData() {
		double[] testData1 = {0.0, 1.0, 2.5, 3.0};
		Number[] expected1 = {0.0, 1.0, 2.5, 3.0};
		
		Number[] result = DataUtilities.createNumberArray(testData1);
		
		for(int i = 0; i < result.length; i++) {
			assertEquals(expected1[i], result[i]);
		}
	} 
	
	@Test
	public void testCreateNumberArrayWithNegativeDataValues() {
		double[] testData2 = {-1.0, -2.0};
		Number[] expected2 = {-1.0, -2.0};
		
		Number[] result = DataUtilities.createNumberArray(testData2);
		
		for(int i = 0; i < result.length; i++) {
			assertEquals(expected2[i], result[i]);
		}
	}
	
	@Test
	public void testCreateNumberArrayWithEmptyData() {
		double[] testData2 = {};
		Number[] expected2 = {};
		
		Number[] result = DataUtilities.createNumberArray(testData2);
		
		for(int i = 0; i < result.length; i++) {
			assertEquals(expected2[i], result[i]);
		}
	}
	
	@Test
	public void testCreateNumberArrayWithNullData() {
		try {
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	
	@Test
	public void testCreateNumberArray2DWithValidData() {
		double[] testDoubleArray1 = {0.0, 1.0};
		double[] testDoubleArray2 = {2.5, 3.0};
		double[][] testData2 = {testDoubleArray1, testDoubleArray2};
		Number[][] expected2 = {{0.0, 1.0}, {2.5, 3.0}};
		
		Number[][] result = DataUtilities.createNumberArray2D(testData2);
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				assertEquals(expected2[i][j], result[i][j]);
			}
		}
	} 
	
	@Test
	public void testCreateNumberArray2DWithNegativeDataValues() {
		double[][] testData3 = {{-1.0, -2.0}, {1.0, 2.0}};
		Number[][] expected3 = {{-1.0, -2.0}, {1.0, 2.0}};
		
		Number[][] result = DataUtilities.createNumberArray2D(testData3);
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				assertEquals(expected3[i][j], result[i][j]);
			}
		}
	}
	
	@Test
	public void testCreateNumberArray2DWithEmptyData() {
		double[][] testData4 = {};
		Number[][] expected4 = {};
		
		Number[][] result = DataUtilities.createNumberArray2D(testData4);
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				assertEquals(expected4[i][j], result[i][j]);
			}
		}
	}
	
	@Test
	public void testCreateNumberArray2DWithEmptyArrayInData() {
		double[][] testData5 = {{}};
		Number[][] expected5 = {{}};
		
		Number[][] result = DataUtilities.createNumberArray2D(testData5);
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				assertEquals(expected5[i][j], result[i][j]);
			}
		}
	}
	
	@Test
	public void testCreateNumberArray2DWithNullData() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	
	@Test
	public void testGetCumulativePercentagesWithValidData() {
		KeyedValues result = DataUtilities.getCumulativePercentages(validKeyedValues);
		
		assertEquals(0.1875, result.getValue((Comparable<?>)0));
		assertEquals(0.4375, result.getValue((Comparable<?>)1));
		assertEquals(0.75, result.getValue((Comparable<?>)2));
	} 
	
	@Test
	public void testGetCumulativePercentagesWithNegativeDataValues() {
		KeyedValues result = DataUtilities.getCumulativePercentages(negativeKeyedValues);
		
		assertEquals(-0.125, result.getValue((Comparable<?>)0));
		assertEquals(-0.3125, result.getValue((Comparable<?>)1));
	}
	
	@Test
	public void testGetCumulativePercentagesWithDataValueLargerThan1() {
		try {
			DataUtilities.getCumulativePercentages(invalidKeyedValues);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
		
	}
	
	@Test
	public void testGetCumulativePercentagesWithNullData() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentagesWithEmptyData() {
		try {
			DataUtilities.getCumulativePercentages(emptyKeyedValues);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. Throws: " + e, e.getClass().equals(IllegalArgumentException.class));
		}
	}
}