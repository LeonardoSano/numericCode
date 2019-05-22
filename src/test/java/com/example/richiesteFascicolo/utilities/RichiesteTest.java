package com.example.richiesteFascicolo.utilities;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class RichiesteTest {

	Richieste richieste = new Richieste();

	@Test
	public void testToNumericCodeAexpectedOne(){
		assertThat("A Expected 1",richieste.toNumericCode("a"), Matchers.equalTo(1));
	}

	@Test
	public void testToNumericCodeCAexptectedS79() {
		assertThat("CA Expected 80",richieste.toNumericCode("Cc"), Matchers.equalTo(81));
	}

	@Test
	public void testToNumericCodeCspaceAexpected79() {
		assertThat("C A Expected 79",richieste.toNumericCode("C A"), Matchers.equalTo(79));
	}

	@Test
	public void testToNumericCodeAAAexpected703() {
		assertThat("AAA Expected 703",richieste.toNumericCode("AAA"), Matchers.equalTo(703));
	}

	@Test
	public void testToNumericCodeConNotLetterCharacterExpectedZero() {
		assertThat("^ Expected 0",richieste.toNumericCode("^"), Matchers.equalTo(0));
	}

	@Test
	public void testToStringCodeOneExpectedA() {
		assertThat("1 Expected A",richieste.toStringCode(26), Matchers.equalTo("Z"));
	}

	@Test
	public void testToStringCode79exptectedCA() {
		assertThat("79 Expected CA",richieste.toStringCode(79), Matchers.equalTo("CA"));
	}

	@Test
	public void testToStringCode703exptectedAAA() {
		assertThat("703 Expected AAA",richieste.toStringCode(703), Matchers.equalTo("AAA"));
	}

	@Test
	public void testToStringCodeZeroExpectedEmptyString() {
		assertThat("0 Expected empty String",richieste.toStringCode(0), Matchers.equalTo(""));
	}

	@Test
	public void testToStringCodeNegativeNumberExpectedEmptyString() {
		assertThat("-10 Expected empty String",richieste.toStringCode(-10), Matchers.equalTo(""));
	}

	@Test
	public void testNextCodeZtoAA() {
		assertThat("Z Expected AA",richieste.nextCode("Z"), Matchers.equalTo("AA"));
	}

	@Test
	public void testNextCodeLowerAtoB() {
		assertThat("a Expected B",richieste.nextCode("a"), Matchers.equalTo("B"));
	}

	@Test
	public void testNextCodeZZtoAAA() {
		assertThat("ZZ Expected AAA",richieste.nextCode("ZZ"), Matchers.equalTo("AAA"));
	}
	
	@Test
	public void testNextCodeZwhitespaceZtoAAA() {
		assertThat("Z Z Expected AAA",richieste.nextCode("Z Z"), Matchers.equalTo("AAA"));
	}
	
	@Test
	public void testNextCodeSpecialCharacterToEmptyString() {
		assertThat("-% Expected empty String",richieste.nextCode("-%"), Matchers.equalTo(""));
	}
	
	@Test
	public void testNextCodeZwhitespaceLowerZtoAAA() {
		assertThat("Z Z Expected AAA",richieste.nextCode("Z z"), Matchers.equalTo("AAA"));
	}

}
