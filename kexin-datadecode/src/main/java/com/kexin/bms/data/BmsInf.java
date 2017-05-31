package com.kexin.bms.data;

import com.kexin.bms.BaseBatteryInfo;
import com.kexin.bms.Constants;
import com.kexin.bms.enums.Receiver;
import com.kexin.bms.enums.Sender;
import com.kexin.bms.object.PeliCanId;

public class BmsInf extends BaseBatteryInfo {

	public static final PeliCanId id = new PeliCanId(new byte[]{(byte)0x18, (byte) 0xF2, (byte)0x12, (byte)0xF3});
	
	public BmsInf(){
		sender = Sender.OTHER;	
		receiver = Receiver.BMS;
		canIDType = Constants.CAN_ID_TYPE;
	}
	
	@Override
	protected void parse(byte[] data) {
		// TODO Auto-generated method stub
		
	}
	
}
