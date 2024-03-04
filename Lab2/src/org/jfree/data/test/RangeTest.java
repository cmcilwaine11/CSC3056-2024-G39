package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest;
	private Range validRange1;
	private Range validRange2;
	private Range constrainRange;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
		validRange1 = new Range(3, 4);
		validRange2 = new Range(1, 2);
		constrainRange = new Range(1, 5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}

	@Test
	public void testGetLengthBothPositiveAndEqual() {
		Range r1 = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthBothPositiveAndNotEqual() { 
		Range r2 = new Range(4, 9);
		assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthBothNegativeAndEqual() {
		Range r3 = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthBothNegativeAndNotEqual() {
		Range r4 = new Range(-11, -4);
		assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthOnePositiveOneNegative() {
		Range r5 = new Range(-5, 3);
		assertEquals("getLength: Did not return the expected output", 8.0, r5.getLength(), 0.000000001d);
	}
	
	
	@Test
	public void testCombineWithBothValidRanges() {
		assertEquals(new Range(1, 4), Range.combine(validRange1, validRange2));
	}
	
	@Test
	public void testCombineWithANullRange2() {
		assertEquals(validRange1, Range.combine(validRange1, null));
	}
	
	@Test
	public void testCombineWithANullRange1() {
		assertEquals(validRange2, Range.combine(null, validRange2));
	}
	
	@Test
	public void testCombineWithABothNullRanges() {
		assertNull(Range.combine(null, null));
	}
	
	@Test
	public void testCombineWithANegativeRange1() {
		Range range1 = new Range(3, 4);
		Range range2 = new Range(-3, -2);
		assertEquals(new Range(-3, 4), Range.combine(range1, range2));
	}
	
	@Test
	public void testCombineWithANegativeRange2() {
		Range range1 = new Range(-1, 4);
		Range range2 = new Range(-3, -2);
		assertEquals(new Range(-3, 4), Range.combine(range1, range2));
	}
	
	@Test
	public void testCombineWithFirstRangeHigherThanSecond() {
		assertEquals(new Range(1, 4), Range.combine(validRange2, validRange1));
	}

	
	@Test
	public void testConstrainWithAValueLowerThanRangeBound() {
		assertEquals(1, constrainRange.constrain(0), 0.000000001d);
	}
	
	@Test
	public void testConstrainWithAValueAtLowerRangeBound() {
		assertEquals(1, constrainRange.constrain(1), 0.000000001d);
	}
	
	@Test
	public void testConstrainWithAMiddleValueOfRange() {
		assertEquals(3, constrainRange.constrain(3), 0.000000001d);
	}
	
	@Test
	public void testConstrainWithAValueAtUpperRangeBound() {
		assertEquals(5, constrainRange.constrain(5), 0.000000001d);
	}
	
	@Test
	public void testConstrainWithAValueHigherThanRangeBound() {
		assertEquals(5, constrainRange.constrain(6), 0.000000001d);
	}
	
	@Test
	public void testConstrainWithADecimalValue() {
		assertEquals(3.5, constrainRange.constrain(3.5), 0.000000001d);
	}
	
	
	@Test
	public void testEqualsWithValidObject() {
		assertTrue(validRange1.equals(new Range(3, 4)));
	}
	
	@Test
	public void testEqualsWithInvalidObject() {
		assertFalse(validRange1.equals(new Range(1, 2)));
	}
	
	@Test
	public void testEqualsWithNullObject() {
		assertFalse(validRange1.equals(null));
	}
	
	
	@Test
	public void testExpandToIncludeWithValidInputsWithHigherValue() {
		assertEquals(new Range(1, 4), Range.expandToInclude(validRange2, 4));
	}
	
	@Test
	public void testExpandToIncludeWithValidInputsWithLowerValue() {
		assertEquals(new Range(0, 2), Range.expandToInclude(validRange2, 0));
	}
	
	@Test
	public void testExpandToIncludeWithNullRange() {
		assertEquals(new Range(3, 3), Range.expandToInclude(null, 3));
	}
	
	@Test
	public void testExpandToIncludeWithNegativeInputs() {
		assertEquals(new Range(-5, 4), Range.expandToInclude(new Range(-3, 4), -5));
	}
	
	
	@Test
	public void testIntersectsWithValuesBelowRange() {
		assertFalse(validRange1.intersects(1, 2));
	}
	
	@Test
	public void testIntersectsWithValuesIntersectingAtLowerBound() {
		assertTrue(validRange1.intersects(1, 3));
	}
	
	@Test
	public void testIntersectsWithValuesOfRange() {
		assertTrue(validRange1.intersects(3, 4));
	}
	
	@Test
	public void testIntersectsWithValuesIntersectingAtUpperBound() {
		assertTrue(validRange1.intersects(3, 5));
	}
	
	@Test
	public void testIntersectsWithValuesAboveRange() {
		assertFalse(validRange1.intersects(5, 6));
	}
}
