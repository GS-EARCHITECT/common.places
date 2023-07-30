package place_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PLACE_CLASS_STRUCTURE database table.
 * 
 */
@Embeddable
public class PlaceClassStructurePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1702551663488786108L;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "PLACE_CLASS_SEQ_NO")
	private Long placeClassSeqNo;

	@Column(name = "PAR_PLACE_CLASS_SEQ_NO")
	private Long parPlaceClassSeqNo;

	public PlaceClassStructurePK() {
	}

	public Long getPlaceClassSeqNo() {
		return this.placeClassSeqNo;
	}

	public void setPlaceClassSeqNo(Long placeClassSeqNo) {
		this.placeClassSeqNo = placeClassSeqNo;
	}

	public Long getParPlaceClassSeqNo() {
		return this.parPlaceClassSeqNo;
	}

	public void setParPlaceClassSeqNo(Long parPlaceClassSeqNo) {
		this.parPlaceClassSeqNo = parPlaceClassSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parPlaceClassSeqNo == null) ? 0 : parPlaceClassSeqNo.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((placeClassSeqNo == null) ? 0 : placeClassSeqNo.hashCode());
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
		PlaceClassStructurePK other = (PlaceClassStructurePK) obj;
		if (parPlaceClassSeqNo == null) {
			if (other.parPlaceClassSeqNo != null)
				return false;
		} else if (!parPlaceClassSeqNo.equals(other.parPlaceClassSeqNo))
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
		return true;
	}

	public PlaceClassStructurePK(Long partySeqNo, Long placeClassSeqNo, Long parPlaceClassSeqNo) {
		super();
		this.partySeqNo = partySeqNo;
		this.placeClassSeqNo = placeClassSeqNo;
		this.parPlaceClassSeqNo = parPlaceClassSeqNo;
	}

}