package com.kexin.bms;

import com.kexin.bms.exception.DataParseFailedException;

/**
 * kexin battery info
 * 
 * @author jzeng
 *
 */
public interface IInfo {
	
	/**
	 * parse the real info from the byte array.
	 * 
	 * @param data
	 * @throws DataParseFailedException 
	 */
	public void valueOf(byte[] data) throws DataParseFailedException;

}
