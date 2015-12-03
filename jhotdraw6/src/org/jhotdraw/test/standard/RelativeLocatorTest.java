/*
 * @(#)Test.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */
package org.jhotdraw.test.standard;

import org.jhotdraw.standard.RelativeLocator;
import junit.framework.TestCase;
// JUnitDoclet begin import
// JUnitDoclet end import

/*
 * Generated by JUnitDoclet, a tool provided by
 * ObjectFab GmbH under LGPL.
 * Please see www.junitdoclet.org, www.gnu.org
 * and www.objectfab.de for informations about
 * the tool, the licence and the authors.
 */

// JUnitDoclet begin javadoc_class
/**
 * TestCase RelativeLocatorTest is generated by
 * JUnitDoclet to hold the tests for RelativeLocator.
 * @see org.jhotdraw.standard.RelativeLocator
 */
// JUnitDoclet end javadoc_class
public class RelativeLocatorTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
	// JUnitDoclet begin class
	// instance variables, helper methods, ... put them in this marker
	private RelativeLocator relativelocator;
	// JUnitDoclet end class

	/**
	 * Constructor RelativeLocatorTest is
	 * basically calling the inherited constructor to
	 * initiate the TestCase for use by the Framework.
	 */
	public RelativeLocatorTest(String name) {
		// JUnitDoclet begin method RelativeLocatorTest
		super(name);
		// JUnitDoclet end method RelativeLocatorTest
	}

	/**
	 * Factory method for instances of the class to be tested.
	 */
	public RelativeLocator createInstance() throws Exception {
		// JUnitDoclet begin method testcase.createInstance
		return new RelativeLocator();
		// JUnitDoclet end method testcase.createInstance
	}

	/**
	 * Method setUp is overwriting the framework method to
	 * prepare an instance of this TestCase for a single test.
	 * It's called from the JUnit framework only.
	 */
	protected void setUp() throws Exception {
		// JUnitDoclet begin method testcase.setUp
		super.setUp();
		relativelocator = createInstance();
		// JUnitDoclet end method testcase.setUp
	}

	/**
	 * Method tearDown is overwriting the framework method to
	 * clean up after each single test of this TestCase.
	 * It's called from the JUnit framework only.
	 */
	protected void tearDown() throws Exception {
		// JUnitDoclet begin method testcase.tearDown
		relativelocator = null;
		super.tearDown();
		// JUnitDoclet end method testcase.tearDown
	}

	// JUnitDoclet begin javadoc_method equals()
	/**
	 * Method testEquals is testing equals
	 * @see org.jhotdraw.standard.RelativeLocator#equals(java.lang.Object)
	 */
	// JUnitDoclet end javadoc_method equals()
	public void testEquals() throws Exception {
		// JUnitDoclet begin method equals
		// JUnitDoclet end method equals
	}

	// JUnitDoclet begin javadoc_method locate()
	/**
	 * Method testLocate is testing locate
	 * @see org.jhotdraw.standard.RelativeLocator#locate(org.jhotdraw.framework.Figure)
	 */
	// JUnitDoclet end javadoc_method locate()
	public void testLocate() throws Exception {
		// JUnitDoclet begin method locate
		// JUnitDoclet end method locate
	}

	// JUnitDoclet begin javadoc_method write()
	/**
	 * Method testWrite is testing write
	 * @see org.jhotdraw.standard.RelativeLocator#write(org.jhotdraw.util.StorableOutput)
	 */
	// JUnitDoclet end javadoc_method write()
	public void testWrite() throws Exception {
		// JUnitDoclet begin method write
		// JUnitDoclet end method write
	}

	// JUnitDoclet begin javadoc_method read()
	/**
	 * Method testRead is testing read
	 * @see org.jhotdraw.standard.RelativeLocator#read(org.jhotdraw.util.StorableInput)
	 */
	// JUnitDoclet end javadoc_method read()
	public void testRead() throws Exception {
		// JUnitDoclet begin method read
		// JUnitDoclet end method read
	}

	// JUnitDoclet begin javadoc_method east()
	/**
	 * Method testEast is testing east
	 * @see org.jhotdraw.standard.RelativeLocator#east()
	 */
	// JUnitDoclet end javadoc_method east()
	public void testEast() throws Exception {
		// JUnitDoclet begin method east
		// JUnitDoclet end method east
	}

	// JUnitDoclet begin javadoc_method north()
	/**
	 * Method testNorth is testing north
	 * @see org.jhotdraw.standard.RelativeLocator#north()
	 */
	// JUnitDoclet end javadoc_method north()
	public void testNorth() throws Exception {
		// JUnitDoclet begin method north
		// JUnitDoclet end method north
	}

	// JUnitDoclet begin javadoc_method west()
	/**
	 * Method testWest is testing west
	 * @see org.jhotdraw.standard.RelativeLocator#west()
	 */
	// JUnitDoclet end javadoc_method west()
	public void testWest() throws Exception {
		// JUnitDoclet begin method west
		// JUnitDoclet end method west
	}

	// JUnitDoclet begin javadoc_method northEast()
	/**
	 * Method testNorthEast is testing northEast
	 * @see org.jhotdraw.standard.RelativeLocator#northEast()
	 */
	// JUnitDoclet end javadoc_method northEast()
	public void testNorthEast() throws Exception {
		// JUnitDoclet begin method northEast
		// JUnitDoclet end method northEast
	}

	// JUnitDoclet begin javadoc_method northWest()
	/**
	 * Method testNorthWest is testing northWest
	 * @see org.jhotdraw.standard.RelativeLocator#northWest()
	 */
	// JUnitDoclet end javadoc_method northWest()
	public void testNorthWest() throws Exception {
		// JUnitDoclet begin method northWest
		// JUnitDoclet end method northWest
	}

	// JUnitDoclet begin javadoc_method south()
	/**
	 * Method testSouth is testing south
	 * @see org.jhotdraw.standard.RelativeLocator#south()
	 */
	// JUnitDoclet end javadoc_method south()
	public void testSouth() throws Exception {
		// JUnitDoclet begin method south
		// JUnitDoclet end method south
	}

	// JUnitDoclet begin javadoc_method southEast()
	/**
	 * Method testSouthEast is testing southEast
	 * @see org.jhotdraw.standard.RelativeLocator#southEast()
	 */
	// JUnitDoclet end javadoc_method southEast()
	public void testSouthEast() throws Exception {
		// JUnitDoclet begin method southEast
		// JUnitDoclet end method southEast
	}

	// JUnitDoclet begin javadoc_method southWest()
	/**
	 * Method testSouthWest is testing southWest
	 * @see org.jhotdraw.standard.RelativeLocator#southWest()
	 */
	// JUnitDoclet end javadoc_method southWest()
	public void testSouthWest() throws Exception {
		// JUnitDoclet begin method southWest
		// JUnitDoclet end method southWest
	}

	// JUnitDoclet begin javadoc_method center()
	/**
	 * Method testCenter is testing center
	 * @see org.jhotdraw.standard.RelativeLocator#center()
	 */
	// JUnitDoclet end javadoc_method center()
	public void testCenter() throws Exception {
		// JUnitDoclet begin method center
		// JUnitDoclet end method center
	}

	// JUnitDoclet begin javadoc_method testVault
	/**
	 * JUnitDoclet moves marker to this method, if there is not match
	 * for them in the regenerated code and if the marker is not empty.
	 * This way, no test gets lost when regenerating after renaming.
	 * <b>Method testVault is supposed to be empty.</b>
	 */
	// JUnitDoclet end javadoc_method testVault
	public void testVault() throws Exception {
		// JUnitDoclet begin method testcase.testVault
		// JUnitDoclet end method testcase.testVault
	}

}
