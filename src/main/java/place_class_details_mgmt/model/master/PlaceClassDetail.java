package place_class_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PLACE_CLASS_DETAILS database table.
 * 
 */
@Entity
@Table(name = "PLACE_CLASS_DETAILS")
public class PlaceClassDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlaceClassDetailPK id;

	public PlaceClassDetail() {
	}

	public PlaceClassDetailPK getId() {
		return this.id;
	}

	public void setId(PlaceClassDetailPK id) {
		this.id = id;
	}

	public PlaceClassDetail(PlaceClassDetailPK id) {
		super();
		this.id = id;
	}

}