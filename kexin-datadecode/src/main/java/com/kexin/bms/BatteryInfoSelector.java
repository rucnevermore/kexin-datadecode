package com.kexin.bms;

import java.util.Arrays;

import com.kexin.bms.data.BmsInf;
import com.kexin.bms.enums.CanIDType;
import com.kexin.bms.exception.DataParseFailedException;
import com.kexin.bms.exception.NotImplementException;
import com.kexin.bms.object.ICanId;
import com.kexin.bms.object.PeliCanId;

public class BatteryInfoSelector {
	
	public BatteryInfoSelector() {
	}
	
	/**
	 * 
	 * basic-can data will have 10 bytes.
	 * 
	 * </br>The low 10 bits of the first 2 bytes represent the can id, 
	 * </br>the last 8 bytes represent the data. 
	 * </br>
	 * </br>
	 * peli-can data will have 12 bytes. 
	 * </br>The low 29 bits of the first 4 bytes represent the can id, 
	 * </br>the last 8 bytes represent the data. 
	 * 
	 * @param data
	 * @throws DataParseFailedException 
	 */
	public BaseBatteryInfo select(byte[] data) throws DataParseFailedException{		
		ICanId id;
		byte[] dataArray;
		CanIDType canIDType = Constants.CAN_ID_TYPE;
		switch(canIDType){
		case BASIC_CAN:
			throw new NotImplementException();
		case PELI_CAN:
			id = new PeliCanId(data);
			dataArray = Arrays.copyOfRange(data, 4, data.length);
			break;
		default:
			throw new IllegalStateException("can id type is not legal");	
		}			
		return createBatteryInfo(id, dataArray);
	}

	private BaseBatteryInfo createBatteryInfo(ICanId id, byte[] dataArray) {
		BaseBatteryInfo info = null;
		
		if (id.equals(BmsInf.id)){
			info = new BmsInf();
		}
				
		if (info != null){
			try {
				info.valueOf(dataArray);
			} catch (DataParseFailedException e) {
				e.printStackTrace();
				return null;
			}
		}
		return info;
	}

	
}
