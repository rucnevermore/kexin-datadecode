package com.kexin.bms.object;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kexin.bms.exception.DataParseFailedException;

public class PeliCanIdTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws DataParseFailedException {
		byte[] data = new byte[]{(byte)0x18, (byte) 0xF2, (byte)0x12, (byte)0xF3};
		PeliCanId canId = new PeliCanId(data);
		Assert.assertEquals(6, canId.P);
		Assert.assertEquals(0, canId.R);
		Assert.assertEquals(0, canId.DP);
		Assert.assertEquals(242, canId.PF);
		Assert.assertEquals(18, canId.PS);
		Assert.assertEquals(243, canId.SA);
		Assert.assertEquals(61970, canId.PGN);
		System.out.println("canId.P : " + canId.P);
		System.out.println("canId.R : " + canId.R);
		System.out.println("canId.DP : " + canId.DP);
		System.out.println("canId.PF : " + canId.PF);
		System.out.println("canId.PS : " + canId.PS);
		System.out.println("canId.SA : " + canId.SA);
		System.out.println("canId.PGN : " + canId.PGN);
	}

}
