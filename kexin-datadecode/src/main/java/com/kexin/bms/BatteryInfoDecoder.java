package com.kexin.bms;

import com.kexin.bms.exception.DataParseFailedException;

/**
 * decode the battery information base on the data array push by the GPRS module.
 * 
 * @author jzeng
 *
 */
public class BatteryInfoDecoder {

	public void decode(byte[] data, IInfo info) throws DataParseFailedException{
		BatteryInfoSelector batteryInfoSelector = new BatteryInfoSelector();
		info = batteryInfoSelector.select(data);
	}
	
}
