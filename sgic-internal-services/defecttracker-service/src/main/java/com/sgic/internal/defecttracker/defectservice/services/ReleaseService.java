package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.Release;

public interface ReleaseService {
	
	public Release createRelease(Release release);
	public List<Release> getAllRelease();

}
