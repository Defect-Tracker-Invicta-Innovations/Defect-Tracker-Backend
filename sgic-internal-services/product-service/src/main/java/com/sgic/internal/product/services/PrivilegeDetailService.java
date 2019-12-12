package com.sgic.internal.product.services;

import java.util.List;
import com.sgic.internal.product.entities.PrivilegeDetail;

public interface PrivilegeDetailService {

	    //Get PrivilegeDetail By Id
		public PrivilegeDetail getPrivilegeDetailById(Long id);

		// Save PrivilegeDetail
		public PrivilegeDetail savePrivilegeDetail(PrivilegeDetail privilegeDetail);

		// List all PrivilegeDetail
		public List<PrivilegeDetail> getAllPrivilegeDetail();

		// Delete PrivilegeDetail
		public void deletePrivilegeDetailById(Long id);

		// Update PrivilegeDetail
		public PrivilegeDetail updatePrivilegeDetail(PrivilegeDetail privilegeDetail);
}
