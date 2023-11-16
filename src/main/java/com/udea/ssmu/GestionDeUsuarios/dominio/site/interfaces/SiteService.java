package com.udea.ssmu.GestionDeUsuarios.dominio.site.interfaces;

import com.udea.ssmu.GestionDeUsuarios.dominio.site.dto.SiteData;
import com.udea.ssmu.GestionDeUsuarios.dominio.site.dto.SiteRegistrationData;

import java.util.List;

public interface SiteService {
    List<SiteData> getSitesByUser(Long userCode);

    void deleteSite(Long siteCode);

    SiteData registerSite(SiteRegistrationData siteRegistrationData);

    SiteData getSite(Long siteCode);
}
