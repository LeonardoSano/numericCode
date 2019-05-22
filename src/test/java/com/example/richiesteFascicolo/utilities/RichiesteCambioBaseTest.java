package com.example.richiesteFascicolo.utilities;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class RichiesteCambioBaseTest {

	RichiesteCambioBase richiesteCambioBase = new RichiesteCambioBase();

	@Test
	public void testToNumericCodeZexpected26() {
		assertThat("Z Expected 26", richiesteCambioBase.toNumericCode("Z"), Matchers.equalTo(26));
	} 

	@Test
	public void testToNumericCodeAexpectedOne() {
		assertThat("A Expected 1", richiesteCambioBase.toNumericCode("A"), Matchers.equalTo(1));
	} 
	
	@Test
	public void testToNumericCodeCAexptectedS79() {
		assertThat("CA Expected 79", richiesteCambioBase.toNumericCode("yz"), Matchers.equalTo(676));
	}
	
	@Test
	public void testToNumericCodeCcexptectedS81() {
		assertThat("Cc Expected 81", richiesteCambioBase.toNumericCode("Cc"), Matchers.equalTo(81));
	}

	@Test
	public void testToNumericCodeCspaceAexpected79() {
		assertThat("C A Expected 79", richiesteCambioBase.toNumericCode("C A"), Matchers.equalTo(79));
	}
	
	@Test
	public void testToNumericCodeCspaceZZexpected702() {
		assertThat("ZZ Expected 702", richiesteCambioBase.toNumericCode("ZZ"), Matchers.equalTo(702));
	}


	@Test
	public void testToNumericCodeAAAexpected703() {
		assertThat("AAA Expected 703", richiesteCambioBase.toNumericCode("AAA"), Matchers.equalTo(703));
	}

	@Test
	public void testToNumericCodeConNotLetterCharacterExpectedZero() {
		assertThat("^ Expected 0", richiesteCambioBase.toNumericCode("^"), Matchers.equalTo(0));
	}

	@Test
	public void testToStringCodeOneExpectedA() {
		assertThat("26 Expected Z", richiesteCambioBase.toStringCode(26), Matchers.equalTo("Z"));
	}

	@Test
	public void testToStringCode79exptectedCA() {
		assertThat("79 Expected CA", richiesteCambioBase.toStringCode(81), Matchers.equalTo("CC"));
	}

	@Test
	public void testToStringCode703exptectedAAA() {
		assertThat("703 Expected AAA", richiesteCambioBase.toStringCode(703), Matchers.equalTo("AAA"));
	}

	@Test
	public void testToStringCodeZeroExpectedEmptyString() {
		assertThat("0 Expected empty String", richiesteCambioBase.toStringCode(0), Matchers.equalTo(""));
	}

	@Test
	public void testToStringCodeNegativeNumberExpectedEmptyString() {
		assertThat("-10 Expected empty String", richiesteCambioBase.toStringCode(-10), Matchers.equalTo(""));
	}

	@Test
	public void testNextCodeZtoAA() {
		assertThat("Z Expected AA", richiesteCambioBase.nextCode("Z"), Matchers.equalTo("AA"));
	}

	@Test
	public void testNextCodeLowerAtoB() {
		assertThat("a Expected B", richiesteCambioBase.nextCode("a"), Matchers.equalTo("B"));
	}

	@Test
	public void testNextCodeZZtoAAA() {
		assertThat("ZZ Expected AAA", richiesteCambioBase.nextCode("ZZ"), Matchers.equalTo("AAA"));
	}

	@Test
	public void testNextCodeZwhitespaceZtoAAA() {
		assertThat("Z Z Expected AAA", richiesteCambioBase.nextCode("Z Z"), Matchers.equalTo("AAA"));
	}

	@Test
	public void testNextCodeZwhitespaceLowerZtoAAA() {
		assertThat("Z Z Expected AAA", richiesteCambioBase.nextCode("Z z"), Matchers.equalTo("AAA"));
	}

	@Test
	public void testNextCodeSpecialCharacterToEmptyString() {
		assertThat("-% Expected empty String", richiesteCambioBase.nextCode("-%"), Matchers.equalTo(""));
	}
}
