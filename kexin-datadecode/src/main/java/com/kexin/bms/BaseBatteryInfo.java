package com.kexin.bms;

import com.kexin.bms.enums.CanIDType;
import com.kexin.bms.enums.Receiver;
import com.kexin.bms.enums.Sender;
import com.kexin.bms.exception.DataParseFailedException;
import com.kexin.bms.exception.NotImplementException;

public abstract class BaseBatteryInfo implements IInfo {

	private static final int DATA_LENGTH = 8;
	
	protected Sender sender;	
	protected Receiver receiver = Receiver.BMS;
	protected CanIDType canIDType = Constants.CAN_ID_TYPE;
	
	/**
	 * depends on the CAN protocol version, the ID size will be different.
	 * @throws DataParseFailedException 
	 */
	public void valueOf(byte[] data) throws DataParseFailedException {		
		if (data.length != DATA_LENGTH){
			throw new DataParseFailedException("CAN message data length should be " + DATA_LENGTH);
		}
		parse(data);
	}

	protected abstract void parse(byte[] data);
}
