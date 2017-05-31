package com.kexin.bms.object;


public class PeliCanId implements ICanId {
	protected int P;
	protected int R;
	protected int DP;
	protected int PF;
	protected int PS;
	protected int SA;
	protected int PGN;

	private int PMask = 0x1C;
	private int RMask = 0x02;
	private int DPMask = 0x01;

	public PeliCanId(byte[] data){
		if (data.length >= 4) {
			P = ((data[0] & PMask) >> 2);
			R = ((data[0] & RMask) >> 1);
			DP = ((data[0] & DPMask));
			PF = data[1] & 0xFF;
			PS = data[2] & 0xFF;
			SA = data[3] & 0xFF;
			PGN = getPGN(PF, PS);
		}
	}

	private int getPGN(int pf, int ps) {
		if (pf < 240) {
			return pf * 256;
		} else {
			return pf * 256 + ps;
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof PeliCanId) {
			PeliCanId other = (PeliCanId) obj;
			return other.P == P && other.R == R && other.DP == DP
					&& other.PF == PF && other.PS == PS && other.SA == SA
					&& other.PGN == PGN;
		} else {
			return false;
		}
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode += hashCode * 31 + P;
		hashCode += hashCode * 31 + R;
		hashCode += hashCode * 31 + DP;
		hashCode += hashCode * 31 + PF;
		hashCode += hashCode * 31 + PS;
		hashCode += hashCode * 31 + SA;
		hashCode += hashCode * 31 + PGN;
		return hashCode;
	}
}
