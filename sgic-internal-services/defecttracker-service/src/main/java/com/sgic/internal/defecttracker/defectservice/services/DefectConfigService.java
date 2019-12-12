package com.sgic.internal.defecttracker.defectservice.services;

import com.sgic.internal.defecttracker.defectservice.entities.DefectConfig;

public interface DefectConfigService {
	public Object createDefectConfig(DefectConfig defectConfig);
	DefectConfig findDefectConfigById(long id);

}
