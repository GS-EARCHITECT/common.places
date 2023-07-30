package place_class_structure_mgmt.model.dto;

import java.io.Serializable;

public class PlaceClassStructure_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5535162513752955581L;
	private Long partySeqNo;
	private Long placeClassSeqNo;
	private Long parPlaceClassSeqNo;

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Long getPlaceClassSeqNo() {
		return placeClassSeqNo;
	}

	public void setPlaceClassSeqNo(Long placeClassSeqNo) {
		this.placeClassSeqNo = placeClassSeqNo;
	}

	public Long getParPlaceClassSeqNo() {
		return parPlaceClassSeqNo;
	}

	public void setParPlaceClassSeqNo(Long parPlaceClassSeqNo) {
		this.parPlaceClassSeqNo = parPlaceClassSeqNo;
	}

	public PlaceClassStructure_DTO(Long partySeqNo, Long placeClassSeqNo, Long parPlaceClassSeqNo) {
		super();
		this.partySeqNo = partySeqNo;
		this.placeClassSeqNo = placeClassSeqNo;
		this.parPlaceClassSeqNo = parPlaceClassSeqNo;
	}

	public PlaceClassStructure_DTO() {
		super();
	}

}