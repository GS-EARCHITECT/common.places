package place_class_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PLACE_CLASS_DETAILS database table.
 * 
 */
@Embeddable
public class PlaceClassDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "PLACE_CLASS_SEQ_NO")
	private Long placeClassSeqNo;

	@Column(name = "PLACE_SEQ_NO")
	private Long placeSeqNo;

	@Column(name = "PAR_PLACE_SEQ_NO")
	private Long parPlaceSeqNo;

	public Long getPlaceClassSeqNo() {
		return this.placeClassSeqNo;
	}

	public void setPlaceClassSeqNo(Long placeClassSeqNo) {
		this.placeClassSeqNo = placeClassSeqNo;
	}

	public Long getPlaceSeqNo() {
		return this.placeSeqNo;
	}

	public void setPlaceSeqNo(Long placeSeqNo) {
		this.placeSeqNo = placeSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Long getParPlaceSeqNo() {
		return parPlaceSeqNo;
	}

	public void setParPlaceSeqNo(Long parPlaceSeqNo) {
		this.parPlaceSeqNo = parPlaceSeqNo;
	}

	public PlaceClassDetailPK() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parPlaceSeqNo == null) ? 0 : parPlaceSeqNo.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((placeClassSeqNo == null) ? 0 : placeClassSeqNo.hashCode());
		result = prime * result + ((placeSeqNo == null) ? 0 : placeSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlaceClassDetailPK other = (PlaceClassDetailPK) obj;
		if (parPlaceSeqNo == null) {
			if (other.parPlaceSeqNo != null)
				return false;
		} else if (!parPlaceSeqNo.equals(other.parPlaceSeqNo))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (placeClassSeqNo == null) {
			if (other.placeClassSeqNo != null)
				return false;
		} else if (!placeClassSeqNo.equals(other.placeClassSeqNo))
			return false;
		if (placeSeqNo == null) {
			if (other.placeSeqNo != null)
				return false;
		} else if (!placeSeqNo.equals(other.placeSeqNo))
			return false;
		return true;
	}

	public PlaceClassDetailPK(Long partySeqNo, Long placeClassSeqNo, Long placeSeqNo, Long parPlaceSeqNo) {
		super();
		this.partySeqNo = partySeqNo;
		this.placeClassSeqNo = placeClassSeqNo;
		this.placeSeqNo = placeSeqNo;
		this.parPlaceSeqNo = parPlaceSeqNo;
	}

}